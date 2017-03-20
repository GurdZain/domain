package com.nnbee.core.base.ws.interceptor;
/**
 *=====================================================================
 * Restful Request PreProcessor
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */

import com.nnbee.core.annotation.NoRequireAuthorization;
import com.nnbee.core.constant.RestConst;
import com.nnbee.core.exception.ServiceException;
import com.nnbee.core.util.ExceptionUtil;
import com.nnbee.core.util.RestRequestStore;
import com.nnbee.core.vo.json.BaseErrorInfoResponseVO;
import com.nnbee.core.vo.json.BaseRestRequestVO;
import com.nnbee.core.vo.json.StatusVO;
import com.nnbee.core.security.service.OauthService;
import com.nnbee.core.security.vo.AccessToken;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.MessageBodyReaderContext;
import org.jboss.resteasy.spi.interception.MessageBodyReaderInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

@Named
@Provider
@ServerInterceptor
public class RestRequestPreProcessor implements PreProcessInterceptor, MessageBodyReaderInterceptor {
	Logger logger = LoggerFactory.getLogger(RestRequestPreProcessor.class);

	@Context
	HttpServletRequest servletRequest;

	public static final ThreadLocal<String> timeZone_local = new ThreadLocal<String>();
	
	public static final ThreadLocal<Long> enterpriseID_local = new ThreadLocal<Long>();

	@Resource
	private OauthService oauthService;
	
	@Value("${token_validation_flag}")
	private String tokenValidationFlagStr;

	@SuppressWarnings("unchecked")
	public ServerResponse preProcess(HttpRequest request, ResourceMethod resourceMethod) throws Failure, WebApplicationException {

		/*
		 * SECURITY CHECK will has to be implemented
		 */
		RestRequestStore.setValue(RestConst.BASE_REST_REQ,updateRequestProperties(request)); 
		Enumeration<String> attributeNames = servletRequest.getParameterNames();
		StringBuilder params = new StringBuilder();
		while (attributeNames.hasMoreElements()) {
			String paramName = (String) attributeNames.nextElement();
			String paramValue = servletRequest.getParameter(paramName);
			params.append(paramName).append(":").append(paramValue).append(", ");
		}

		String timezone = servletRequest.getHeader(RestConst.REQ_PARAM_TIMEZONE);
		String authorizationStr = servletRequest.getHeader(RestConst.REQ_PARAM_AUTHORIZATION);
		if(StringUtils.isNotBlank(timezone)){
			timeZone_local.set(timezone);
			logger.info("timeZone is "+ timezone);
		}
		
		String requestURL = request.getUri().getRequestUri().getPath();
		if(requestURL==null||requestURL.contains(RestConst.EXPRESS_URL)){
			if (!requestURL.contains("data/healthcheck")) {
				logger.info("Skip token validation : {}",requestURL);
			}
		}else{
			boolean tokenValidationFlag = tokenValidationFlagStr==null? true: "true".equalsIgnoreCase(tokenValidationFlagStr);
			if(tokenValidationFlag){
				Boolean isNotAuth = checkNoAuthorization(resourceMethod);
				if (!isNotAuth) {
					try {
						//Validate the token information
						oauthService.validateToken(authorizationStr);
						AccessToken accessToken = oauthService.getAccessToken();
						String clientIP = servletRequest.getHeader(RestConst.TOKEN_REQUEST_CLIENT_IP);
						String sessionID = servletRequest.getHeader(RestConst.TOKEN_REQUEST_SESSION_ID);
						accessToken.setClientIP(clientIP);
						accessToken.setSessionId(sessionID);
					} catch (ServiceException e) {
						StatusVO status = ExceptionUtil.genStatusVOFromErrorVO(e);
						BaseErrorInfoResponseVO response = new BaseErrorInfoResponseVO(status);
						return new ServerResponse(response, 200, new Headers<Object>());
					}
				}
			}
		}
		
		String enterpriseID = servletRequest.getHeader(RestConst.HEADER_REQUEST_ENTERPRISE_ID);
		
		if (!requestURL.contains("data/healthcheck")) {
			String requestInfo = new StringBuilder("Request URI: ").append(request.getUri().getAbsolutePath())
		              .append(", accessToken: ").append(authorizationStr)
		              .append(", Request Parameters: ").append(params.toString()).toString();
			logger.info(requestInfo);
		}
		enterpriseID_local.set(enterpriseID==null?null:Long.parseLong(enterpriseID));
		return null;
	}


	private Boolean checkNoAuthorization(ResourceMethod resourceMethod) {
		Boolean isNotAuth = false;
		NoRequireAuthorization annotation = resourceMethod.getResourceClass().getAnnotation(NoRequireAuthorization.class);
		if (annotation != null) {
			isNotAuth = true;
		}
		if (!isNotAuth) {
			annotation = resourceMethod.getMethod().getAnnotation(NoRequireAuthorization.class);
			if (annotation != null) {
				isNotAuth = true;
			}
		}
		return isNotAuth;
	}


	@SuppressWarnings("unchecked")
	public Object read(MessageBodyReaderContext context) throws IOException, WebApplicationException {

		String data = null;
		Object object = null;
		BufferedReader reader = null;
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder sBuilder = new StringBuilder();
		InputStream inputStream = context.getInputStream();

		if (inputStream != null) {
			reader = new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));            
			while ((data = reader.readLine()) != null) {
				sBuilder.append(data);
			}
		}
		logger.info("reading data: "+ sBuilder.toString());

		try {
			if(sBuilder.length() > 0) {
				object = mapper.readValue(sBuilder.toString(), context.getType());
			}    		
		} catch (Exception e) {
			BaseRestRequestVO baseRestRequest = (BaseRestRequestVO)RestRequestStore.getValue(RestConst.BASE_REST_REQ);
			baseRestRequest.setValidationErrorInfo(e.getMessage()); 
			logger.error("read param error.", e);
		}            	
		return object;
	}

	private BaseRestRequestVO updateRequestProperties(HttpRequest request) {

		BaseRestRequestVO baseReq = new BaseRestRequestVO();    	
		baseReq.setFormParameters(request.getFormParameters());
		baseReq.setFormat(RestConst.REQ_DATA_FORMAT);
		baseReq.setHttpMethod(request.getHttpMethod());
		baseReq.setUri(request.getUri().getBaseUri().getRawQuery());	    	
		baseReq.setRequestId(UUID.randomUUID());
		baseReq.setStartTime(new Date());		
		return baseReq;    	
	}

}

package com.nnbee.core.security.service;

import com.nnbee.core.constant.ErrorDescription;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.constant.RestConst;
import com.nnbee.core.exception.DaoException;
import com.nnbee.core.exception.ServiceException;
import com.nnbee.core.security.dao.OauthDAO;
import com.nnbee.core.security.vo.AccessToken;
import com.nnbee.core.util.StringUtil;
import com.nnbee.core.vo.json.ErrorVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
@Transactional
public class OauthService {

	private static final ThreadLocal<AccessToken> accessToken_local = new ThreadLocal<AccessToken>();

	@Resource
	private OauthDAO oauthDAO;

	
	/**
	 * @param authorizationStr
	 * @return
	 * @throws ServiceException 
	 */
	public void validateToken(String authorizationStr) throws ServiceException { 
		AccessToken token = null;
		if (StringUtils.isBlank(authorizationStr)) {
			String errorMSG = ErrorDescription.ERR_MSG_SECURITY_NO_TOKEN;
			ErrorVO errorVO = new ErrorVO(ErrorDescription.ERR_CD_SECURITY_NO_TOKEN, ErrorDescription.ERR_MSG_SECURITY_NO_TOKEN, errorMSG);
			throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION, errorVO);
		} else {
			String tokenValue = null;
			if (authorizationStr.toLowerCase().startsWith(RestConst.REQ_PARAM_AUTHORIZATION_BEARER)) {
				tokenValue = authorizationStr.substring(authorizationStr.indexOf(" ")).trim();
			} else {
				String errorMSG = ErrorDescription.ERR_MSG_SECURITY_INVALID_TOKEN;
				ErrorVO errorVO = new ErrorVO(ErrorDescription.ERR_CD_SECURITY_INVALID_TOKEN, ErrorDescription.ERR_MSG_SECURITY_INVALID_TOKEN, errorMSG);
				throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION, errorVO);
			}
			if(tokenValue.equals(RestConst.EXPRESS_TOKEN)){
				//express token
				return;
			}
			/*Object tokenObj = redisService.get(tokenValue);
			if(tokenObj==null){
				try {
					token = oauthDAO.getAccessTokenByTokenId(tokenValue);
					if(token!=null){
						redisService.set(tokenValue, token);
					}
				} catch (DaoException e) {
					throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION,e.getErrorVO());
				}
			}else{
				token = (AccessToken)tokenObj;
			}*/
			try {
				token = oauthDAO.getAccessTokenByTokenId(tokenValue);
			} catch (DaoException e) {
				throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION,e.getErrorVO());
			}
			
			if (token == null) {
				String errorMSG = ErrorDescription.ERR_MSG_SECURITY_INVALID_TOKEN;
				ErrorVO errorVO = new ErrorVO(ErrorDescription.ERR_CD_SECURITY_INVALID_TOKEN,ErrorDescription.ERR_MSG_SECURITY_INVALID_TOKEN, errorMSG);
				throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION,errorVO);
			}
			
			if (token.isExpired()) {
				ErrorVO errorVO = new ErrorVO(ErrorDescription.ERR_CD_SECURITY_EXPIRED_TOKEN,ErrorDescription.ERR_MSG_SECURITY_EXPIRED_TOKEN, ErrorDescription.ERR_MSG_SECURITY_EXPIRED_TOKEN);
				throw new ServiceException(ExceptionType.EXCEPTION_AUTHENTICATION,errorVO);
			} 
			accessToken_local.set(token);
		}
	}
	
	public void saveAppVersion(String enterpriseIdStr, String deviceType, String currentVersion){ 
		if (StringUtils.isBlank(enterpriseIdStr)  || StringUtils.isBlank(currentVersion)) {
			return;
		} else {
			if(StringUtils.isBlank(deviceType)){
				deviceType = "none";
			}
			try{
				Long enterpriseId = Long.parseLong(enterpriseIdStr);
				String key = new StringBuilder(RestConst.APP_VERSION_PREFIX).append(enterpriseId).append("_").append(deviceType).toString();
				/*Object versionObj = redisService.get(key);
				
				//版本信息在cache中存在
				if(versionObj!=null){
					String appVersion = versionObj.toString();
					if(!appVersion.equals(currentVersion)){
						int count = oauthDAO.updateAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
						if(count==0){
							String version = oauthDAO.getAppEnterpriseVersion(deviceType, enterpriseId);
							if(StringUtil.isBlank(version)){
								oauthDAO.insertAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
							}
						}
					}
				}else{ //版本信息在cache中不存在
					String version = oauthDAO.getAppEnterpriseVersion(deviceType, enterpriseId);
					if(StringUtil.isBlank(version)){
						oauthDAO.insertAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
					}else{
						oauthDAO.updateAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
					}
					redisService.set(key, currentVersion);
				}*/
				String version = oauthDAO.getAppEnterpriseVersion(deviceType, enterpriseId);
				if(StringUtil.isBlank(version)){
					oauthDAO.insertAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
				}else{
					oauthDAO.updateAppEnterpriseVersion(deviceType, enterpriseId, currentVersion);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	 
	/**
	 * @return
	 */
	public static AccessToken getAccessToken(){
		return accessToken_local.get();
	}
	
	/**
	 * @param token
	 */
	public static void setAccessToken(AccessToken token){
		accessToken_local.set(token);
	}


}
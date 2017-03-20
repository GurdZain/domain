package com.nnbee.core.security.dao.impl;

import com.nnbee.core.base.das.jdbc.impl.AbstractJdbcDaoImpl;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.exception.DaoException;
import com.nnbee.core.security.dao.OauthDAO;
import com.nnbee.core.security.vo.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OAUTH Security related database operations.
 *
 */
public class OauthDAOImpl  extends AbstractJdbcDaoImpl implements OauthDAO{
	
	private static Logger logger = LoggerFactory.getLogger(OauthDAOImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.maxFun.security.dao.OauthDAO#getClientServiceByName(java.lang.String)
	 */
	public AccessToken getAccessTokenByTokenId(String accessToken) throws DaoException{
		String queryStr = "select a.*,e.login_name from access_token a left join enterprise e on a.enterprise_id = e.enterprise_id"
				+ " where a.status=0 and a.access_token=:access_token";
		
		List<Map<String, Object>> resultMapList = null;
		try {
			Map<String,Object> valueMap = new HashMap<String,Object>();
			valueMap.put("access_token", accessToken);
			resultMapList = executeJdbcQuery(queryStr,valueMap);
		} catch (DaoException e) {
			throw new DaoException(ExceptionType.EXCEPTION_SERVICE,e.getErrorVO()); 
		}
		if(resultMapList==null || resultMapList.size()==0){
			return null;
		} else{
			Map<String, Object> resultMap = resultMapList.get(0);
			AccessToken token = new AccessToken();
			Object createdDateObj = resultMap.get("created_date");
			Object expiredDateObj = resultMap.get("expired_date");
			Object enterpriseIdObj = resultMap.get("enterprise_id");
			//Object enterpriseUserIdObj = resultMap.get("enterprise_user_id");
			Object loginNameObj = resultMap.get("login_name");
			Object sourceObj = resultMap.get("source");
			
			token.setAccessToken(accessToken);
			token.setEnterpriseId(enterpriseIdObj==null?null:Long.parseLong(enterpriseIdObj.toString()));
			//token.setEnterpriseUserId(enterpriseUserIdObj==null?null:Long.parseLong(enterpriseUserIdObj.toString()));
			token.setUsername(loginNameObj==null?"":loginNameObj.toString());
			token.setCreatedDate(createdDateObj==null?null:(Date)createdDateObj);
			token.setExpiredDate(expiredDateObj==null?null:(Date)expiredDateObj);
			token.setSource(sourceObj==null?null:sourceObj.toString());
			return token;
		}
	}
	
	public int insertAppEnterpriseVersion(String appName, Long enterpriseId, String currentVersion) throws DaoException{
		String sql = "insert into app_enterprise_version(app_name,enterprise_id,current_version) values (:app_name,:enterprise_id,:current_version)";
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("app_name", appName);
			paramMap.put("enterprise_id", enterpriseId);
			paramMap.put("current_version", currentVersion);
			return this.executeJdbcUpdate(sql, paramMap);
		} catch (DaoException e) {
			throw new DaoException(ExceptionType.EXCEPTION_SERVICE,e.getErrorVO()); 
		}
	}
	
	public int updateAppEnterpriseVersion(String appName, Long enterpriseId, String currentVersion) throws DaoException{
		String sqlStr = "update app_enterprise_version set current_version=:current_version where app_name=:app_name and enterprise_id=:enterprise_id";
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("app_name", appName);
			paramMap.put("enterprise_id", enterpriseId);
			paramMap.put("current_version", currentVersion);
			return this.executeJdbcUpdate(sqlStr, paramMap);
		} catch (DaoException e) {
			throw new DaoException(ExceptionType.EXCEPTION_SERVICE,e.getErrorVO()); 
		}
	}

	@Override
	public String getAppEnterpriseVersion(String appName, Long enterpriseId)
			throws DaoException {
		String queryStr = "select current_version from app_enterprise_version where app_name=:app_name and enterprise_id=:enterprise_id";
		
		List<Map<String, Object>> resultMapList = null;
		try {
			Map<String,Object> valueMap = new HashMap<String,Object>();
			valueMap.put("app_name", appName);
			valueMap.put("enterprise_id", enterpriseId);
			resultMapList = executeJdbcQuery(queryStr,valueMap);
		} catch (DaoException e) {
			throw new DaoException(ExceptionType.EXCEPTION_SERVICE,e.getErrorVO()); 
		}
		if(resultMapList==null || resultMapList.size()==0){
			return null;
		} else{
			Map<String, Object> resultMap = resultMapList.get(0);
			Object currentVersionObj = resultMap.get("current_version");
			return currentVersionObj==null?"":currentVersionObj.toString();
		}
	}

}

package com.nnbee.core.security.dao;

import com.nnbee.core.base.das.jdbc.AbstractJdbcDao;
import com.nnbee.core.exception.DaoException;
import com.nnbee.core.security.vo.AccessToken;

/**
 *
 */
public interface OauthDAO extends AbstractJdbcDao{
	
	/**
	 * @param accessToken
	 * @return
	 * @throws DaoException
	 */
	public AccessToken getAccessTokenByTokenId(String accessToken) throws DaoException;
	
	/**
	 * @param appName
	 * @param enterpriseId
	 * @return
	 * @throws DaoException
	 */
	public String getAppEnterpriseVersion(String appName, Long enterpriseId) throws DaoException;
	
	/**
	 * @param appName
	 * @param enterpriseId
	 * @param currentVersion
	 * @return
	 * @throws DaoException
	 */
	public int insertAppEnterpriseVersion(String appName, Long enterpriseId, String currentVersion) throws DaoException;
	
	/**
	 * @param appName
	 * @param enterpriseId
	 * @param currentVersion
	 * @return
	 * @throws DaoException
	 */
	public int updateAppEnterpriseVersion(String appName, Long enterpriseId, String currentVersion) throws DaoException;
	
	
}

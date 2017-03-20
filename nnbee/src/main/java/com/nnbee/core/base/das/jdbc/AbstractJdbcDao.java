package com.nnbee.core.base.das.jdbc;
/**
 *=====================================================================
 * Abstract JDBC DAO Interface
 * 
 * Default operations for all the JDBC based DAO. 
 * When you think this POJO might just need CRUD, so we can use this 
 * default DAO. If you think this POJO has some other specific operations, 
 * we should create a separated DAO instead of using default one.
 *
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */
;
import com.nnbee.core.exception.DaoException;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Map;

public interface AbstractJdbcDao {
	
	/**
	 * @param query
	 * @param paramMap
	 * @return
	 * @throws DaoException
	 */
	public List<Map<String, Object>> executeJdbcQuery(String query, Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * @param query
	 * @param paramSource
	 * @param generatedKeyHolder
	 * @return
	 * @throws DaoException
	 */
	public int executeJdbcUpdate(String query, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DaoException ;
	
	
	/**
	 * @param query
	 * @param paramMap
	 * @return
	 * @throws DaoException
	 */
	public int executeJdbcUpdate(String query, Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * @param query
	 * @param paramMap
	 * @return
	 * @throws DaoException
	 */
	public int executeSimpleQuery(String query, Map<String, String> paramMap) throws DaoException;
	
	/**
	 * @param query
	 * @param batchValues
	 * @return
	 * @throws DaoException
	 */
	public int[] executeJdbcBatchUpdate(String query, Map<String, ?>[] batchValues) throws DaoException;

}

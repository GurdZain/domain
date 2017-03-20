package com.nnbee.core.util;

import com.nnbee.core.constant.ErrorDescription;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.exception.DaoException;
import com.nnbee.core.exception.UtilityException;
import com.nnbee.core.vo.json.ErrorVO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *=====================================================================
 *
 * The bean is used to define all the  queries.
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 01/16/2013   create
 *
 */	
public class QueryDefinitionBean {

	private Map<String, String> namedQueryMap = new HashMap<String, String>();
	private static Logger logger = Logger
			.getLogger(QueryDefinitionBean.class.getName());

	public Map<String, String> getNamedQueryMap() {
		return namedQueryMap;
	}

	public void setNamedQueryMap(Map<String, String> namedQueryMap) {
		this.namedQueryMap = namedQueryMap;
	}

	/**
	 * @param queryName
	 * @return
	 * @throws DaoException
	 */
	public String getQueryByName(String queryName) throws UtilityException {
		String queryStr = "";
		String errorDescription = "";
		if (namedQueryMap != null) {
			queryStr = namedQueryMap.get(queryName);
			if(StringUtils.isBlank(queryStr)){
				errorDescription = "Failed to get the query string by name ' "+queryName+"'.";
				logger.error(MessageFormattor.errorFormat(QueryDefinitionBean.class.getName(),
		                "getQueryByName", ExceptionType.EXCEPTION_UTILITY, errorDescription));
				throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
						new ErrorVO(ErrorDescription.ERR_CD_UT_QUERY_NOT_FOUND,ErrorDescription.ERR_MSG_UT_QUERY_NOT_FOUND, errorDescription));
			}
			return queryStr;
		} else {
			errorDescription = "Failed to get the query string by name ' "+queryName+"'. The namedQueryMap is null. Please check the spring bean configuraion file in Java.";
			logger.error(MessageFormattor.errorFormat(QueryDefinitionBean.class.getName(),
	                "getQueryByName", ExceptionType.EXCEPTION_UTILITY, errorDescription));
			throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
					new ErrorVO(ErrorDescription.ERR_CD_COMMON_INTERNAL,ErrorDescription.ERR_MSG_COMMON_INTERNAL, errorDescription));
		}
	}

}

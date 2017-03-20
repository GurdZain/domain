package com.nnbee.core.exception;

import com.nnbee.core.vo.json.ErrorVO;

/**
 *=====================================================================
 * ACP DAO Layer Exception
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 


public class DaoException extends BaseException {
	private static final long serialVersionUID = 5404733870677069564L;

	/**
	 * Constructor
	 * 
	 * @param exceptionType
	 * @param errvo
	 */
	public DaoException(String exceptionType, ErrorVO errvo) {
		super(exceptionType, errvo);
	}
	
	public DaoException() {
	}

}

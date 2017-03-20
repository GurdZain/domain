package com.nnbee.core.exception;

import com.nnbee.core.vo.json.ErrorVO;

/**
 *=====================================================================
 * ACP ValidationException Exception
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 01/16/2013   create
 *
 */	
public class ValidationException  extends BaseException  {

	private static final long serialVersionUID = 7895723562145223930L;
	
	/**
	 * @param exceptionType
	 * @param errvo
	 */
	public ValidationException(String exceptionType, ErrorVO errvo) {
		super(exceptionType, errvo);
	}

}

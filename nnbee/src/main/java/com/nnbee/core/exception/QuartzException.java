package com.nnbee.core.exception;
/**
 *=====================================================================
 * ACP Quartz Job Exception
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

import com.nnbee.core.vo.json.ErrorVO;

public class QuartzException extends BaseException {
	private static final long serialVersionUID = 7990555744712442335L;

	/**
	 * Constructor
	 * 
	 * @param exceptionType
	 * @param errvo
	 */
	public QuartzException(String exceptionType, ErrorVO errvo) {
		super(exceptionType, errvo);
	}

}

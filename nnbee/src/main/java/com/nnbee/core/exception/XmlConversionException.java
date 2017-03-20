package com.nnbee.core.exception;

import com.nnbee.core.vo.json.ErrorVO;

/**
 *=====================================================================
 * ACP XML Conversion Exception
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 


public class XmlConversionException extends BaseException {
	private static final long serialVersionUID = 9124757008178353203L;

	/**
	 * Constructor
	 * 
	 * @param exceptionType
	 * @param errvo
	 */
	public XmlConversionException(String exceptionType, ErrorVO errvo) {
		super(exceptionType, errvo);
	}

}

package com.nnbee.core.exception;
/**
 *=====================================================================
 * ACP Base Exception
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */


import com.nnbee.core.constant.ErrorDescription;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.vo.json.ErrorVO;

import java.io.Serializable;


/**
 * 
 */
public class BaseException extends Exception implements Serializable {
	private static final long serialVersionUID = 3743203851771467234L;
	
	private String  exceptionType;
	
	private ErrorVO errorvo;

	/**
	 * Default Constructor
	 */
	public BaseException() {
	  exceptionType = ExceptionType.EXCEPTION_APPLICATION;
	  if ( errorvo == null ) {
			errorvo = new ErrorVO(ErrorDescription.ERR_CD_COMMON_INTERNAL,ErrorDescription.ERR_MSG_COMMON_INTERNAL,"");
	  }
	}

	public BaseException(String exceptionType, ErrorVO errvo) {
	   this.exceptionType = exceptionType;
	   this.errorvo = errvo;
	}

	
	//======================setters and getters
	public String getExceptionType() {
		return this.exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	public ErrorVO getErrorVO() {
		return this.errorvo;
	}

	public void setErrorVO(ErrorVO errvo) {
		this.errorvo = errvo;
	}

}

package com.kavli.core.vo.json;

import java.io.Serializable;

public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String message;
	private String trace;
	
	public Error() {
	}	

	public Error(String errorCode, String errorMessage) {
		this.code = errorCode;
		this.message = errorMessage;
	}

	public Error(String errorCode, String errorMessage, String errorTrace) {
		this.code = errorCode;
		this.message = errorMessage;
		this.trace = errorTrace;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}

}
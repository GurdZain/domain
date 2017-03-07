package com.kavli.core.vo.json;

/**
 *=====================================================================
 * ACP Error Value Object 
 * 
 *  Error object carry on all the error related information
 *
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ErrorVO implements java.io.Serializable {

	private static final long serialVersionUID = -7725934887400306872L;

	private String errCd;

	private String errMsg;

	private String errDescription;

	private String userId;

	private String userName;

	private String email;

	private String errorType;

	private List<Error> errors;

	public ErrorVO(){

	}

	/**
	 * @param errCd
	 * @param errMsg
	 * @param errDescription
	 * @param userId
	 * @param userName
	 * @param email
	 */
	public ErrorVO(String errCd, String errMsg, String errDescription,
                   String userId, String userName, String email, String errorType) {
		this.errCd = errCd;
		this.errMsg = errMsg;
		this.errDescription = errDescription;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.errorType=errorType;
	}

	/**
	 * @param errCd
	 * @param errMsg
	 * @param errDescription
	 */
	public ErrorVO(String errCd, String errMsg, String errDescription) {
		this.errCd = errCd;
		this.errMsg = errMsg;
		this.errDescription = errDescription;
		List<Error> errors = new ArrayList<Error>();
		errors.add(new Error( errCd,  errMsg,  errDescription));
		this.errors = errors;
	}
	
	public ErrorVO(List<Error> errors) {
		this.errors = errors;
	}

	public String getErrCd() {
		return errCd;
	}

	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrDescription() {
		return errDescription;
	}

	public void setErrDescription(String errDescription) {
		this.errDescription = errDescription;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}

package com.nnbee.core.util;

import com.nnbee.core.vo.json.ErrorVO;

/**
 *=====================================================================
 * ACP ErrorVO Generator Utility 
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 


public class ErrorVOGenerator {

	public static ErrorVO genarateErrorVO(String userId, String userName,
			String errorCd, String errorMsg) {
		ErrorVO errorVo = new ErrorVO();
		errorVo.setErrCd(errorCd);
		errorVo.setErrMsg(errorMsg);
		errorVo.setUserId(userId);
		errorVo.setUserName(userName);
		return errorVo;
	}
}

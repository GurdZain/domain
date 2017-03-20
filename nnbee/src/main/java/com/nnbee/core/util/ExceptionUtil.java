package com.nnbee.core.util;

import com.nnbee.core.exception.BaseException;
import com.nnbee.core.vo.json.ErrorVO;
import com.nnbee.core.vo.json.StatusVO;
import org.apache.commons.lang.StringUtils;

public class ExceptionUtil {

	/**
	 * Method to generate the error code depending on the exception type
	 * @param exceptionType
	 * @return int
	 */
	public static int getErrorCode(String exceptionType)  {
		int errorCode = 500; // default value
		if (StringUtils.isNotBlank(exceptionType)) {
			String codeForType = PropertyUtil.get(exceptionType);
			if (StringUtils.isNumeric(codeForType)) {
				errorCode = Integer.valueOf(codeForType);
			}
		}
		return errorCode;
	}

	/**
	 * Generate status VO from Error VO.
	 * @param baseException
	 * @return StatusVO
	 */
	public static StatusVO genStatusVOFromErrorVO(BaseException baseException) {
		ErrorVO errorVO = baseException.getErrorVO();
		// retrieve code from exception type.
//		String code = String.valueOf(ExceptionUtil.getErrorCode(baseException.getExceptionType()));
		StatusVO status = new StatusVO();
		status.setCode(errorVO.getErrCd());
		status.setMessage(errorVO.getErrDescription());
//		if (errorVO != null) {
//			status.setErrors(baseException.getErrorVO().getErrors());
//		}
		// If debug is set.
//		BaseRestRequestVO baseRequest = null;
//		Object baseRequestObject = RestRequestStore.getValue(RestConst.BASE_REST_REQ);
//		if(baseRequestObject!=null){
//			baseRequest = (BaseRestRequestVO)baseRequestObject;
//			ResponseDebugVO debug = new ResponseDebugVO();
//			debug.setTimings(baseRequest.getStartTime());
//			debug.setDescription(baseRequest.getUri());
//			status.setDebug(debug);
//		}
		return status;
	}

}
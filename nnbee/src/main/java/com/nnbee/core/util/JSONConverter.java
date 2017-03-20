package com.nnbee.core.util;

import com.nnbee.core.constant.ErrorDescription;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.exception.UtilityException;
import com.nnbee.core.vo.json.ErrorVO;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JSONConverter {
    private static Logger mLogger = LoggerFactory.getLogger(JSONConverter.class.getName());
	private static final ObjectMapper mapper = new ObjectMapper();
	
	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public static  Map<String,String> convertJSONtoMap(String jsonString) throws UtilityException {
		 Map<String,String> map= new HashMap<String,String>();

		 try{
		     map = mapper.readValue(jsonString, HashMap.class);
		
		 }catch(Exception e){
	        mLogger.error(MessageFormattor.errorFormat(JSONConverter.class.getName(),
	                    "convertJSONtoMap", ExceptionType.EXCEPTION_JSON,
	                    e.getMessage()));
	       throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
		            new ErrorVO(ErrorDescription.ERR_CD_UT_JSON_CONVERSION, ErrorDescription.ERR_MSG_UT_JSON_CONVERSION, e.getMessage()));
		}
		
		return map;
	}
	
	public static String objectToJsonStr(Object obj) throws UtilityException {
		if (obj == null) {
			return null;
		}
		
		try{
		     String jsonStr = mapper.writeValueAsString(obj);
		     return jsonStr;
		}catch(Exception e){
	        mLogger.error(MessageFormattor.errorFormat(JSONConverter.class.getName(),
	                    "convertJSONtoMap", ExceptionType.EXCEPTION_JSON,
	                    e.getMessage()));
	       throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
		            new ErrorVO(ErrorDescription.ERR_CD_UT_JSON_CONVERSION, ErrorDescription.ERR_MSG_UT_JSON_CONVERSION, e.getMessage()));
		}
	}
}

package com.kavli.core.utils;

/**
 *=====================================================================
 * ACP Logging Message Formatter Utility 
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

public class MessageFormattor {

	
   /**
    * format message log for null/empty and no whitespace string.
	*    
    * @param  className  String
    * @param  methodName String
    * @param  message    String
	* @return String
	*/
	 public static String infoFormat(String className, String methodName, String message) {
		 if (StringUtil.isBlank(className)) className = "";
		 if (StringUtil.isBlank(methodName)) methodName = "";
		 
		 String location = " at ".concat(className) + ".".concat(methodName);
	     String outputString = location + " [*****] " + ( (message == null) ? "Message is empty" : message);
	     return outputString;
     }

	 
   /**
    * format error message log for null/empty and no whitespace string.
	*    
    * @param  className  String
    * @param  methodName String
    * @param  errorType  String
    * @param  error      String
	* @return String
	*/
    public static String errorFormat(String className, String methodName, String errorType, String error) {
		 if (StringUtil.isBlank(className)) className = "";
		 if (StringUtil.isBlank(methodName)) methodName = "";

		 String location = " at ".concat(className) + ".".concat(methodName);
		 String outputString = location + " [?????] ".concat(errorType + ": ") + ( (error == null) ? "Exception Message is empty" : error);
		 return outputString;
    }

	 
}

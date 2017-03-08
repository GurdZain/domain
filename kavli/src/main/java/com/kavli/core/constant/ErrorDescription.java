package com.kavli.core.constant;
/**
 *=====================================================================
 * ACP Error Handling Constants
 *
 * Provide constant definitions on ACP Error handling services. 
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

public interface ErrorDescription {
	
	/******* Error Messages ***********/
	
	public static final String ERR_CD_NO_OPERATION = "JE002";
	public static final String ERR_MSG_NO_OPERATION = "No such operation";

	public static final String ERR_CD_OPERATION = "JE003";
	public static final String ERR_MSG_OPERATION = "Can't execute this operation";
	
	public static final String ERR_CD_ILLEGAL_ACCESS = "JE004";
	public static final String ERR_MSG__ILLEGAL_ACCESS = "Can't access this message";
	
	public static final String ERR_CD_INVALID_SERVICE = "JE005";
	public static final String ERR_MSG_INVALID_SERVICE= "Service name cannot be null";
	
	public static final String ERR_CD_SERVICE_INVOCATION = "JE006";
	public static final String ERR_MSG_SERVICE_INVOCATION= "Service invocation error";
	
	public static final String ERR_CD_JMS = "JE010";
	public static final String ERR_MSG_JMS = "JMS error";
	
	/**  DAO access error*/
	public static final String ERR_CD_DAO_QUERY = "DAO01";
	public static final String ERR_MSG_DAO_QUERY = "Data querying error";
	
	public static final String ERR_CD_DAO_INSERT = "DAO02";
	public static final String ERR_MSG_DAO_INSERT = "Data inserting error";
	
	public static final String ERR_CD_DAO_UPDATE = "DAO03";
	public static final String ERR_MSG_DAO_UPDATE = "Data updating error";
	
	public static final String ERR_CD_DAO_INSERT_OR_UPDATE = "DAO004";
	public static final String ERR_MSG_DAO_INSERT_OR_UPDATE = "Data inserting or updating error";
	
	public static final String ERR_CD_DAO_DELETE = "DAO05";
	public static final String ERR_MSG_DAO_DELETE = "Delete error";
	
	public static final String ERR_CD_DAO_VERSION_SYNC = "DAO06";
    public static final String ERR_MSG_DAO_VERSION_SYNC = "Another user has changed the data your are editing since you opened the record. Please cancel out of this screen and re-enter your changes.";

    public static final String ERR_CD_DAO_HIBERNATE_CLEAR = "DAO06";
	public static final String ERR_MSG_DAO_HIBERNATE_CLEAR = "Hibernate clear error";
	
	public static final String ERR_CD_DAO_HIBERNATE_FLUSH = "DAO07";
	public static final String ERR_MSG_DAO_HIBERNATE_FLUSH = "Hibernate flush error";
	
	public static final String ERR_CD_DAO_HIBERNATE_EVICT = "DAO08";
	public static final String ERR_MSG_DAO_HIBERNATE_EVICT = "Hibernate evict error";
	
	public static final String ERR_CD_DAO_SP = "DAO05";
	public static final String ERR_MSG_DAO_SP = "Stored procedure invocation error";
	
	
	/**  Utility error*/
	public static final String ERR_CD_UT_PROPERTY_INIT = "UT001";
	public static final String ERR_MSG_UT_PROPERTY_INIT = "Property initilazation error";
	
	public static final String ERR_CD_UT_PROPERTY_GET = "UT002";
	public static final String ERR_MSG_UT_PROPERTY_GET = "Property getting error";
	
	public static final String ERR_CD_UT_XML_CONVERSION = "UT003";
	public static final String ERR_MSG_UT_XML_CONVERSION = "XML conversion error";
	
	public static final String ERR_CD_UT_XML_VALIDATION = "UT004";
	public static final String ERR_MSG_UT_XML_VALIDATION = "XML validation error";

	public static final String ERR_CD_UT_DATE_CONVERSION = "UT005";
	public static final String ERR_MSG_UT_DATE_CONVERSION = "Date conversion error";
	
	public static final String ERR_CD_UT_QUERY_NOT_FOUND = "UT006";
	public static final String ERR_MSG_UT_QUERY_NOT_FOUND = "Query not found";
	
	public static final String ERR_CD_UT_JSON_CONVERSION = "UT007";
	public static final String ERR_MSG_UT_JSON_CONVERSION = "JSON conversion error";
	
	
	/**  Service error*/
	public static final String ERR_CD_SERVICE_VALIDATION = "SV001";
	public static final String ERR_MSG_SERVICE_VALIDATION = "Service validation error";
	
	
	/**  Common error*/
	public static final String ERR_CD_COMMON_INTERNAL = "CM001";
	public static final String ERR_MSG_COMMON_INTERNAL = "Internal error";
	
	public static final String ERR_CD_COMMON_OBJECT_CONVERSION = "CM002";
	public static final String ERR_MSG_COMMON_OBJECT_CONVERSION = "Invalid object conversion";
	
	public static final String ERR_CD_COMMON_RESOURCE_NOTFOUND = "CM003";
	public static final String ERR_MSG_COMMON_RESOURCE_NOTFOUND = "Resource not found";
	
	
	/** Memcache error */
	public static final String ERR_CD_MEMCACHE = "ME001";
	public static final String ERR_MSG_MEMCACHE = "Memcache error";
	
	/**  Validation error*/
	public static final String ERR_CD_VALIDATION_NULLPOINTER = "VA001";
	public static final String ERR_MSG_VALIDATION_NULLPOINTER = "The object is null";
	
	
	/**  Security Error*/
	public static final String ERR_CD_SECURITY_NO_TOKEN = "SE001";
	public static final String ERR_MSG_SECURITY_NO_TOKEN = "No authentication information found";
	
	public static final String ERR_CD_SECURITY_INVALID_TOKEN = "SE002";
	public static final String ERR_MSG_SECURITY_INVALID_TOKEN = "Invalid token";
	
	public static final String ERR_CD_SECURITY_EXPIRED_TOKEN = "SE003";
	public static final String ERR_MSG_SECURITY_EXPIRED_TOKEN = "Expired token";
	
	public static final String ERR_CD_SECURITY_INTENAL = "SE004";
	public static final String ERR_MSG_SECURITY_INTENAL = "Security internal error";
	
	public static final String ERR_CD_SECURITY_UNAUTHORIZED_TOKEN = "SE005";
	public static final String ERR_MSG_SECURITY_UNAUTHORIZED_TOKEN = "User token required";
	
	public static final String ERR_CD_SECURITY_UNKNOWN_SERVICE_ENDPOINT = "SE006";
	public static final String ERR_MSG_SECURITY_UNKNOWN_SERVICE_ENDPOINT = "Unregistered service";
	
	public static final String ERR_CD_SECURITY_DISABLED_SERVICE_ENDPOINT = "SE007";
	public static final String ERR_MSG_SECURITY_DISABLED_SERVICE_ENDPOINT = "Disabled service endpoint";
	
	public static final String ERR_CD_NO_PERMISSION = "SE008";
	public static final String ERR_MSG_NO_PERMISSION = "权限不够";
	
	/** Bidding Error */
	public static final String ERR_CD_BIDDING_VALIDATION = "BD001";
	public static final String ERR_MSG_BIDDING_VALIDATION = "Bidding validation error.";
	
	public static final String ERR_CD_BIDDING_INVALID_INPUT = "BD002";
	public static final String ERR_MSG_BIDDING_INVALID_INPUT = "Invalid input.";
	
	public static final String ERR_CD_BIDDING_BID_AMOUNT_LOW = "BD003";
	public static final String ERR_MSG_BIDDING_BID_AMOUNT_LOW = "Invalid bid amount.";
		
	public static final String ERR_CD_BIDDING_AUCTION_NOT_STARTED = "BD004";
	public static final String ERR_MSG_BIDDING_AUCTION_NOT_STARTED = "Auction not started.";
	
	public static final String ERR_CD_BIDDING_AUCTION_ALREADY_ENDED = "BD005";
	public static final String ERR_MSG_BIDDING_AUCTION_ALREADY_ENDED = "Auction already ended.";
	
	public static final String ERR_CD_BIDDING_USER_NOT_REGISTERED = "BD006";
	public static final String ERR_MSG_BIDDING_USER_NOT_REGISTERED = "User not registered for this auction.";
	
	public static final String ERR_CD_BIDDING_USER_NOT_AUTHORIZED = "BD007";
	public static final String ERR_MSG_BIDDING_USER_NOT_AUTHORIZED = "User not authorized for bidding on this property.";
	
	public static final String ERR_CD_BIDDING_NOT_ONLINE_AUCTION = "BD008";
	public static final String ERR_MSG_BIDDING_NOT_ONLINE_AUCTION = "This property is not set for online bidding.";
	
	public static final String ERR_CD_BIDDING_NOT_ALLOW_PROXY_BID = "BD009";
	public static final String ERR_MSG_BIDDING_NOT_ALLOW_PROXY_BID = "Proxy bid is not allowed for this auction.";

	public static final String ERR_CD_BIDDING_PROXY_BID_STOPPED = "BD010";
	public static final String ERR_MSG_BIDDING_PROXY_BID_STOPPED = "Proxy bid is not allowed after auction starts.";

			// property service  exceptions
			//TODO rename to ERR_CD ...
	public static final String PROPERTY_SERVICE_EXCEPTION = "PS001";
	public static final String ERR_MSG_PROPERTY_SERVICE = "Property is not active";
	
	public static final String PROPERTY_SERVICE_EXCEPTION_FOR_INVALID_PROPERTYID = "PS002";
	public static final String ERR_MSG_PROPERTY_SERVICE_FOR_INVALID_PROPERTYID = "PropertyID NOT VALID";
	
	public static final String PROPERTY_WATCH_EXCEPTION = "PS101";
	public static final String ERR_MSG_PROPERTY_WATCH = "Invalid input sent in the request";
	
	public static final String PROPERTY_WATCH_EXCEPTION_FOR_USERID = "PS102";
	public static final String ERR_MSG_PROPERTY_WATCH_FOR_USERID = "User is not logged in to submit the feedback.";
	
	public static final String PROPERTY_WATCH_EXCEPTION_FOR_PROPERTYID = "PS103";
	public static final String ERR_MSG_PROPERTY_WATCH_FOR_PROPERTYID = "Property Id is not valid.";
	
	public static final String PROPERTY_WATCH_EXCEPTION_UNHANDLED = "PS104";
	public static final String ERR_MSG_PROPERTY_WATCH_UNHANDLED = "Not able to accept the feedback currently.";
	
	

	// Document Service Exceptions.
	public static final String DOCUMENT_SERVICE_EXCEPTION = "DS001";
	public static final String ERR_MSG_DOCUMENT_SERVICE = "Internal error occurred in document service.";
	
	/** Quartz Error*/
	public static final String ERR_CD_QUARTZ_CREATE_JOB = "JE014";
	public static final String ERR_MSG_QUARTZ_CREATE_JOB = "Job creation failed";
	
	/******* Tracing(debug) Messages ***********/
	// no message now
	
      
	/******* Aspect Errors***********/
	public static final String ERR_CD_CACHE_ASPECT = "AS001";
	public static final String ERR_MSG_CACHE_ASPECT = "No aspect action found";
	
	// ====================== Severity Codes ==============================
	// Severity FATAL
	public static final String SEVERITY_CODE_FATAL = "JF001";
	public static final String SEVERITY_LEVEL_FATAL = "FATAL";
	public static final String SEVERITY_NAME_FATAL = "Severity Fatal";
	public static final String SEVERITY_DESC_FATAL = "Fatal Severity";
	
	// Severity ERROR
	public static final String SEVERITY_CODE_ERROR = "JE001";
	public static final String SEVERITY_LEVEL_ERROR = "ERROR";
	public static final String SEVERITY_NAME_ERROR = "Severity Error";
	public static final String SEVERITY_DESC_ERROR = "Error Severity";
	
	// Severity WARNING
	public static final String SEVERITY_CODE_WARNING = "JW001";
	public static final String SEVERITY_LEVEL_WARNING = "WARNING";
	public static final String SEVERITY_NAME_WARNING = "Severity Warning";
	public static final String SEVERITY_DESC_WARNING = "Warning Severity";
	
	// Severity INFO
	public static final String SEVERITY_CODE_INFO = "JI001";
	public static final String SEVERITY_LEVEL_INFO = "INFO";
	public static final String SEVERITY_NAME_INFO = "Severity Info";
	public static final String SEVERITY_DESC_INFO = "Info Severity";

	// Severity TRACE
	public static final String SEVERITY_CODE_TRACE = "JT001";
	public static final String SEVERITY_LEVEL_TRACE = "TRACE";
	public static final String SEVERITY_NAME_TRACE = "Severity Trace";
	public static final String SEVERITY_DESC_TRACE = "Trace Severity";
	
	// external service  exceptions
	public static final String EXTERNAL_SERVICE_EXCEPTION = "ES001";
	public static final String ERR_MSG_EXTERNAL_SERVICE = "External service call exception";
}

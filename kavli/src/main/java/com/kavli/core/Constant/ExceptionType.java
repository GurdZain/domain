package com.kavli.core.Constant;
/**
 *=====================================================================
 * ACP Exception Type Constants
 *
 * Exception type definitions on ACP Platform. 
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

public final class ExceptionType {

	  //======================================================
	  //                Business Exception Types
	  //------------------------------------------------------
	  //  Note: Do not convert Business Exception to Technical Exception
	  //======================================================
	  //
	  /* Type 1: Default Business Exceptions  */
	  public static final String EXCEPTION_BUSINESS = "BusinessException";
	  
	  /* Type 2: Specific Business Exceptions  */
	  public static final String EXCEPTION_XML = "XmlDocumentException";
	  public static final String EXCEPTION_JSON = "JSONException";

	  
	  //======================================================
	  //               Technical Exception Types
	  //------------------------------------------------------
	  // Note: 
	  //    1. catch exceptions and logging the exception immediately
	  //    2. caller needs to convert the thrown exceptions with its 
	  //       exceptions without changing exception type and contents
	  //       and also don't logging this exception again
	  // Sample:
	  //    DAO Layer: 
	  //       a. catch itself exceptions then logging the exception with correct type
      //       b. catch UtilityException thrown out on calling core utilities if existed    
	  //          then convert that to ServiceException without logging outputs
	  //       c. create and throw DaoException to its caller in Service layer
	  //
	  //    Service layer:
	  //       a. catch itself exceptions then logging the exceptions with correct type
      //       b. catch UtilityException thrown out on calling core utilities if existed    
	  //          then convert that to ServiceException without logging outputs
	  //       c. catch DaoException thrown out by DAO Layer
	  //          then convert that to ServiceException without logging outputs
	  //       d. Only throw ServiceExceptions and Business Exceptions to its AMS caller 
	  //======================================================
	  //
	  /* Type 1: Default Technical Exceptions  */
	  public static final String EXCEPTION_APPLICATION = "ApplicationException";
	  
	  public static final String EXCEPTION_NOTFOUND = "ResourceNotFoundException";

	  /* Type 2: Core or Utility Exceptions */
	  public static final String EXCEPTION_UTILITY     = "UtilityException";
	  public static final String EXCEPTION_QUARTZ      = "QuartzException";
	  public static final String EXCEPTION_IOEXCEPTION = "IOException";
	  public static final String EXCEPTION             = "Exception";

	  /* Type 3: AMS Layer Exceptions */
	  public static final String EXCEPTION_JMS         = "JmsException";
	  public static final String EXCEPTION_WS          = "WebServiceException";
	  public static final String EXCEPTION_DELEGATE    = "BusinessDelegateException";

	  /* Type 4: Service Layer Exceptions */
	  public static final String EXCEPTION_SERVICE     = "ServiceException";
	  public static final String EXCEPTION_UNSUPPORTED = "UnsupportedOperation";
	  public static final String EXCEPTION_BUSINESS_DELEGATION = "BusinessDelegationException";
	  
	  /* Type 5: DAO Layer Exceptions */
	  public static final String EXCEPTION_DAO             = "DaoException";
	  public static final String EXCEPTION_ENTITY_NOTFOUND = "EntityNotFoundException";
	  public static final String EXCEPTION_RESULT_NOTFOUND = "ResultNotFoundException";
	  public static final String EXCEPTION_UPDATE_ERR      = "ErrorUpdateException";
	  public static final String EXCEPTION_VERSION_SYNC    = "VersioningException";
	  public static final String EXCEPTION_QUERY_INVALID   = "InvalidQuery";

      // Parameter validations 
	  public static final String EXCEPTION_PARAMETER  = "ErrorParameters";
	  public static final String EXCEPTION_VALIDATION = "ValidationException";

	  /* Type 6: Application Contexts and Connection Exceptions */
	  public static final String EXCEPTION_CONTEXT    = "ContextException";
      public static final String EXCEPTION_CONNECTION = "ConnectionException";
	  
      /* Type 7: User Authentication Exceptions */
	  public static final String EXCEPTION_AUTHENTICATION = "AuthenticationException";
	  public static final String EXCEPTION_AUTHORIZATION  = "AuthorizationException";

	  /* Type 8: Faces  Exception */
	  public static final String EXCEPTION_FACESHANDLER = "FacesHandlerException";
	  
	  public static final String EXCEPTION_CLIENT_REQUEST_VALIDATION="ClientInputValidationException";
	
}

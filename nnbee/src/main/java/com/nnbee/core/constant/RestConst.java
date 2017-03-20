package com.nnbee.core.constant;
/**
 *=====================================================================
 * ACP Restful Core Service Constants
 *
 * Provide constant definitions on ACP core web service layer. 
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

public class RestConst {

	// Rest Service
	public static final String BASE_REST_REQ   = "baserestrequest";
	public static final String REQ_URI         = "Request URI";
	public static final String REQ_DATA_FORMAT = "json";
	public static final String REQ_PARAMS      = "Request Parameters";
	
	
	public static final String REQ_PARAM_AUTHORIZATION = "Authorization";
	
	public static final String REQ_PARAM_AUTHORIZATION_BEARER = "bearer ";
	
	public static final String PRE_SERVICE_ENDPOINT_FLITER = "SERVICE_ENDPOINT_FLITER_";
	
	public static final String REQ_PARAM_TIMEZONE = "timezone";
	
	public static final String REQ_PARAM_TIMEZONE_DEFAULT = "America/Los_Angeles";
	
	public static final String SECURITY_NAME_EMAIL = "email";
	
	public static final String SECURITY_NAME_USERNAME = "username";
	
	public static final String SECURITY_NAME_FIRST_NAME = "firstName";
	
	public static final String SECURITY_NAME_LAST_NAME = "lastName";
	
	public static final String SECURITY_NAME_USERID = "userId";
	
	public static final String SECURITY_NAME_GRANT_TYPE = "grant_type";
	
	public static final String TOKEN_REQUEST_CLIENT_IP = "client_ip";
	
	public static final String TOKEN_REQUEST_CLIENT_NAME = "client_name";
	
	public static final String TOKEN_REQUEST_SESSION_ID = "session_id";
	
	public static final String TOKEN_REQUEST_COOKIE_ID = "cookie_id";
	
	public static final String HEADER_REQUEST_ENTERPRISE_ID = "enterprise_id";
	
	public static final String HEADER_REQUEST_APP_VERSION = "app_version_code";
	
	public static final String HEADER_REQUEST_DEVICE_TYPE = "device_type";
	
	public static final String HEADER_REQUEST_DEVICE_TYPE_ANDROID_PAD = "android_pad";
	
	public static final String HEADER_REQUEST_DEVICE_TYPE_ANDROID_PHONE = "android_phone";
	
	public static final String HEADER_REQUEST_DEVICE_INFO = "device_info";
	
	public static final String APP_VERSION_PREFIX="app_version_";
	
	public static final String EXPRESS_URL = "/services/transaction/";

	public static final String EXPRESS_TOKEN = "express_token";
	public static final int RES_STATUS_CODE_200 = 200;
	public static final int RES_STATUS_CODE_300 = 300;
	public static final int RES_STATUS_CODE_400 = 400;
	public static final int RES_STATUS_CODE_500 = 500;

}

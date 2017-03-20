package com.nnbee.core.constant;
/**
 *=====================================================================
 * ACP Core Framework Constants
 *
 * Provide constant definitions on ACP Core Framework. 
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 


/**
 *=====================================================================
 * constant definitions on Application level
 *
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 08/02/2011   create
 *
 */	 

public class CoreConst {

	//--------------------------------------
    //  Application Configurations 
	//--------------------------------------
	/* Application Name  */
	public static final String APPLILCATION_NAME = "A2 Application";

	/* Application Resource Path  */
	public static final String RESOURCE_PATH = "/";

	/* Application Resource Bundle */
	public static final String APP_PROPERTITY_FILE = "application.properties";
	public static final String APP_PROPERTITY_FILE_NAME = "application";
	public static final String APP_PROPERTITY_INSTANCE_NAME = "application.instance.name";
	
	/* Analytics Application Resource Bundle */
	public static final String APP_PROPERTITY_FILE_ANALYTICS = "analytics.properties";
	
	/* Document Application Resource Bundle */
	public static final String APP_PROPERTITY_DOCUMENT_SERVICE_FILE = "document.properties";
	
	
	
	/* MQ Resource Bundle */
	public static final String MQ_PROPERTITY_FILE = "mq.properties";
	public static final String MQ_PROPERTITY_FILE_NAME = "mq";

	/* Memcached Resource Bundle */
	public static final String MEMCACHED_PROPERTIES = "memcached.properties";
	
	/* Oauth Resource Bundle */
	public static final String OAUTH_PROPERTIES = "oauthResources.properties";
	
	/* ACPCore Resource Bundle */
	public static final String ACPCORE_PROPERTIES = "acpcore.properties";
	public static final String ACPCORE_PROPERTY_TIME_TRACKER_LOGGER_APPENDER_NAME = "acpcore.time.tracker.logger.appender.name";
	
	/* Faces Resource Bundle  */
	public static final String RESOURCE_FACES_MESSAGE = "FacesMessages";

	/* CRLF Code  */
	public static final String CRLF = "\n";

	
	//--------------------------------------
    //  Logging Level Configurations
	//--------------------------------------
	public static final char LOGGING_LEVEL_FATAL = 'F';
	public static final char LOGGING_LEVEL_ERROR = 'E';
	public static final char LOGGING_LEVEL_WARN  = 'W';
	public static final char LOGGING_LEVEL_INFO  = 'I';
	public static final char LOGGING_LEVEL_DEBUG = 'D';


	//---------------------------------------------
    //  Time Tracking & Logging Configurations
	//---------------------------------------------
	/* Time tracking for test and debug */
	public static final String TIME_TRACKING_LOG = "timetracking.log.path";
	public static final String TIME_TRACKING_MODE = "timetracking.Mode";
	
	public static final String TIME_TRACKING_MODE_DEBUG = "debug";
	public static final String TIME_TRACKING_MODE_PRODUCTION = "production";
	
	
	//--------------------------------------
    //  Memcached Configurations
	//--------------------------------------
	/* memcached connection info */
	public static final String MEMCACHED_HOST = "memcached.dev.connection.host";
	public static final String MEMCACHED_PORT = "memcached.dev.connection.port";
	public static final String MEMCACHED_TIMEOUT = "memcached.dev.timeout" ;
	
	/* memcached active event collection key */
	public static final String EVENTS_ACTIVE_MEMCACHED = "memcached.event.active" ;
	
	//--------------------------------------
    //  XML Configurations
	//--------------------------------------
	/* XML Special Tags */
	public static final String XML_SPECIAL_TAG_BEGINE = "<![CDATA[";
	public static final String XML_SPECIAL_TAG_END = "]]>";

	/* the path of XSD files */
	public static final String XSD_PATH = "xsd.path";
	public static final String XSD_PATH_BID_UPDATE = "bidUpdate.xsd";
	public static final String XSD_PATH_BID_STATUS = "bidStatus.xsd";
	public static final String XSD_PATH_BID_REQUEST = "event_offer_bid.xsd";
	public static final String XSD_PATH_EVENT_OFFER_UPDATE= "eventOfferUpdate.xsd";
	
	public static final String XSD_PATH_EVENT_REQUEST = "event_request.xsd";
	public static final String XSD_PATH_EVENT_OFFER_REQUEST = "event_offer_request.xsd";
	
	public static final String XSD_PATH_SYSTEMMANGER_REQUEST = "systemmanager_request.xsd";
	public static final String XSD_PATH_SYSTEMMANGER_RESPONSE = "systemmanager_response.xsd";
	
	public static final String XSD_PATH_GENERIC_REQUEST = "generic_request.xsd";
	
	public static final String MESSAGE_DESTINATION_FUNCTION_REQUEST = "request";
	public static final String MESSAGE_DESTINATION_FUNCTION_RESPONSE = "resqonse";
	
	public static final String MESSAGE_DESTINATION_TYPE_QUEUE = "queue";
	public static final String MESSAGE_DESTINATION_TYPE_TOPIC = "topic";
	
	public static final String MESSAGE_DESTINATION_BIDDING_REQUEST_QUEUE_PREFIX = "QUEUE.ENGINE.BID.REQUEST.";
	
	public static final String MESSAGE_DESTINATION_SERVICE_AUCTIONENGINE = "auction engine";
	public static final String MESSAGE_DESTINATION_SERVICE_DATABROKER = "data broker";
	public static final String MESSAGE_DESTINATION_SERVICE_SYSTEMMANAGER = "system manager";
	
	
	//--------------------------------------
    //  Auction Management Configurations
	//--------------------------------------
	/* Auction Extension time configuration*/
	public static final String BID_EXTENSION_THREADHOLD = "bid.extension.threshold";
	public static final String BID_EXTENSION_INCERESE= "bid.extension.incremence";

	/* Auction Status configuration*/
	public static final String AUCTION_STATUS_PENDING = "pending";
	public static final String AUCTION_STATUS_ACTIVE = "ACTIVE";
	public static final String AUCTION_STATUS_FINALIZING = "finalizing";
	public static final String AUCTION_STATUS_CLOSED = "closed";
//	public static final String AUCTION_STATUS_SUSPENDED = "SUSPENDED"; 
	
	/* Auction Process State */
	public static final String AUCTION_PROCESS_STATE_LIVE = "Live";
	public static final String AUCTION_PROCESS_STATE_SUSPENDED = "Suspend";
	
	//QUEUE EVENT MAPPING STATUS
	public static final String QUEUE_EVENT_MAPPING_PENDING = "pending";
	public static final String QUEUE_EVENT_MAPPING_ACTIVE = "active";
	public static final String QUEUE_EVENT_MAPPING_CLOSED = "closed";
	
	public static final String QUARTZ_JOB_NAME_EVENT_CREATE_PRE = "createEvent";
	public static final String QUARTZ_JOB_NAME_EVENTOFFER_CREATE_PRE = "finilizeEventOffer";
	public static final String QUARTZ_JOB_NAME_CHECK_FINILIZEJOB_PRE = "checkFinilizeJobBeforeEventEnds";
	
	/* Auction operation type configuration*/
	public static final String EVENT_OPERATION_TYPE_CREATE = "CREATE";
	public static final String EVENT_OPERATION_TYPE_EDIT = "EDIT";
	public static final String EVENT_OPERATION_TYPE_CLEANUP = "CLEANUP";
	
	// Bid Evaluation result 
	public static final String HIGH_BID = "HIGH BID";
	public static final String FAILED_BID = "FAILED BID";
	
	public static final String AUCTIONENGINE_INSTANCE_TOTLE = "auctionengine.instance.total";
	
	public static final String QUEUENAME_FINALZATION_RESPONSE = "QUEUE.MANAGER.AE.FEEDBACK";


	// Auction Job Events Logging
	public static final String JOB_OPERATION_TYPE_CREATE  = "CREATE";
	public static final String JOB_OPERATION_TYPE_UPDATE  = "UPDATE";
	public static final String JOB_OPERATION_TYPE_DELETE  = "DELETE";
	public static final String JOB_OPERATION_TYPE_TRIGGER = "TRIGGER";
	
	public static final String JOB_SERVICE_NAME_SYSTEM_MANGER  = "SYSTEM MANAGER";
	public static final String JOB_SERVICE_NAME_AUCTION_ENGINE = "AUCTION ENGINE";
	
	public static final String JOB_ENTITY_TYPE_EVENT       = "EVENT";
	public static final String JOB_ENTITY_TYPE_EVENT_OFFER = "EVENT_OFFER";
	public static final String JOB_ENTITY_TYPE_EOAM        = "EVENT_OFFER_ACTION_MATRIX";
	
	//Grant type name defination
	public static final String OAUTH2_GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
	public static final String OAUTH2_GRANT_TYPE_PASSWORD = "password";
	public static final String OAUTH2_GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
	
	
	public final static String APPLICATION_JSON = "application/json";
}

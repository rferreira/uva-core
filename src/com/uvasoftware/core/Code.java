/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core;

/**
 * Infrastructure Status and Error Codes
 * 
 * @author <a href="raf@uvasoftware.com">Rafael Ferreira</a>
 *  
 */
public final class Code {
	
	/**
	 * A SIF Status is returned in a <code>SIF_ACK</code> to acknowledge successfully processing a message. 
	 * 
	 */
	public class Status {

		public static final int SUCCESS = 0;
		public static final int IMMEDIATE_SIF = 1;
		public static final int INTERMEDIATE_ACK = 2;
		public static final int FINAL_ACK = 3;
		public static final int DUPLICATE_MESSAGE_ID = 7;
		public static final int RECEIVER_SLEEPING = 8;
		public static final int NO_MESSAGE_AVAILABLE = 9;
		
	}
	
	/**
	 * Describes the SIF functional areas where an error may occur. Maps to <code>SIF_Error/SIF_Category</code>
	 * 
	 */
	public class ErrorCategory {
		public static final int UNKNOWN= 0;
		public static final int XML_VALIDATION = 1;
		public static final int ENCRYPTION = 2;
		public static final int AUTHENTICATION = 3;
		public static final int ACCESS_AND_PERMISSIONS = 4;
		public static final int REGISTRATION = 5;
		public static final int PROVISION = 6;
		public static final int SUBSCRIPTION = 7;
		public static final int REQUEST_AND_RESPONSE = 8;
		public static final int EVENT_REPORTING_AND_PROCESSING = 9;
		public static final int TRANSPORT = 10;
		public static final int SYSTEM = 11;
		public static final int GENERIC_MESSAGE_HANDLING = 12;
	}

	/**
	 * <code>SIF_Error</code> codes related to XML parsing/validation 
	 * 
	 */
	public class XmlValidationError {
		public static final int GENERIC_ERROR = 1;
		public static final int MESSAGE_IS_NOT_WELL_FORMATTED = 2;
		public static final int GENERIC_VALIDATION_ERROR = 3;
		public static final int INVALID_VALUE_FOR_ELEMENT_OR_ATTRIBUTE = 4;
		//public static final int RESERVED = 5;
		public static final int MISSING_MANDATORY_ELEMENT_OR_ATTRIBUTE = 6;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to encryption 
	 * 
	 */
	public class EncryptionError {
		public static final int GENERIC_ERROR =1;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to authentication 
	 * 
	 */
	public class AuthenticationError {
		public static final int GENERIC_ERROR =1;
		public static final int GENERIC_AUTHENTICATOIN_ERROR =2;
		public static final int MISSING_SENDER_CERTIFICATE = 3;
		public static final int INVALID_CERTIFICATE =4;
		public static final int SENDER_CERTIFICATE_IS_NOT_TRUSTED = 5;
		public static final int EXPIRED_CERTIFICATE = 6;
		public static final int INVALID_SIGNATURE = 7;
		public static final int INVALID_ENCRYPTION_ALGORIGTHM = 8;
		public static final int MISSING_PUBLIC_KEY_OF_THE_RECEIVER = 9;
		public static final int MISSING_RECEIVER_PRIVATE_KEY = 10;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to ACL's 
	 * 
	 */
	public class AccessAndPermissionError {
		public static final int GENERIC_ERROR =1;
		public static final int NO_PERMISSION_TO_REGISTER =2;
		public static final int NO_PERMISSION_TO_PROVIDE_THIS_OBJECT =3;
		public static final int NO_PERMISSION_TO_SUBSCRIBE_TO_THIS_SIF_EVENT =4;
		public static final int NO_PERMISSION_TO_REQUEST_THIS_OBJECT = 5;
		public static final int NO_PERMISSION_TO_RESPOND_TO_THIS_OBJECT = 6;
		public static final int NO_PERMISSION_TO_REPORT_SIF_EVENT = 7;
		public static final int NO_PERMISSION_TO_ADMINISTER_POLICIES =8;
		public static final int SIF_SOURCEID_IS_NOT_REGISTERED = 9;
		public static final int NO_PERMISSION_TO_REPORT_SIF_EVENT_ADD = 10;
		public static final int NO_PERMISSION_TO_REPORT_SIF_EVENT_CHANGE = 11;
		public static final int NO_PERMISSION_TO_REPORT_SIF_EVENT_DELETE = 12;
		
		
	}
	
	/**
	 * <code>SIF_Error</code> codes related to registering 
	 * 
	 */
	public class RegistrationError {
		public static final int GENERIC_ERROR = 1;
		public static final int SIF_SOURCEID_IS_INVALID = 2;
		public static final int REQUESTED_TRANSPORT_PROTOCOL_IS_UNSUPPORTED= 3;
		public static final int REQUESTED_SIF_VERSION_IS_NOT_SUPPORTED = 4;
		//public static final int RESERVED = 5;
		public static final int REQUESTED_SIF_MAXBUFFERSIZE_IS_TOO_SMALL = 6;
		public static final int ZIS_REQUIRES_A_SECURE_TRANSPORT = 7;
		//public static final int RESERVED_2 = 8;
		/**
		 * Returned when a  push mode agent send a <code>SIF_GetMessage</code>
		 */
		public static final int AGENT_IS_REGISTERED_FOR_PUSH_MODE = 9;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to a provide message 
	 * 
	 */
	public class ProvisionErorr {
		public static final int GENERIC_ERROR = 1;
		//public static final int RESERVED = 2;
		public static final int INVALID_OBJECT = 3;
		/**
		 * <code>SIF_Provide</code> Message
		 */
		public static final int OBJECT_ALREADY_HAS_A_PROVIDER = 4;
		/**
		 * <code>SIF_UnProvide</code> Message
		 */
		public static final int NOT_THE_PROVIDER_OF_THE_OBJECT = 5;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to a subscribe message 
	 * 
	 */
	public class SubscriptionError {
		public static final int GENERIC_ERROR = 1;
		//public static final int RESERVED = 2;
		public static final int INVALID_OBJECT = 3;
		/**
		 * <code>SIF_Unsubscribe</code> message
		 */
		public static final int NOT_A_SUBSCRIBER_OF_THE_OBJECT = 4;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to request/response
	 * 
	 */
	public class RequestAndResponseError {
		public static final int GENERIC_ERROR = 1;
		public static final int INVALID_OBJECT = 3;
		public static final int NO_PROVIDER = 4;
		public static final int RESPONDER_DOES_NOT_SUPPORT_REQUESTED_VERSION = 7;
		public static final int RESPONDER_DOES_NOT_SUPPORT_REQUESTED_SIF_MAXBUFFERSIZE = 8;
		public static final int UNSUPPORTED_QUERY_IN_REQUEST = 9;
	}
	
	/**
	 * <code>SIF_Error</code> codes related to event reporting and processing 
	 * 
	 */
	public class EventReportingAndProcessingError {
		public static final int GENERIC_ERROR = 1;
		public static final int INVALID_EVENT = 3;
	}
	
	
	/**
	 * <code>SIF_Error</code> codes related to transport issues 
	 * 
	 */
	public class TransportError {
		public static final int GENERIC_ERROR = 1;
		public static final int REQUESTED_PROTOCOL_IS_NOT_SUPPORTED = 2;
		public static final int SECURE_CHANNEL_REQUESTED_AND_NO_SECURE_PATH_EXISTS = 3;
		public static final int UNABLE_TO_STABLISH_CONNECTION = 4;
	}
	
	/**
	 * <code>SIF_Error</code> for a faulty system 
	 * 
	 */
	public class SystemError {
		public static final int GENERIC_ERROR = 1;
	}
	
	/**
	 * <code>SIF_Error</code> codes for genetic message hanlding
	 * 
	 */
	public class GenericMessageHandlingError {
		public static final int GENERIC_ERROR = 1;
		public static final int MESSAGE_NOT_SUPPORTED = 2;
		public static final int VERSION_NOT_SUPPORTED = 3;
	}
}

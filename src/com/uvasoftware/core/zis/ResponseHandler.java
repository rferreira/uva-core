/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFEvent;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.SIFResponse;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Handles <code>SIF_Response</code> messages
 * 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 */
public class ResponseHandler implements IEventHandler {

	private static Logger log = Logger.getLogger(ResponseHandler.class);

	public ResponseHandler() {
		log.info("enabled");
	}
	
	
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		SIFAck resp = null;
		ZIS zis = (ZIS) eventSource;


		if (message.getType() == SIFMessage.Type.RESPONSE) {
			
			SIFResponse r = message.getResponse();
			
			if (r.getHeader().getDestinationId() != null && r.getRequestMsgID() != null ) {
				zis.DAO.putMessage(message);	
				resp = message.createResponseAck();
				resp.setStatusCode(Code.Status.SUCCESS);
				
			} else {
				resp = message.createResponseAck();
				resp.setErrorCode(Code.RequestAndResponseError.GENERIC_ERROR);
				resp.setErrorCategory(Code.ErrorCategory.REQUEST_AND_RESPONSE);
				resp.setErrorDesc("destinationid and request msg id must be present in the message");
			}
		}
		
		// should send response out. 
		if (resp != null) args.response = resp;
	}

}

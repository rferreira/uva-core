/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.SIFEvent;
import com.uvasoftware.core.exception.StopDispatchException;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Handles <code>SIF_Event</code> messages
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class EventHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(EventHandler.class);

	public EventHandler() {
		log.info("enabled");
	}
	
	
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		SIFAck resp = null;
		ZIS zis = (ZIS) eventSource;


		if (message.getType() == SIFMessage.Type.EVENT) {
			
			log.debug("in event message handler");
			
			log.debug(String.format("Storing new event with id %s and action %s for object %s in the message queue", message.getId(), message.getEvent().getAction(), message.getEvent().getEventObjectName() ));
			zis.DAO.putMessage(message);	
			resp = message.createResponseAck();
			resp.setStatusCode(Code.Status.SUCCESS);
			args.response = resp; 
		}
		
		// should send response out. 
	

	}

}

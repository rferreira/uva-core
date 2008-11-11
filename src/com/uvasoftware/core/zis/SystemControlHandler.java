/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.util.IEventHandler;
import com.uvasoftware.core.*;
/**
 * Handles <code>SIF_SystemControl</code> messages
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class SystemControlHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(SystemControlHandler.class);
	
	public SystemControlHandler() {
		log.info("enabled");
	}
	
	public void handle(Object eventSource, Object eventArgs) { 
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		ZIS zis = (ZIS) eventSource;
		SIFMessage message = args.request;
		SIFAck resp = null;
	
		AgentRecord agent = zis.DAO.getAgent(message.getSourceId().trim());
		
		
		
		if (message.getType() == SIFMessage.Type.PING) {
			resp = new SIFAck(message.getHeader().getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);
			
		}else if (message.getType() == SIFMessage.Type.SLEEP) {
			agent.isSleep = true;
			log.info(String.format("Agent %s is going to sleep",message.getSourceId()));
			resp = new SIFAck(message.getHeader().getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);
			
		}else if (message.getType() == SIFMessage.Type.WAKEUP) {
			log.info(String.format("Agent %s is waking up",message.getSourceId()));
			agent.isSleep = false;
			resp = message.createResponseAck();
			resp.setStatusCode(Code.Status.SUCCESS);
			//resp = new SIFAck(message.getHeader().getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);
			

		} else if (message.getType() == SIFMessage.Type.GETMESSAGE) {
			log.debug("in get message handler");
			
			java.util.List<SIFMessage> messages = zis.DAO.getMessagesForAgent(agent.sourceId);
			
			log.debug("returning " + messages.size() + " messages");
			
			resp = message.createResponseAck();
			
			if (messages.size() > 0 ) {
				
				resp.setStatusCode(Code.Status.SUCCESS);	
				resp.setAllStatusData(messages);
			}else {
				//resp = new SIFAck(message.getHeader().getSIFTime(),message.getHeader().getId(),Code.Status.NO_MESSAGE_AVAILABLE);
				resp.setStatusCode(Code.Status.NO_MESSAGE_AVAILABLE);
			}
		
		} 
		
		
		if (resp != null) args.response = resp;
	
		
	
	}

}

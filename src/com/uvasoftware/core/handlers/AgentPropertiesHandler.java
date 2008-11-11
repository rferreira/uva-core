/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.handlers;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.uvasoftware.core.SIFEndPoint;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.util.ConfigConstants;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Event handler that takes care of populating the outbound message with the correct agent information
 * @author rafael
 *
 */
public class AgentPropertiesHandler implements IEventHandler {

	private static Logger log = Logger.getLogger(AgentPropertiesHandler.class);  
	
	/** 
	 * Event handler
	 */
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		
		// decomposing event
		
		SIFEndPoint ep = (SIFEndPoint) eventSource;
		SIFMessage msg = (SIFMessage) eventArgs;
		Properties props = ep.agentProperties;
		
		log.debug("populating message with agent information, handling message:" + msg.getId());
		
		/*
		 * Message requirements:
		 */
		log.debug("populating message");
		
		
		
		/*
		 * HEADER
		 */
		log.debug("populating header");
		msg.getHeader().setSourceId(props.getProperty(ConfigConstants.AGENT_SOURCEID));

	
		
		if (msg.getType() == SIFMessage.Type.REGISTER) {
			
			// REGISTER
			
			log.debug("populating register message");
			msg.getRegister().setMaxBuffer(Integer.parseInt(props.getProperty(ConfigConstants.AGENT_MAXBUFFER)));
			
			if (props.getProperty(ConfigConstants.AGENT_MODE).toLowerCase() == "push") {
				throw new Exception("PUSH agents are not currently supported!");
			}
			
			msg.getRegister().setMode(props.getProperty(ConfigConstants.AGENT_MODE));
			msg.getRegister().setName(props.getProperty(ConfigConstants.AGENT_NAME));
			msg.getRegister().getVersions().add(props.getProperty(ConfigConstants.AGENT_SIF_SUPPORT));
			
		}else if (msg.getType() == SIFMessage.Type.REQUEST) {
			
			// REQUEST
			log.debug("setting message request version");
			msg.getRequest().setVersion(props.getProperty(ConfigConstants.AGENT_SIF_SUPPORT));
			log.debug("setting request buffer size");
			msg.getRequest().setMaxBuffer(Integer.parseInt(props.getProperty(ConfigConstants.AGENT_MAXBUFFER)));
		}

	}
	

}

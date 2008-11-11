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
 * Handles <code>SIF_Provides</code> messages
 * @author rafael
 *
 */
public class ProvisionHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(ProvisionHandler.class);

	public ProvisionHandler() {
		log.info("enabled");
	}
	
	public void handle(Object eventSource, Object eventArgs) {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		ZIS zis = (ZIS) eventSource;
		
		
		if (message.getType() == SIFMessage.Type.PROVIDE) {
			SIFProvide prov = message.getProvide();
			
			//loading agent
			AgentRecord agent = zis.DAO.getAgent(message.getSourceId().trim());
			try  {
				for (SIFObjectName n: prov.getProvidedObjects()) 
				{
					log.info(String.format("Adding agent [%s] as the provider for type: %s", message.getSourceId(), n));
					agent.provides.add(n);
					args.response =  new SIFAck(message.getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);

				}
				
				// saving agent
				zis.DAO.putAgent(agent);
				
			} catch (Exception e) {
				args.response = new SIFAck(message.getSourceId(),message.getId(),Code.ErrorCategory.SUBSCRIPTION,Code.SubscriptionError.GENERIC_ERROR, "Generic Error");
				return;
			}
			
			
		}else if (message.getType() == SIFMessage.Type.UNPROVIDE) {
			SIFUnProvide unprov = message.getUnProvide();
			AgentRecord agent = zis.DAO.getAgent(message.getSourceId().trim());
			
			try  {
				for (SIFObjectName n: unprov.getUnProvidedObjects())
				{
					log.info(String.format("Removing agent [%s] as the provider for type: %s", message.getSourceId(), n));
					agent.provides.remove(n);
					args.response =  new SIFAck(message.getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);

				}
				// saving agent
				zis.DAO.putAgent(agent);
				
			} catch (Exception e) {
				args.response = new SIFAck(message.getSourceId(),message.getId(),Code.ErrorCategory.SUBSCRIPTION,Code.SubscriptionError.GENERIC_ERROR, "Generic Error");
				return;
			}
			
			
		}

	}

}

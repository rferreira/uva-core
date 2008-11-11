package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.*;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Handles <code>SIF_Subscribe</code> messages
 * @author rafael
 *
 */
public class SubscribeHandler implements IEventHandler {

	private static Logger log = Logger.getLogger(SubscribeHandler.class);

	public SubscribeHandler() {
		log.info("enabled");
	}
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		SIFAck resp = null;
		ZIS zis = (ZIS) eventSource;
		String name = message.getSourceId().trim();


		if (message.getType() == SIFMessage.Type.SUBSCRIBE) {
			SIFSubscribe sub = message.getSubscribe();
			
			try  {
				AgentRecord agent = zis.DAO.getAgent(name);
				
				for (SIFObjectName n: sub.getSubscribedObjects() ) 
				{
					log.info(String.format("Adding agent [%s] as the subscriber for type: %s", message.getSourceId(), n));
					agent.subscribes.add(n);
					args.response =  new SIFAck(message.getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);

				}
				zis.DAO.putAgent(agent);
				
			} catch (Exception e) {
				args.response = new SIFAck(message.getSourceId(),message.getId(),Code.ErrorCategory.SUBSCRIPTION,Code.SubscriptionError.GENERIC_ERROR, "Generic Error");
				return;
			}
			
		} else if (message.getType() == SIFMessage.Type.UNSUBSCRIBE) {
				SIFUnSubscribe sub = message.getUnSubscribe();
				
				try  {
					AgentRecord agent = zis.DAO.getAgent(name);
					
					for (SIFObjectName n: sub.getUnSubscribedObjects() ) 
					{
						log.info(String.format("removing agent [%s] as the subscriber for type: %s", message.getSourceId(), n));
						agent.subscribes.remove(n);
						args.response =  new SIFAck(message.getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);

					}
					zis.DAO.putAgent(agent);
					
				} catch (Exception e) {
					args.response = new SIFAck(message.getSourceId(),message.getId(),Code.ErrorCategory.SUBSCRIPTION,Code.SubscriptionError.GENERIC_ERROR, "Generic Error");
					return;
				}
		}
	}

}

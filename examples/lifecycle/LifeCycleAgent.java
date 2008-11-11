/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

import java.util.Properties;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.Authentication;
import com.uvasoftware.core.data.infra.AuthenticationInfo;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Displays how Uva Core can be used to produce both consumers and producers agents using its built in agent micro framework
 * @author Rafael Ferreira <raf@uvasoftware.com>
 * @see SIFAgent
 *
 */
public class LifeCycleAgent {
	public static class Producer implements IEventHandler{
		
		public SIFAgent agent = null;
		public Producer() {
			Properties p = new Properties();
			p.setProperty(ConfigConstants.AGENT_NAME, "producer");
			p.setProperty(ConfigConstants.AGENT_SOURCEID, "producer");
			p.setProperty(ConfigConstants.AGENT_ZONE_URL, "mock://local");
			p.setProperty(ConfigConstants.AGENT_POLL_PERIOD, "20000");
			agent = new SIFAgent(p);
			agent.provides.add(SIFObjectName.Authentication);
			
			// registering message producer
			agent.onPeriodicRun.appendHandler(this);
			
			
		}
		/**
		 * Since this is the producer this method will be fired periodically to trigger new events
		 */
		public void handle(Object eventSource, Object eventArgs)
				throws Exception {
			
			// generates dummy event
			SIFAgent ag = (SIFAgent) eventSource;
			
			Authentication auth = new Authentication();
			AuthenticationInfo ai = new AuthenticationInfo("AD name",AuthenticationInfo.SystemType.Application);
			ai.setDistinguishedName("john@example.com");
			ai.setPassword(AuthenticationInfo.PasswordAlgorithm.base64, "password", "password");
			auth.addAuthenticationInfo(ai);
			
			ag.getZone().sendEvent(auth, SIFObjectName.Authentication, SIFEvent.Action.Add);
			
			
		}
		
		
	}
	
	public static class Consumer implements IEventHandler{
		public SIFAgent agent = null;
		public Consumer() {
			
			Properties p = new Properties();
			p.setProperty(ConfigConstants.AGENT_NAME, "consumer");
			p.setProperty(ConfigConstants.AGENT_SOURCEID, "consumer");
			p.setProperty(ConfigConstants.AGENT_ZONE_URL, "mock://local");
			p.setProperty(ConfigConstants.AGENT_POLL_PERIOD, "15000");
			agent = new SIFAgent(p);
			agent.subscribes.add(SIFObjectName.Authentication);
			
			// registering new message handler
			
			agent.onReceiveMessage.appendHandler(this);
		}
		
		/**
		 * Since this is the consumer, this method will be used to read the incoming messages
		 */
		public void handle(Object eventSource, Object eventArgs)
		throws Exception {
			
			//  event
			SIFAgent ag = (SIFAgent) eventSource;
			SIFMessage msg = (SIFMessage) eventArgs;
			
			System.out.println("received event for message " + msg.getId());
	
		}
	}
	
	public static void main(String args[] ) throws Exception {
		
		//Config.getInstance().set(ConfigConstants.DEBUG_SIF,"true");
		
		System.out.println("starting consumer");
		
		Consumer consumer = new Consumer();
		consumer.agent.start();
	
	
		System.out.println("starting producer");
		Producer producer = new Producer();
		producer.agent.start();
		
	
		System.out.println("going to sleep for 60 seconds");
		Thread.sleep(60000);	
		
		System.out.println("stopping agents");
		producer.agent.stop();
		consumer.agent.stop();
		System.exit(0);
		
		
	}
}

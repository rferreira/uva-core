package com.uvasoftware.core;


import java.util.Properties;

import junit.framework.TestCase;

import com.uvasoftware.core.util.*;

public class SIFAgentTest extends TestCase{


	public class Producer {
		public SIFAgent agent = null;
		public Producer() {
			Properties p = new Properties();
			p.setProperty(ConfigConstants.AGENT_NAME, "producer");
			p.setProperty(ConfigConstants.AGENT_SOURCEID, "producer");
			p.setProperty(ConfigConstants.AGENT_ZONE_URL, "mock://local");
			agent = new SIFAgent(p);
			agent.provides.add(SIFObjectName.Authentication);
			
			
		}
	}
	
	public class Consumer {
		public SIFAgent agent = null;
		public Consumer() {
			
			Properties p = new Properties();
			p.setProperty(ConfigConstants.AGENT_NAME, "consumer");
			p.setProperty(ConfigConstants.AGENT_SOURCEID, "consumer");
			p.setProperty(ConfigConstants.AGENT_ZONE_URL, "mock://local");
			agent = new SIFAgent(p);
			agent.subscribes.add(SIFObjectName.Authentication);
		}
	}

	

	public void testSimpleRegistration() throws Exception {

		Consumer consumer  = new Consumer();
		consumer.agent.start();
		System.out.println("here");
		
		Producer producer = new Producer();
		producer.agent.start();
		
		Thread.sleep(3000);
		
		assertTrue(consumer.agent.getZone().isAgentRegistered()); 
		assertTrue(producer.agent.getZone().isAgentRegistered());

		SIFAck ack = consumer.agent.getZone().ping();
		assertEquals(Code.Status.SUCCESS, ack.getStatusCode());
		
		ack = producer.agent.getZone().ping();
		assertEquals(Code.Status.SUCCESS, ack.getStatusCode());
		
	}
	
	public void testNoStartJustSend() throws Exception {
		Producer producer = new Producer();
		try {
			SIFAck ack = producer.agent.getZone().ping();
		} catch (IllegalStateException e) {
			return;
		}
		fail();
	}
	
	public void testStartStop() throws Exception {
		Producer producer = new Producer();
		producer.agent.start();
		producer.agent.stop();
		
	}
	
	
	
}

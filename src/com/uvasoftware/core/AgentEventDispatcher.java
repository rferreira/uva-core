/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.util.ConfigConstants;

/**
 * This is the agent worker thread and it is responsible for periodically firing events
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class AgentEventDispatcher implements Runnable {
	
	
	private static Logger log = Logger.getLogger(AgentEventDispatcher.class);
	private SIFAgent agent = null;
	private boolean stop = false;
	private long sleep = 0;

	public AgentEventDispatcher(SIFAgent agent, long sleep) {
		this.agent = agent;
		this.sleep = sleep;
		
		log.info("Agent thread sleep is set to:" + sleep);
		
	}

	/**
	 * Runnable method that takes care of handling periodic tasks as well as inbound messages
	 */
	public void run()  {
		
		Thread.currentThread().setName(agent.getProperties().getProperty(ConfigConstants.AGENT_SOURCEID)+"-dispatcher");
		
		while(stop != true) {
			
			try {
				
				if (agent.onPeriodicRun.size() > 0) {
					log.info("firing periodic task");
					agent.onPeriodicRun.dispatch(agent, null);
				
				}
				
				if (agent.onReceiveMessage.size() > 0 ) {
					log.info("looking for new messages");
					
					SIFAck ack = agent.getZone().getMessage();
					
					while (ack.getStatusCode() == Code.Status.SUCCESS ) {
						
						if (ack.getStatusCode() == Code.Status.NO_MESSAGE_AVAILABLE) {
							log.info("no new messages available");
							continue;
						}
						
						log.info(String.format("processing message %s", ack.getId()));
						
						SIFAck response_ack = null;
						
						for (SIFMessage i: ack.getStatusDataMessages() ) {
							
							log.debug("handling a message of type" + i.getType());
							
							response_ack = i.createResponseAck();
							
							/* 
							 * from the doc: Typically a pull-mode agent removes the message from its queue by 
							 * sending an "Immediate" SIF_Ack to the ZIS; an agent may also send a SIF_Ack with any applicable error condition 
							 * to the ZIS
							 */
							response_ack.setStatusCode(Code.Status.IMMEDIATE_SIF);
							
							
							if (agent.getZone().sendMessage(response_ack).getAck().getStatusCode() != Code.Status.SUCCESS ) {
								log.error("error ocurred while notifying the zis of sucessful message reception, skipping message");
								continue;
							}else {
								log.debug("message removal successful");
							}
							
						
							agent.onReceiveMessage.dispatchAsync(agent, i,null);
								
	
						}
						
						
						// getting next message:
						ack = agent.getZone().getMessage();
					}
				}
			//System.out.println("Going to sleep");
				
			Thread.sleep(this.sleep);
			} catch (InterruptedException e) {
				log.warn("dispatcher thread was interrupted... usually not a bad thing",e);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error while running peridoc agent task", e);
			}
			
		}
		
		log.info("shutting down...");

			
	}
	/**
	 * Sets the stop flag to true
	 */
	public void stop()  { 
		log.debug("attempting to stop thread");
		stop = true;
	}
}

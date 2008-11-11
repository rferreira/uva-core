/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.uvasoftware.core.util.*;

/**
 * Simple framework for creating SIF Agents
 * <p>
 * <b>Explaining how events work:</b></br>
 * This agent is event driven and, as such, all you need to do to use it is subscribe to certain events via IEventHandler delegates
 * </p>
 * <p>
 * Important notes:
 * <li> onReceiveMessage is fired once per incoming event</li>
 * <li> onPeriodicRun is the event you want to subscribe if you intend on sending sif events to the Zone</li>
 * <li> You must provide either a agent.properties application home or pass a properties file yourself to proper config the agent </li> 
 * </p>
 * 
 * @author <a href="raf@uvasoftware.com"> Rafael Ferreira </a>
 * 
*/
public final class SIFAgent {
	
	// EVENTS
	/**
	 * Event triggered whenever the agent is started
	 */
	public EventSink onInit = new EventSink();
	/**
	 * Event triggered whenever a new message arrives
	 */
	public EventSink onReceiveMessage = new EventSink();
	/**
	 * Event triggered whenever the agent is told to shutdown
	 */
	public EventSink onShutdown = new EventSink();
	//public EventSink onRun = new EventSink();
	/**
	 * Event triggered periodically and meant for "poll" type agents
	 */
	public EventSink onPeriodicRun = new EventSink();
	/**
	 * Event triggered whenever a new messages is about to the sent to the ZIS
	 */
	public EventSink onSendMessage = new EventSink();
	
	
	public String config = "agent.properties";
	private SIFZone zone = null;
	private String zoneId = SIFGUID.next();
	private String zoneURL = null;
	private Properties agent_properties = null;
	private AgentEventDispatcher dispatcher = null;
	private Thread dispatcher_thread = null;
	
	private static Logger log = Logger.getLogger(SIFAgent.class);
	
	/**
	 * This is a list of all the object this agent would like to subscribe to. Append to this for automagic subscription
	 */
	public ArrayList<SIFObjectName> subscribes = new ArrayList<SIFObjectName>();
	/**
	 * This is a list of all the object this agent would like to provide to the Zone. Append to this for automagic provide notification 
	 */
	public ArrayList<SIFObjectName> provides = new ArrayList<SIFObjectName>();
	
	/**
	 * Shuts down the agents and triggers the shutdown event
	 */
	public void stop() {
		log.info("Agent framework is stopping...");
		log.info("firing shutdown events");
		try {
			this.onShutdown.dispatch(this,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
			
		}
		log.debug("attempting to shutdown dispatcher thread");
		dispatcher.stop();
		log.debug("interrupting thread");
		dispatcher_thread.interrupt();
	}
	
	/**
	 * Most basic ctor which will rely on loading config from your agent.properties file.
	 */
	public SIFAgent() {

		initContext();
		try {
			agent_properties.load( new FileInputStream(config));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.fatal("could not properly configure agent by reading its properties file");
		} catch (IOException e) {
			e.printStackTrace();
			log.fatal("could not properly configure agent by reading its properties file");
		}
	}
	
	/**
	 * Creates a SIF Agent form a dynamic properties file as apposed to the static agent.properties
	 * @param name this agent's name (so we can uniquely identify it. 
	 * @param agentProperties the properties file containing all the needed agent informaiton
	 * @see ConfigConstants
	 */
	public SIFAgent(Properties agentProperties) {

		initContext();
		log.debug("creating agent from custom properties file");
		agent_properties.putAll(agentProperties);
		
	}
	
	private void initContext() {
		this.agent_properties = Config.getInstance().getProperties();
	}

	/**
	 * Starts up the agent / triggers init event
	 */
	public synchronized void start() {
		
		log.info("Agent framework starting up...");
		log.debug("trying to load agent properties");
		
		
		// configuring agent
		try {
			
			
			if (zoneURL == null )
				zoneURL = this.agent_properties.get(ConfigConstants.AGENT_ZONE_URL).toString().trim();
			
			if (zoneURL == null) {
				log.fatal("Agent configuration requires a " + ConfigConstants.AGENT_ZONE_URL);
			}

			System.out.println("Agent is binding the default zone: "+ zoneURL);
			log.info("creating default zone");
			
			// zoneid is used to guarantee uniqueness
			zone = SIFZone.createSIFZone( zoneId, zoneURL, agent_properties);
			
			log.info("zone creation successful");	
			
			System.out.println(String.format("Agent %s init...", zone.agentProperties.getProperty(ConfigConstants.AGENT_NAME)));
			
			// running inits
			this.onInit.dispatch(this, null);
			
			/*
			 * sending subscribe requests / one by one so they can fail individually
			 */
			if (this.subscribes.size() > 0) { 
	 			//System.out.println("Sending subscribe notification to the ZIS...");
				for (SIFObjectName n: this.subscribes) {
					System.out.print(String.format("Subscribing to object [%s]...",n));
					log.info("subscribing to object:" + n);
					
					SIFAck ack = this.zone.sendSubscribe(n);
					if (ack.getStatusCode() == Code.Status.SUCCESS) {
						System.out.println("OK");
					}else {
						System.out.println("ERROR");
						log.fatal("agent could not subscribe to object:" + n);
						System.exit(1);
					}
				}
			}	
			
			/*
			 * sending provide requests / one by one so they can fail individually
			 */
			if (this.provides.size() > 0 ) {
				//System.out.println("Sending provide notification to the ZIS...");
				for (SIFObjectName n: this.provides) {
					System.out.print(String.format("Provision for object [%s]...",n));
					log.info("providing object:" + n);
					
					SIFAck ack = this.zone.sendProvide(n);
					if (ack.getStatusCode() == Code.Status.SUCCESS) {
						System.out.println("OK");
					}else {
						System.out.println("ERROR");
						log.fatal("agent could not provide object:" + n);
						System.exit(1);
					}
				}
			}
			long poll_period = Long.parseLong( (String) zone.agentProperties.get(ConfigConstants.AGENT_POLL_PERIOD)) ;
			
			System.out.println(String.format("Agent is set to run every %d seconds.", + poll_period / 1000));
			
			log.info("starting agent thread");
			dispatcher = new AgentEventDispatcher(this,poll_period);
			dispatcher_thread = new Thread(dispatcher);
			dispatcher_thread.start();
			log.info("agent thread started");
			System.out.println("Agent started");
			// we don't block execution, letting the caller app handle it
			/*
			while(true){ 
				// putting main thread to sleep so timer can do its magic
				Thread.sleep(Integer.MAX_VALUE);
			}
			*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}catch (Exception e) {
			log.fatal("Generic exception",e);
		}
	} 
	
	public SIFZone getZone() {
		if (this.zone == null ) {
			throw(new IllegalStateException("agent must first be started before it can be used"));
		}
		return(zone);
	}

	/**
	 * @return the name
	 */
	public Properties getProperties() {
		return(agent_properties);
	}


}

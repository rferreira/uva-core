package com.uvasoftware.core;


import org.apache.log4j.Logger;

import com.uvasoftware.core.util.*;
import com.uvasoftware.core.data.infra.*;
import com.uvasoftware.core.query.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * 
 * This class abstracts interaction with the ZIS.  It adds endpoint functionality that 
 * is ZIS-specific and is not covered in a generic SIFEndPoint.<br>
 * <i>Note: SIFZone is a factory class in which zones are cached and actually created 
 * only once</i>
 * <p>
 * Example of using SIFZone:<br>
 * <code>
 * SIFZone zone = new SIFZone("myzone","https://192.168.0.1/myzone");<br>
 * zone.ping();<br>
 * </code>
 * 
 * @see SIFEndPoint
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */

public class SIFZone extends SIFEndPoint{
	
	private static Logger log = Logger.getLogger(SIFZone.class);  
	private static HashMap <String,SIFZone>zones = new HashMap<String,SIFZone>();
	private boolean isAgentRegistered = false;
	private String zoneID;
	
	public static SIFZone createSIFZone(String zoneID, String uri, Properties agentProperties) throws Exception {
		if(!zones.containsKey(zoneID)) {
			log.info(String.format("creating new zone: [%s] with uri [%s]",zoneID,uri ));
		    zones.put(zoneID,new SIFZone(zoneID, uri, agentProperties) );
		}
		
		SIFZone z = zones.get(zoneID);
		
		log.debug("returning zone " + zoneID);
		return (z);
	}

	/**
	 * Creates a new SIFZone abstraction / Factory method using built in defaults
	 * Zones are created only once and from that point on they are returned from cache
	 *
	 * @param zoneID the name/id that you will use to reference this zone 
	 * @param uri the uri of the SIF Zone
	 * @return a new SIFZone object
	 *
	 */
	public static SIFZone createSIFZone(String zoneID, String uri) throws Exception {		
		if(!zones.containsKey(zoneID)) {
			log.info(String.format("creating new zone: [%s] with uri [%s]",zoneID,uri ));
		    zones.put(zoneID,new SIFZone(zoneID,uri,null) );
		}
		
		SIFZone z = zones.get(zoneID);
		
		log.debug("returning zone " + zoneID);
		return (z);
	}

	/**
	 * Creates a new SIFZone abstraction / Factory method using a custom agent configuration
	 * Zones are created only once and from that point on they are returned from cache
	 *
	 * @param zoneID the name/id that you will use to reference this zone 
	 * @param uri the uri of the SIF Zone
	 * @param props a properties file containing custom agent configuration 
	 * @return a new SIFZone object
	 *
	 */
	private SIFZone(String zoneID, String uri, Properties props) throws Exception {
		super(uri,props);
		
		this.zoneID = zoneID;
		
		//log.info(String.format("SIFZone init [%s]", zoneID ));
		
	    if (agentProperties.getProperty(ConfigConstants.AUTO_REGISTER).contains("true") ) {
			log.info("automatically registering agent");
			try {
				register();
			} catch (Exception e) {
				log.error("Automatic registration failed!",e);
				throw(new Exception("Automatic registration failed, please check logs",e));
			}
		}
	}
	
	/**
	 * Returns the id of this zone 
	 *
	 * @return the zoneId
	 */
	public String getZoneId() {
		return(this.zoneID);
	}

	
	/**
	 * Registers the agent with the ZIS
	 *  
	 * @return SIFAck response from ZIS
	 * @throws Exception
	 */
	public synchronized SIFAck register() throws Exception{
		log.info("attempting to register agent");
		SIFAck ack = this.sendMessage( new SIFRegister()).getAck();
		if (ack.getStatusCode() == Code.Status.SUCCESS) {
			log.info("agent registration successful");
			this.isAgentRegistered = true;
		} else {
			log.warn("Agent could not registered itself with the ZIS, things will prob not work from this point on");
			log.warn(String.format("error code: %s error category: %s error extended desc: %s", ack.getErrorCode(), ack.getErrorCategory(), ack.getErrorExtDesc()));
		}
		return(ack);
	}
	
	/**
	 * Tells you whether the agent attached to this Zone is successfully registered with the ZIS or not
	 */
	public boolean isAgentRegistered() {
		return(isAgentRegistered);
	}
	/** 
	 * Unregisters the agent with the ZIS. 
	 * @return SIFAck response from ZIS
	 * @throws Exception
	 */
	public SIFAck unregister() throws Exception {
		return(this.sendMessage(new SIFUnRegister()).getAck());
	}
	
	/**
	 * Asks the ZIS server for its Zone Status
	 * @return a SIFZoneStatus object
	 * @throws Exception
	 */
	public SIFZoneStatus getSIFZoneStatus() throws Exception{
		log.debug("sending zonestatus query");
		
		SIFQuery query = new SIFQuery(SIFObjectName.SIFZoneStatus);
		
		SIFAck ack  = sendMessage(new SIFRequest(query)).getAck();
		
		if (ack.getStatusCode() == Code.Status.SUCCESS) {
			log.debug("successful ack response from zis");
			log.debug("sending gratis getmessage");
			
			ack  = getMessage();
			SIFResponse resp = ack.getResponse();
			
			if (resp == null )
				return(null);
			
			if (resp.getObjectData(SIFObjectName.SIFZoneStatus).size() == 0) {
				log.warn("malformed zonestatus response");
				log.warn(resp);
				return(null);
			}
			
			SIFZoneStatus zs = (SIFZoneStatus) resp.getObjectData(SIFObjectName.SIFZoneStatus).get(0);
			
			//removing message from the Zone Q:
			SIFAck response_ack = ack.createResponseAck();
			response_ack.setStatusCode(Code.Status.IMMEDIATE_SIF);
			
			if (sendMessage(response_ack).getAck().getStatusCode() != Code.Status.SUCCESS ) {
				log.error("error ocurred while notifying the zis of sucessful message reception, skipping message");
				return(null);
			}
			
			
			return(zs);
		} else {
			log.error("error while requesting a sif zone status: " + ack.getErrorExtDesc());
		}
		
		return(null);		
		
	}
	
	// SYSTEM CONTROL MESSAGES

	/**
	 * Notifies the receiver that the sender will not be able to handle new messages
	 * <p>
	 * Note: a wakeup or register message will notify the receiver that sender is once
	 * again ready to receive messages
	 *
	 * @return SIFAck containing response from ZIS
	 */
	public SIFAck sleep() throws Exception {
		log.debug("sending sleep");
		return(this.sendMessage( new SIFSleep()).getAck());
	}
	
	/**
	 * Notifies receiver that sender is ready to receive messages
	 *
	 * @return SIFAck containing response from ZIS
	 */
	public SIFAck wakeup() throws Exception{
		log.debug("sending wakeup");
		return(this.sendMessage( new SIFWakeup()).getAck());
	}

	/**
	 * Checks whether the ZIS is alive and ready to receive messages 
	 *
	 * @return SIFAck containing response from ZIS
	 */
	public SIFAck ping() throws Exception {
		log.debug("sending ping");
		return(this.sendMessage( new SIFPing()).getAck());
	}
	
	// REGULAR MESSAGES

	/**
	 * Returns all messages currently in the ZIS for this agent. Please note that the messages will be encapsulated in the <code>SIF_ACK</code>
	 *
	 * @return SIFAck containing response from ZIS
	 */
	public SIFAck getMessage() throws Exception {
		log.debug("sending generic sif message");
		return(this.sendMessage( new SIFGetMessage()).getAck());
		
	}

	/** 
	 * Sends a <code>SIF_Provide</code> message to the ZIS 
	 * @see SIFProvide
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to start providing events
	 */
	public SIFAck sendProvide(SIFObjectName sifObjectName) throws Exception{
		log.debug("sending provide");
		SIFAck ack = null;
		SIFProvide prov = new SIFProvide();
		prov.provide(sifObjectName.toString());
		ack = this.sendMessage(prov).getAck();
		return(ack);
	}

	/** 
	 * Sends a <code>SIF_Provide</code> message to the ZIS 
	 * @see SIFProvide
	 * 
	 * @param sifObjectName A list of valid SIF object names to which you would like to start providing events
	 */
	public SIFAck sendProvide(List<SIFObjectName> sifObjectName) throws Exception{
		log.debug("sending provide");
		SIFAck ack = null;
		SIFProvide prov = new SIFProvide();
		prov.provide(sifObjectName.toString());
		ack = this.sendMessage(prov).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Unprovide</code> message to the ZIS 
	 * @see SIFUnprovide
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to stop providing events
	 */
	public SIFAck sendUnprovide(SIFObjectName sifObjectName) throws Exception{
		log.debug("sending unprovide");
		SIFAck ack = null;
		SIFUnProvide unprov = new SIFUnProvide();
		unprov.unProvide(sifObjectName.name());
		ack = this.sendMessage(unprov).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Unprovide</code> message to the ZIS 
	 * @see SIFUnprovide
	 * 
	 * @param sifObjectName A list of valid SIF object names to which you would like to stop providing events
	 */
	public SIFAck sendUnprovide(List<SIFObjectName> sifObjectName) throws Exception{
		log.debug("sending unprovide");
		SIFAck ack = null;
		SIFUnProvide unprov = new SIFUnProvide();
		unprov.unProvide(sifObjectName.toString());
		ack = this.sendMessage(unprov).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Subscribe</code> message to the ZIS 
	 * @see SIFSubscribe
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to subscribe
	 */
	public SIFAck sendSubscribe(SIFObjectName sifObjectName) throws Exception{
		log.debug("sending subscribe");
		SIFAck ack = null;
		SIFSubscribe sub = new SIFSubscribe();
		sub.subscribe(sifObjectName.toString());
		ack = this.sendMessage(sub).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Subscribe</code> message to the ZIS 
	 * @see SIFSubscribe
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to subscribe
	 */
	public SIFAck sendSubscribe(List<SIFObjectName> sifObjectName) throws Exception{
		log.debug("sending subscribe");
		SIFAck ack = null;
		SIFSubscribe sub = new SIFSubscribe();
		sub.subscribe(sifObjectName.toString());
		ack = this.sendMessage(sub).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Unsubscribe</code> message to the ZIS 
	 * @see SIFUnsubscribe
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to unsubscribe
	 */
	public SIFAck sendUnsubscribe(SIFObjectName sifObjectName) throws Exception{
		log.debug("sending unsubscribe");
		SIFAck ack = null;
		SIFUnSubscribe unsub = new SIFUnSubscribe();
		unsub.unSubscribe(sifObjectName.toString());
		ack = this.sendMessage(unsub).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Unsubscribe</code> message to the ZIS 
	 * @see SIFUnsubscribe
	 * 
	 * @param sifObjectName A valid SIF object name to which you would like to unsubscribe
	 */
	public SIFAck sendUnsubscribe(List<SIFObjectName> sifObjectName) throws Exception{
		log.debug("sending unsubscribe");
		SIFAck ack = null;
		SIFUnSubscribe unsub = new SIFUnSubscribe();
		unsub.unSubscribe(sifObjectName.toString());
		ack = this.sendMessage(unsub).getAck();
		return(ack);
	}

	/** 
	 * Sends a <code>SIF_Request</code> message to the ZIS 
	 * @see SIFRequest
	 * @param destinationId the specific agent to direct this request to
	 * @param query	the sif query object
	 * @see com.uvasoftware.core.query.SIFQuery
	 */
	public SIFAck sendRequest(String destinationId, SIFQuery query) throws Exception{
		log.debug("sending request");
		SIFAck ack = null;
		
		SIFRequest req = new SIFRequest();
		req.getHeader().setDestinationId(destinationId);
		req.setQuery(query);
		
		ack = this.sendMessage(req).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Request</code> message to the ZIS 
	 * @see SIFRequest
	 * @param query	the sif query object
	 * @see com.uvasoftware.core.query.SIFQuery
	 */
	public SIFAck sendRequest(SIFQuery query) throws Exception{
		log.debug("sending request");
		SIFAck ack = null;
		SIFRequest req = new SIFRequest();
		req.setQuery(query);
		
		ack = this.sendMessage(req).getAck();
		return(ack);
	}
	
	/** 
	 * Sends a <code>SIF_Event</code> message to the ZIS 
	 * @see SIFEvent
	 * 
	 * @param sifObject the SIF object for the event
	 * @param action the SIFEvent action type
	 */
	public SIFAck sendEvent(ISIFObject sifObject, SIFObjectName name, SIFEvent.Action action) throws Exception{
		log.debug("sending event");
		SIFAck ack = null;
		SIFEvent event = new SIFEvent();
		event.setEventData(sifObject, name.name(), action);
		ack = this.sendMessage(event).getAck();
		return(ack);
	}
	
	/**
	 * Sends a complete <code>SIF_Response</code> message to the ZIS
	 * @see SIFResponse
	 * @param destinationId the <code>SIF_SourceId</code> of the originator of the SIF_Request message
	 * @param sifObject the object data to be returned (if applicable)
	 * @param requestMsgID the id of the request that triggered this response
	 * @param packetNumber the number of the current packet in the entire series
	 * @param hasMorePackets true if this is NOT the last packet of the response series
	 * @return a SIFAck
	 * @throws Exception
	 */
	public SIFAck sendResponse(String destinationId, ISIFObject sifObject, String requestMsgID, int packetNumber, boolean hasMorePackets) throws Exception{
		SIFAck ack = null;
		SIFResponse resp = new SIFResponse(requestMsgID, packetNumber, hasMorePackets);
		resp.getHeader().setDestinationId(destinationId);
		resp.addObjectData(sifObject);
		ack = this.sendMessage(resp).getAck();
		return(ack);
	}
	
	/**
	 * Sends a complete <code>SIF_Response</code> message to the ZIS 
	 * @see SIFResponse
	 * @param destinationId the <code>SIF_SourceId</code> of the originator of the SIF_Request message
	 * @param sifObject a list of object data to be returned (if applicable)
	 * @param requestMsgID the id of the request that triggered this response
	 * @param packetNumber the number of the current packet in the entire series
	 * @param hasMorePackets true if this is NOT the last packet of the response series
	 * @return a SIFAck
	 * @throws Exception
	 */
	public SIFAck sendResponse(String destinationId, List<ISIFObject> sifObject, String requestMsgID, int packetNumber, boolean hasMorePackets) throws Exception{
		SIFAck ack = null;
		SIFResponse resp = new SIFResponse(requestMsgID, packetNumber, hasMorePackets);
		resp.getHeader().setDestinationId(destinationId);
		
		for (ISIFObject d: sifObject) { resp.addObjectData(d); }
		
		ack = this.sendMessage(resp).getAck();
		return(ack);
	}
	/**
	 * Sends a <code>SIF_Response</code> containing a <code>SIF_ERROR</code> message
	 *  
	 * @param errorCode the error code
	 * @param errorCategory the erro category
	 * @param errorDesc the error description
	 * @param extDesc the extensive decription of the error
	 * @param requestMsgID the id of the request that triggered this response
	 * @param packetNumber the number of the current packet in the entire series
	 * @param hasMorePackets true if this is NOT the last packet of the response serie
	 * @return an ack back from the endpoint
	 * @throws Exception
	 * 
	 * @see com.uvasoftware.core.Code
	 */
	public SIFAck sendResponse(int errorCode, int errorCategory, String errorDesc, String extDesc, String requestMsgID, int packetNumber, boolean hasMorePackets) throws Exception{
		log.debug("sending response");
		SIFAck ack = null;
		SIFResponse resp = new SIFResponse(requestMsgID, packetNumber, hasMorePackets);
		resp.setError(errorCode,errorCategory,errorDesc,extDesc);
		ack = this.sendMessage(resp).getAck();
		return(ack);
	}
	
}

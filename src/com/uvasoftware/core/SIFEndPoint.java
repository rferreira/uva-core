package com.uvasoftware.core;

import org.apache.log4j.Logger;
import java.util.Properties;

import com.uvasoftware.core.handlers.*;
import com.uvasoftware.core.util.*;

/**
 * Represents a generic SIF communication endpoint - either ZIS of Agent (in pull mode)
 * <p>
 * <b>Note:</b><br>
 * SIFEndpoint is a fairly low level abstraction. If you intend on communicating with a ZIS
 * you should look at @{see SIFZone} zone abstraction because it provides all the functionality 
 * of a SIFEndpoint plus all the Zone/ZIS specific stuff
 * <p>
 * Also, if you are really brave, you can use the events provided by this class to alter incoming and outgoing <code>SIF_Message</code>'s
 * </p>

 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFEndPoint {
	
	private static Logger log = Logger.getLogger(SIFEndPoint.class);
	private static Config config = Config.getInstance();

	private SIFMessageMarshaller marshall = null;
	private String uri;
	
	/**
	 * Represents the agent specific properties and it shares the same initial context as the global 
	 */
	public Properties agentProperties = new Properties();
	
	/**
	 * Event fired prior to a message being sent passing as only argument the message to be sent
	 */
	EventSink onBeforeSendMessage = new EventSink();
	
	/**
	 * Event fired after to a message being sent passing as only argument the response received
	 */
	EventSink onAfterSendMessage = new EventSink();

	/**
	 * Builds a new SIF endpoint that can be accessed via a certain URI
	 * @param URI - the URI of the endpoint
	 */
	public SIFEndPoint(String URI, Properties props) {
		
		this.uri = URI;
		
		if (props != null) {
			log.debug("loading custom agent properties");
			this.agentProperties.putAll(props);
		} else {
			log.info("injecting default agent properties");
			this.agentProperties = Config.getInstance().getProperties();
		}
		
		log.debug("wiring default handlers");
		this.onBeforeSendMessage.appendHandler(new AgentPropertiesHandler());
		marshall = SIFMessageMarshaller.getInstance();
		
		// writing request to console
		if ( agentProperties.get(ConfigConstants.DEBUG_SIF).toString().contains("true")  ) {
			log.debug("seting formatted output");	
			marshall.enableFormatedOutput();
			this.onAfterSendMessage.appendHandler(new SimpleLoggingHandler());
			this.onBeforeSendMessage.appendHandler(new SimpleLoggingHandler());
		}
		
	}

	/**
	 * Sends a SIFMessage (generic) to the SIF endpoint
	 * @param message to be sent
	 * @return a message object with the reponse 
	 * @throws Exception
	 */
	public SIFMessage sendMessage(SIFMessage message) throws Exception {
		
		try {
			// dispatching event
			onBeforeSendMessage.dispatch(this, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		ISIFConnection conn = SIFConnectionFactory.getConnection(uri);
		SIFMessage response = null;
		try {

			response = conn.sendMessage(message);

		} catch (Exception e) {
			log.error("error while sending message", e);
			throw (e);
		}		
		
		try {
			// dispatching event
			onAfterSendMessage.dispatch(this, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return (response);
	}

	/**
	 * Returns the URI used to communicated with this endpoint
	 * 
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI used to communicate with ths endpoint
	 * 
	 * @param uri
	 *            the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}

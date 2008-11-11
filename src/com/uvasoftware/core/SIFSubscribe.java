package com.uvasoftware.core;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.primitives.SubscribeObjectNames;
import com.uvasoftware.core.primitives.SIFSubscribe.SIFObject;

/**
 * Represents a <code>SIF_Subscribe</code> message 
 * <p>
 * Version 2.0r1 of the SIF Specification describes <code>SIF_Subscribe</code> as follows:
 * <blockquote>
 * An Agent registers with the ZIS to receive <code>SIF_Events </code> for one or more SIF
 * objects in one or more contexts by sending a <code>SIF_Subscribe</code>  message to the ZIS. 
 * The Agent must have access control rights at the ZIS to successfully subscribe to events for 
 * an object. 
 * <p>
 * Note that upon successful completion of <code>SIF_Subscribe </code> that your Agent is still 
 * subscribed to objects to which it had previously subscribed.
 * <p>
 * To unregister as a Subscriber of given objects, use <code>SIF_Unsubscribe</code>. To replace 
 * all objects to which your Agent subscribes in one operation, use <code>SIF_Provision</code>.
 * <p>
 * As of version 2.0 of this specification, <code>SIF_Provision</code> is the preferred method 
 * for registering an Agent as a Subscriber, and provisioning an Agent in general. Support for 
 * <code>SIF_Subscribe</code> may be removed in a future major release of this specification.
 * <a href="../../../../overview-summary.html#reference2"><sup>2</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>   
 */
public class SIFSubscribe extends SIFMessage {
	
	
	private static Logger log = Logger.getLogger(SIFSubscribe.class);
		
	/**
	 * Creates a new SIFSubscribe message with no default object subscriptions
	 */
		public SIFSubscribe( ) {
	
			// building the message with the little known information 
			log.debug("ctor");
			com.uvasoftware.core.primitives.SIFSubscribe sub = new com.uvasoftware.core.primitives.SIFSubscribe();
			sub.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
			message.setSIFSubscribe( sub  );
			
		}
		/**
		 * Returns a list of all the objects this message would like to subscribe to<br>
		 * @return a list of <code>SIFObjectName</code>
		 */
		public List<SIFObjectName> getSubscribedObjects() {
			ArrayList<SIFObjectName> resp = new ArrayList<SIFObjectName>();
			
			for (SIFObject sb: this.message.getSIFSubscribe().getSIFObject() ) {
				log.debug(sb.getObjectName().toString() );
				resp.add(SIFObjectName.valueOf(sb.getObjectName().value()));
			}
			return resp;
		}
			 
			
			
		/**
		 * Adds an object subscription to the SIF_Subscribe message<br>
		 * <i>Note: A list of valid objects may be found in the SIF specification</i>
		 * <p>
		 * All valid SIF events on this object will be routed to the agent
		 *  
		 * @param objectName the name of the object to which the agent should subscribe
		 */
		public void subscribe(String objectName) {
			com.uvasoftware.core.primitives.SIFSubscribe sub = message.getSIFSubscribe();
			
			SIFObject obj = new SIFObject(); 
			
			//TODO: convert the exception into a custom type (SIFException or something)
			obj.setObjectName(SubscribeObjectNames.fromValue(objectName));
			 
			 sub.getSIFObject().add(obj);
			 
			
		}
		
		/**
		 * Helper method that takes a List of String containing valid, subscribable object names
		 * and adds them to the <code>SIF_Subscribe</code> message
		 * 
		 * @param objNames a list of objectNames to which the agent should subscribe
		 */
		
		public void subscribe (List <String> objNames) {
			for (String i: objNames) {
				subscribe(i);
			}
		}
}

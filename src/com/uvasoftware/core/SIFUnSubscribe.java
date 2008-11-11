package com.uvasoftware.core;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.primitives.SubscribeObjectNames;
import com.uvasoftware.core.primitives.SIFUnsubscribe.SIFObject;

/**
 * Represents a <code>SIF_Unsubscribe</code> message 
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Unsubscribe</code> as follows:
 * <blockquote> 
 * This message performs the opposite function of <code>SIF_Subscribe</code>. It removes the 
 * message sender as a subscriber to the <code>SIF_Events</code> contained in this message.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>   
 */
public class SIFUnSubscribe extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFUnSubscribe.class.toString());
		
	/**
	 * Creates a new <code>SIF_Unsubscribe</code> message with no default object subscriptions
	 */
		public SIFUnSubscribe() {
			// building the message with the little known information 
			log.debug("ctor");
			com.uvasoftware.core.primitives.SIFUnsubscribe unsub = new com.uvasoftware.core.primitives.SIFUnsubscribe();
			unsub.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
			message.setSIFUnsubscribe(unsub);	
		}
		
		/**
		 * Adds an object that the agent wishes to unsubscribe from to the <code>SIF_Unsubscribe</code> message<br>
		 * <i>Note: A list of valid objects may be found in the SIF specification</i>
		 * <p>
		 * All valid SIF events on this object will be routed to the agent
		 *  
		 * @param objectName the name of the object to which the agent should unsubscribe
		 */
		public void unSubscribe(String objectName) {
			com.uvasoftware.core.primitives.SIFUnsubscribe unsub = message.getSIFUnsubscribe();
			
			SIFObject obj = new SIFObject(); 
			
			//TODO: convert the exception into a custom type (SIFException or something)
			obj.setObjectName(SubscribeObjectNames.fromValue(objectName));
			 
			unsub.getSIFObject().add(obj);	
		}
		
		/**
		 * Helper method that takes a List of String containing valid, subscribable object names
		 * and adds them to the <code>SIF_Unsubscribe</code> message
		 * 
		 * @param objNames a list of objectNames to which the agent should unsubscribe
		 */	
		public void unSubscribe (List <String> objNames) {
			for (String i: objNames) {
				unSubscribe(i);
			}
		}
		
		/**
		 * Returns a list of all the objects this message would like to unsubscribe to<br>
		 * @return a list of <code>SIFObjectName</code>
		 */
		public List<SIFObjectName> getUnSubscribedObjects() {
			ArrayList<SIFObjectName> resp = new ArrayList<SIFObjectName>();
			
			for (SIFObject sb: this.message.getSIFUnsubscribe().getSIFObject() ) {
				log.debug(sb.getObjectName().toString() );
				resp.add(SIFObjectName.valueOf(sb.getObjectName().value()));
			}
			return resp;
		}
}

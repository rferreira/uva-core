package com.uvasoftware.core;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.primitives.ProvideObjectNames;
import com.uvasoftware.core.primitives.SIFUnprovide.SIFObject;


/**
 * Represents a <code>SIF_Unprovide</code> message 
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Unprovide</code> as follows:
 * <blockquote>
 * This message performs the opposite function of <code>SIF_Provide</code>. It removes the message sender 
 * as a provider of the data objects contained in this message.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>   
 */
public class SIFUnProvide extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFProvide.class);
		
	/**
	 * Creates a new <code>SIF_Unprovide</code> message with no default object subscriptions
	 */
		public SIFUnProvide() {
			// building the message with the little known information 
			//log.debug("ctor");
			com.uvasoftware.core.primitives.SIFUnprovide unprov = new com.uvasoftware.core.primitives.SIFUnprovide();
			unprov.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
			message.setSIFUnprovide(unprov);	
		}
		
		/**
		 * Adds an object that the agent intends to stop providing to the <code>SIF_Unprovide</code> message<br>
		 * <i>Note: A list of valid objects may be found in the SIF specification</i>
		 * <p>
		 * All valid SIF events on this object will be routed to the agent
		 *  
		 * @param objectName the name of the object that the agent intends to stop providing
		 */
		public void unProvide(String objectName) {
			com.uvasoftware.core.primitives.SIFUnprovide unprov = message.getSIFUnprovide();
			
			SIFObject obj = new SIFObject(); 
			
			//TODO: convert the exception into a custom type (SIFException or something)
			obj.setObjectName(ProvideObjectNames.fromValue(objectName));
			
			unprov.getSIFObject().add(obj);	
		}
		
		/**
		 * Helper method that takes a List of String containing valid, provide-able object names
		 * and adds them to the <code>SIF_Unprovide</code> message
		 * 
		 * @param objNames a list of objectNames that the agent intends to stop providing
		 */	
		public void unProvide (List <String> objNames) {
			for (String i: objNames) {
				unProvide(i);
			}
		}
		
		/**
		 * Returns a list of all the unprovided objects in this message
		 * @return the list of <code>SIFObjectName</code> that this object provide
		 */
		public List <SIFObjectName> getUnProvidedObjects() {
			ArrayList<SIFObjectName> resp = new ArrayList<SIFObjectName>();
			
			for (SIFObject sb: this.message.getSIFUnprovide().getSIFObject()) {
				resp.add(SIFObjectName.valueOf(sb.getObjectName().value()));
			}
			
			return(resp);
		}
}
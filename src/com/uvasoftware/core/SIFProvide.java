package com.uvasoftware.core;

import org.apache.log4j.Logger;
import java.util.List;

import com.uvasoftware.core.primitives.ProvideObjectNames;
import com.uvasoftware.core.primitives.SIFProvide.SIFObject;
import java.util.ArrayList;

/**
 * Represents a <code>SIF_Provide</code> message 
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Provide</code> as follows:
 * <blockquote>
 * The <code>SIF_Provide</code> message is used for advertising the provision of data objects.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>   
 */
public class SIFProvide extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFProvide.class);
		
	/**
	 * Creates a new <code>SIF_Provide</code> message with no default object subscriptions
	 */
		public SIFProvide() {
			// building the message with the little known information 
			
			com.uvasoftware.core.primitives.SIFProvide prov = new com.uvasoftware.core.primitives.SIFProvide();
			prov.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
			message.setSIFProvide(prov);	
		}
		
		/**
		 * Adds an object subscription to the SIF_Provide message<br>
		 * <i>Note: A list of valid objects may be found in the SIF specification</i>
		 * <p>
		 * All valid SIF events on this object will be routed to the agent
		 *  
		 * @param objectName the name of the object that the agent intends to provide
		 */
		public void provide(String objectName) {
			com.uvasoftware.core.primitives.SIFProvide prov = message.getSIFProvide();
			
			SIFObject obj = new SIFObject(); 
			
			//TODO: convert the exception into a custom type (SIFException or something)
			obj.setObjectName(ProvideObjectNames.fromValue(objectName));
			
			prov.getSIFObject().add(obj);	
		}
		
		/**
		 * Helper method that takes a List of String containing valid, provide-able object names
		 * and adds them to the <code>SIF_Provide</code> message
		 * 
		 * @param objNames a list of objectNames that the agent intends to provide
		 */	
		public void provide (List <String> objNames) {
			for (String i: objNames) {
				provide(i);
			}
		}
		
		/**
		 * Returns a list of all the provided objects in this message
		 * @return the list of <code>SIFObjectName</code> that this object provide
		 */
		public List <SIFObjectName> getProvidedObjects() {
			ArrayList<SIFObjectName> resp = new ArrayList<SIFObjectName>();
			
			for (SIFObject sb: this.message.getSIFProvide().getSIFObject() ) {
				resp.add(SIFObjectName.valueOf(sb.getObjectName().value()));
			}
			
			return(resp);
		}
		/**
		 * Adds an object subscription to the SIF_Provide message<br>
		 * <i>Note: A list of valid objects may be found in the SIF specification</i>
		 * <p>
		 * All valid SIF events on this object will be routed to the agent
		 *  
		 * @param objectName the name of the object that the agent intends to provide
		 */
		public void provide(SIFObjectName name) {
			com.uvasoftware.core.primitives.SIFProvide prov = message.getSIFProvide();
			
			SIFObject obj = new SIFObject(); 
			
			//TODO: convert the exception into a custom type (SIFException or something)
			obj.setObjectName(ProvideObjectNames.fromValue(name.toString()));
			
			prov.getSIFObject().add(obj);	
		}
		
}

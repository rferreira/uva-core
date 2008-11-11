package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.primitives.SIFSystemControl;
import com.uvasoftware.core.primitives.SIFSystemControlData;


/**
 * Represents a <code>SIF_GetMessage</code> message
 * <p>
 * The <code>SIF_SystemControl - SIF_GetMessage</code> message provides the mechanism for an agent to pull message from a 
 * ZIS. An agent sends a <code>SIF_SystemControl - SIF_GetMessage</code> and the ZIS returns the next available message, 
 * according to the Selective Message Blocking scheme, wrapped in a <code>SIF_Ack</code> with a 
 * <code>SIF_Status/SIF_Code</code> of 0 and the message in the <code>SIF_Status/SIF_Data</code> element. If there are no 
 * messages to be returned, the ZIS returns a value of 9 in <code>SIF_Status/SIF_Code</code>.
 * <p>
 * If an agent is not registered with a mode of "Pull" the ZIS will return a <code>SIF_Ack</code> with an error category 
 * of Registration and an error code indicating the agent is registered in Push mode. The 
 * <code>SIF_SystemControl-SIF_GetMessage</code> message contains no elements.
 * 
 * @author  <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFGetMessage extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFGetMessage.class.toString());
				
		public SIFGetMessage() {
			SIFSystemControlData sd = new SIFSystemControlData();
			sd.setSIFGetMessage(new com.uvasoftware.core.primitives.SIFGetMessage());
			SIFSystemControl sc = new SIFSystemControl();
			sc.setSIFSystemControlData(sd);
			sc.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
			
			message.setSIFSystemControl(sc);		
		}
		
		/**
		 * Creates a new <code>SIF_GetMessage</code> form an XML primitive
		 * @param primitive the XML primitive
		 */
		public SIFGetMessage(com.uvasoftware.core.primitives.SIFMessage primitive) {
			this.message = primitive;
		}
}

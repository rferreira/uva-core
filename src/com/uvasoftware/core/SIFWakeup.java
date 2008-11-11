package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.primitives.SIFSystemControl;
import com.uvasoftware.core.primitives.SIFSystemControlData;


/**
 * Represents a <code>SIF_Wakeup</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Ack</code> as follows:
 * <blockquote>
 * When the "sleeping" agent or ZIS is ready to resume message processing, it will send a <code>SIF_SystemControl</code> - 
 * <code>SIF_Wakeup</code> message. This will signal the receiver that the sender is now able to process messages. 
 * Sending a <code>SIF_Wakeup</code> message without a previous <code>SIF_Sleep</code> message is permissible and is not 
 * considered an error.
 * <p>
 * If there are any blocked messages in the Agent's queue when a ZIS receives the <code>SIF_Wakeup</code> message the 
 * blocks will be removed.
 * <p>
 * Since a ZIS may choose to stop sending messages to an agent if a connection cannot be made with that agent, it is 
 * recommended that an agent send a <code>SIF_Wakeup</code> message to the ZIS upon agent startup. The 
 * <code>SIF_SystemControl</code> - <code>SIF_Wakeup</code> message contains no elements.
 * <p>
 * An agent or ZIS is not required to be able to send <code>SIF_Wakeup</code> messages. Although the sending of 
 * <code>SIF_Wakeup</code> is optional, an agent or ZIS must always be able to process and respond to these messages 
 * correctly if received.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author  <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFWakeup extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFWakeup.class.toString());
			
		/**
		 * Creates a new <code>SIF_Wakeup</code> message
		 */
		public SIFWakeup() {
			//log.debug("wakeup ctor");
			
			SIFSystemControlData sd = new SIFSystemControlData();
			sd.setSIFWakeup(new com.uvasoftware.core.primitives.SIFWakeup());
			SIFSystemControl sc = new SIFSystemControl();
			sc.setSIFSystemControlData(sd);
			sc.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
			
			message.setSIFSystemControl(sc);		
		}

}

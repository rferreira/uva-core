/**
 * 
 */
package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.primitives.SIFSystemControl;
import com.uvasoftware.core.primitives.SIFSystemControlData;

/**
 * Represents a <code>SIF_Sleep</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Sleep</code> as follows:
 * <blockquote>
 * The <code>SIF_SystemControl</code> - <code>SIF_Sleep</code> message allows an agent to notify a ZIS 
 * or a ZIS to notify a push-mode agent that it must not send any more messages to the sender of the 
 * <code>SIF_Sleep</code>. After the sender receives a <code>SIF_Ack</code> indicating that the 
 * message was received, the receiver must not send any further messages to the sender. 
 * <p>
 * This message provides the ability to signal an agent or ZIS that the sender will be unable to 
 * process further messages until some time in the future. Reasons for sending a 
 * <code>SIF_Sleep</code> message include the sender is unable to process more data because of 
 * limited resources (i.e. disk storage, network bandwidth, etc.), or the sender is being temporarily 
 * shutdown and will be unable to receive messages.
 * <p>
 * Since the sender may send a SIF_Sleep message for a variety of reasons, if the receiver sends 
 * messages after a <code>SIF_Sleep</code> message but prior to receiving a <code>SIF_Wakeup</code> 
 * or <code>SIF_Register</code> message from the sender, an error must be returned. A transport error 
 * will occur or be returned if a connection cannot be established with the sender, or the sender may 
 * choose to receive the connection but return an error.
 * <p>
 * If the sender is an agent, the ZIS will continue to hold any messages for the agent in the queue but 
 * the ZIS will not send those messages until a <code>SIF_Wakeup</code> (or <code>SIF_Register</code>) 
 * message is received.
 * <p>
 * If an agent is processing a message requiring additional <code>SIF_Requests</code> to be sent to the 
 * ZIS and a <code>SIF_Sleep</code> message is received from the ZIS, the agent will not be able to 
 * retrieve the additional data. The agent must abort the processing of the message and only attempt to 
 * process the message after receiving a <code>SIF_Wakeup</code> message from the ZIS.
 * <p>
 * An agent or ZIS is not required to be able to send <code>SIF_Sleep</code> messages. However, if an 
 * agent or ZIS has the ability to send a <code>SIF_Sleep</code>, it must also be able to send a 
 * <code>SIF_Wakeup</code>. Although the sending of <code>SIF_Sleep</code> is optional, an agent or ZIS 
 * must always be able to process and respond appropriately to these messages if received.
 * <p>
 * The <code>SIF_SystemControl</code> - <code>SIF_Sleep</code> message contains no elements. 
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFSleep extends SIFMessage {
	
	private static Logger log = Logger.getLogger(SIFSleep.class.toString());

	public SIFSleep() {
		
		//log.debug("sleep ctor");
		
		SIFSystemControlData sd = new SIFSystemControlData();
		sd.setSIFSleep(new com.uvasoftware.core.primitives.SIFSleep());
		SIFSystemControl sc = new SIFSystemControl();
		sc.setSIFSystemControlData(sd);
		sc.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
		message.setSIFSystemControl(sc);
		
	}
}

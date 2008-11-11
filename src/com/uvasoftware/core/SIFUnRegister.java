/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core;

import org.apache.log4j.Logger;


/**
 * Represents a <code>SIF_Unregister</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Unregister</code> as follows:
 * <blockquote>
 * This message allows an agent to remove any association it has with the ZIS. By sending this 
 * message, the ZIS will remove all provisions and subscriptions it maintains for the sender and 
 * discards any messages pending for the agent.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 *  
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFUnRegister extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFUnRegister.class.toString());
	
	public SIFUnRegister() {
		//log.debug("unregister ctor");

		com.uvasoftware.core.primitives.SIFUnregister unreg = new com.uvasoftware.core.primitives.SIFUnregister();
		unreg.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		message.setSIFUnregister(unreg);
	}
}

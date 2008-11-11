/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.handlers;

import org.apache.log4j.Logger;

import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.util.IEventHandler;


/**
 * Simple handler that logs the message to the screen 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class SimpleLoggingHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(SimpleLoggingHandler.class);  
	
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		SIFMessage msg = (SIFMessage) eventArgs;
		System.out.println("SIF MESSAGE XML:\n" + msg);
		//log.debug(msg);

	}

}

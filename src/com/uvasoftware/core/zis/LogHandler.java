package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.util.IEventHandler;
/**
 * Simple handler that output the message to the screen 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class LogHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(LogHandler.class);
	
	public LogHandler() {
		log.info("enabled");
	}
	
	public void handle(Object eventSource, Object eventArgs) {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		
		log.debug("REQUEST");
		log.debug(message);
		
		if (args.request != null ) {
			
			log.debug("RESPONSE");
			log.debug(args.response);
		}
	}

}

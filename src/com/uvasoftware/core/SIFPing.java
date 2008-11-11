package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.primitives.SIFSystemControl;
import com.uvasoftware.core.primitives.SIFSystemControlData;


/**
 * Represents a <code>SIF_Ping</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Ping</code> as follows:
 * <blockquote>
 * <code>SIF_SystemControl</code> - <code>SIF_Ping</code> is sent to detect if a ZIS or push-mode agent 
 * is ready to receive and process messages. The <code>SIF_SystemControl</code> - <code>SIF_Ping</code> 
 * message contains no elements.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author  <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFPing extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFPing.class);
	
		/** 
		 * Creates a compliant SIF Ping message
		 */
		public SIFPing() {
			
			log.debug("ping ctor");
			
			SIFSystemControlData sd = new SIFSystemControlData();
			sd.setSIFPing(new com.uvasoftware.core.primitives.SIFPing());
			SIFSystemControl sc = new SIFSystemControl();
			sc.setSIFSystemControlData(sd);
			sc.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
			
			message.setSIFSystemControl(sc);
			
		}
}

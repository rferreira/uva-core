/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.zis;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.exception.StopDispatchException;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Makes sure that incoming messages pass a basic sanity check 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class SanitationHandler implements IEventHandler {

	/* (non-Javadoc)
	 * @see com.uvasoftware.core.util.IEventHandler#handle(java.lang.Object, java.lang.Object)
	 */
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		ZIS zis = (ZIS) eventSource;
		SIFMessage message = args.request;
		SIFAck resp = null;
		
		/*
		 * We basically go over some basic requirements for a sane SIF message
		 * 
		 */
		
		if ( message.getHeader().getDate() == null ) {
			resp = message.createResponseAck();
			resp.setErrorCode(Code.XmlValidationError.MESSAGE_IS_NOT_WELL_FORMATTED);
			resp.setErrorCategory(Code.ErrorCategory.XML_VALIDATION);
			resp.setErrorDesc("could not read date information from the sif header");
			
		}else if ( message.getHeader().getSourceId() == null ) {
			resp = message.createResponseAck();
			resp.setErrorCode(Code.XmlValidationError.MESSAGE_IS_NOT_WELL_FORMATTED);
			resp.setErrorCategory(Code.ErrorCategory.XML_VALIDATION);
			resp.setErrorDesc("source id cannot be null");
			
		} else if ( message.getHeader().getSIFTime() == null ) {
			resp = message.createResponseAck();
			resp.setErrorCode(Code.XmlValidationError.MESSAGE_IS_NOT_WELL_FORMATTED);
			resp.setErrorCategory(Code.ErrorCategory.XML_VALIDATION);
			resp.setErrorDesc("could not read agent time information ");
		} else if ( message.getHeader().getSIFTimeZone() == null ) {
			resp = message.createResponseAck();
			resp.setErrorCode(Code.XmlValidationError.MESSAGE_IS_NOT_WELL_FORMATTED);
			resp.setErrorCategory(Code.ErrorCategory.XML_VALIDATION);
			resp.setErrorDesc("could not read time zone information");
		} 
		
		
		// if the resp was set we terminate the dispatch chain
		if (resp != null)  { 
			args.response = resp;
			throw new StopDispatchException();
		}

	}

	
}

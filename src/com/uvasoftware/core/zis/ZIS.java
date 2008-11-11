/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;
import com.uvasoftware.core.*;
import com.uvasoftware.core.util.*;


/**
 * Native ZIS implementation
 * <p>
 * Please note that you need to provide a DAO (implementing IZISDAO) for the ZIS to work, for example:<br>
 * <code> 
 * ZIS myzis = new ZIS(new VolatileDAO());
 * </code>
 * 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class ZIS {
	

	// this will prob have to change to support multiple zones

	private String vendorName = Config.getInstance().get(ConfigConstants.VENDOR) ;
	private String vendorProduct = Config.getInstance().get(ConfigConstants.ZIS_NAME);
	private String version = Config.getInstance().get(ConfigConstants.VERSION);
	
	/**
	 * EventSink argument passing object
	 */
	public class EventArgs {
		SIFMessage request;
		SIFMessage response;
	}
	
	private static Logger log = Logger.getLogger(ZIS.class);
	
	/**
	 * DAO used to persist ZIS metadata - you can use it to query the ZIS internal data structures
	 */
	public IZISDAO DAO = null;
	
	/**
	 * Event dispatches once a new request arrives containing the request / Handles the request
	 */
	public EventSink onRequest = new EventSink();

	/**
	 * Event dispatched before the incoming request is handled
	 */
	public EventSink onBeforeRequestHandling = new EventSink();
	
	/**
	 * Event dispatched right before sending the response message to the user. You cannot use this to modify the copy of the message
	 */
	public EventSink onAfterRequestHandling =new EventSink(); 
	
	/**
	 * Default ctor - requires a IZISDAO impl class
	 * @param dao the DAO to be used to persist the zis metadata
	 */
	public ZIS(IZISDAO dao) {
		
		log.info("Built in ZIS is firing up...");
		
		log.info("wiring handlers");
		onRequest.appendHandler(new SanitationHandler());
		onRequest.appendHandler(new SystemControlHandler());
		//onBeforeSendingMessage.appendHandler(new LogHandler());
		onRequest.appendHandler(new RegisterHandler());
		onRequest.appendHandler(new ProvisionHandler());
		onRequest.appendHandler(new SubscribeHandler());	
		onRequest.appendHandler(new EventHandler());
		onRequest.appendHandler(new AckHandler());
		onRequest.appendHandler(new RequestHandler());
		onRequest.appendHandler(new ResponseHandler());
		this.DAO = dao;
		
	}
	
	/**
	 * Pushes this message through the zis internal pipeline. You can call this the brains of the operation.
	 * @param in the message to the handled
	 * @return a sif response 
	 */
	public SIFMessage enter(SIFMessage in) {
		log.debug("dispatching onReceive");
		try {
			onBeforeRequestHandling.dispatch(this, in);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		log.debug("dispatching onRequest");
		EventArgs e = new EventArgs();
		e.request = in;
		
		try {
			onRequest.dispatch(this, e);
		} catch (Exception e1) {

			e1.printStackTrace();
			SIFAck resp = new SIFAck(e.request.getSourceId(),e.request.getId(), Code.ErrorCategory.SYSTEM, Code.SystemError.GENERIC_ERROR, "Internal Server Error");
			e.response = resp;
		}
		
		
		if (e.response == null) {
			log.warn("a response message was not returned, I'm going to send a error response of generic message not supported!");
			SIFAck resp = new SIFAck(e.request.getSourceId(),e.request.getId(), Code.ErrorCategory.GENERIC_MESSAGE_HANDLING, Code.GenericMessageHandlingError.MESSAGE_NOT_SUPPORTED, "There was no handler available to service this request type");
			e.response = resp;
			
		}
		
		//setting the ZIS sourceid
		e.response.getHeader().setSourceId(vendorProduct);
		
		log.debug("dispatching onBeforeSendingMessage");
		try {
			onAfterRequestHandling.dispatch(this, e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.debug("sending out response");	
		return(e.response);
		
	}


	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the vendorProduct
	 */
	public String getVendorProduct() {
		return vendorProduct;
	}

	/**
	 * @param vendorProduct the vendorProduct to set
	 */
	public void setVendorProduct(String vendorProduct) {
		this.vendorProduct = vendorProduct;
	}

	/**
	 * @return the vendorVersion
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param vendorVersion the vendorVersion to set
	 */
	public void setVersion(String vendorVersion) {
		this.version = vendorVersion;
	}
	
}

/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFObjectName;
import com.uvasoftware.core.SIFRequest;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.SIFResponse;
import com.uvasoftware.core.data.infra.SIFZoneStatus;
import com.uvasoftware.core.query.SIFQuery;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Handles Request messages - experimental!
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class RequestHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(RequestHandler.class);
	
	public RequestHandler() {
		log.info("enabled");
	}
	
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		ZIS zis = (ZIS) eventSource;
		SIFMessage message = args.request;
		SIFAck resp = null;
		
		if (message.getType() == SIFMessage.Type.REQUEST) {
			log.debug("handling request message");
			SIFRequest req = message.getRequest();
			
			SIFQuery q = null;
			
			q = req.getQuery();
			
			try {
			
				log.debug("handling request for object:" + q.getSIFObjectName());
				
			} catch (Exception e) {
				resp = message.createResponseAck();
				resp.setErrorCode(Code.RequestAndResponseError.INVALID_OBJECT);
				resp.setErrorCategory(Code.ErrorCategory.REQUEST_AND_RESPONSE);
			}
			
			if (q.getSIFObjectName() == SIFObjectName.SIFZoneStatus ) {
				
				/*
				 * In this case we create a quick response message and put it in the queue
				 */
				
				SIFResponse rp = new SIFResponse(message.getSourceId(),1,false);
				rp.getHeader().setDestinationId(message.getSourceId());
				SIFZoneStatus zt = zis.DAO.getZoneStatus();
				
				//TODO: this is incorrect and it should actually represent the zone name
				zt.setName("built-in zone");
				zt.setProductVersion(zis.getVersion());
				zt.setProduct(zis.getVendorProduct());
				zt.setVendorName(zis.getVendorName());
	
				rp.addObjectData(zt);
				// putting the response in the queue
				
				zis.DAO.putMessage(rp);
				
				resp = message.createResponseAck();
				resp.setStatusCode(Code.Status.SUCCESS);

			}else {
				
				/*
				 * Handling generic requests
				 */
						
				zis.DAO.putMessage(message);
				resp = message.createResponseAck();
				resp.setStatusCode(Code.Status.SUCCESS);
				args.response = resp; 
				
				
			}
		

		}
		if (resp != null) args.response = resp;

	}

}


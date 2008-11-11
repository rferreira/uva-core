package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.util.IEventHandler;

/**
 * Handles ACK messages
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class AckHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(AckHandler.class);
	
	public AckHandler() {
		log.info("enabled");
	}
	
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		ZIS zis = (ZIS) eventSource;
		SIFMessage message = args.request;
		SIFAck resp = null;
		
		if (message.getType() == SIFMessage.Type.ACK ) {
			log.debug("handling ack message");
			SIFAck ack = message.getAck();
			
			if (ack.getOriginalMsgID() != null && ack.getStatusCode() == Code.Status.IMMEDIATE_SIF ) {
				log.debug("hanlding immediate sif ack");
				zis.DAO.deleteMessage(ack.getSourceId(), ack.getOriginalMsgID());
			}
			
			resp = message.createResponseAck();
			resp.setStatusCode(Code.Status.SUCCESS);
		}
		if (resp != null) args.response = resp;

	}

}

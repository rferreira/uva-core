package com.uvasoftware.core.zis;

import org.apache.log4j.Logger;

import com.uvasoftware.core.Code;
import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.exception.StopDispatchException;
import com.uvasoftware.core.util.IEventHandler;
/**
 * Handles <code>SIF_Register</code> and <code>SIF_UnRegister</code> messages
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class RegisterHandler implements IEventHandler {
	private static Logger log = Logger.getLogger(RegisterHandler.class);
	
	public RegisterHandler() {
		log.info("enabled");
	}
	public void handle(Object eventSource, Object eventArgs) throws Exception {
		ZIS.EventArgs args = (ZIS.EventArgs) eventArgs;
		SIFMessage message = args.request;
		SIFAck resp = null;
		ZIS zis = (ZIS) eventSource;
		String source_id = message.getSourceId().trim();

		if (message.getType() == SIFMessage.Type.REGISTER) {
			
			if ( message.getRegister().getName()  == null ) {
				resp = message.createResponseAck();
				resp.setErrorCategory(Code.ErrorCategory.REGISTRATION);
				resp.setErrorCode(Code.RegistrationError.GENERIC_ERROR);
				resp.setErrorDesc("could not read agent name");
			
			} else if (message.getSourceId() == null ){
				resp = message.createResponseAck();
				resp.setErrorCategory(Code.ErrorCategory.REGISTRATION);
				resp.setErrorCode(Code.RegistrationError.SIF_SOURCEID_IS_INVALID);
				resp.setErrorDesc("could not read agent sourceid");	
				
			} else if (message.getRegister().getVersions().size() == 0 ) {
				log.error("received a register without version support information");
				resp = message.createResponseAck();
				resp.setErrorCode(Code.RegistrationError.REQUESTED_SIF_VERSION_IS_NOT_SUPPORTED);
				resp.setErrorCategory(Code.ErrorCategory.REGISTRATION);
				resp.setErrorDesc("problems reading the agent supported version in the registration request");
				
			} else {
			
				log.debug("in register message handler");
	
				log.debug("registering the agent /  creatig record");
				
				AgentRecord rec = new AgentRecord(source_id );
				
				rec.version = message.getRegister().getProtocolVersion();
				rec.maxBufferSize = message.getRegister().getMaxBuffer();
				rec.name = message.getRegister().getName();
				
				log.info(String.format("New agent [%s]  registerd", rec.name));
				
				log.debug("building response");
				resp = new SIFAck(message.getHeader().getSourceId(),message.getHeader().getId(),Code.Status.SUCCESS);
				
				zis.DAO.putAgent(rec);
			}

		}else if (message.getType() == SIFMessage.Type.UNREGISTER) {
			if ( source_id  == null ) return;
			zis.DAO.deleteAgent(source_id);
			resp = message.createResponseAck();
			resp.setStatusCode(Code.Status.SUCCESS);

		}else {
		
			// checking to see if the agent is registered:
			if (zis.DAO.getAgent(source_id) == null ) {
				resp = new SIFAck(message.getSourceId(),message.getId(),Code.ErrorCategory.ACCESS_AND_PERMISSIONS, Code.AccessAndPermissionError.SIF_SOURCEID_IS_NOT_REGISTERED, "Agent must first register" );
				throw (new StopDispatchException());
			}
			
		}
		
		if (resp != null) args.response = resp;
	
		

	}

}

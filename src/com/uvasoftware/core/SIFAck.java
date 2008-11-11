package com.uvasoftware.core;

import org.apache.log4j.Logger;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a <code>SIF_Ack</code> message.
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Ack</code> as follows:
 * <blockquote> 
 * This message is used as an acknowledgement for infrastructure messages. All infrastructure 
 * messages will return a <code>SIF_Ack</code> as a result to indicate if the request was 
 * successful or not. A <code>SIF_Ack</code> must contain either a <code>SIF_Status</code> 
 * element acknowledging a successful result or a <code>SIF_Error</code> element describing the 
 * failure. The <code>SIF_Error</code> element contains a standardized error number as well as 
 * a description of the error.
 * <p>
 * A successful <code>SIF_Ack</code> is typically returned to the caller containing a 
 * <code>SIF_Header</code>, <code>SIF_OriginalSourceId</code>, <code>SIF_OriginalMsgId</code> 
 * and the <code>SIF_Status</code> element. In situations where additional information needs to 
 * be returned to the caller, a <code>SIF_Data</code> element can be added to the 
 * <code>SIF_Status</code> element. 
 * <p>
 * In addition, successful <code>SIF_Ack</code> messages may also be sent to the ZIS under two 
 * conditions. The first is when a pull-mode agent requests that a message is to be removed from 
 * its queue. The second is when an agent which has invoked SMB wishes to end SMB handling. In 
 * that case, the agent sends a "Final" <code>SIF_Ack</code> to the ZIS. In each instance the ZIS 
 * returns a <code>SIF_Ack</code> in response to the agent's <code>SIF_Ack</code> message. 
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFAck extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFAck.class);

	// Instantiate SIF_Status and SIF_Error
	private com.uvasoftware.core.primitives.SIFStatus status = new com.uvasoftware.core.primitives.SIFStatus();
	//private String statusData = new String();
	private com.uvasoftware.core.primitives.SIFError error = new com.uvasoftware.core.primitives.SIFError();
	
	/**
	 * Provides basic setup common to all constructors
	 */
	private com.uvasoftware.core.primitives.SIFAck SIFAckCtorInit() {
		// Instantiate a SIFAck object from the primitive
		com.uvasoftware.core.primitives.SIFAck ack = new com.uvasoftware.core.primitives.SIFAck();
		
		// Populate everything we can on our own
		ack.setSIFHeader( (com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		message.setSIFAck(ack);
		return ack;
	}
	
	/**
	 * Creates a <code>SIF_Ack</code> reporting success
	 * @param originalSourceID the value of the <code>SIF_OriginalSourceID</code> element
	 * @param originalMsgID the value of the <code>SIF_OriginalMsgID</code> element
	 * @param statusCode the value of the <code>SIF_Status/SIF_Code</code> element
	 */
	public SIFAck(String originalSourceID, String originalMsgID, int statusCode) {
		com.uvasoftware.core.primitives.SIFAck ack = SIFAckCtorInit();
		ack.setSIFOriginalMsgId(originalMsgID);
		ack.setSIFOriginalSourceId(originalSourceID);

		//TODO Look, another BigInteger to fix in the primitives
		status.setSIFCode(new BigInteger(String.valueOf(statusCode)));
		ack.setSIFStatus(status);
	}
	
	/**
	 * Creates a <code>SIF_Ack</code> 
	 * @param originalSourceID the value of the <code>SIF_OriginalSourceID</code> element
	 * @param originalMsgID the value of the <code>SIF_OriginalMsgID</code> element
	 */
	public SIFAck(String originalSourceID, String originalMsgID) {
		com.uvasoftware.core.primitives.SIFAck ack = SIFAckCtorInit();
		ack.setSIFOriginalMsgId(originalMsgID);
		ack.setSIFOriginalSourceId(originalSourceID);

	}
	/**
	 * Ack ctor that doesn't do anything
	 */
	public SIFAck() {
		
	}
	/**
	 * Creates a <code>SIF_Ack</code> reporting failure
	 * @param originalSourceID the value of the <code>SIF_OriginalSourceID</code> element
	 * @param originalMsgID the value of the <code>SIF_OriginalMsgID</code> element
	 * @param errorCode the value of the <code>SIF_Error/SIF_Code</code> element
	 * @param errorCategory the value of the <code>SIF_Error/SIF_Category</code> element
	 */
	public SIFAck(String originalSourceID, String originalMsgID, int errorCode, int errorCategory, String errorDesc) {
		com.uvasoftware.core.primitives.SIFAck ack = SIFAckCtorInit();
		ack.setSIFOriginalMsgId(originalMsgID);
		ack.setSIFOriginalSourceId(originalSourceID);
		
		//TODO Have I mentioned how much I hate BigIntegers?  At least I'm not forcing the user to employ them.
		error.setSIFCode(new BigInteger(String.valueOf(errorCode)));
		error.setSIFCategory(new BigInteger(String.valueOf(errorCategory)));
		error.setSIFDesc(errorDesc);
		ack.setSIFError(error);
	}
	
	/*
	 * REMAINING METHODS
	 */

	/**
	 * Gets the value of the <code>SIF_OriginalSourceID</code> element
	 * @return the value of the <code>SIF_OriginalSourceID</code> element
	 */
	public String getOriginalSourceID() {
		return this.message.getSIFAck().getSIFOriginalSourceId();
	}

	/**
	 * Sets the value of the <code>SIF_OriginalSourceID</code> element
	 * @param originalSourceID the value of the <code>SIF_OriginalSourceID</code> element
	 */
	public void setOriginalSourceID(String originalSourceID) {
		this.message.getSIFAck().setSIFOriginalSourceId(originalSourceID);
	}

	/**
	 * Gets the value of the <code>SIF_OriginalMsgID</code> element
	 * @return the value of the <code>SIF_OriginalMsgID</code> element
	 */
	public String getOriginalMsgID() {
		return this.message.getSIFAck().getSIFOriginalMsgId();
	}

	/**
	 * Sets the value of the <code>SIF_OriginalMsgID</code> element
	 * @param originalMsgID the value of the <code>SIF_OriginalMsgID</code> element
	 */
	public void setOriginalMsgID(String originalMsgID) {
		this.message.getSIFAck().setSIFOriginalMsgId(originalMsgID);
	}

	/**
	 * Gets the value of the <code>SIF_Status/SIF_Code</code> element
	 * @return the value of the <code>SIF_Status/SIF_Code</code> element
	 */
	public int getStatusCode() {
		if ( this.message.getSIFAck().getSIFStatus() == null ) {
			int ret = -1;
			return ret;
		} else {
			return this.message.getSIFAck().getSIFStatus().getSIFCode().intValue();
		}
	}

	/**
	 * Sets the value of the <code>SIF_Status/SIF_Code</code> element
	 * @param statusCode the value of the <code>SIF_Status/SIF_Code</code> element
	 */
	public void setStatusCode(int statusCode) {
		if (message.getSIFAck().getSIFStatus() == null ) {
			message.getSIFAck().setSIFStatus(new com.uvasoftware.core.primitives.SIFStatus());
		}
		
		this.message.getSIFAck().getSIFStatus().setSIFCode(new BigInteger(String.valueOf(statusCode)));
	}

	/**
	 * Gets the value of the <code>SIF_Status/SIF_Data</code> element
	 * @return the value of the <code>SIF_Status/SIF_Data</code> element
	 */
	public String getStatusData() {
		if (message.getSIFAck().getSIFStatus() == null || message.getSIFAck().getSIFStatus().getSIFData() == null || message.getSIFAck().getSIFStatus().getSIFData().getContent() == null )
			return(null);
		
		return this.message.getSIFAck().getSIFStatus().getSIFData().toString();
	}
	
	/**
	 * Returns a list of <code>SIFMessage</code> objects from the payload in this <code>SIF_Status/SIF_Data</code>
	 * @return list of <code>SIF_Message</code>
	 */
	public List<SIFMessage> getStatusDataMessages() {
		ArrayList<SIFMessage>list = new ArrayList<SIFMessage>();
		
		if (message.getSIFAck().getSIFStatus() == null || message.getSIFAck().getSIFStatus().getSIFData() == null || message.getSIFAck().getSIFStatus().getSIFData().getContent() == null )
			return(list);
		
		/*
		 * The logic below handles the possiblity of out of place newlines in the sifmessage response
		 */
		for (Object o: this.message.getSIFAck().getSIFStatus().getSIFData().getContent()) {
			if (o instanceof com.uvasoftware.core.primitives.SIFMessage) {
				list.add( new SIFMessage(o));
			}else {
				log.warn("illegal character in respnse data of type [" + o.getClass().getName() + "], skipping it");
			}
			
		}
		return(list);
	}

	/**
	 * Sets the value of the <code>SIF_Status/SIF_Data</code> element
	 * @param statusData the value of the <code>SIF_Status/SIF_Data</code> element
	 */
	public void setStatusData(SIFMessage retMsg) {
		//TODO: do we need to change accepted parameter type?
		//spec wording: Optional element to hold a ~textual description of SIF_Code~. SIF_Data also ~MAY~ 
		//contain a SIF_Message in a SIF_Ack returned by the ZIS containing a pull-mode agent's next message.
		//
		com.uvasoftware.core.primitives.SIFData data = this.message.getSIFAck().getSIFStatus().getSIFData();
		
		if (data == null )
			data = new com.uvasoftware.core.primitives.SIFData();
		
		// now we jam the return message int the data payload
		data.getContent().add(retMsg.getPrimitive());
		
		// and we jam the payload into the Ack
		this.message.getSIFAck().getSIFStatus().setSIFData(data);
	}

	/**
	 * List based wrapper for <code>setStatusData</code>
	 * @param list
	 */
	public void setAllStatusData(List<SIFMessage> list) {
		for (SIFMessage m: list) {
			setStatusData(m);
		}
	}
	/**
	 * Gets the value of the <code>SIF_Error/SIF_Code</code> element
	 * @return the value of the <code>SIF_Error/SIF_Code</code> element
	 */
	public int getErrorCode() {
		if ( this.message.getSIFAck().getSIFError() == null ) {
			int ret = -1;
			return ret;
		} else {
			//TODO: BigInteger cleanup
			return this.message.getSIFAck().getSIFError().getSIFCode().intValue();
		}
	}

	/**
	 * Sets the value of the <code>SIF_Error/SIF_Code</code> element
	 * @param errorCode the value of the <code>SIF_Error/SIF_Code</code> element
	 */
	public void setErrorCode(int errorCode) {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		//TODO: BigInteger cleanup
		this.message.getSIFAck().getSIFError().setSIFCode(new BigInteger(String.valueOf(errorCode)));
	}

	/**
	 * Gets the value of the <code>SIF_Error/SIF_Category</code> element
	 * @return the value of the <code>SIF_Error/SIF_Category</code> element
	 */
	public int getErrorCategory() {
		if ( this.message.getSIFAck().getSIFError() == null ) {
			int ret = -1;
			return ret;
		} else {
			//TODO: BigInteger cleanup
			return this.message.getSIFAck().getSIFError().getSIFCategory().intValue();
		}
	}

	/**
	 * Sets the value of the <code>SIF_Error/SIF_Category</code> element
	 * @param errorCategory the value of the <code>SIF_Error/SIF_Category</code> element
	 */
	public void setErrorCategory(int errorCategory) {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		//TODO: BigInteger cleanup
		this.message.getSIFAck().getSIFError().setSIFCategory(new BigInteger(String.valueOf(errorCategory)));
	}

	/**
	 * Gets the value of the <code>SIF_Error/SIF_Desc</code> element
	 * @return the value of the <code>SIF_Error/SIF_Desc</code> element
	 */
	public String getErrorDesc() {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		return this.message.getSIFAck().getSIFError().getSIFDesc();
	}

	/**
	 * Sets the value of the <code>SIF_Error/SIF_Desc</code> element
	 * @param errorDesc the value of the <code>SIF_Error/SIF_Desc</code> element
	 */
	public void setErrorDesc(String errorDesc) {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		this.message.getSIFAck().getSIFError().setSIFDesc(errorDesc);
	}

	/**
	 * Gets the value of the <code>SIF_Error/SIF_ExtDesc</code> element
	 * @return the value of the <code>SIF_Error/SIF_ExtDesc</code> element
	 */
	public String getErrorExtDesc() {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		return this.message.getSIFAck().getSIFError().getSIFExtendedDesc();
	}

	/**
	 * Sets the value of the <code>SIF_Error/SIF_ExtDesc</code> element
	 * @param errorExtDesc the value of the <code>SIF_Error/SIF_ExtDesc</code> element
	 */
	public void setErrorExtDesc(String errorExtDesc) {
		if (message.getSIFAck().getSIFError() == null ) buildErrorStructure();
		this.message.getSIFAck().getSIFError().setSIFExtendedDesc(errorExtDesc);
	}
	
	public SIFResponse getResponse() {
		
		// if this is an error we return quick
		if (message.getSIFAck().getSIFStatus().getSIFData() == null )
			return(null);
		
		SIFResponse resp = new SIFResponse();
		resp.setPrimitive((com.uvasoftware.core.primitives.SIFMessage) message.getSIFAck().getSIFStatus().getSIFData().getContent().get(0));
		return(resp);
	}
	
	private void buildErrorStructure() {
		this.message.getSIFAck().setSIFError(new com.uvasoftware.core.primitives.SIFError());
		
	}
		
}

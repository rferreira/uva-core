/**
 * 
 */
package com.uvasoftware.core;

import java.math.BigInteger;

import org.apache.log4j.Logger;

import com.uvasoftware.core.query.SIFQuery;


/**
 * Represents a <code>SIF_Request</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Request</code> as follows:
 * <blockquote>
 * This message is used to request information in SIF data objects from other agents. It specifies fields in the object to 
 * request and the query or search criteria. <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 *  
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFRequest extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFRequest.class);
	
	/**
	 * Creates a new Request object
	 * 
	 */
	public SIFRequest() {
		init();
	}
	
	/**
	 * Creates a new Request object and sets it query
	 * @param q the SIFquery to be used
	 */
	public SIFRequest(SIFQuery q) {
		init();
		setQuery(q);
	}
	
	/**
	 * Sets the sif query to be used in this request
	 * @param q the sifquery object 
	 */
	public void setQuery(SIFQuery q ) {
		
		message.getSIFRequest().setSIFQuery((com.uvasoftware.core.primitives.SIFQuery) q.getPrimitive());
	}
	
	/**
	 * Returns the query encapsulated by this request
	 */
	public SIFQuery getQuery() {
		return( new SIFQuery(message.getSIFRequest().getSIFQuery()));
	}
		
	private void init() {
		log.debug("creating a new sif_request");
		com.uvasoftware.core.primitives.SIFRequest req = new com.uvasoftware.core.primitives.SIFRequest();
		req.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
		// setting version 
		req.setSIFVersion("None");
		
		//req.setSIFMaxBufferSize(BigInteger.ZERO);
		
		// setting max buffer size
		// req.setSIFMaxBufferSize(new BigInteger);
		this.message.setSIFRequest(req);
	}
	
	/**
	 * Returns the value of <code>SIF_Version</code> which specifies which spec version should be used when returning the response data
	 * @return
	 */
	public String getVersion() {
		return(message.getSIFRequest().getSIFVersion());
	}
	
	/**
	 * Sets the value of <code>SIF_Version</code> which specifies which spec version should be used when returning the response data
	 * @param value
	 */
	public void setVersion(String value) {
		message.getSIFRequest().setSIFVersion(value);
	}
	
	/**
	 * Gets the value of the SIF_MaxBufferSize element
	 * @return the value of the SIF_MaxBufferSize element
	 */
	public int getMaxBuffer() {
		return this.message.getSIFRequest().getSIFMaxBufferSize().intValue();
	}

	/**
	 * Sets the value of the SIF_MaxBufferSize element
	 * @param maxBufferInt
	 */
	public void setMaxBuffer(int maxBufferInt) {
		//TODO After fixing MaxBufferSize type (should be int), remove this conversion
		this.message.getSIFRequest().setSIFMaxBufferSize(new BigInteger(String.valueOf(maxBufferInt)));
	}

}

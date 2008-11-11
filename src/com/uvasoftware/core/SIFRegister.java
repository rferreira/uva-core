/**
 * 
 */
package com.uvasoftware.core;

import org.apache.log4j.Logger;

import com.uvasoftware.core.util.*;

import java.math.BigInteger;
import java.util.List;


/**
 * Represents a <code>SIF_Register</code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Register</code> as follows:
 * <blockquote>
 * <code>SIF_Register</code> is the message for registering an agent with a ZIS. An agent must 
 * be registered before it sends out other SIF messages. <code>SIF_Register</code> serves to 
 * provide the ZIS with the sender's identification information as well as to provide the 
 * information that the ZIS will need to contact this agent, should it register in Pull mode.
 * <p>
 * Once a sender registers in the ZIS with the <code>SIF_Register</code> message, the sender 
 * can use the <code>SIF_SourceId </code>value in the header of all other outgoing messages 
 * as its identification. It is not necessary to send a <code>SIF_Register</code> message each 
 * time your agent starts up but it is not an error to do so. If there are any blocked 
 * messages in the Agent's queue when a ZIS receives the <code>SIF_Register</code> message 
 * the blocks will be removed. <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>  
 * <i>Note: Only Pull mode is currently supported</i> 
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFRegister extends SIFMessage  {
	private static Logger log = Logger.getLogger(SIFRegister.class);
		
	
	/**
	 * Creates a new <code>SIF_Message</code> object from an XML primitive
	 * @param primitive the XML primitive
	 */
	public SIFRegister(com.uvasoftware.core.primitives.SIFMessage primitive) {
		this.setPrimitive(primitive);
		
	}
	public SIFRegister() {
		log.debug("register ctor");

		// Instantiate a SIFRegister object from the primitive
		com.uvasoftware.core.primitives.SIFRegister reg = new com.uvasoftware.core.primitives.SIFRegister();
		
		// Populate everything we can on our own
		reg.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		
		message.setSIFRegister(reg);
		
	}
		
	/**
	 * Gets the value of the SIF_MaxBufferSize element
	 * @return the value of the SIF_MaxBufferSize element
	 */
	public int getMaxBuffer() {
		return this.message.getSIFRegister().getSIFMaxBufferSize().intValue();
	}

	/**
	 * Sets the value of the SIF_MaxBufferSize element
	 * @param maxBufferInt
	 */
	public void setMaxBuffer(int maxBufferInt) {
		//TODO After fixing MaxBufferSize type (should be int), remove this conversion
		this.message.getSIFRegister().setSIFMaxBufferSize(new BigInteger(String.valueOf(maxBufferInt)));
	}

	/**
	 * Gets the value of the SIF_Mode element
	 * @return the value of the SIF_Mode element
	 */
	public String getMode() {
		return this.message.getSIFRegister().getSIFMode();
	}

	/**
	 * Sets the value of the SIF_Mode element
	 * @param mode
	 */
	public void setMode(String mode) {
		this.message.getSIFRegister().setSIFMode(ParseSIFMode.valueOf(mode));
	}

	/**
	 * Gets the value of the SIF_Name element
	 * @return the value of the SIF_Name element
	 */
	public String getName() {
		return this.message.getSIFRegister().getSIFName();
	}

	/**
	 * Sets the value of the SIF_Name element
	 * @param name
	 */
	public void setName(String name) {
		this.message.getSIFRegister().setSIFName(name);
	}
	/**
	 * Returns a list representing all the SIF versions supported by this agent
	 */
	public List<String> getVersions() {
		return this.message.getSIFRegister().getSIFVersion();
	}

}

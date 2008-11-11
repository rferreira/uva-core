/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.uvasoftware.core.primitives.TimeWithZoneType;
import com.uvasoftware.core.util.SIFGUID;



/**
 * Facade around the SIF primitive
 * <p>
 * The <code>SIF_Header</code> element has the following attributes in version 1.5r1 of the SIF spec:
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * <table>
 * 	<tr valign=top>
 * 		<th align=left>Element
 * 		<th align=left>Attribute
 * 		<th align=left>Characteristic
 * 		<th align=left>Description
 * 	<tr valign=top>
 * 		<td><code>SIF_MsgID</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td><code>SIF_MsgId</code> is a globally unique message identifier from the Agent or ZIS that sends out the message.
 * 	<tr valign=top>
 * 		<td><code>SIF_Date</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The date on which the message is sent. It is a string value in the format of "CCYYMMDD." For example,
 *  		<code>&lt;SIF_Date&gt;19990218&lt;/SIF_Date&gt;</code> represents February 18, 1999.
 * 	<tr valign=top>
 * 		<td><code>SIF_Time</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The time at which the message is sent.
 * 	<tr valign=top>
 * 		<td>
 * 		<td><code>Zone</code>
 * 		<td>Required
 * 		<td>The Zone attribute describes the time zone as an offset from the zero meridian. The value of SIF_Time is in the 
 * 			format "HH:MM:SS" with HH in the range 0 to 23, MM in the range 0 to 59 and SS in the range 0 to 59.
 * 			<code>&lt;SIF_Time Zone="UTC-08:00"&gt;20:39:12&lt;/SIF_Time&gt;</code> represents 20 hours 39 minutes and 12 
 * 			seconds (or 8 o'clock 39 minutes and 12 seconds PM) for the Pacific Standard Time. <code>SIF_Date</code> and 
 * 			<code>SIF_Time</code> together represent the time stamp of a message.
 * 	<tr valign=top>
 * 		<td><code>SIF_Security</code>
 * 		<td>
 * 		<td>Optional
 * 		<td>This element allows an originating agent to specify security requirements that the ZIS must ensure upon delivery 
 * 			of the message to recipient agents. SIF_Security is only examined and processed by a ZIS on SIF_Request, 
 * 			<code>SIF_Response</code> and <code>SIF_Event</code> messages. In this version of the specification, 
 * 			<code>SIF_Security</code> is ignored on all other messages; its use on other messages is reserved for future 
 * 			versions of this specification.
 * 	<tr valign=top>
 * 		<td><code>SIF_Security/<br>SIF_SecureChannel</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The originating agent uses this element to specify security requirements for the channel between the ZIS and 
 * 			any recipient agents at delivery time. The ZIS must ensure these requirements are met for this message when 
 * 			delivered to other agents.
 * 	<tr valign=top>
 * 		<td><code>SIF_Security/<br>SIF_SecureChannel/<br>SIF_AuthenticationLevel</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The minimum level of authentication required by the message originator to be considered a secure channel upon 
 * 			message delivery to other agents.
 * 	<tr valign=top>
 * 		<td><code>SIF_Security/<br>SIF_SecureChannel/<br>SIF_EncryptionLevel</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The minimum level of encryption required by the message originator to be considered a secure channel upon 
 * 			message delivery to other agents.
 * 	<tr valign=top>
 * 		<td><code>SIF_SourceId</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>The <code>SIF_SourceId</code> is the ID of the originator of the message. Each source needs to have a zone unique 
 * 			case-sensitive identifier.
 * 	<tr valign=top>
 * 		<td><code>SIF_DestinationId</code>
 * 		<td>
 * 		<td>Mandatory
 * 		<td>This element represents the ID of the recipient of the message and may be present as follows:<br> 
 * 			<code>SIF_Response</code> messages MUST have this element set to the <code>SIF_SourceId</code> of the originator 
 * 			of the <code>SIF_Request</code> message. The ZIS will use this information to route the <code>SIF_Response</code> 
 * 			to the requesting agent.<br> 
 * 			<code>SIF_Request</code> messages MAY have this element set to the ID of a specific agent if the requesting 
 * 			agent wishes to direct the <code>SIF_Request</code> to a specific responder. If present, the ZIS will route the 
 * 			<code>SIF_Request</code> to the agent referenced in the element subject to the access control policies in effect 
 * 			for the zone. This element SHOULD NOT be used in any other SIF Infrastructure messages. If the element is 
 * 			present, it will be ignored by the ZIS.
 * </table>
 * 
 * <p>
 * It is important to note that this class will attempt to populate as much of header information as possible from the system wide Config
  <p>
 *   
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFHeader implements ISIFObject {
	private static Logger log = Logger.getLogger(SIFHeader.class);
		
	private static SimpleDateFormat headerDateFormat = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat headerTimeFormat = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat tzFormat = new SimpleDateFormat("Z");
	
	// primitive
	private com.uvasoftware.core.primitives.SIFHeader primitive = null;

	public SIFHeader() {
		//log.debug("creating new sif message header");
		primitive = new com.uvasoftware.core.primitives.SIFHeader();
		
		// Populate mandatory element "SIF_MsgID"
		primitive.setSIFMsgId(SIFGUID.next());

		log.debug("New message with id " + primitive.getSIFMsgId());
		
		
		// Populate mandatory element "SIF_Date"
		Date now = new Date();
		primitive.setSIFDate(headerDateFormat.format(now));
		
		// Populate mandatory element "SIF_Time"
		//TODO: this is prob inefficient
		TimeWithZoneType tz = new TimeWithZoneType();
		tz.setValue(headerTimeFormat.format(now));
		tz.setZone("UTC" + (tzFormat.format(now).toString().replace("00", ":00")));
		primitive.setSIFTime(tz);
		
		
	}
	/**
	 * Helper ctor for those situations when you want to just create a facade from the primitive
	 * @param header the primitive to be used
	 */
	public SIFHeader(com.uvasoftware.core.primitives.SIFHeader header) {
		//log.debug("shortcut ctor via primitive injection");
		setPrimitive(header);
	}
	
	/**
	 * Returns the pimitive of this facade
	 */
	public Object getPrimitive() {
		return(primitive);
	}
	
	/**
	 * sets the primitive of this facade 
	 */
	public void setPrimitive(Object primitive) {
		this.primitive = (com.uvasoftware.core.primitives.SIFHeader) primitive;
	}
	
	//other relative methods
	/**
	 * Gets the <code>SIF_MsgID</code> field of the <code>SIF_Header</code> element
	 */
	@Deprecated
	public String getID() {
		return(primitive.getSIFMsgId());
	}

	//other relative methods
	/**
	 * Gets the <code>SIF_MsgID</code> field of the <code>SIF_Header</code> element
	 */
	public String getId() {
		return(primitive.getSIFMsgId());
	}

	/**
	 * Sets the <code>SIF_MsgID</code> field of the <code>SIF_Header</code> element
	 * @param ID the new SIF message ID
	 */
	@Deprecated
	public void setID(String ID) {
		this.primitive.setSIFMsgId(ID);
	}
	
	/**
	 * Sets the <code>SIF_MsgID</code> field of the <code>SIF_Header</code> element
	 * @param ID the new SIF message ID
	 */
	public void setId(String ID) {
		this.primitive.setSIFMsgId(ID);
	}
	/**
	 * Gets the <code>SIF_Date</code> field of the <code>SIF_Header</code> element
	 */
	public String getDate() {
		return(primitive.getSIFDate());
	}
	
	/**
	 * Sets the <code>SIF_Date</code> field of the <code>SIF_Header</code> element
	 * @param 
	 */
	public void setDate(String newDate) {
		this.primitive.setSIFDate(newDate);
	}
	
	/**
	 * Gets the <code>SIF_DestinationId</code> field of the <code>SIF_Header</code> element 
	 */
	@Deprecated
	public String getDestinationID() {
		return(primitive.getSIFDestinationId());
	}
	
	/**
	 * Sets the <code>SIF_DestinationId</code> field of the <code>SIF_Header</code> element
	 * @param the new destination id
	 */
	@Deprecated
	public void setDestinationID(String newID) {
		primitive.setSIFDestinationId(newID);
	}
	
	
	/**
	 * Gets the <code>SIF_DestinationId</code> field of the <code>SIF_Header</code> element 
	 */
	public String getDestinationId() {
		return(primitive.getSIFDestinationId());
	}
	
	/**
	 * Sets the <code>SIF_DestinationId</code> field of the <code>SIF_Header</code> element
	 * @param the new destination id
	 */
	public void setDestinationId(String newID) {
		primitive.setSIFDestinationId(newID);
	}
	
	/**
	 * Gets the <code>SIF_SourceId</code> field of the <code>SIF_Header</code> element
	 * 
	 */
	@Deprecated
	public String getSourceID() {
		return(primitive.getSIFSourceId());
	}
	
	/**
	 * Sets the <code>SIF_SourceId</code> field of the <code>SIF_Header</code> element
	 * @param value the new source ID
	 */
	@Deprecated
	public void setSourceID(String value) {
		this.primitive.setSIFSourceId(value);
	}
	
	/**
	 * Gets the <code>SIF_SourceId</code> field of the <code>SIF_Header</code> element
	 * 
	 */
	public String getSourceId() {
		return(primitive.getSIFSourceId());
	}
	
	/**
	 * Sets the <code>SIF_SourceId</code> field of the <code>SIF_Header</code> element
	 * @param value the new source ID
	 */
	public void setSourceId(String value) {
		this.primitive.setSIFSourceId(value);
	}
	/**
	 * Gets the <code>SIF_Time</code> field of the <code>SIF_Header</code> element
	 * 
	 */
	public String getSIFTime() {
		return(primitive.getSIFTime().getValue());
	}
	
	/**
	 * Sets the <code>SIF_Time</code> field of the <code>SIF_Header</code> element
	 * @param value the new time in the correct SIF format
	 */
	public void setSIFTime(String value) {
		if (primitive.getSIFTime() == null) 
			primitive.setSIFTime(new TimeWithZoneType());
		
		primitive.getSIFTime().setValue(value);
		
	}
	
	/**
	 * Gets the <code>SIF_Time/Zone</code> field of the <code>SIF_Header</code> element
	 * 
	 */	
	public String getSIFTimeZone() {
		return(primitive.getSIFTime().getZone());
	}
	
	/**
	 * Sets the <code>SIF_Time/Zone</code> field of the <code>SIF_Header</code> element
	 * @param value the new time zone in the correct SIF format
	 */	
	public void setSIFTimeZone(String value) {
		if (primitive.getSIFTime() == null) 
			primitive.setSIFTime(new TimeWithZoneType());
		
		primitive.getSIFTime().setZone(value);
	}
	
}

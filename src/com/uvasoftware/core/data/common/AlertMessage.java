/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


/**
 * This class represents a SIF <code>AlertMsg</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 * 
 * 
 */
public class AlertMessage extends BaseSIFObject {
	//TODO: if feels there should be a type enumeration here somewhere LAMESPEC
	
	com.uvasoftware.core.primitives.AlertMsg primitive = new com.uvasoftware.core.primitives.AlertMsg();

	/**
	 * Creates a new <code>AlertMsg</code> object from an XML primitive
	 * @param value the XML primitive
	 */
	public AlertMessage() { 
		
	}
	/**
	 * Creates a new <code>AlertMsg</code> object
	 * @param type the alert type
	 * @param message the alert message
	 */
	public AlertMessage(String type, String message) {
		primitive.setType(type);
		primitive.setValue(message);
	}

	
	/**
	 * Returns the <code>Type</code> attribute of the <code>AlertMsg</code>
	 * @return a string representing the type 
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/**
	 * Sets the <code>Type</code> attribute of the <code>AlertMsg</code>
	 * @param value the new <code>Type</code> 
	 */
	public void setType(String value) {
		this.primitive.setType(value);
	}
	
	/**
	 * Returns the message of the <code>AlertMsg</code>
	 * @return a string representing the message 
	 */
	public String getMessage() {
		return(primitive.getValue());
	}
	
	/**
	 * Sets the message of the <code>AlertMsg</code>
	 * @param value the new message 
	 */
	public void setMessage(String value) {
		this.primitive.setValue(value);
	}
	

}

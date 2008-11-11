/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>OtherId</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class OtherId extends BaseSIFObject {

	com.uvasoftware.core.primitives.OtherId primitive = new com.uvasoftware.core.primitives.OtherId();
	
	
	/**
	 * Sets the <code>type</code> property of the <code>OtherId</code> object
	 * 
	 * @param type the id type
	 */
	public void setType(String type) { 
		this.primitive.setType(type); 
	}
	
	/**
	 * Gets the <code>type</code> property of the <code>OtherId</code> object
	 * @return the id type
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/**
	 * Sets the value of the <code>OtherId</code> object
	 * @param value the value of the <code>OtherId</code> object
	 */
	public void setValue(String value) { 
		this.primitive.setValue(value);
	}
	
	/**
	 * Gets the value of the <code>OtherId</code> object
	 * @return the value of the <code>OtherId</code> object
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/**
	 * Creates a new SIF <code>OtherId</code> object
	 * @param type the type of the Id
	 * @param value the value of the Id
	 */
	public OtherId(String type, String value) {
		setValue(value);
		setType(type);
	}
	
	public OtherId() {
		
	}
	
	public OtherId(com.uvasoftware.core.primitives.OtherId value) { 
		this.primitive = value;
	}
	

	
}

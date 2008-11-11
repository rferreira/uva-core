/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>IdentificationInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class IdentificationInfo extends BaseSIFObject  {

	com.uvasoftware.core.primitives.IdentificationInfo primitive = new com.uvasoftware.core.primitives.IdentificationInfo();
	
	
	/**
	 * ctor
	 */
	public IdentificationInfo() {
		
	}
	/**
	 * Creates a new <code>IdentificationInfo</code> object from an XML primitive
	 * @param value the xml primitive
	 */
	public IdentificationInfo(com.uvasoftware.core.primitives.IdentificationInfo value) {
		this.primitive = value;
	}
	
	/**
	 * Sets the <code>Code</code> attribute of this object
	 * @param code
	 */
	public void setCode(String code) {
		this.primitive.setCode(code);
	}

	/** 
	 * Gets the <code>Code</code> attribute of this object
	 * @return
	 */
	public String getCode() {
		return(primitive.getCode());
	}
	
	/**
	 * Sets the value of this object
	 * @param value
	 */
	public void setValue(String value) {
		primitive.setValue(value);
	}
	
	/**
	 * Gets the value of this object
	 * @return
	 */
	public String getValue() {
		return(primitive.getValue());
	}
}

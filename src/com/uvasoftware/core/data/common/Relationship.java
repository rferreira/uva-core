/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


/**
 * This class represents a SIF <code>Relationship</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class Relationship extends BaseSIFObject {

	com.uvasoftware.core.primitives.Relationship primitive = new com.uvasoftware.core.primitives.Relationship();
	
	/**
	 * Creates a new SIF <code>Relationship</code> object
	 * @param code the value of the <code>Code</code> attribute of the object
	 */
	public Relationship(String code) {
		this.primitive.setCode(code);
	}
	
	/**
	 * Creates a new SIF <code>Relationship</code> object from an XML primitive
	 */
	public Relationship(com.uvasoftware.core.primitives.Relationship primitive) {
		this.primitive = primitive;
	}
	
	/**
	 * Gets the value of the <code>Code</code> attribute
	 * @return the value of the attribute
	 */
	public String getCode() {
		return(this.primitive.getCode());
	}
	
	/**
	 * Sets the value of the <code>Code</code> attribute
	 * @param code the <code>Relationship</code> code
	 */
	public void setCode(String code) {
		this.primitive.setCode(code);
	}
	
	
}

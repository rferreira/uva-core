/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


/**
 * This class represents a SIF <code>EmployerType</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class EmployerType extends BaseSIFObject {

	com.uvasoftware.core.primitives.EmployerType primitive = new com.uvasoftware.core.primitives.EmployerType();
	
	/**
	 * Creates a new SIF <code>EmployerType</code> object
	 * @param code the value of the <code>Code</code> attribute of the object
	 */
	public EmployerType(String code) {
		this.primitive.setCode(code);
	}
	
	/**
	 * Creates a new SIF <code>EmployerType</code> object from an XML primitive
	 */
	public EmployerType(com.uvasoftware.core.primitives.EmployerType primitive) {
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
	 * @param code the <code>EmployerType</code> code
	 */
	public void setCode(String code) {
		this.primitive.setCode(code);
	}
	
	
}


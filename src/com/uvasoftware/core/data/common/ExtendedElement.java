/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>SIF_ExtendedElement</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 * <p>
 * From the spec:<br>
 * Allows an agent to include data not yet defined within a SIF data
object as name/value pairs
 *
 */
public class ExtendedElement extends BaseSIFObject {

	com.uvasoftware.core.primitives.SIFExtendedElement primitive = new com.uvasoftware.core.primitives.SIFExtendedElement(); 
	
	public String getName() {
		return(primitive.getName());
	}
	
	public void setName(String value) {
		this.primitive.setName(value);
	}
	
	public String getValue() {
		return(primitive.getValue());
	}
	
	public void setValue(String value) {
		this.primitive.setValue(value);
	}
	
	public ExtendedElement(String name, String value) {
		setValue(value);
		setName(name);
	}
	
	
	
	
	

}

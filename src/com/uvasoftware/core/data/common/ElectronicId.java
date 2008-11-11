/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>ElectronicId</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class ElectronicId extends BaseSIFObject {

	com.uvasoftware.core.primitives.ElectronicId primitive = new com.uvasoftware.core.primitives.ElectronicId();
	
	/**
	 * Represents the different electronic ID types defined in the SIF spec
	 */
	public class Type{
		public static final String BARCODE = "Barcode";
		public static final String MAGSTRIPE = "Magstripe";
		public static final String PIN = "PIN";
	}
	
	
	/**
	 * Returns the primitive representation of this object
	 * 
	 * @see com.uvasoftware.core.ISIFObject#getPrimitive()
	 */
	@Override
	public Object getPrimitive() {
		return(primitive);
	}

	/**
	 * Sets the primitive representation of this object
	 */
	@Override
	public void setPrimitive(Object primitive) {
		this.primitive = (com.uvasoftware.core.primitives.ElectronicId) primitive;
	}
	
	/**
	 * Creates a new ElectronicId object with the assigned ElectronicId Type
	 * 
	 * @param type the type of electronic ID
	 * @param value the value of the electronic ID 
	 * 
	 * @see ElectronicId.Types
	 */
	public ElectronicId(String type, String value) {
		primitive.setType(type);
		primitive.setValue(value);
	}
	/**
	 * Creates a new ElectronicId object from an XML primitive
	 * 
	 * 
	 */
	public ElectronicId(com.uvasoftware.core.primitives.ElectronicId value) {
		this.primitive = value;
	}	
	/** 
	 * Gets the <code>Type</code> attribute of the <code>ElectronicId</code> element
	 * @return the type of electronic ID
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/** 
	 * Sets the <code>Type</code> attribute of the <code>ElectronicId</code> element
	 * @param type the type of electronic ID
	 * @see ElectronicId.Types
	 */
	public void setType(String type) {
		primitive.setType(type);
	}
	
	/** 
	 * Gets the value of the <code>ElectronicId</code> element
	 * @return the value of the electronic ID
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/** 
	 * Sets the value of the <code>ElectronicId</code> element
	 * @param value the value of the electronic ID
	 */
	public void setValue(String value) {
		primitive.setValue(value);
	}
}
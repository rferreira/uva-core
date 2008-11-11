/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>PhoneNumber</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class PhoneNumber extends BaseSIFObject {

	com.uvasoftware.core.primitives.PhoneNumber primitive = new com.uvasoftware.core.primitives.PhoneNumber();
	
	/**
	 * Represents the different PhoneNumber types in the sif spec
	 */
	public static class Format {
		public static final String NA = "North America";
		public static final String EU = "Europe";
		public static final String FF = "Free-form";
	}
	
	/**
	 * Creates a new PhoneNumber object with the assigned PhoneNumber type
	 * @param format the phone number <code>Format</code>
	 * @param type the phone number type
	 * @param number the phone number to be stored
	 */
	public PhoneNumber(String format, String type, String number) {
		primitive.setFormat(format);
		primitive.setType(type);
		primitive.setValue(number);
	}
	
	/**
	 * Gets the <code>format</code> field of the <code>PhoneNumber/format</code> element
	 * @return the <code>format</code> field of the <code>PhoneNumber/format</code> element
	 */
	public String getformat() { 
		return(primitive.getFormat()); 
	}
	/**
	 * Sets the <code>format</code> field of the <code>PhoneNumber/format</code> element
	 * @param format the <code>format</code> field of the <code>PhoneNumber/format</code> element
	 */	
	public void setFormat(String format) {
		primitive.setFormat(format);
	}
	/**
	 * Gets the <code>type</code> field of the <code>PhoneNumber/type</code> element
	 * @return the <code>type</code> field of the <code>PhoneNumber/type</code> element
	 */
	public String getType() {
		return(primitive.getType());
	}
	/**
	 * Sets the <code>type</code> field of the <code>PhoneNumber/type</code> element
	 * @param type the <code>type</code> field of the <code>PhoneNumber/type</code> element
	 */	
	public void setType(String type){
		primitive.setType(type);
	}
	/**
	 * Gets the <code>number</code> field of the <code>PhoneNumber/number</code> element
	 * @return the <code>number</code> field of the <code>PhoneNumber/number</code> element
	 */
	public String getNumber() {
		return(primitive.getValue());
	}
	/**
	 * Sets the <code>number</code> field of the <code>PhoneNumber/number</code> element
	 * @param number the <code>number</code> field of the <code>PhoneNumber/number</code> element
	 */
	public void setNumber(String number) {
		primitive.setValue(number);
	}

	
	/**
	 * Creates a new <code>PhoneNumber</code> object from an XML primitive
	 * @param value the XML primitive
	 */
	public PhoneNumber(com.uvasoftware.core.primitives.PhoneNumber value) {
		this.primitive = value;
	}
}

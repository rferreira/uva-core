/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>Email</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class Email extends BaseSIFObject {

	/**
	 * Represents the different Email types defined in the SIF spec
	 * 
	 */
	public static class Type {
		public static final String PRIMARY = "Primary";
		public static final String ALTERNATE1 = "Alternate1";
		public static final String ALTERNATE2 = "Alternate2";
		public static final String ALTERNATE3 = "Alternate3";
		public static final String ALTERNATE4 = "Alternate4";
	}
	
	com.uvasoftware.core.primitives.Email primitive = new com.uvasoftware.core.primitives.Email();
	
	/**
	 * Creates a new Email object
	 * 
	 * @param type the <code>Email Type</code>
	 * @param email the email address
	 * 
	 * @see Email.Type
	 */
	public Email(String type, String email) {
		primitive.setType(type);
		primitive.setValue(email);
		
	}
	
	/**
	 * Gets the <code>Type</code> field of the <code>Email</code> element
	 * @return the type of this email
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/**
	 * Sets the type associated with this email
	 * 
	 * @param value the type to be set to 
	 */
	public void setType(String type){
		this.primitive.setType(type);
	}
	
	/**
	 * Gets the address associated with this email
	 * @return a string representation of the email address
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/**
	 * Sets the address associated with this email 
	 * @param value the email to be set to
	 */
	public void setValue(String value) {
		primitive.setValue(value);
	}
	
	/**
	 * Creates a new <code>Email</code> object from an XML primitive
	 * @param value the XML primitive
	 */
	public Email(com.uvasoftware.core.primitives.Email value) {
		this.primitive = value;
	}

}

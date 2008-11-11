/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


/**
 * This class represents a SIF <code>Program</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class Program extends BaseSIFObject  {

	com.uvasoftware.core.primitives.Program primitive = new com.uvasoftware.core.primitives.Program();
	
	/**
	 * Represents the different Program types defined in the SIF spec
	 */
	public class Type{
		public static final String FOODSERVICE = "Foodservice";
		public static final String CFDA = "CFDA";
		public static final String NCES = "NCES";
		public static final String STATEDOE = "StateDOE";
		public static final String LOCAL = "Local";
		public static final String TEXT = "Text";
	}
	
	/**
	 * Creates a new <code>Program</code> object
	 * 
	 * @param type the program type
	 * @param value the program value 
	 * 
	 * @see Program.Types
	 */
	public Program(String type, String value) {
		primitive.setType(type);
		primitive.setValue(value);
	}
	
	/** 
	 * Gets the <code>Type</code> attribute of the <code>Program</code> element
	 * @return the type of program
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/** 
	 * Sets the <code>Type</code> attribute of the <code>Program</code> element
	 * @param type the type of program
	 * @see Program.Types
	 */
	public void setType(String type) {
		primitive.setType(type);
	}
	
	/** 
	 * Gets the value of the <code>Program</code> element
	 * @return the program value
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/** 
	 * Sets the value of the <code>Program</code> element
	 * @param value the program value
	 */
	public void setValue(String value) {
		primitive.setValue(value);
	}
}
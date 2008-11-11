/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>GradYear</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class GradYear extends BaseSIFObject {

	com.uvasoftware.core.primitives.GradYear primitive = new com.uvasoftware.core.primitives.GradYear();
	
	/**
	 * Represents the different GradYear types defined in the SIF spec
	 */
	public class Type{
		public static final String ORIGINAL = "Original";
		public static final String PROJECTED = "Projected";
		public static final String ACTUAL = "Actual";
	}
	
	
	/**
	 * Creates a new GradYear object with the assigned GradYear Type
	 * 
	 * @param type the graduation year type
	 * @param year the 4-digit graduation year (e.g., 2006 for the 2005-06 school year)
	 * 
	 * @see GradYear.Types
	 */
	public GradYear(String type, String value) {
		primitive.setType(type);
		primitive.setValue(value);
	}
	
	/** 
	 * Gets the <code>Type</code> attribute of the <code>GradYear</code> element
	 * @return the graduation year type
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/** 
	 * Sets the <code>Type</code> attribute of the <code>GradYear</code> element
	 * @param type the graduation year type
	 * @see GradYear.Types
	 */
	public void setType(String type) {
		primitive.setType(type);
	}
	
	/** 
	 * Gets the value of the <code>GradYear</code> element
	 * @return the 4-digit graduation year
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/** 
	 * Sets the value of the <code>GradYear</code> element
	 * @param year the 4-digit graduation year (e.g., 2006 for the 2005-06 school year)
	 */
	public void setValue(String year) {
		primitive.setValue(year);
	}
	/**
	 * Creates a new <code>GradYear</code> object from an XML primitive
	 * @param value the XML primitive
	 */
	public GradYear(com.uvasoftware.core.primitives.GradYear value) {
		this.primitive = value;
	}
}
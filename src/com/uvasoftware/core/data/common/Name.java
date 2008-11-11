/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>Name</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class Name extends BaseSIFObject {

	com.uvasoftware.core.primitives.Name primitive = new com.uvasoftware.core.primitives.Name();
	
	/**
	 * Represents the different name types defined in the SIF spec
	 */
	public static class Type{
		public static final String GIVEN_NAME = "01";
		public static final String CURRENT_LEGAL = "02";
		public static final String ALIAS = "03";
		public static final String NAME_OF_RECORD = "04";
		public static final String PREVIOUS_NAME = "05";
		public static final String MARRIED_NAME = "07";
		public static final String PROFESSIONAL_NAME = "08";
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
	public void setPrimitive(Object value) {
		primitive = (com.uvasoftware.core.primitives.Name) value;
	}

	/**
	 * Creates a new Name object with the assigned Name type
	 * 
	 * @param type a string representing the SIF <code>Name</code> type to be used
	 * 
	 * @see com.uvasoftware.core.data.common.Name.Types
	 */
	public Name(String type, String firstName, String lastName) {
		primitive.setType(type);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	/**
	 * Creates a new Name object from an XML primitive
	 * 
	 * @param the XML primitive that this name object should reference
	 * 
	 */
	public Name(com.uvasoftware.core.primitives.Name name) {
		this.primitive = name;
		
	}
	
	/** 
	 * Sets the <code>LastName</code> field of the <code>Name</code> object
	 * @param lastName the last name to be used
	 */
	public void setLastName(String lastName) {
		primitive.setLastName(lastName);
	}
	
	/** 
	 * Gets the <code>LastName</code> field of the <code>Name</code> object
	 * @return the last name 
	 */
	public String getLastName() {
		return(primitive.getLastName());
	}
	
	/** 
	 * Sets the <code>FirstName</code> field of the <code>Name</code> object
	 * @param firstName the first name to be used
	 */
	public void setFirstName(String firstName) {
		primitive.setFirstName(firstName);
	}
	/** 
	 * Gets the <code>FirstName</code> field of the <code>Name</code> object
	 * @return the value of the FirstName field
	 */
	public String getFirstName() {
		return(primitive.getFirstName());
		
	}
	
	
	/** 
	 * Sets the <code>Type</code> field of the <code>Name</code> object
	 * @param firstName the first name to be used
	 */
	public void setType(String firstName) {
		primitive.setType(firstName);
	}
	/** 
	 * Gets the <code>Type</code> field of the <code>Name</code> object
	 * @return the value of the Type field
	 */
	public String getType() {
		return(primitive.getType());
		
	}
	
	/**
	 * Sets the <code>Prefix</code> field of the <code>Name</code> object
	 * @param prefix the prefix to be used
	 */
	public void setPrefix(String prefix) {
		this.primitive.setPrefix(prefix);
	}
	
	/**
	 * Gets the <code>Prefix</code> field of the <code>Name</code> object
	 * @return the value of the Prefix field
	 */
	public String getPrefix() {
		return(primitive.getPrefix());
	}
	
	/**
	 * Sets the <code>MiddleName</code> field of the <code>Name</code> object
	 * @param middleName the middle name to be used
	 */
	public void setMiddleName(String middleName) {
		primitive.setMiddleName(middleName);
		
	}
	
	/** 
	 * Gets the <code>MiddleName</code> field of the <code>Name</code> object
	 * @return the value of the MiddleName field
	 */
	public String getMiddleName() {
		return(primitive.getMiddleName());
	}
	
	/**
	 * Sets the <code>Suffix</code> field of the <code>Name</code> object
	 * @param suffix the suffix to be used
	 */
	public void setSuffix(String suffix) {
		primitive.setSuffix(suffix);
	}
	
	/**
	 * Gets the <code>Suffix field</code> of the <code>Name</code> object
	 * @return the value of the Suffix field
	 */
	public String getSuffix() {
		return(primitive.getSuffix());
	}
	
	/**
	 * Sets the <code>PreferredName</code> field of the <code>Name</code> object
	 * @param prefName the preferred name to use
	 */
	public void setPreferredName(String prefName) {
		primitive.setPreferredName(prefName);
	}
	
	/**
	 * Gets the <code>PreferredName</code> field of the <code>Name</code> object
	 * @return the value of the PreferredName field
	 */
	public String getPreferredName() {
		return(primitive.getPreferredName());
	}
	
	/**
	 * Sets the <code>ShortName</code> field of the <code>Name</code> object
	 * @param shortName the short name to use 
	 */
	public void setShortName(String shortName){
		primitive.setSortName(shortName);
	}
	
	/**
	 * Gets the <code>ShortName</code> field of the <code>Name</code> object
	 * @return the value of the ShortName field
	 */
	public String getShortName() {
		return(primitive.getSortName());
	}
	
	/**
	 * Sets the <code>FullName</code> field of the <code>Name</code> object
	 * @param fullName the full name to be used
	 */
	public void setFullName(String fullName) {
		primitive.setFullName(fullName);
	}
	
	/**
	 * Gets the <code>FullName</code> field of the <code>Name</code> object
	 * @return the value of the FullName field
	 */
	public String getFullName(){
		return (primitive.getFullName());
	}
}

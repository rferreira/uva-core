/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a SIF <code>ContactInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class ContactInfo extends BaseSIFObject {

	com.uvasoftware.core.primitives.ContactInfo primitive = new com.uvasoftware.core.primitives.ContactInfo();


	/**
	 * Creates a new <code>ContactInfo</code> object
	 * 
	 * @param name the name of the contact person (must contain either <code>FirstName</code> and <code>LastName</code> values or a <code>FullName</code> value) 
	 * 
	 * @see com.uvasoftware.core.data.common.Name
	 */
	public ContactInfo(Name name) {
		//TODO add exception if FullName and either FirstName or LastName are null
		primitive.setName((com.uvasoftware.core.primitives.Name)name.getPrimitive());
	}
	/**
	 * Creates a new <code>ContactInfo</code> object
	 * 
	 * 	  
	 */
	public ContactInfo() {
		
	}
	
	/** 
	 * Sets the <code>Name</code> child element of the <code>ContactInfo</code> element
	 * @param name the name of the contact person (must contain either <code>FirstName</code> and <code>LastName</code> values or a <code>FullName</code> value)
	 */
	public void setName(Name name) {
		//TODO add exception if FullName and either FirstName or LastName are null
		primitive.setName((com.uvasoftware.core.primitives.Name)name.getPrimitive());
	}

	/** 
	 * Gets the <code>Name</code> child element of the <code>ContactInfo</code> element
	 * @return the value of the <code>ContactInfo/Name</code> element
	 */
	public Name getName() {
		Name name = new Name(null, null, null);
		name.setPrimitive(primitive.getName());
		return(name);
	}
	
	/** 
	 * Sets the <code>Email</code> child elements of the <code>ContactInfo</code> element
	 * @param email Email address(es) of the contact person
	 */
	public void setEmail(List<Email> email) {
		for (Email e: email) 
			primitive.getEmail().add((com.uvasoftware.core.primitives.Email)e.getPrimitive());
	}

	/** 
	 * Gets the list of <code>Email</code> child elements from the <code>ContactInfo</code> element
	 * @return the value of the <code>ContactInfo/Email</code> element
	 */
	public List<Email> getEmail() {
		ArrayList<Email> list = new ArrayList<Email>();
		Email email = null;
		for (com.uvasoftware.core.primitives.Email e: primitive.getEmail()) {
			email = new Email(null, null);
			email.setPrimitive(e);
			list.add(email);
		}

		return(list);
	}
	
	/** 
	 * Sets the <code>PhoneNumber</code> child elements of the <code>ContactInfo</code> element
	 * @param phone Phone number(s) of the contact person
	 */
	public void setPhoneNumber(List<PhoneNumber> phone) {
		for (PhoneNumber p: phone) 
			primitive.getPhoneNumber().add((com.uvasoftware.core.primitives.PhoneNumber)p.getPrimitive());
	}

	/** 
	 * Gets the list of <code>PhoneNumber</code> child elements from the <code>ContactInfo</code> element
	 * @return the value of the <code>ContactInfo/PhoneNumber</code> element
	 */
	public List<PhoneNumber> getPhoneNumber() {
		ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
		PhoneNumber phone = null;
		for (com.uvasoftware.core.primitives.PhoneNumber p: primitive.getPhoneNumber()) {
			phone = new PhoneNumber(null, null, null);
			phone.setPrimitive(p);
			list.add(phone);
		}

		return(list);
	}
}
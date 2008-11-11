/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.Address;
import com.uvasoftware.core.data.common.BaseSIFObject;

public class StudentAddress extends BaseSIFObject implements ISIFObject {
	
	/**
	 * Specifies the type of address this represents
	 */
	public static enum PickupOrDropoffType { NA, Pickup, Dropoff, Both }; 
	
	private com.uvasoftware.core.primitives.StudentAddress primitive = null;
	
	/**
	 * Creates a new <code>StudentAddress</code> object will all its required fields
	 * @param type the type of address this represents
	 * @param dayOfWeek the days of the week for which the pickup or dropoff address is valid
	 * @param address the actual address
	 */
	public StudentAddress(PickupOrDropoffType type, String dayOfWeek, Address address) {
		primitive = new com.uvasoftware.core.primitives.StudentAddress();
		
		setAddress(address);
		setDayOfWeek( dayOfWeek == null ? "NA": dayOfWeek);
		setPickupOrDropoffType(type);
		
	}
	/**
	 * Creates a new Address object from an XML primitive
	 * 
	 * @param value the XML primitive
	 */
	public StudentAddress(com.uvasoftware.core.primitives.StudentAddress primitive) {
		this.primitive = primitive;
	}
	
	/**
	 * Returns the address contained in this element
	 */
	public Address getAddress() {
		return(new Address(primitive.getAddress()));
	}
	
	/**
	 * Sets the address contained in this element
	 */
	public void setAddress(Address address) {
		primitive.setAddress( (com.uvasoftware.core.primitives.Address) address.getPrimitive());
	}
	
	/**
	 * Returns the DayOfWeek contained in this element
	 */
	public String getDayOfWeek() {
		return(primitive.getDayOfWeek());
	}
	
	/**
	 * Sets the DayOfWeek contained in this element
	 */
	public void setDayOfWeek(String value) {
		primitive.setDayOfWeek(value);
	}
	
	/**
	 * Returns the type of address this object represents
	 */
	public PickupOrDropoffType getPickupOrDropoff() {
		return( PickupOrDropoffType.valueOf(primitive.getPickupOrDropoff()));
	}
	
	/**
	 * Sets the type of address this object represents
	 */
	public void setPickupOrDropoffType(PickupOrDropoffType type) {
		primitive.setPickupOrDropoff(type.name());
	}
	
	
}

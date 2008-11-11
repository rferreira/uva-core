/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.data.student;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.data.common.BaseSIFObject;
import com.uvasoftware.core.data.common.Demographics;
import com.uvasoftware.core.data.common.ElectronicId;
import com.uvasoftware.core.data.common.Email;
import com.uvasoftware.core.data.common.Name;
import com.uvasoftware.core.data.common.OtherId;
import com.uvasoftware.core.data.common.PhoneNumber;
import com.uvasoftware.core.data.common.Address;

/**
 * This class represents a SIF <code>StaffPersonal</code> object
 * @author Rafael Ferreira <raf@uvasoftware.com>
 */
public class StaffPersonal extends BaseSIFObject {
	com.uvasoftware.core.primitives.StaffPersonal primitive = new com.uvasoftware.core.primitives.StaffPersonal();

        /**
         * Parameterless ctor for injection
         */
	public StaffPersonal() {
		
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>StaffPersonal</code> object
	 * @param value the refid
	 */
	public void setRefId(String value) {
		this.primitive.setRefId(value);
	}
	
	/**
	 * Gets the <code>RefId</code> field of the <code>StaffPersonal</code> object
	 * @return
	 */
	public String getRefId() {
		return(this.primitive.getRefId());
	}
	
	/**
	 * Sets the <code>EmployeeLink/EmployeePersonalRefId</code> field of the <code>StaffPersonal</code> object
	 * @param value the employee personal refid
	 */
	public void setEmployeeLink(String value) {
		com.uvasoftware.core.primitives.EmployeeLink l = new com.uvasoftware.core.primitives.EmployeeLink();
		l.setEmployeePersonalRefId(value);
		this.primitive.setEmployeeLink(l);
	}
	
	/**
	 * Gets the <code>EmployeeLink/EmployeePersonalRefId</code> field of the <code>StaffPersonal</code> object
	 * @return value the employee personal refid
	 */
	public String getEmployeeLink() {
		return(this.primitive.getEmployeeLink().getEmployeePersonalRefId());
	}

	/**
	 * Sets the <code>Title</code> field of the <code>StaffPersonal</code> object
	 * @param value the title
	 */
	public void setTitle(String value) {
		this.primitive.getTitle().clear();
		this.primitive.getTitle().add(value);
	}
	
	/**
	 * Gets the <code>Title</code> field of the <code>StaffPersonal</code> object
	 * @return
	 */
	public String getTitle() {
		return(this.primitive.getTitle().get(0));
	}

	/**
	 * Sets the <code>LocalId</code> field of the <code>StaffPersonal</code> object
	 * @param value a locally assigned identified for this student
	 */
	public void setLocalId(String value) {
		this.primitive.setLocalId(value);
	}
	
	/**
	 * Gets the <code>LocalId</code> field of the <code>StaffPersonal</code> object
	 * @return the <code>LocalId</code> 
	 */
	public String getLocalId() { return(this.primitive.getLocalId()); }
	
	/**
	 * Sets the <code>SatePrId</code> field of the <code>StaffPersonal</code> object
	 * @param value a state assigned identified for this student
	 */	
	public void setStatePrId(String value) {
		this.primitive.setStatePrId(value);
	}
	/**
	 * Gets the <code>SatePrId</code> field of the <code>StaffPersonal</code> object
	 * @return the <code>StatePrId</code>
	 */
	public String getStatePrId() { return(this.primitive.getStatePrId()); }
	
	/**
	 * Adds a new <code>ElectronicId</code> field to the <code>StaffPersonal</code> object
	 * @param value the <code>ElectronicId</code> to be added
	 */
	public void addElectronicId(ElectronicId value) {
		this.primitive.getElectronicId().add( (com.uvasoftware.core.primitives.ElectronicId) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>ElectronicId</code>  contained in this message
	 * @return a list containing a bunch of ElectronicId
	 */
	public List <ElectronicId> getElectronicId() { 
		ArrayList <ElectronicId> resp = new ArrayList <ElectronicId>();
		for (com.uvasoftware.core.primitives.ElectronicId e: primitive.getElectronicId() ) {
			resp.add(new ElectronicId(e));
			
		}
		return(resp);
	}
	/**
	 * Adds a new <code>OtherId</code> field to the <code>StaffPersonal</code> object
	 * @param value the <code>OtherId</code> to be added
	 */
	public void addOtherId(OtherId value) {
		primitive.getOtherId().add((com.uvasoftware.core.primitives.OtherId) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>OtherId</code>  contained in this message
	 * @return a list containing a bunch of OtherId
	 */
	public List <OtherId> getOtherId() { 
		ArrayList <OtherId> resp = new ArrayList <OtherId>();
		for (com.uvasoftware.core.primitives.OtherId e: primitive.getOtherId() ) {
			resp.add(new OtherId(e));
			
		}
		return(resp);
	}
	/**
	 * Sets the <code>Name</code> field of the <code>StaffPersonal</code> object
	 * @param value the name object associated with this student
	 */
	public void setName(Name value) {
		primitive.setName((com.uvasoftware.core.primitives.Name) value.getPrimitive());	
	}
	
	/**
	 * Gets the <code>Name</code> field of the <code>StaffPersonal</code> object
	 * @return the Name object associated with this object
	 */
	public Name getName() {
		return(new Name(primitive.getName()));
	}
	
	/**
	 * Adds a new <code>Email</code> field to the <code>StaffPersonal</code> object
	 * @param value the <code>Email</code> to be added
	 */
	public void addEMail(Email value) {
		this.primitive.getEmail().add((com.uvasoftware.core.primitives.Email) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>Email</code>  contained in this message
	 * @return a list containing a bunch of Email objects
	 */
	public List <Email> getEmail() {
		ArrayList <Email> resp = new ArrayList <Email>();
		for (com.uvasoftware.core.primitives.Email e: primitive.getEmail() ) {
			resp.add(new Email(e));
			
		}
		return(resp);
	}
	
	/**
	 * Sets the <code>Demographics</code> field of the <code>StaffPersonal</code> object
	 * @param value the <code>Demographics</code> object
	 */
	public void setDemographics(Demographics value) {
		primitive.setDemographics((com.uvasoftware.core.primitives.Demographics) value.getPrimitive());
	}
	/**
	 * Gets the <code>Demographics</code> field of the <code>StaffPersonal</code> object
	 * @return a <code>Demographics</code> object
	 */
	public Demographics getDemographics() {
		return(new Demographics(primitive.getDemographics()));
	}
	
	/**
	 * Adds a new <code>PhoneNumber</code> field to the <code>StaffPersonal</code> object
	 * @param value the <code>PhoneNumber</code> to be added
	 */
	public void addPhoneNumber(PhoneNumber value) {
		primitive.getPhoneNumber().add((com.uvasoftware.core.primitives.PhoneNumber) value.getPrimitive());
	}
	
	/**
	 * Returns a list with all the phone numbers in this object
	 * @return
	 */
	public List <PhoneNumber> getPhoneNumber() {
		ArrayList <PhoneNumber> resp = new ArrayList <PhoneNumber>();
		for (com.uvasoftware.core.primitives.PhoneNumber e: primitive.getPhoneNumber() ) {
			resp.add(new PhoneNumber(e));
			
		}
		return(resp);
	}
	
	/**
	 * Adds a new <code>Address</code> field to the <code>StaffPersonal</code> object
	 * @param value the <code>Address</code> to be added
	 */
	public void addAddress(Address value) {
		this.primitive.getAddress().add((com.uvasoftware.core.primitives.Address) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>Address</code>  contained in this message
	 * @return a list containing a bunch of Address objects
	 */
	public List <Address> getAddress() {
		ArrayList <Address> resp = new ArrayList <Address>();
		for (com.uvasoftware.core.primitives.Address e: primitive.getAddress() ) {
			resp.add(new Address(e));
			
		}
		return(resp);
	}
	
	
}

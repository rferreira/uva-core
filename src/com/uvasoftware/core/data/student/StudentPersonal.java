/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.data.student;

import com.uvasoftware.core.data.common.Address;
import com.uvasoftware.core.data.common.AlertMessage;
import com.uvasoftware.core.data.common.BaseSIFObject;
import com.uvasoftware.core.data.common.ElectronicId;
import com.uvasoftware.core.data.common.Email;
import com.uvasoftware.core.data.common.GradYear;
import com.uvasoftware.core.data.common.Name;
import com.uvasoftware.core.data.common.OtherId;
import com.uvasoftware.core.data.common.Demographics;
import com.uvasoftware.core.data.common.PhoneNumber;
import com.uvasoftware.core.util.SIFGUID;

import com.uvasoftware.core.ISIFObject;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This class represents a SIF <code>StudentPersonal</code> object
 * </p>
 * Please note that certain elements/attributes are required
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class StudentPersonal extends BaseSIFObject implements ISIFObject{

	com.uvasoftware.core.primitives.StudentPersonal primitive = new com.uvasoftware.core.primitives.StudentPersonal();
	
	/**
	 * No arg ctor - not for general consumption
	 */
	public StudentPersonal() {}
	
	/**
	 * Creates a new <code>StudentPersonal</code> object and sets its <code>StudentPersonal/RefId</code> and <code>StudentPersonal/Name</code> elements
	 * @param refId the GUID of the student
	 * @param name name of the student
	 */
	public StudentPersonal(String refId, Name name) {
		setRefId(refId);
		setName(name);
	}
	
	/**
	 * Creates a new <code>StudentPersonal</code> object and sets its  <code>StudentPersonal/Name</code> element and automatically generates a GUID for the refId
	 * @param refId the GUID of the student
	 * @param name name of the student
	 */
	public StudentPersonal(Name name) {
		setRefId(SIFGUID.next());
		setName(name);
	}
	
	/**
	 * Sets the GUID of the student
	 * @param value the GUID to be used
	 */
	public void setRefId(String value) {
		this.primitive.setRefId(value);
	}
	
	public String getRefId() { return(this.primitive.getRefId()); }
	
	
	/**
	 * Adds a new <code>AlertMsg</code> to this object
	 * @param value the alert message associated with the student
	 * @see Common.AlertMessage
	 */
	public void addAlertMessage(AlertMessage value) {
		primitive.getAlertMsg().add((com.uvasoftware.core.primitives.AlertMsg) value.getPrimitive()); 
		
	}
	
	/**
	 * Returns a list of all the <code>AlertMsg</code>  contained in this message
	 * @return a list containing a bunch of AlertMessages 
	 */
	//TODO: LAMESPEC
	public List <AlertMessage> getAlertMessages() {
		ArrayList <AlertMessage> resp = new ArrayList <AlertMessage>();
		for (com.uvasoftware.core.primitives.AlertMsg e: primitive.getAlertMsg()) {
			AlertMessage m = new AlertMessage();
			m.setPrimitive(e);
			resp.add(m);			
		}
		return(resp);
	}
	
	/**
	 * Sets the <code>LocalId</code> field of the <code>StudentPersonal</code> object
	 * @param value a locally assigned identified for this student
	 */
	public void setLocalId(String value) {
		this.primitive.setLocalId(value);
	}
	
	/**
	 * Gets the <code>LocalId</code> field of the <code>StudentPersonal</code> object
	 * @return the <code>LocalId</code> 
	 */
	public String getLocalId() { return(this.primitive.getLocalId()); }
	
	/**
	 * Sets the <code>SatePrId</code> field of the <code>StudentPersonal</code> object
	 * @param value a state assigned identified for this student
	 */	
	public void setStatePrId(String value) {
		this.primitive.setStatePrId(value);
	}
	/**
	 * Gets the <code>SatePrId</code> field of the <code>StudentPersonal</code> object
	 * @return the <code>StatePrId</code>
	 */
	public String getStatePrId() { return(this.primitive.getStatePrId()); }
	
	/**
	 * Adds a new <code>ElectronicId</code> field to the <code>StudentPersonal</code> object
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
	 * Adds a new <code>OtherId</code> field to the <code>StudentPersonal</code> object
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
	 * Sets the <code>Name</code> field of the <code>StudentPersonal</code> object
	 * @param value the name object associated with this student
	 */
	public void setName(Name value) {
		primitive.setName((com.uvasoftware.core.primitives.Name) value.getPrimitive());	
	}
	
	/**
	 * Gets the <code>Name</code> field of the <code>StudentPersonal</code> object
	 * @return the Name object associated with this object
	 */
	public Name getName() {
		return(new Name(primitive.getName()));
	}
	
	/**
	 * Adds a new <code>Email</code> field to the <code>StudentPersonal</code> object
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
	 * Adds a new <code>GradYear</code> field to the <code>StudentPersonal</code> object
	 * @param value the <code>GradYear</code> to be added
	 */
	public void addGradYear(GradYear value) {
		this.primitive.getGradYear().add((com.uvasoftware.core.primitives.GradYear) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>GradYear</code>  contained in this message
	 * @return a list containing a bunch of <code>GradYear</code> objects
	 */
	public List <GradYear> getGradYear() {
		ArrayList <GradYear> resp = new ArrayList <GradYear>();
		for (com.uvasoftware.core.primitives.GradYear e: primitive.getGradYear() ) {
			resp.add(new GradYear(e));
			
		}
		return(resp);
	}
	/**
	 * Sets the <code>Demographics</code> field of the <code>StudentPersonal</code> object
	 * @param value the <code>Demographics</code> object
	 */
	public void setDemographics(Demographics value) {
		primitive.setDemographics((com.uvasoftware.core.primitives.Demographics) value.getPrimitive());
	}
	/**
	 * Gets the <code>Demographics</code> field of the <code>StudentPersonal</code> object
	 * @return a <code>Demographics</code> object
	 */
	public Demographics getDemographics() {
		return(new Demographics(primitive.getDemographics()));
	}
	
	
	/**
	 * Adds a new <code>PhoneNumber</code> field to the <code>StudentPersonal</code> object
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
	 * Adds a new <code>StudentAddress</code> field to the <code>StudentPersonal</code> object
	 * @param value the <code>StudentAddress</code> to be added
	 */
	public void addStudentAddress(StudentAddress value) {
		primitive.getStudentAddress().add((com.uvasoftware.core.primitives.StudentAddress) value.getPrimitive());
	}
	
	/**
	 * Returns a list with all the studentaddresses in this object
	 * @return a list containing all the <code>StudentAddress</code> objects
	 */
	public List <StudentAddress> getStudentAddress() {
		ArrayList <StudentAddress> resp = new ArrayList <StudentAddress>();
		for (com.uvasoftware.core.primitives.StudentAddress e: primitive.getStudentAddress() ) {
			resp.add(new StudentAddress(e));
			
		}
		return(resp);
	}
	
	
	
	
	
	
}

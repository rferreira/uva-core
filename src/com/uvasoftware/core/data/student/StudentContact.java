/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.data.student;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.*;

/**
 * This object contains the student's contact information. <code>SIF_Events</code> are reported. 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class StudentContact extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.StudentContact primitive = null;
	
	/**
	 * Type of student contact
	 */
	public static class Type {
		public static final String DISCIPLINARY_CONTACT = "6X";
		public static final String PERSON_OR_ENTITY_LEGALLY_RESPONSIBLE_FOR_A_CHILD = "E1";
		public static final String PERSON_OR_ENTITY_WITH_WHOM_A_CHILD_RESIDES= "E2";
		public static final String PERSON_OR_ENTITY_LEGALLY_RESPONSIBLE_FOR_AND_WITH_WHOM_A_PERSON_RESIDES = "E3";
		public static final String OTHER_PERSON_OR_ENTITY_ASSOCIATED_WITH_STUDENT = "E4";
		public static final String EMERGENCY_CONTACT = "EM";
		public static final String PRIMARY_CARE_PROVIDER = "P3";
		public static final String PARENT = "S1";
		public static final String STUDENT = "S2";
		public static final String CUSTODIAL_PARENT = "S3";
	}
	
	/**
	 * Injection friendly ctor 
	 * @param primitive
	 */
	public StudentContact() {
	}
	
	/**
	 * Creates a new StudentContact object from an XML primitive
	 * @param primitive
	 */
	public StudentContact(com.uvasoftware.core.primitives.StudentContact primitive) {
		this.primitive = primitive;
	}
	
	
	/**
	 * Creates a new StudentContact object with all the required fields
	 * @param refId the GUID of this contact
	 * @param studentPersonalRedId The GUID of the student whose contact this is
	 * @param type the type of student contact
	 */
	public StudentContact(String refId, String studentPersonalRefId, String type ) {
		this.primitive = new com.uvasoftware.core.primitives.StudentContact();
		setRefId(refId);
		setStudentPersonalRefId(studentPersonalRefId);
		setType(type);
	
	}
	
	/**
	 * Gets the <code>RefId</code> field of the <code>StudentContact</code> element
	 * @return the value
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>StudentContact</code> element
	 * @param value the value
	 */
	public void setRefId(String value) {
		primitive.setRefId(value);
	}
	
	/**
	 * Gets the <code>StudentPersonalRefId</code> field of the <code>StudentContact</code> element
	 * @return the value
	 */
	public String getStudentPersonalRefId() {
		return(primitive.getStudentPersonalRefId());
	}
	
	/**
	 * Sets the <code>StudentPersonalRefId</code> field of the <code>StudentContact</code> element
	 * @param value the value
	 */
	public void setStudentPersonalRefId(String value) {
		primitive.setStudentPersonalRefId(value);
	}
	/**
	 * Gets the <code>Type</code> field of the <code>StudentContact</code> element
	 * @return the value
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/**
	 * Sets the <code>Type</code> field of the <code>StudentContact</code> element
	 * @param value the value
	 */
	public void setType(String value) {
		primitive.setType(value);
	}
	
	/**
	 * Gets the <code>Name</code> field of the <code>StudentContact</code> element
	 */
	public Name getName() {
		return(new Name(primitive.getName()));
	}
	
	/**
	 * Sets the <code>Name</code> field of the <code>StudentContact</code> element
	 */
	public void setName(Name value) {
		primitive.setName( (com.uvasoftware.core.primitives.Name) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>Demographics</code> field of the <code>StudentContact</code> element
	 */
	public Demographics getDemographics() {
		return(new Demographics(primitive.getDemographics()));
	}
	
	/**
	 * Sets the <code>Demographics</code> field of the <code>StudentContact</code> element
	 */
	public void setDemographics(Demographics value) {
		primitive.setDemographics( (com.uvasoftware.core.primitives.Demographics) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>PhoneNumber</code> field of the <code>StudentContact</code> element
	 * @return a list of phone numbers
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
	
	/**
	 * Adds a new <code>PhoneNumber</code> field to the <code>StudentContact</code> object
	 * @param value the <code>PhoneNumber</code> to be added
	 */
	public void addPhoneNumber(PhoneNumber value) {
		primitive.getPhoneNumber().add((com.uvasoftware.core.primitives.PhoneNumber) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>Email</code> field of the <code>StudentContact</code> element
	 * @return a list of names
	 */
	public List<Email> getEmail() {
		ArrayList<Email> list = new ArrayList<Email>();
		Email v = null;
		for (com.uvasoftware.core.primitives.Email p: primitive.getEmail()) {
			v = new Email(p);
			list.add(v);
		}
		return(list);
	}
	
	/**
	 * Adds a new <code>Email</code> field to the <code>StudentContact</code> object
	 * @param value the <code>Email</code> to be added
	 */
	public void addEMail(Email value) {
		this.primitive.getEmail().add((com.uvasoftware.core.primitives.Email) value.getPrimitive());
	}
	
	/**
	 * Adds a new <code>Address</code> field to the <code>StudentContact</code> object
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
	
	/**
	 * Adds a new <code>OtherId</code> field to the <code>StudentContact</code> object
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
	 * Gets the <code>Relationship</code> field of the <code>StudentContact</code> element
	 */
	public Relationship getRelationship() {
		return(new Relationship(primitive.getRelationship()));
	}
	
	/**
	 * Sets the <code>Relationship</code> field of the <code>StudentContact</code> element
	 */
	public void setRelationship(Relationship value) {
		primitive.setRelationship( (com.uvasoftware.core.primitives.Relationship) value.getPrimitive());
	}
	
	/**
	 * Adds a new <code>EmployerType</code> field to the <code>StudentContact</code> object
	 * @param value the <code>EmployerType</code> to be added
	 */
	public void addEmployerType(EmployerType value) {
		primitive.getEmployerType().add((com.uvasoftware.core.primitives.EmployerType) value.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>EmployerType</code>  contained in this message
	 * @return a list containing a bunch of EmployerType
	 */
	public List <EmployerType> getEmployerType() { 
		ArrayList <EmployerType> resp = new ArrayList <EmployerType>();
		for (com.uvasoftware.core.primitives.EmployerType e: primitive.getEmployerType() ) {
			resp.add(new EmployerType(e));
			
		}
		return(resp);
	}
	/**
	 * Gets the <code>EducationalLevel/code</code> field of the <code>StudentContact</code> element
	 * @return the value
	 */
	public String getEducationalLevel() {
		return (primitive.getEducationalLevel() == null ? null : primitive.getEducationalLevel().getCode() );
		
	}
	
	/**
	 * Sets the <code>EducationalLevel/code</code> field of the <code>StudentContact</code> element
	 * @param value the value
	 */
	public void setEducationalLevel(String value) {
		primitive.setEducationalLevel(new com.uvasoftware.core.primitives.EducationalLevel());
		primitive.getEducationalLevel().setCode(value);
	}
	
	/**
	 * Gets the <code>PickupRights/code</code> field of the <code>StudentContact</code> element
	 * @return the value
	 */
	public boolean getPickupRights() {
		return (primitive.getPickupRights().toUpperCase().contains("YES") ? true : false );
	}
	
	/**
	 * Sets the <code>PickupRights/code</code> field of the <code>StudentContact</code> element
	 * @param value the value
	 */
	public void setPickupRights(boolean v) {
		if (v) {
			primitive.setPickupRights("Yes");
		}else {
			primitive.setPickupRights("No");
		}
		
	}

	

}

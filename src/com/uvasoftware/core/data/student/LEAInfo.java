package com.uvasoftware.core.data.student;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.primitives.EducationAgencyType;
import com.uvasoftware.core.primitives.LEAContact;


/**
 * This class represents a SIF <code>SectionInfo</code> object
 * 
 * <p>
 * From the spec:<br>
 * This object contains information about a school district or other Local Educational Agency (LEA). SIF_Events are
reported.
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class LEAInfo extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.LEAInfo primitive = new com.uvasoftware.core.primitives.LEAInfo();
	
	public LEAInfo() {}
	
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
	public void setPrimitive(Object primitive) {
		this.primitive = (com.uvasoftware.core.primitives.LEAInfo) primitive;

	}
	
	/**
	 * Sets the value of the <code>RefId</code> attribute of the LEAInfo object
	 * <p>
	 * From the spec:<br>
	 * The GUID of the LEAD whose information this is
	 * 
	 *  
	 * @param value
	 */
	public void setRefId(String value) {
		this.primitive.setRefId(value);
	}

	/**
	 * Gets the value of the <code>RefId</code> attribute of the LEAInfo object
	 * <p>
	 * From the spec:<br>
	 * The GUID of the LEAD whose information this is
	 * 
	 *  
	 */
	public String getRefId() {
		return(this.primitive.getRefId());
	}

		
	/**
	 * Sets the <code>LocalId</code> tag of the LEAInfo object
	 * @param value the new LocalId 
	 */
	public void setLocalId(String value) {
		this.primitive.setLocalId(value);
	}
	
	/**
	 * Gets the <code>LocalId</code> tag of the LEAInfo object
	 *  
	 */
	public String getLocalId() {
		return(primitive.getLocalId());
	}
	
	/**
	 * Sets the <code>StatePrId</code> tag of the LEAInfo object
	 * @param value the new StatePrId 
	 */
	public void setStatePrID(String value) {
		this.primitive.setStatePrId(value);
	}
	
	/**
	 * Gets the <code>StatePrId</code> tag of the LEAInfo object
	 *  
	 */
	public String getStatePrId() {
		return(primitive.getStatePrId());
	}

	/**
	 * Sets the <code>NCESId</code> tag of the LEAInfo object
	 * @param value the new NCESId 
	 */
	public void setNCESId(String value) {
		this.primitive.setNCESId(value);
	}
	
	/**
	 * Gets the <code>NCESId</code> tag of the LEAInfo object
	 *  
	 */
	public String getNCESId() {
		return(primitive.getNCESId());
	}
	
	/**
	 * Sets the <code>LEAName</code> tag of the LEAInfo object
	 * @param value the new LEAName 
	 */
	public void setLEAName(String value) {
		this.primitive.setLEAName(value);
	}
	
	/**
	 * Gets the <code>LEAName</code> tag of the LEAInfo object
	 *  
	 */
	public String getLEAName() {
		return(primitive.getLEAName());
	}
	
	/**
	 * Sets the <code>LEAUrl</code> tag of the LEAInfo object
	 * @param value the new LEAUrl 
	 */
	public void setLEAUrl(String value) {
		this.primitive.setLEAURL(value);
	}
	
	/**
	 * Gets the <code>LEAUrl</code> tag of the LEAInfo object
	 *  
	 */
	public String getLEAUrl() {
		return(primitive.getLEAURL());
	}
	
	/**
	 * Sets the <code>EducationAgencyType</code> tag of the LEAInfo object
	 * <p>
	 * From the spec:<br>
	 * The classification of the education agency within the geographic boundaries of a state according to the level of administrative and operational control
	 * 
	 * @see Education Agency Type
	 * 
	 * @param value the code representing the Education Agency Type  
	 */
	public void setEducationAgencyType(String value) {
		EducationAgencyType a = new EducationAgencyType();
		a.setCode(value);
		this.primitive.setEducationAgencyType(a);
	}
	
	/**
	 * Gets the <code>EducationAgencyType</code> tag of the LEAInfo object
	 *  
	 */
	public String getEducationAgencyType() {
		EducationAgencyType a = primitive.getEducationAgencyType();
		return(a.getCode());
	}
	
	/**
	 * Sets the <code>LEAContact</code> tag of the LEAInfo object 
	 * 
	 * @see com.uvasoftware.core.data.common.ContactInfo
	 * @param contact the contactinfo that should be used in this LEAContact
	 */
	public void setLEAContact(ContactInfo contact) {
		LEAContact lc = new LEAContact();
		lc.setContactInfo( (com.uvasoftware.core.primitives.ContactInfo) contact.getPrimitive());
		
		primitive.getLEAContact().add(0, lc);
			
		
	}
	
	/**
	 * Gets the <code>LEAContact</code> tag of the LEAInfo object 
	 * 
	 * @see com.uvasoftware.core.data.common.ContactInfo
	 */
	public ContactInfo getLEAContact() {
		ContactInfo ci = new ContactInfo();
		ci.setPrimitive(primitive.getLEAContact().get(0).getContactInfo());
		return(ci);			
		
	}
	
	
	/**
	 * Sets the <code>LEAContact/PublishInDirectory</code> tag of the LEAInfo object
	 * 
	 * @param publishInDirectory whether it should display "Yes" or "No"
	 */
	public void setPublishInDirectory(boolean publishInDirectory) throws Exception {
		
		try {
			LEAContact lc = primitive.getLEAContact().get(0);
			if (publishInDirectory)  {
				lc.setPublishInDirectory("Yes");
			} else {
				lc.setPublishInDirectory("No");
			}

		} catch (IndexOutOfBoundsException ex) {
			throw new Exception("You must first add a LEAContact object!",ex);
		}
	
	}
	
	
	/**
	 * Gets the <code>LEAContact/PublishInDirectory</code> tag of the LEAInfo object
	 * 
	 * @return a boolean representation of whether PublishInDirectory is Yes or No
	 */
	public boolean getPublishInDirectory() {
		LEAContact lc = primitive.getLEAContact().get(0);
		
		if (lc.getPublishInDirectory().toLowerCase().contains("yes"))  {
			return(true);
		} else {
			return(false);
		}
	}
	
	/**
	 * Adds another entry to the <code>PhoneNumber</code> tag of the LEAInfo object
	 * @param value the new PhoneNumber object to the added
	 */
	public void addPhoneNumber(PhoneNumber value) {
		primitive.getPhoneNumber().add((com.uvasoftware.core.primitives.PhoneNumber) value.getPrimitive());
		
	}
	
	
	/**
	 * Returns a list containing all the <code>PhoneNumber</code> contained in this message
	 * @return
	 */
	public List <PhoneNumber> getPhoneNumber() {
		ArrayList <PhoneNumber> list = new ArrayList <PhoneNumber>();
		for (com.uvasoftware.core.primitives.PhoneNumber e: primitive.getPhoneNumber()) {
			list.add(new PhoneNumber(e));
		}
		return(list);
		
	}

	/**
	 * Adds another entry to the <code>PhoneNumber</code> tag of the LEAInfo object
	 * @param value the new PhoneNumber object to the added
	 */
	public void addAddress(Address value) {
		primitive.getAddress().add( (com.uvasoftware.core.primitives.Address) value.getPrimitive());
		
	}
	
	
	/**
	 * Returns a list containing all the <code>Address</code> contained in this message
	 * @return
	 */
	public List <Address> getAddress() {
		ArrayList <Address> list = new ArrayList <Address>();
		for (com.uvasoftware.core.primitives.Address e: primitive.getAddress()) {
			list.add(new Address(e));
		}
		return(list);
	}
	
	/**
	 * Adds another entry to the <code>IdentificationInfo</code> tag of the LEAInfo object
	 * @param 
	 */
	public void addIdentificationInfo(IdentificationInfo value) {
		primitive.getIdentificationInfo().add( (com.uvasoftware.core.primitives.IdentificationInfo) value.getPrimitive());
		
	}
	
	
	/**
	 * Returns a list containing all the <code>Address</code> contained in this message
	 * @return
	 */
	public List <IdentificationInfo> getIdentificationInfo() {
		ArrayList <IdentificationInfo> list = new ArrayList <IdentificationInfo> ();
		for (com.uvasoftware.core.primitives.IdentificationInfo e: primitive.getIdentificationInfo()) {
			list.add(new IdentificationInfo(e));
		}
		return(list);
	}
	
	
	/**
	 * Populates the <code>GradeLevels</code> tag of the LEAInfo object
	 * @param value the <code>GradeLevels</code> to be added to this object
	 * 
	 *  @see com.uvasoftware.core.data.common.GradeLevels
	 */
	public void setGradeLevels(GradeLevels value) {
		this.primitive.setGradeLevels((com.uvasoftware.core.primitives.GradeLevels) value.getPrimitive());
	}
	
	/**
	 * Returns the <code>GradeLevels</code> tag contained inside the LEAInfo object
	 * @return the <code>GradeLevels</code> object contained in this message
	 */
	public GradeLevels getGradeLevels() {
		GradeLevels gl = new GradeLevels();
		gl.setPrimitive(this.primitive.getGradeLevels());
		return gl;
		
	}
	
	/**
	 * Sets the <code>OperationalStatus</code> tag contained inside the LEAInfo object
	 * @param value the value to be set to 
	 */
	public void setOperationalStatus(String value) {
		this.primitive.setOperationalStatus(value);
	}
	
	/**
	 * Gets the <code>OperationalStatus</code> tag contained inside the LEAInfo object
	 * @return the current value of the tag
	 */
	public String getOperationalStatus() {
		return(this.primitive.getOperationalStatus());
	}
	
	/**
	 * Sets the <code>CongressionalDistrcit</code> tag contained inside the LEAInfo object
	 * @param value the value to be set to
	 */
	public void setCongressionalDistrict(String value) {
		this.primitive.setCongressionalDistrict(value);
	}
	
	/**
	 * Gets the <code>CongressionalDistrict</code> tag contained inside the LEAInfo object
	 * @return the current value of the tag
	 */
	public String getCongressionalDistrict() {
		return(this.primitive.getCongressionalDistrict());
	}




}

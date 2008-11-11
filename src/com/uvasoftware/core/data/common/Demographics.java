/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.uvasoftware.core.ISIFObject;

/**
 * This class represents a SIF <code>Demographics</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 * 
 * 
 */
public class Demographics extends BaseSIFObject {

	//TODO: this class should be changed to reference code pages
	
	com.uvasoftware.core.primitives.Demographics primitive = new com.uvasoftware.core.primitives.Demographics(); 

	/**
	 * Represents a <code>Demographics/Ethnicity</code> object
	 */
	public static class Ethnicity {
		public String type = "NA";
		public String code = "0%";
		public String proportion;
		
	}
	
	/**
	 * Creates a new <code>Demographics</code> object from an XML primitive
	 * @param value the XML primitive to be used
	 */
	public Demographics(com.uvasoftware.core.primitives.Demographics value) {
		this.primitive = value;
	}
	
	/**
	 * Creates a new <code>Demographics</code> object
	 * 
	 */
	public Demographics() {}
	
	
	/**
	 * Adds an <code>Ethnicity</code> to the <code>Demographics</code> object
	 * @param ethnicity the ethnicity entry to be added
	 * 
	 * @see com.uvasoftware.core.commmon.Demographics.Ethnicity
	 */
	public void setEthnicity(Ethnicity ethnicity) {
		
		com.uvasoftware.core.primitives.Ethnicity et = new com.uvasoftware.core.primitives.Ethnicity();
		et.setCode(ethnicity.code);
		et.setProportion(ethnicity.proportion);
		et.setType(ethnicity.type);
		
		primitive.getEthnicity().add(et);

		
	}
	
	/**
	 * Returns a list containing all the ethnicity entries for this object
	 * 
	 * @return a new list containing copies of all the ethnicity entries in this object 
	 */
	public List <Demographics.Ethnicity> getEthnicity() {
		ArrayList <Demographics.Ethnicity> ar = new ArrayList<Demographics.Ethnicity>();
		
		if (primitive.getEthnicity().size() == 0)  return(ar);
		
		for (Iterator it = primitive.getEthnicity().iterator(); it.hasNext(); ) {
			
			Demographics.Ethnicity p = new Demographics.Ethnicity();
			
			com.uvasoftware.core.primitives.Ethnicity p1 = (com.uvasoftware.core.primitives.Ethnicity)it.next();
			
			p.code = p1.getCode();
			p.type = p1.getType();
			p.proportion = p1.getProportion();
			
		
			ar.add(p);
		}
		
		return(ar);
	}
	
	
	/** 
	 * Sets the <code>Gender</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/Code</code> element 
	 */
	public void setGender(String gender) {
		this.primitive.setGender(gender);
	}
	
	/** 
	 * Gets the <code>Gender</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/Code</code> element 
	 */
	public String getGender() {
		return(primitive.getGender());
	}
	
	/** 
	 * Sets the <code>BirthDate</code> field of the <code>Demographics</code> element
	 * @param date the person's birth date
	 * @return the value of the <code>Demographics/BirthDate</code> element 
	 */
	public void setBirthDate(String date) {
		this.primitive.setBirthDate(date);
	}
	
	/** 
	 * Gets the <code>BirthDate</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/BirthDate</code> element 
	 */
	public String getBirthDate() {
		return(this.primitive.getBirthDate());
	}
	
	/** 
	 * Sets the <code>BirthDateVerification</code> field of the <code>Demographics</code> element
	 * @param value means by which the verification took place 
	 * @return the value of the <code>Demographics/BirthDateVerification</code> element 
	 */
	public void setBirthDateVerification(String value) {
		this.primitive.setBirthDateVerification(value);
	}
	
	/** 
	 * Gets the <code>BirthDateVerification</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/BirthDateVerification</code> element 
	 */
	public String getBirthDateVerication() {
		return(this.primitive.getBirthDateVerification());
	}
	
	/** 
	 * Sets the <code>PlaceOfBirth</code> field of the <code>Demographics</code> element
	 * @param value the place of birth 
	 * @return the value of the <code>Demographics/PlaceOfBirth</code> element 
	 */
	public void setPlaceOfBirth(String value) {
		this.primitive.setPlaceOfBirth(value);
	}
	
	/** 
	 * Gets the <code>PlaceOfBirth</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/PlaceOfBirth</code> element 
	 */
	public String getPlaceOfBirth() {
		return(this.primitive.getPlaceOfBirth());
	}

	/** 
	 * Sets the <code>CountyOfBirth</code> field of the <code>Demographics</code> element
	 * @param value the county of birth
	 * @return the value of the <code>Demographics/CountyOfBirth</code> element 
	 */
	public void setCountyOfBirth(String value) {
		this.primitive.setCountyOfBirth(value);
	}
	
	/** 
	 * Gets the <code>CountyOfBirth</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/CountyOfBirth</code> element 
	 */
	public String getCountyOfBirth() {
		return(this.primitive.getCountyOfBirth());
	}

	/** 
	 * Sets the <code>countryOfBirth</code> field of the <code>Demographics</code> element
	 * @param value the county of birth
	 * @return the value of the <code>Demographics/countryOfBirth</code> element
	 * @see com.uvasoftware.core.common.Address.CountryCode
	 */
	public void setCountryOfBirth(String value) {
		com.uvasoftware.core.primitives.CountryOfBirth cb = null; 
		
		
		if (this.primitive.getCountryOfBirth() != null ) { 
			cb.setCode(value);
		} else {
			cb = new com.uvasoftware.core.primitives.CountryOfBirth();
			cb.setCode(value);
		}
		this.primitive.setCountryOfBirth(cb);
		
	}
	
	/** 
	 * Gets the <code>countryOfBirth</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Demographics/countryOfBirth</code> element 
	 */
	public String getCountryOfBirth() {
		return(this.primitive.getCountryOfBirth().getCode());
	}
	
	/** 
	 * Sets the <code>countryOfCitizenship</code> field of the <code>Demographics</code> element
	 * @param values a list containing one of more country codes
	 * @return the value of the <code>Demographics/countryOfCitizenship</code> element
	 * @see com.uvasoftware.core.common.Address.CountryCode
	 */
	public void setCountryOfCitizenship(List<String> values) {
				
		for(String it: values) {
			com.uvasoftware.core.primitives.CountryOfCitizenship cc = new com.uvasoftware.core.primitives.CountryOfCitizenship(); 
			cc.setCode(it);
			primitive.getCountryOfCitizenship().add(cc);
		}
		
		
	}
	/** 
	 * Gets the <code>countryOfCitizenship</code> field of the <code>Demographics</code> element
	 * @return a list representing the <code>Demographics/countryOfCitizenship</code> element 
	 */
	public List<String> getCountryOfCitizenship() {
		ArrayList<String> ar = new ArrayList<String>();
		for(com.uvasoftware.core.primitives.CountryOfCitizenship cc: primitive.getCountryOfCitizenship()) {
			ar.add(cc.getCode());
		}
		
		return(ar);
	}

	/** 
	 * Sets the <code>countryOfCitizenship</code> field of the <code>Demographics</code> element
	 * @param values a list containing one of more country codes
	 * @return the value of the <code>Demographics/countryOfCitizenship</code> element
	 * @see com.uvasoftware.core.common.Address.CountryCode
	 */
	public void setCountryOfResidency(List<String> values) {
				
		for(String it: values) {
			com.uvasoftware.core.primitives.CountryOfResidency cc = new com.uvasoftware.core.primitives.CountryOfResidency(); 
			cc.setCode(it);
			primitive.getCountryOfResidency().add(cc);
		}
		
		
	}
	/** 
	 * Gets the <code>countryOfResidency</code> field of the <code>Demographics</code> element
	 * @return a list representing the <code>Demographics/countryOfResidency</code> element 
	 */
	public List<String> getCountryOfResidency() {
		ArrayList<String> ar = new ArrayList<String>();
		for(com.uvasoftware.core.primitives.CountryOfResidency cc: primitive.getCountryOfResidency()) {
			ar.add(cc.getCode());
		}
		
		return(ar);
	}
	
	/** 
	 * Sets the <code>CountryArrivalDate</code> field of the <code>Demographics</code> element
	 * @param value the county of birth
	 * @return the value of the <code>Demographics/</code> element 
	 */
	public void setCountryArrivalDate(String value) {
		this.primitive.setCountryArrivalDate(value);
	}
	
	/** 
	 * Gets the <code>CountryArrivalDate</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Ethnicity/CountyOfBirth</code> element 
	 */
	public String getCountryArrivalDate() {
		return(this.primitive.getCountryArrivalDate());
	}
	
	
	/** 
	 * Sets the <code>CitizenshipStatus</code> field of the <code>Demographics</code> element
	 * @param value the citizenship status
	 * @return the value of the <code>Demographics/CitizenshipStatus</code> element 
	 */
	public void setCitizenshipStatus(String value) {
		this.primitive.setCitizenshipStatus(value);
	}
	
	/** 
	 * Gets the <code>CitizenshipStatus</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Ethnicity/CitizenshipStatus</code> element 
	 */
	public String getCitizenshipStatus() {
		return(this.primitive.getCitizenshipStatus());
	}	
	
	
	/** 
	 * Sets the <code>EnglishProficiency</code> field of the <code>Demographics</code> element
	 * @param Person's proficiency in English
	 * @return the value of the <code>Demographics/EnglishProficiency</code> element 
	 */
	public void setEnglishProficiency(String value) {
		if (this.primitive.getEnglishProficiency() == null ) {
			this.primitive.setEnglishProficiency(new com.uvasoftware.core.primitives.EnglishProficiency());
		}
		this.primitive.getEnglishProficiency().setCode(value);
	}
	
	/** 
	 * Gets the <code>EnglishProficiency</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Ethnicity/EnglishProficiency</code> element 
	 */
	public String getEnglishProficiency() {
		return(this.primitive.getEnglishProficiency().getCode());
	}

	/** 
	 * Sets the <code>Language</code> field of the <code>Demographics</code> element
	 * @param values a list containing one of more country codes
	 * @return the value of the <code>Demographics/Language</code> element
	 */
	public void setLanguage(List<String> values) {
				
		for(String it: values) {
			com.uvasoftware.core.primitives.Language cc = new com.uvasoftware.core.primitives.Language(); 
			cc.setType(it);
			primitive.getLanguage().add(cc);
		}
		
		
	}
	/** 
	 * Gets the <code>Language</code> field of the <code>Demographics</code> element
	 * @return a list representing the <code>Demographics/Language</code> element 
	 */
	public List<String> getLanguage() {
		ArrayList<String> ar = new ArrayList<String>();
		for(com.uvasoftware.core.primitives.Language cc: primitive.getLanguage()) {
			ar.add(cc.getType());
		}
		
		return(ar);
		
	}
	
	/** 
	 * Sets the <code>DwellingArrangement</code> field of the <code>Demographics</code> element
	 * @param environment in which the person resides
	 * @return the value of the <code>Demographics/DwellingArrangement</code> element 
	 */
	public void setDwellingArrangement(String value) {
		this.primitive.setDwellingArrangement(value);
	}
	
	/** 
	 * Gets the <code>DwellingArrangement</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Ethnicity/DwellingArrangement</code> element 
	 */
	public String getDwellingArrangement() {
		return(this.primitive.getDwellingArrangement());
	}
	
	/** 
	 * Sets the <code>MaritalStatus</code> field of the <code>Demographics</code> element
	 * @param person's marital status
	 * @return the value of the <code>Demographics/MaritalStatus</code> element 
	 */
	public void setMaritalStatus(String value) {
		this.primitive.setMaritalStatus(value);
	}
	
	/** 
	 * Gets the <code>MaritalStatus</code> field of the <code>Demographics</code> element
	 * @return the value of the <code>Ethnicity/MaritalStatus</code> element 
	 */
	public String getMaritalStatus() {
		return(this.primitive.getMaritalStatus());
	}
	
	
}


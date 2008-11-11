/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>SubjectArea</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SubjectArea extends BaseSIFObject {

	com.uvasoftware.core.primitives.SubjectArea primitive = new com.uvasoftware.core.primitives.SubjectArea();
	
	/**
	 * Represents the different SubjectArea codes defined in the SIF spec
	 */
	public class Code{
		public static final String AGRICULTURE_AND_RENEWABLE_NATURAL_RESOURCES = "01";
		public static final String BUSINESS = "02";
		public static final String COMPUTER_AND_INFORMATION_SCIENCES = "03";
		public static final String CONSTRUCTION_TRADES = "04";
		public static final String CONSUMER_AND_HOMEMAKING_EDUCATION = "05";
		public static final String COSMETOLOGY = "06";
		public static final String DRAFTING = "07";
		public static final String ELECTIVE_ACTIVITIES = "08";
		public static final String ENERGY_POWER_AND_TRANSPORTATION_TECHNOLOGIES = "09";
		public static final String ENGLISH_LANGUAGE_AND_LITERATURE = "10";
		public static final String FINE_AND_PERFORMING_ARTS = "11";
		public static final String FOREIGN_LANGUAGE_AND_LITERATURE = "12";
		public static final String GRAPHIC_AND_PRINTING_COMMUNICATION = "13";
		public static final String HEALTH_AND_SAFETY_EDUCATION = "14";
		public static final String HEALTH_CARE_SCIENCES = "15";
		public static final String INDUSTRIAL_TECHNOLOGY_EDUCATION = "16";
		public static final String LIFE_AND_PHYSICAL_SCIENCES = "17";
		public static final String MARKETING = "18";
		public static final String MASS_COMMUNICATION = "19";
		public static final String MATHEMATICS = "20";
		public static final String MILITARY_SCIENCE = "21";
		public static final String MULTI_INTERDISCIPLINARY_STUDIES = "22";
		public static final String PHYSICAL_EDUCATION = "23";
		public static final String PRECISION_METALWORK = "24";
		public static final String PUBLIC_PROTECTIVE_AND_SOCIAL_SERVICES = "25";
		public static final String RELIGIOUS_EDUCATION_AND_THEOLOGY = "26";
		public static final String SOCIAL_SCIENCES_AND_HISTORY = "27";
		public static final String SPECIAL_EXCEPTIONAL_EDUCATION = "28";
		public static final String VOCATIONAL_HOME_ECONOMICS = "29";
	}
	
	
	/**
	 * Creates a new <code>SubjectArea</code> object
	 * 
	 * @param code the subject area code
	 * @param value the subject matter area or department
	 * 
	 * @see SubjectArea.Code
	 */
	public SubjectArea(String code, String value) {
		primitive.setCode(code);
		primitive.setValue(value);
	}
	
	/** 
	 * Gets the <code>Code</code> attribute of the <code>SubjectArea</code> element
	 * @return the subject area code
	 */
	public String getCode() {
		return(primitive.getCode());
	}
	
	/** 
	 * Sets the <code>Code</code> attribute of the <code>SubjectArea</code> element
	 * @param code the subject area code
	 * @see SubjectArea.Code
	 */
	public void setCode(String code) {
		primitive.setCode(code);
	}
	
	/** 
	 * Gets the value of the <code>SubjectArea</code> element
	 * @return the subject matter area or department
	 */
	public String getValue() {
		return(primitive.getValue());
	}
	
	/** 
	 * Sets the value of the <code>SubjectArea</code> element
	 * @param value the subject matter area or department
	 */
	public void setValue(String value) {
		primitive.setValue(value);
	}
}
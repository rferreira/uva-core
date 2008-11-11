/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core.data.common;

import com.uvasoftware.core.ISIFObject;
/**
 * This class represents a SIF <code>GradeLevel</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class GradeLevel extends BaseSIFObject  {

	com.uvasoftware.core.primitives.GradeLevel primitive = new com.uvasoftware.core.primitives.GradeLevel();
	
	/**
	 * Represents the different GradeLevel types defined in the SIF spec
	 */
	public class Code{
		public static final String PREKINDERGARTEN_PRESCHOOL = "PK";
		public static final String KINDERGARTEN__DEPRECATED = "0K";
		public static final String KINDERGARTEN = "KG";
		public static final String GRADE_1 = "01";
		public static final String GRADE_2 = "02";
		public static final String GRADE_3 = "03";
		public static final String GRADE_4 = "04";
		public static final String GRADE_5 = "05";
		public static final String GRADE_6 = "06";
		public static final String GRADE_7 = "07";
		public static final String GRADE_8 = "08";
		public static final String GRADE_9 = "09";
		public static final String GRADE_10 = "10";
		public static final String GRADE_11 = "11";
		public static final String GRADE_12 = "12";
		public static final String POSTGRADUATE = "PG";
		public static final String UNGRADED = "UN";
	}
	
	
	/**
	 * Creates a new GradeLevel object with the assigned GradeLevel Code
	 * 
	 * @param code the code associated with the grade level 
	 * 
	 * @see GradeLevel.Code
	 */
	public GradeLevel(String code) {
		primitive.setCode(code);
	}
	
	/** 
	 * Gets the <code>Code</code> attribute of the <code>GradeLevel</code> element
	 * @return the grade level code
	 */
	public String getCode() {
		return(primitive.getCode());
	}
	
	/** 
	 * Sets the <code>Code</code> attribute of the <code>GradeLevel</code> element
	 * @param code the code associated with the grade level
	 */
	public void setCode(String code) {
		primitive.setCode(code);
	}
}
/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;


import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a SIF <code>GradeLevels</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class GradeLevels extends BaseSIFObject {

	com.uvasoftware.core.primitives.GradeLevels primitive = new com.uvasoftware.core.primitives.GradeLevels();
	
	
	/**
	 * Adds a new <code>GradeLevel</code> element to this <code>GradeLevels</code> SIF object 
	 * @param gradeLevel the <code>GradeLevel</code> to be added
	 */
	public void addGradeLevel(GradeLevel gradeLevel) {
		this.primitive.getGradeLevel().add((com.uvasoftware.core.primitives.GradeLevel) gradeLevel.getPrimitive());
	}
	
	/**
	 * Returns a list containing a copy of all the <code>GradeLevel</code> elements
	 * @return a list of all the GradeLevels
	 */
	public List<GradeLevel> getGradeLevel() {
		ArrayList <GradeLevel> ar = new ArrayList<GradeLevel>();
		
		for (com.uvasoftware.core.primitives.GradeLevel e: primitive.getGradeLevel()) {
			ar.add(new GradeLevel(e.getCode()));
		}
		
		return(ar);
	}

}

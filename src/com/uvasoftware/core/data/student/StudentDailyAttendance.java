/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.BaseSIFObject;

/**
 * This object provides daily attendance information for a particular student in a particular school on a particular date.  
 * <code>SIF_Events</code> are reported. 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class StudentDailyAttendance extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.StudentDailyAttendance primitive = null;
	
	/**
	 * parameterless ctor used for injection
	 */
	public StudentDailyAttendance() {}
	
	/**
	 * Creates a new <code>StudentDailyAttendance</code> object with all the required attributes
	 * @param studentPersonalRefId The ID (GUID) of the student for whom this attendance information is being reported
	 * @param schoolInfoRefId The ID (GUID) of the school for which this attendance information is being reported. 
	 * @param date The calendar date to which this attendance information relates (CCYYMMDD)
	 * @param dailyAttendanceCode Locally-defined attendance code information. 
	 */
	public StudentDailyAttendance(String studentPersonalRefId, String schoolInfoRefId, String date, String dailyAttendanceCode) {
		primitive = new com.uvasoftware.core.primitives.StudentDailyAttendance();
		primitive.setStudentPersonalRefId(studentPersonalRefId);
		primitive.setDate(date);
		primitive.setSchoolInfoRefId(schoolInfoRefId);
		
		
	}
	
	/**
	 * Sets the <code>StudentPersonalRefId</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public void setStudentPersonalRefId(String value) {
		primitive.setStudentPersonalRefId(value);
	}
	
	/**
	 * Gets the <code>StudentPersonalRefId</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getStudentPersonalRefId() {
		return(primitive.getStudentPersonalRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public void setSchoolInfoRefId(String value) {
		primitive.setSchoolInfoRefId(value);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>Date</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public void setDate(String value) {
		primitive.setDate(value);
	}
	
	/**
	 * Gets the <code>Date</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getDate() {
		return(primitive.getDate());
	}
	
	/**
	 * Sets the <code>TimeIn</code> field of the <code>StudentDailyAttendance</code> element
	 * @param value The time the student entered or returned to school (HH:MM:SS)
	 */
	public void setTimeIn(String value) {
		primitive.setTimeIn(value);
	}
	
	/**
	 * Gets the <code>TimeIn</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getTimeIn() {
		return(primitive.getTimeIn());
	}
	/**
	 * Sets the <code>TimeOut</code> field of the <code>StudentDailyAttendance</code> element
	 * @param The time the student left school (HH:MM:SS). 
	 */
	public void setTimeOut(String value) {
		primitive.setTimeOut(value);
	}
	
	/**
	 * Gets the <code>TimeOut</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getTimeOut() {
		return(primitive.getTimeOut());
	}
	
	/**
	 * Sets the <code>AttendanceNote</code> field of the <code>StudentDailyAttendance</code> element
	 * @param Note related to this particular attendance. 
	 */
	public void setAttendanceNote(String value) {
		primitive.setAttendanceNote(value);
	}
	
	/**
	 * Gets the <code>AttendanceNote</code> field of the <code>StudentDailyAttendance</code> element
	 */
	public String getAttendanceNote() {
		return(primitive.getAttendanceNote());
	}
	
	
	

}

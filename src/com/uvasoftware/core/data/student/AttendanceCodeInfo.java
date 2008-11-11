/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.SIFGUID;
import com.uvasoftware.core.data.common.BaseSIFObject;

/**
 * This class represents a SIF <code>AttendanceCodeInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class AttendanceCodeInfo extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.AttendanceCodeInfo primitive = new com.uvasoftware.core.primitives.AttendanceCodeInfo();
	
	/**
	 * Represents the different AttendanceType in the SIF spec
	 */
	public static class AttendanceType {
		public static final String ABSENT = "Absent";
		public static final String TARDY = "Tardy";
		public static final String EARLY_DEPARTURE = "EarlyDeparture"; 
		public static final String PARTIAL = "Partial";
		public static final String PRESENT = "Present";
		public static final String OTHER = "Other";
	}
	
	/**
	 * Represents the different AttendanceStatuses in the SIF spec
	 */
	public static class AttendanceStatus {
		public static final String EXCUSED = "Excused";
		public static final String UNEXCUSED = "Unexcused";
		public static final String UNKNOWN = "Unknown";
		public static final String NA = "NA";
	}
	
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
		this.primitive = (com.uvasoftware.core.primitives.AttendanceCodeInfo) primitive;

	}
	
	/**
	 * Creates a new AttendanceCodeInfo object
	 * @param schoolId the GUID of the school where the attendance code is used
	 * @param code the attendance code (locally defined)
	 * @param type the attendance code type
	 * @param status the excused status of the attendance code
	 * 
	 * @see AttendanceType
	 * @see AttendanceStatus
	 */
	public AttendanceCodeInfo(String schoolId, String code, String type, String status) {
		primitive.setRefId(SIFGUID.next());
		primitive.setSchoolInfoRefId(schoolId);
		primitive.setAttendanceCode(code);
		primitive.setAttendanceType(type);
		primitive.setAttendanceStatus(status);
	}
	
	public AttendanceCodeInfo() {}
	
	/**
	 * Gets the <code>AttendanceCode</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the attendance code
	 */
	public String getAttendanceCode() { 
		return(primitive.getAttendanceCode()); 
	}
	
	/**
	 * Sets the <code>AttendanceCode</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param code the attendance code
	 */	
	public void setAttendanceCode(String code) {
		primitive.setAttendanceCode(code);
	}
	
	/**
	 * Gets the <code>AttendanceType</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the attendance code type
	 */
	public String getAttendanceType() {
		return(primitive.getAttendanceType());
	}
	
	/**
	 * Sets the <code>AttendanceType</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param type the attendance code type
	 * @see AttendanceType
	 */	
	public void setAttendanceType(String type){
		primitive.setAttendanceType(type);
	}
	
	/**
	 * Gets the <code>AttendanceStatus</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the excused status of the attendance code
	 */
	public String getAttendanceStatus() {
		return(primitive.getAttendanceStatus());
	}
	
	/**
	 * Sets the <code>AttendanceStatus</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param status the excused status of the attendance code
	 * @see AttendanceStatus
	 */
	public void setAttendanceStatus(String status) {
		primitive.setAttendanceStatus(status);
	}

	/**
	 * Gets the <code>AttendanceValue</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the portion of the attendance relative to the time span being reported (e.g., day, period, section), up to three decimal places.
	 */
	public String getAttendanceValue() {
		return(primitive.getAttendanceValue());
	}
	
	/**
	 * Sets the <code>AttendanceValue</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param value the portion of the attendance relative to the time span being reported (e.g., day, period, section), up to three decimal places.
	 */
	public void setAttendanceValue(String value) {
		primitive.setAttendanceValue(value);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the GUID of the school where the attendance code is used
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param schoolId the GUID of the school where the attendance code is used
	 */
	public void setSchoolInfoRefId(String schoolId) {
		primitive.setSchoolInfoRefId(schoolId);
	}

	/**
	 * Gets the <code>RefId</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the GUID uniquely identifying this AttendanceCodeInfo instance
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param refId the GUID uniquely identifying this AttendanceCodeInfo instance
	 */
	public void setRefId(String refId) {
		primitive.setRefId(refId);
	}

	/**
	 * Gets the <code>Description</code> field of the <code>AttendanceCodeInfo</code> element
	 * @return the textual description of the attendance code
	 */
	public String getDescription() {
		return(primitive.getDescription());
	}
	
	/**
	 * Sets the <code>Description</code> field of the <code>AttendanceCodeInfo</code> element
	 * @param desc the textual description of the attendance code
	 */
	public void setDescription(String desc) {
		primitive.setDescription(desc);
	}


}
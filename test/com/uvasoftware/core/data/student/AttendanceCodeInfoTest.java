/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.data.student.AttendanceCodeInfo;
import com.uvasoftware.core.util.SIFGUID;

/**
 * @author Uva Software - http://uvasoftware.com
 *
 */
public class AttendanceCodeInfoTest {

	String schoolId = "A2E35B359D75101A8C3D00AA001A0000";
	String code = "AE";
	String type = "Absent";
	String status = "Excused";
	AttendanceCodeInfo att = new AttendanceCodeInfo(schoolId,code,type,status);
	
	String newCode = "Tardy";
	AttendanceCodeInfo newatt = new AttendanceCodeInfo(schoolId,newCode,type,status);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(att.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		att.setPrimitive(newatt.getPrimitive());
		assertEquals(att.getPrimitive(), newatt.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#AttendanceCodeInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAttendanceCodeInfo() {
		assertNotNull(att);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setAttendanceCode(java.lang.String)}.
	 */
	@Test
	public void testSetAttendanceCode() {
		String code = "LATE";
		att.setAttendanceCode(code);
		assertEquals(att.getAttendanceCode(),code);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setAttendanceType(java.lang.String)}.
	 */
	@Test
	public void testSetAttendanceType() {
		String type = "Present";
		att.setAttendanceType(type);
		assertEquals(att.getAttendanceType(),type);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setAttendanceStatus(java.lang.String)}.
	 */
	@Test
	public void testSetAttendanceStatus() {
		String status = "NA";
		att.setAttendanceStatus(status);
		assertEquals(att.getAttendanceStatus(),status);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setAttendanceValue(java.lang.String)}.
	 */
	@Test
	public void testSetAttendanceValue() {
		String value = "1.0";
		att.setAttendanceValue(value);
		assertEquals(att.getAttendanceValue(),value);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setSchoolInfoRefId(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolInfoRefId() {
		String newSchoolId = SIFGUID.next();
		att.setSchoolInfoRefId(newSchoolId);
		assertEquals(att.getSchoolInfoRefId(),newSchoolId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		String refId = SIFGUID.next();
		att.setRefId(refId);
		assertEquals(att.getRefId(),refId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AttendanceCodeInfo#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		String description = "Room 1048";
		att.setDescription(description);
		assertEquals(att.getDescription(),description);
	}



}

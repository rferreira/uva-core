/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import com.uvasoftware.core.util.SIFGUID;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.data.student.SchoolCourseInfo;

/**
 * @author Uva Software - http://uvasoftware.com
 *
 */
public class SchoolCourseInfoTest {
	
	SchoolCourseInfo course, newcourse; 
	
	@Before
	public void setup() {
		String code = "CS101";
		String title = "Intro to Computer Science";
		String schoolId = "A2E35B359D75101A8C3D00AA001A0000";
		course = new SchoolCourseInfo(schoolId, code, title);
		
		String newCode = "CS101";
		String newTitle = "Intro to Computer Science";
		String newSchoolId = "D3E34B359D75101A8C3D00AA001A1652";
		newcourse = new SchoolCourseInfo(newSchoolId, newCode, newTitle);
		
	}
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(course.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		course.setPrimitive(newcourse.getPrimitive());
		assertEquals(course.getPrimitive(), newcourse.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#SchoolCourseInfo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSchoolCourseInfo() {
		assertNotNull(course);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setCourseCode(java.lang.String)}.
	 */
	@Test
	public void testSetCourseCode() {
		
		course.setCourseCode("CSE999");
		assertEquals("CSE999",course.getCourseCode());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setStateCourseCode(java.lang.String)}.
	 */
	@Test
	public void testSetStateCourseCode() {
		course.setStateCourseCode("1");
		assertEquals("1",course.getStateCourseCode());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setDistrictCourseCode(java.lang.String)}.
	 */
	@Test
	public void testSetDistrictCourseCode() {
		course.setDistrictCourseCode("1");
		assertEquals("1",course.getDistrictCourseCode());
	
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setSubjectArea(java.util.List)}.
	 */
	@Test
	public void testaddSubjectArea() {
		SubjectArea a = new SubjectArea(SubjectArea.Code.AGRICULTURE_AND_RENEWABLE_NATURAL_RESOURCES,"A");
		course.addSubjectArea(a);
		
		assertEquals(SubjectArea.Code.AGRICULTURE_AND_RENEWABLE_NATURAL_RESOURCES,course.getSubjectArea().get(0).getCode());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setCourseTitle(java.lang.String)}.
	 */
	@Test
	public void testSetCourseTitle() {
		course.setCourseTitle("1");
		assertEquals("1",course.getCourseTitle());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setInstructionalLevel(java.lang.String)}.
	 */
	@Test
	public void testSetInstructionalLevel() {
		course.setInstructionalLevel("1");
		assertEquals("1",course.getInstructionalLevel());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setCourseCredits(java.util.List)}.
	 */
	@Test
	public void testAddCourseCredits() {
		SchoolCourseInfo.CourseCredits cred = new SchoolCourseInfo.CourseCredits("A","B");
		course.addCourseCredits(cred);
		
		assertEquals(cred.code,course.getCourseCredits().get(0).code);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setCoreAcademicCourse(boolean)}.
	 */
	@Test
	public void testSetCoreAcademicCourse() {
		course.setCoreAcademicCourse(true);
		assertEquals(true,course.getCoreAcademicCourse());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setGradRequirement(boolean)}.
	 */
	@Test
	public void testSetGradRequirement() {
		course.setGradRequirement(true);
		assertEquals(true,course.getGradRequirement());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		String refId = SIFGUID.next();
		course.setRefId(refId);
		assertEquals(course.getRefId(),refId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setSchoolInfoRefId(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolInfoRefId() {
		String newSchoolId = SIFGUID.next();
		course.setSchoolInfoRefId(newSchoolId);
		assertEquals(course.getSchoolInfoRefId(),newSchoolId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.SchoolCourseInfo#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		String description = "Room 1048";
		course.setDescription(description);
		assertEquals(course.getDescription(),description);
	}



}

package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.SIFGUID;
import java.util.List;
import java.util.ArrayList;
import com.uvasoftware.core.data.common.*;

import com.uvasoftware.core.data.common.BaseSIFObject;

/**
 * This class represents a SIF <code>SchoolCourseInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SchoolCourseInfo extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.SchoolCourseInfo primitive = new com.uvasoftware.core.primitives.SchoolCourseInfo();
	
	public SchoolCourseInfo() {}
	
	
	/**
	 * Helper class that represents a CourseCredits object  
	 */
	public static class CourseCredits {
		public String credits = new String();
		public String code = "01";
		
		public CourseCredits(String code, String credits) {
			this.credits = credits;
			this.code = code;
		}
		
		public CourseCredits() {}
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
		this.primitive = (com.uvasoftware.core.primitives.SchoolCourseInfo) primitive;

	}
	
	/**
	 * Creates a new SchoolCourseInfo object
	 * @param schoolId the school's GUID
	 * @param code the school-defined local code for the course
	 * @param title the title of the course
	 * 
	 */
	public SchoolCourseInfo(String schoolId, String code, String title) {
		primitive.setRefId(SIFGUID.next());
		primitive.setSchoolInfoRefId(schoolId);
		primitive.setCourseCode(code);
		primitive.setCourseTitle(title);
	}
	
	/**
	 * Gets the <code>CourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the school-defined local code for the course
	 */
	public String getCourseCode() {
		return(primitive.getCourseCode());
	}
	
	/**
	 * Sets the <code>CourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @param code the school-defined local code for the course
	 */
	public void setCourseCode(String code) {
		primitive.setCourseCode(code);
	}

	/**
	 * Gets the <code>StateCourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the state-defined standard code for the course
	 */
	public String getStateCourseCode() {
		return(primitive.getStateCourseCode());
	}
	
	/**
	 * Sets the <code>StateCourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @param code the state-defined standard code for the course
	 */
	public void setStateCourseCode(String code) {
		primitive.setStateCourseCode(code);
	}

	/**
	 * Gets the <code>DistrictCourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the district-defined standard code for the course
	 */
	public String getDistrictCourseCode() {
		return(primitive.getDistrictCourseCode());
	}
	
	/**
	 * Sets the <code>DistrictCourseCode</code> field of the <code>SchoolCourseInfo</code> element
	 * @param code the district-defined standard code for the course
	 */
	public void setDistrictCourseCode(String code) {
		primitive.setDistrictCourseCode(code);
	}
	/**
	 * Gets the <code>SubjectArea</code> child element(s) of the <code>SchoolCourseInfo</code> element
	 * @return a list of subject matter areas or departments for the course
	 */
	public List<SubjectArea> getSubjectArea() {
		ArrayList<SubjectArea> list = new ArrayList<SubjectArea>();
		SubjectArea sub = null;
		for (com.uvasoftware.core.primitives.SubjectArea s: primitive.getSubjectArea()) {
			sub = new SubjectArea(null, null);
			sub.setPrimitive(s);
			list.add(sub);
		}
		return(list);
	}
	
	/**
	 * Adds a new <code>SubjectArea</code> child element(s) of the <code>SchoolCourseInfo</code> element
	 * @param subjectList the list of subject matter areas or departments for the course
	 */
	public void addSubjectArea(SubjectArea subject) {
		primitive.getSubjectArea().add((com.uvasoftware.core.primitives.SubjectArea)subject.getPrimitive());
	}
	
	/**
	 * Gets the <code>CourseTitle</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the title of the course
	 */
	public String getCourseTitle() {
		return(primitive.getCourseTitle());
	}
	
	/**
	 * Sets the <code>CourseTitle</code> field of the <code>SchoolCourseInfo</code> element
	 * @param title the title of the course
	 */
	public void setCourseTitle(String title) {
		primitive.setCourseTitle(title);
	}	
	
	/**
	 * Gets the <code>InstructionalLevel</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the Instructional Level code indicating the general nature and difficulty of the course
	 * 
	 * @see com.uvasoftware.core.data.code.InstructionalLevel1230
	 */
	public String getInstructionalLevel() {
		return(primitive.getInstructionalLevel());
	}
	
	/**
	 * Sets the <code>Size</code> field of the <code>SchoolCourseInfo</code> element
	 * @param level the Instructional Level code indicating the general nature and difficulty of the course
	 * 
	 * @see com.uvasoftware.core.data.code.InstructionalLevel1230
	 */
	public void setInstructionalLevel(String level) {
		primitive.setInstructionalLevel(level);
	}
	
	/**
	 * Gets the <code>CourseCredits</code> child element(s) of the <code>SchoolCourseInfo</code> element
	 * @return the list of credits and types of credit awarded for this course
	 * @see SchoolCourseInfo.CourseCredits
	 */
	public List<CourseCredits> getCourseCredits() {
		ArrayList<CourseCredits> list = new ArrayList<CourseCredits>();
		CourseCredits cred = null;
		for (com.uvasoftware.core.primitives.CourseCredits c: primitive.getCourseCredits()) {
			cred = new CourseCredits();
			cred.code = c.getCode();
			cred.credits = c.getValue();
			list.add(cred);
		}
		return(list);
	}
	
	/**
	 * Sets the <code>CourseCredits</code> field of the <code>SchoolCourseInfo</code> element
	 * @param creditsList the list of credits and types of credit awarded for this course
	 */
	public void addCourseCredits(CourseCredits value) {
			com.uvasoftware.core.primitives.CourseCredits cred = new com.uvasoftware.core.primitives.CourseCredits();
			cred.setCode(value.code);
			cred.setValue(value.credits);
			primitive.getCourseCredits().add(cred);
	}
	
	/**
	 * Gets the <code>CoreAcademicCourse</code> field of the <code>SchoolCourseInfo</code> element
	 * <br><br>
	 * <u>Values:</u><br>
	 * Yes, No
	 * @return Answer to the question, "Does the course meet the state definition of a core academic course?"
	 */
	public boolean getCoreAcademicCourse() {
		if (primitive.getCoreAcademicCourse().toUpperCase().contains("YES")) 
			return(true);
		else
			return(false);
	}
	
	/**
	 * Sets the <code>CoreAcademicCourse</code> field of the <code>SchoolCourseInfo</code> element
	 * 
	 * @param bool Answer to the question, "Does the course meet the state definition of a core academic course?" 
	 */
	public void setCoreAcademicCourse(boolean bool) {
		if (bool == true)
			primitive.setCoreAcademicCourse("Yes");
		else
			primitive.setCoreAcademicCourse("No");
	}
	
	/**
	 * Gets the <code>GradRequirement</code> field of the <code>SchoolCourseInfo</code> element
	 * <br><br>
	 * <u>Values:</u><br>
	 * Yes, No
	 * @return Answer to the question, "Does the state require that the course be completed for graduation?"
	 */
	public boolean getGradRequirement() {
		if (primitive.getGradRequirement().toUpperCase().contains("YES")) 
			return(true);
		else
			return(false);
	}
	
	/**
	 * Sets the <code>GradRequirement</code> field of the <code>SchoolCourseInfo</code> element
	 * 
	 * @param bool Answer to the question, "Does the state require that the course be completed for graduation?" 
	 */
	public void setGradRequirement(boolean bool) {
		if (bool == true)
			primitive.setGradRequirement("Yes");
		else
			primitive.setGradRequirement("No");
	}
	
	/**
	 * Gets the <code>RefId</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the GUID uniquely identifying this SchoolCourseInfo instance
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>SchoolCourseInfo</code> element
	 * @param refId the GUID uniquely identifying this SchoolCourseInfo instance
	 */
	public void setRefId(String refId) {
		primitive.setRefId(refId);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the GUID of the school to which the course belongs
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>SchoolCourseInfo</code> element
	 * @param schoolId the GUID of the school to which the course belongs
	 */
	public void setSchoolInfoRefId(String schoolId) {
		primitive.setSchoolInfoRefId(schoolId);
	}

	/**
	 * Gets the <code>Description</code> field of the <code>SchoolCourseInfo</code> element
	 * @return the textual description of the course
	 */
	public String getDescription() {
		return(primitive.getDescription());
	}
	
	/**
	 * Sets the <code>Description</code> field of the <code>SchoolCourseInfo</code> element
	 * @param desc the textual description of the course
	 */
	public void setDescription(String desc) {
		primitive.setDescription(desc);
	}


}
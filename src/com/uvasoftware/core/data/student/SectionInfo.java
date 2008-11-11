package com.uvasoftware.core.data.student;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.BaseSIFObject;

/** 
* Represents a SIF <code>SectionInfo</code> object 
* <p>
* Version 1.5r1 of the SIF Specification describes <code>SIF_Event</code> as follows:
* <blockquote> 
* <code>SectionInfo</code> provides information about the section - the specific time period a session of the course meets<br> SIF_Events are reported.
* <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
* </blockquote>
*/ 
public class SectionInfo extends BaseSIFObject implements ISIFObject {
	
	
	com.uvasoftware.core.primitives.SectionInfo primitive = new com.uvasoftware.core.primitives.SectionInfo();
	
	
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
		this.primitive = (com.uvasoftware.core.primitives.SectionInfo) primitive;

	}
	
	/**
	 * Creates a new <code>SectionInfo</code> object
	 * @param refId the id that uniquely identifies this section
	 * @param srefId the id that identifies the course being taught in this section 
	 */
	public SectionInfo(String refId, String srefId) {
		this.primitive.setRefId(refId);
		this.primitive.setSchoolCourseInfoRefId(srefId);
		
	}
	
	/**
	 * Creates a new <code>SectionInfo</code> object
	 */
	public SectionInfo() {}
	
	/**
	 * Adds a new <code>ScheduleInfo</code> to this object
	 * @param value the 
	 */
	public void addScheduleInfo(ScheduleInfo value) {
		//TODO: LAMESPEC
	
		primitive.getScheduleInfo().add((com.uvasoftware.core.primitives.ScheduleInfo) value.getPrimitive()); 
		
	}
	
	/**
	 * Returns a list of all the <code>ScheduleInfo</code>  contained in this message
	 * @return a list containing a bunch of ScheduleInfos 
	 */
	//TODO: LAMESPEC
	public List <ScheduleInfo> getScheduleInfos() {
		ArrayList <ScheduleInfo> resp = new ArrayList <ScheduleInfo>();
		for (com.uvasoftware.core.primitives.ScheduleInfo e: primitive.getScheduleInfo() ) {
			ScheduleInfo m = new ScheduleInfo();
			m.setPrimitive(e);
			resp.add(m);			
		}
		return(resp);
	}
	
	/**
	 * Sets the <code>MediumOfInstruction</code> field of the <code>SectionInfo</code> element
	 * @param value a string representing the medium through which the student receives instructional communications from the teacher
	 */
	public void setMediumOfInstruction(String value) {
		com.uvasoftware.core.primitives.MediumOfInstruction m = new com.uvasoftware.core.primitives.MediumOfInstruction();
		m.setValue(value);
		primitive.setMediumOfInstruction(m);
	}
	
	/**
	 * Gets the <code>SchoolInfoMediumOfInstruction</code> field of the <code>SectionInfo</code> element
	 */
	public String getMediumOfInstruction() {
		return(primitive.getMediumOfInstruction().getValue());
	}
	
	
	/**
	 * Sets the <code>LanguageOfInstruction</code> field of the <code>SectionInfo</code> element
	 * @param value the language in which the section is taught 
	 */
	public void setLanguageOfInstruction(String value) {
		primitive.setLanguageOfInstruction(value);
	}
	
	/**
	 * Gets the <code>SchoolInfoLanguageOfInstruction</code> field of the <code>SectionInfo</code> element
	 */
	public String getLanguageOfInstruction() {
		return(primitive.getLanguageOfInstruction());
	}
	
	
	/**
	 * Sets the <code>LocationOfInstruction</code> field of the <code>SectionInfo</code> element
	 * @param value Description of the location in which the section is taught.
	 * @param code Source: 1280 (Location of Instruction) [STUDENTHB]
	 */
	public void setLocationOfInstruction(String code, String value) {
		com.uvasoftware.core.primitives.LocationOfInstruction i = new com.uvasoftware.core.primitives.LocationOfInstruction();
		i.setCode(code);
		i.setValue(value);
		primitive.setLocationOfInstruction(i);
	}
	
	/**
	 * Gets the <code>SchoolInfoLocationOfInstruction</code> field of the <code>SectionInfo</code> element
	 */
	public String getSchoolInfoLocationOfInstructionValue() {
		return(primitive.getLocationOfInstruction().getValue());
	}
	
	/**
	 * Gets the <code>SchoolInfoLocationOfInstruction/Code</code> field of the <code>SectionInfo</code> element
	 */
	public String getSchoolInfoLocationOfInstructionCode() {
		return(primitive.getLocationOfInstruction().getCode());
	}	
	
	/**
	 * Sets the <code>SchoolCourseInfoOverride</code> field of the <code>SectionInfo</code> element
	 * @param value the language in which the section is taught 
	 */
	public void setSchoolCourseInfoOverride(SchoolCourseInfoOverride value) {
		primitive.setSchoolCourseInfoOverride((com.uvasoftware.core.primitives.SchoolCourseInfoOverride) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>SchoolInfoSchoolCourseInfoOverride</code> field of the <code>SectionInfo</code> element
	 */
	public SchoolCourseInfoOverride getSchoolCourseInfoOverride() {
		SchoolCourseInfoOverride i = new SchoolCourseInfoOverride(false);
		i.setPrimitive(primitive.getSchoolCourseInfoOverride());
		return(i);
	}

}

package com.uvasoftware.core.data.student;

import com.uvasoftware.core.data.common.BaseSIFObject;
import com.uvasoftware.core.data.common.MeetingTime;
import com.uvasoftware.core.ISIFObject;
import java.util.List;
import java.util.ArrayList;


/** 
* Represents a SIF <code>ScheduleInfo</code> object 
* <p>
* Version 1.5r1 of the SIF Specification describes <code>SIF_Event</code> as follows:
* <blockquote> 
* <code>ScheduleInfo</code> provides schedule related information for a section repeating for each term in which the section is scheduled.
* <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
* </blockquote>
*/ 
public class ScheduleInfo extends BaseSIFObject implements ISIFObject {
	com.uvasoftware.core.primitives.ScheduleInfo primitive = new com.uvasoftware.core.primitives.ScheduleInfo();
	
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
		this.primitive = (com.uvasoftware.core.primitives.ScheduleInfo) primitive;

	}

	/**
	 * Creates a new <code>ScheduleInfo</code> object
	 * @param termInfoRefId the term to which this schedule information relates
	 */
	public ScheduleInfo(String termInfoRefId) { this.primitive.setTermInfoRefId(termInfoRefId); }
	

	/**
	 * Creates a new <code>ScheduleInfo</code> object
	 * 
	 */
	public ScheduleInfo() {
	}

	/**
	 * Adds the ID of the teacher that who teach this section
	 * @param staffPersonalRefId
	 */
	public void addTeacher(String staffPersonalRefId) {
		com.uvasoftware.core.primitives.Teacher t = new com.uvasoftware.core.primitives.Teacher();
		t.setStaffPersonalRefId(staffPersonalRefId);
		this.primitive.getTeacher().add(t);
	}
	
	/**
	 * Gets a list of all the teacher staffPersonalRefIds in this object
	 * @return a list containing strings for all of the ids
	 */
	public List<String> getTeacherId() {
		ArrayList<String> ar = new ArrayList<String>();
		for (com.uvasoftware.core.primitives.Teacher e: primitive.getTeacher()) {
			ar.add(e.getStaffPersonalRefId());
		}
		return (ar);
	}
	
	/**
	 * Adds the ID of the SectionRoom that who teach this section
	 * @param refId
	 */
	public void addSectionRoom(String refId) {
		com.uvasoftware.core.primitives.SectionRoom t = new com.uvasoftware.core.primitives.SectionRoom();
		t.setRoomInfoRefId(refId);
		this.primitive.getSectionRoom().add(t);
	}
	
	/**
	 * Gets a list of all the SectionRoom staffPersonalRefIds in this object
	 * @return a list containing strings for all of the ids
	 */
	public List<String> getSectionRoomId() {
		ArrayList<String> ar = new ArrayList<String>();
		for (com.uvasoftware.core.primitives.SectionRoom e: primitive.getSectionRoom()) {
			ar.add(e.getRoomInfoRefId());
		}
		return (ar);
	}
	
	/**
	 * Adds the ID of the MeetingTime that who teach this section
	 * @param refId
	 */
	public void addMeetingTime(MeetingTime value) {
		this.primitive.getMeetingTime().add((com.uvasoftware.core.primitives.MeetingTime) value.getPrimitive());
	}
	
	/**
	 * Gets a list of all the MeetingTime staffPersonalRefIds in this object
	 * @return a list containing strings for all of the ids
	 */
	public List<MeetingTime> getMeetingTime() {
		ArrayList<MeetingTime> ar = new ArrayList<MeetingTime>();
		for (com.uvasoftware.core.primitives.MeetingTime e: primitive.getMeetingTime()) {
			MeetingTime mt = new MeetingTime();
			mt.setPrimitive(e);
			ar.add(mt);
		}
		return (ar);
	}
	
	
}

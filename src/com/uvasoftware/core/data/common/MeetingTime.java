/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>MeetingTime</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class MeetingTime extends BaseSIFObject {

	com.uvasoftware.core.primitives.MeetingTime primitive = new com.uvasoftware.core.primitives.MeetingTime();
	
	
	/**
	 * Creates a new MeetingTime object
	 */
	public MeetingTime() {
	}
	
	/** 
	 * Gets the <code>TimetableDay</code> attribute of the <code>MeetingTime</code> element
	 * @return the day code when the section meets
	 */
	public String getTimetableDay() {
		return(primitive.getTimetableDay());
	}
	
	/** 
	 * Sets the <code>TimetableDay</code> attribute of the <code>MeetingTime</code> element
	 * @param day day code when the section meets (e.g., "M"onday through "F"riday; locally defined)
	 */
	public void setTimetableDay(String day) {
		primitive.setTimetableDay(day);
	}
	
	/** 
	 * Gets the <code>TimetablePeriod</code> attribute of the <code>MeetingTime</code> element
	 * @return the period within the day when this section takes place
	 */
	public String getTimetablePeriod() {
		return(primitive.getTimetablePeriod());
	}
	
	/** 
	 * Sets the <code>TimetablePeriod</code> attribute of the <code>MeetingTime</code> element
	 * @param period the period within the day when this section takes place (e.g., "0" through "7")
	 */
	public void setTimetablePeriod(String period) {
		primitive.setTimetablePeriod(period);
	}
}
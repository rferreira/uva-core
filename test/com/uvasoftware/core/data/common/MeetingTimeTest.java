/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Uva Software - http://uvasoftware.com
 *
 */
public class MeetingTimeTest {	
	MeetingTime meet = new MeetingTime();
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.MeetingTime#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(meet.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.MeetingTime#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String day = "T";
			
		MeetingTime newmeet = new MeetingTime();
		newmeet.setTimetableDay(day);
		
		meet.setPrimitive(newmeet.getPrimitive());
		assertEquals(meet.getPrimitive(), newmeet.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.MeetingTime#MeetingTime()}.
	 */
	@Test
	public void testMeetingTime() {
		assertNotNull(meet);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.MeetingTime#setTimetableDay(java.lang.String)}.
	 */
	@Test
	public void testSetTimetableDay() {
		String newday = "W";
		meet.setTimetableDay(newday);
		assertEquals(meet.getTimetableDay(),newday);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.MeetingTime#setTimetablePeriod(java.lang.String)}.
	 */
	@Test
	public void testSetTimetablePeriod() {
		String newperiod = "4";
		meet.setTimetablePeriod(newperiod);
		assertEquals(meet.getTimetablePeriod(),newperiod);
	}

}

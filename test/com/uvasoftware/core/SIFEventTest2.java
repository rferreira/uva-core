/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.data.student.RoomType;
import com.uvasoftware.core.data.student.StudentPersonal;
import com.uvasoftware.core.data.common.*;

/**
 * @author rafael
 *
 */
public class SIFEventTest2 {
	SIFEvent ev = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		RoomType rt = new RoomType("A","B");
		rt.setRefId("260A962CB9854215932B61A32D269992");
		
		ev = new SIFEvent();
		ev.setEventData(rt,SIFObjectName.RoomType.name(),SIFEvent.Action.Remove);
		
		System.out.println(ev);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#SIFEvent()}.
	 */
	@Test
	public void testSIFEvent() {
		assertNotNull(ev);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#setEventData(com.uvasoftware.core.ISIFObject, java.lang.String, com.uvasoftware.core.SIFEvent.Action)}.
	 */
	@Test
	public void testSetEventData() throws Exception {
		StudentPersonal sp = new StudentPersonal();
		sp.setName(new Name(Name.Type.CURRENT_LEGAL,"blue","bag") );
		
		ev.setEventData(sp, SIFObjectName.StudentPersonal.toString(), SIFEvent.Action.Change);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#getEventObjectName()}.
	 */
	@Test
	public void testGetEventObjectName() {
		assertEquals(SIFObjectName.RoomType, ev.getEventObjectName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#setAction(com.uvasoftware.core.SIFEvent.Action)}.
	 */
	@Test
	public void testSetAction() {
		ev.setAction(SIFEvent.Action.Add);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#getAction()}.
	 */
	@Test
	public void testGetAction() {
		assertEquals(SIFEvent.Action.Remove, ev.getAction());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#getEventObject()}.
	 */
	@Test
	public void testGetEventObject() {
		assertNotNull(ev.getEventObject());
	}

}

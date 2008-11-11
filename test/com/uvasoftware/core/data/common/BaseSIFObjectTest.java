/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;
import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.*;
import com.uvasoftware.core.util.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.data.student.*;


/**
 * @author Uva Software <http://uvasoftware.com>
 *
 */
public class BaseSIFObjectTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.BaseSIFObject#addExtendedElement(com.uvasoftware.core.data.common.ExtendedElement)}.
	 */
	@Test
	public void testAddExtendedElement() {
		RoomInfo room = new RoomInfo("A","B");
		room.addExtendedElement(new ExtendedElement("C","D"));
		ExtendedElement p = new ExtendedElement("myname","myvalue");
		ExtendedElement p1 = new ExtendedElement("1","2");
		
		room.addExtendedElement(p);
		room.addExtendedElement(p1);
		System.out.println(room);
		assertTrue(room.toString().contains("<SIF_ExtendedElement Name=\"myname\">myvalue</SIF_ExtendedElement>"));
		assertTrue(room.toString().contains("<SIF_ExtendedElement Name=\"1\">2</SIF_ExtendedElement>"));
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.BaseSIFObject#getExtendedElements()}.
	 */
	@Test
	public void testGetExtendedElements() {
		RoomInfo room = new RoomInfo("A","B");
		ExtendedElement p = new ExtendedElement("myname","myvalue");
		ExtendedElement p1 = new ExtendedElement("1","2");
		
		room.addExtendedElement(p);
		room.addExtendedElement(p1);
		
		
		ArrayList <ExtendedElement >l  = new ArrayList <ExtendedElement> (room.getExtendedElements());
		assertEquals("myname",l.get(0).getName());
		assertEquals("1",l.get(1).getName());
		
		assertEquals("myvalue",l.get(0).getValue());
		assertEquals("2",l.get(1).getValue());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.BaseSIFObject#toString()}.
	 */
	@Test
	public void testToString() {
		RoomInfo room = new RoomInfo("A","B");
		room.addExtendedElement("1","2");
		assertTrue(room.toString().contains("<SIF_ExtendedElement Name=\"1\">2</SIF_ExtendedElement>"));
	}
	
	@Test
	public void testGetSIFObjectName() {
		RoomInfo room = new RoomInfo("A","B");
		assertEquals(SIFObjectName.RoomInfo,room.getSIFObjectName());
		
		//this should return null
		SIFZoneStatus z = new SIFZoneStatus();
		
		assertEquals(SIFObjectName.SIFZoneStatus, z.getSIFObjectName());
		
	}
	
	@Test
	public void testGetPrimitive() {
		Authentication auth = new Authentication(SIFGUID.next(), SIFObjectName.StudentParticipation.toString());
		assertEquals(auth.getRefId(), ((com.uvasoftware.core.primitives.Authentication) auth.getPrimitive()).getRefId()); 
		
	}
	
	@Test
	public void testSetPrimitive() {
		Authentication auth = new Authentication(SIFGUID.next(), SIFObjectName.StudentParticipation.toString());
		Authentication auth2 = new Authentication(SIFGUID.next(), SIFObjectName.StudentParticipation.toString());
		auth2.setPrimitive(auth.getPrimitive());
		
		assertEquals(auth.getRefId(), auth2.getRefId()); 
		
	}
	
	
	

}

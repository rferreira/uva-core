/**
 * 
 */
package com.uvasoftware.core;

import java.util.List;

import junit.framework.TestCase;

import com.uvasoftware.core.SIFResponse;
import com.uvasoftware.core.util.*;
import com.uvasoftware.core.data.student.*;
import com.uvasoftware.core.data.common.*;
/**
 * @author Rafael Ferreira
 *
 */
public class SIFResponseTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#SIFResponse(java.lang.String, int, boolean)}.
	 */
	public void testSIFResponse() {

		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		System.out.println(resp);
		
		assertTrue(resp.toString().contains("SIF_Response"));
		assertTrue(resp.toString().contains("SIF_Header"));
		assertTrue(resp.toString().contains("SIF_RequestMsgId"));
		assertTrue(resp.toString().contains("SIF_PacketNumber"));
		assertTrue(resp.toString().contains("SIF_MorePackets"));
		assertTrue(resp.toString().contains("SIF_ObjectData"));
			

	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#setObjectData(com.uvasoftware.core.primitives.SIFObjectData)}.
	 */
	public void testSetObjectData() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		System.out.println(resp);
		
		
		assertTrue(resp.toString().contains("SIF_ObjectData"));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#getObjectData()}.
	 */
	public void testGetObjectData() {
		SIFResponse resp = new SIFResponse();
		StudentPersonal a = new StudentPersonal();
		a.setName(new Name(Name.Type.ALIAS,"John","Doe"));
		resp.addObjectData(a);
		assertEquals(a.getName().getFirstName(), ( (StudentPersonal) resp.getResponse().getObjectData().get(0)).getName().getFirstName() );
		
		
	}
	
	public void testGetObjectDataObjectName() {
		SIFResponse resp = new SIFResponse();
		StudentPersonal a = new StudentPersonal();
		a.setName(new Name(Name.Type.ALIAS,"John","Doe"));
		resp.addObjectData(a);
		
		StudentPersonal b = new StudentPersonal();
		b.setName(new Name(Name.Type.ALIAS,"A","B"));
		resp.addObjectData(b);
		
		List<ISIFObject> l = resp.getObjectData(SIFObjectName.StudentPersonal);
		
		assertEquals(2,l.size());
		
		assertEquals(a.getName().getFirstName(), ( (StudentPersonal) l.get(0)).getName().getFirstName() );
		assertEquals(b.getName().getFirstName(), ( (StudentPersonal) l.get(1)).getName().getFirstName() );
		
	}
	
	public void testBruteGetObjectDataObjectName() {
		SIFResponse resp = new SIFResponse();
		
		for (SIFObjectName a: SIFObjectName.values()) {
			assertEquals(0,  resp.getObjectData(a).size());
		}
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#setError(int, int, java.lang.String, java.lang.String)}.
	 */
	public void testSetError() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		resp.setError(1, 1, "blah", "blah1");
		assertTrue(resp.toString().contains("blah"));
		assertTrue(resp.toString().contains("blah1"));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#getRequestMsgID()}.
	 */
	public void testGetRequestMsgID() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		assertNotNull(resp.getRequestMsgID());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#getPacketNumber()}.
	 */
	public void testGetPacketNumber() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		assertNotNull(resp.getPacketNumber());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFResponse#hasMorePackets()}.
	 */
	public void testHasMorePackets() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		assertFalse(resp.hasMorePackets());
	}

	public void testGetEmpty() {
		SIFResponse resp = new SIFResponse(SIFGUID.next(),1,false);
		assertNotNull(resp.getObjectData());
	}

}

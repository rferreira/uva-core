/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;
import org.junit.Test;

import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.util.SIFGUID;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFAckTest {
	// Initialize common objects
	String sourceid = "Zero Wing ZIS";
	String msgid = SIFGUID.next();
	
	// Initialize success-specific objects
	int statcode = 0;
	String statdata = "We get signal";
	
	// Initialize failure-specific objects
	int errcode = 2;
	int errcat = 3; 
	String errdesc = "Somebody set us up the bomb";
	String errextdesc = "You have no chance to survive make your time";
	
	// Initialize success and failure SIFAck objects
	SIFAck ackok = new SIFAck(sourceid, msgid, statcode);
	SIFAck ackerr = new SIFAck(sourceid, msgid, errcode, errcat, errdesc);
	
	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#SIFAck(java.lang.String, java.lang.String, int)},
	 * which builds a "success"-type <code>SIF_Ack</code> message
	 */
	@Test
	public void testSIFAckStringStringInt() {
		// Verify provided object values
		assertEquals(ackok.getOriginalSourceID(), sourceid);
		assertEquals(ackok.getOriginalMsgID(), msgid);
		assertEquals(ackok.getStatusCode(), statcode);
		
		// Verify provided object values in the primitive
		assertTrue(ackok.toString().contains(String.valueOf(sourceid)));
		assertTrue(ackok.toString().contains(msgid));
		assertTrue(ackok.toString().contains(String.valueOf(statcode)));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#SIFAck(java.lang.String, java.lang.String, int, int, java.lang.String)},
	 * which builds a "failure"-type <code>SIF_Ack</code> message
	 */
	@Test
	public void testSIFAckStringStringIntIntString() {
		// Verify provided object values
		assertEquals(ackerr.getOriginalSourceID(), sourceid);
		assertEquals(ackerr.getOriginalMsgID(), msgid);
		assertEquals(ackerr.getErrorCode(), errcode);
		assertEquals(ackerr.getErrorCategory(), errcat);
		assertEquals(ackerr.getErrorDesc(), errdesc);
		
		// Verify provided object values in the primitive
		assertTrue(ackerr.toString().contains(String.valueOf(sourceid)));
		assertTrue(ackerr.toString().contains(msgid));
		assertTrue(ackerr.toString().contains(String.valueOf(errcode)));
		assertTrue(ackerr.toString().contains(String.valueOf(errcat)));
		assertTrue(ackerr.toString().contains(errdesc));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getOriginalSourceID()}.
	 */
	@Test
	public void testGetOriginalSourceID() {
		assertEquals(ackok.getOriginalSourceID(), sourceid);
		assertEquals(ackerr.getOriginalSourceID(), sourceid);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setOriginalSourceID(java.lang.String)}.
	 */
	@Test
	public void testSetOriginalSourceID() {
		String newsourceid = sourceid + "test";
		
		ackok.setOriginalSourceID(newsourceid);
		assertEquals(ackok.getOriginalSourceID(), newsourceid);
		
		ackerr.setOriginalSourceID(newsourceid);
		assertEquals(ackerr.getOriginalSourceID(), newsourceid);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getOriginalMsgID()}.
	 */
	@Test
	public void testGetOriginalMsgID() {
		assertEquals(ackok.getOriginalMsgID(), msgid);
		assertEquals(ackerr.getOriginalMsgID(), msgid);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setOriginalMsgID(java.lang.String)}.
	 */
	@Test
	public void testSetOriginalMsgID() {
		String newmsgid = SIFGUID.next();
		
		ackok.setOriginalMsgID(newmsgid);
		assertEquals(ackok.getOriginalMsgID(), newmsgid);
		
		ackerr.setOriginalMsgID(newmsgid);
		assertEquals(ackerr.getOriginalMsgID(), newmsgid);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getStatusCode()}.
	 */
	@Test
	public void testGetStatusCode() {
		assertEquals(ackok.getStatusCode(), statcode);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setStatusCode(int)}.
	 */
	@Test
	public void testSetStatusCode() {
		// Assume statcode + 1 doesn't hit some SIFStatusCode-defined boundary
		int newstatcode = statcode + 1;
		
		ackok.setStatusCode(newstatcode);
		assertEquals(ackok.getStatusCode(), newstatcode);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getStatusData()}.
	 */
	@Test
	public void testGetStatusData() {
		//assertEquals(ackok.getStatusData(), statdata);		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setStatusData(java.lang.String)}.
	 */
	@Test
	public void testSetStatusData() {
		//TODO: implement this and testGetStatusData
		//String newstatdata = statdata + "test";
		//
		//ackok.setStatusData(newstatdata);
		//assertEquals(ackok.getStatusData(), statdata);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode() {
		assertEquals(ackerr.getErrorCode(), errcode);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setErrorCode(int)}.
	 */
	@Test
	public void testSetErrorCode() {
		// Assume errcode + 1 doesn't hit some SIFErrorCode-defined boundary
		int newerrcode = errcode + 1;
		
		ackerr.setErrorCode(newerrcode);
		assertEquals(ackerr.getErrorCode(), newerrcode);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getErrorCategory()}.
	 */
	@Test
	public void testGetErrorCategory() {
		assertEquals(ackerr.getErrorCategory(), errcat);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setErrorCategory(int)}.
	 */
	@Test
	public void testSetErrorCategory() {
		// Assume errcat + 1 doesn't hit some SIFErrorCategory-defined boundary
		int newerrcat = errcat + 1;
		
		ackerr.setErrorCategory(newerrcat);
		assertEquals(ackerr.getErrorCategory(), newerrcat);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getErrorDesc()}.
	 */
	@Test
	public void testGetErrorDesc() {
		assertEquals(ackerr.getErrorDesc(), errdesc);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setErrorDesc(java.lang.String)}.
	 */
	@Test
	public void testSetErrorDesc() {
		String newerrdesc = errdesc + "test";
		
		ackerr.setErrorDesc(newerrdesc);
		assertEquals(ackerr.getErrorDesc(), newerrdesc);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#getErrorExtDesc()}.
	 */
	@Test
	public void testGetErrorExtDesc() {
		ackerr.setErrorExtDesc(errextdesc);
		assertEquals(ackerr.getErrorExtDesc(), errextdesc);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFAck#setErrorExtDesc(java.lang.String)}.
	 */
	@Test
	public void testSetErrorExtDesc() {
		String newerrextdesc = errextdesc + "test";
		
		ackerr.setErrorExtDesc(newerrextdesc);
		assertEquals(ackerr.getErrorExtDesc(), newerrextdesc);
	}

}

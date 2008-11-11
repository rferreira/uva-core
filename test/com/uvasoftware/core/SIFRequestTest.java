/**
 * 
 */
package com.uvasoftware.core;

import junit.framework.TestCase;

import com.uvasoftware.core.SIFRequest;
import com.uvasoftware.core.query.*;

/**
 * @author Rafael Ferreira
 *
 */
public class SIFRequestTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRequest#SIFRequest()}.
	 */
	public void testSIFRequest() {
		SIFRequest q = new SIFRequest();
		System.out.println(q);
		
		assertTrue(q.toString().contains("SIF_Header"));
		assertTrue(q.toString().contains("SIF_Version"));
		//assertEquals(q.get)
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRequest#SIFRequest(com.uvasoftware.core.primitives.SIFQuery)}.
	 */
	public void testSIFRequestSIFQuery() {
		SIFRequest q = new SIFRequest(new SIFQuery(SIFObjectName.StaffAssignment));
		assertTrue(q.toString().contains("SIF_Query"));
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRequest#setQuery(com.uvasoftware.core.primitives.SIFQuery)}.
	 */
	public void testSetQuery() {
		SIFRequest q = new SIFRequest();
		q.setQuery(new com.uvasoftware.core.query.SIFQuery(SIFObjectName.AccountingPeriod));
		assertTrue(q.toString().contains("SIF_Query"));
		
	}

}

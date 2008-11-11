/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class PhoneNumberTest {

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
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#PhoneNumber(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPhoneNumber() { 
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertNotNull(pn);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#getformat()}.
	 */
	@Test
	public void testGetformat() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertEquals(PhoneNumber.Format.NA,pn.getformat());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#setFormat(java.lang.String)}.
	 */
	@Test
	public void testSetFormat() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		pn.setFormat(PhoneNumber.Format.EU);
		assertEquals(PhoneNumber.Format.EU,pn.getformat());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#getType()}.
	 */
	@Test
	public void testGetType() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertEquals("01",pn.getType());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#setType(java.lang.String)}.
	 */
	@Test
	public void testSetType() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		pn.setType("02");
		assertEquals("02",pn.getType());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#getNumber()}.
	 */
	@Test
	public void testGetNumber() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertEquals("(555)555-5555",pn.getNumber());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#setNumber(java.lang.String)}.
	 */
	@Test
	public void testSetNumber() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertEquals("(555)555-5555",pn.getNumber());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		assertNotNull(pn);
		
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.PhoneNumber#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		PhoneNumber pn = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		PhoneNumber pn1 = new PhoneNumber(PhoneNumber.Format.NA,"01","(555)555-5555");
		pn.setPrimitive(pn1.getPrimitive());
		
		assertEquals(pn1.getPrimitive(),pn.getPrimitive());
	}

}

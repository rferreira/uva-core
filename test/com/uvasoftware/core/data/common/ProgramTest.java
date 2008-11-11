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
public class ProgramTest {
	String type = "Foodservice";
	String value = "NSLP";
	
	Program program = new Program(type, value);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Program#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(program.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Program#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String newvalue = "Foobar";
		Program newprogram = new Program(type, newvalue);
		
		program.setPrimitive(newprogram.getPrimitive());
		assertEquals(program.getPrimitive(), newprogram.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Program#Program(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProgram() {
		assertNotNull(program);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Program#setType(java.lang.String)}.
	 */
	@Test
	public void testSetType() {
		String newtype = "Local";
		program.setType(newtype);
		assertEquals(program.getType(),newtype);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Program#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValue() {
		String newvalue = "Kilroy";
		program.setValue(newvalue);
		assertEquals(program.getValue(),newvalue);
	}

}

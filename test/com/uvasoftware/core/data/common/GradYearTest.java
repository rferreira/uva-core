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
public class GradYearTest {
	String type = "Actual";
	String year = "2004";
	
	GradYear grad = new GradYear(type, year);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradYear#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(grad.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradYear#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String newyear = "2005";
		GradYear newgrad = new GradYear(type, newyear);
		
		grad.setPrimitive(newgrad.getPrimitive());
		assertEquals(grad.getPrimitive(), newgrad.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradYear#GradYear(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGradYear() {
		assertNotNull(grad);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradYear#setType(java.lang.String)}.
	 */
	@Test
	public void testSetType() {
		String newtype = "Projected";
		grad.setType(newtype);
		assertEquals(grad.getType(),newtype);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradYear#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValue() {
		String newyear = "2006";
		grad.setValue(newyear);
		assertEquals(grad.getValue(),newyear);
	}

}

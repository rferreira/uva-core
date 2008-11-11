/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Rafael Ferreira
 *
 */
public class GridLocationTest {

	GridLocation grid = new GridLocation("1","2");
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(grid.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		GridLocation g2 = new GridLocation("9","10");
		g2.setPrimitive(grid.getPrimitive());
		
		assertEquals(grid.getLongitude(),g2.getLongitude());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#GridLocation(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGridLocation() {
		GridLocation g2 = new GridLocation("9","10");
		assertNotNull(g2);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#getLatitude()}.
	 */
	@Test
	public void testGetLatitude() {
		assertEquals("1",grid.getLatitude());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#setLatitude(java.lang.String)}.
	 */
	@Test
	public void testSetLatitude() {
		GridLocation g2 = new GridLocation("9","10");
		g2.setLatitude("0");
		assertEquals("0",g2.getLatitude());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#getLongitude()}.
	 */
	@Test
	public void testGetLongitude() {
		assertEquals("2",grid.getLongitude());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GridLocation#setLongitude(java.lang.String)}.
	 */
	@Test
	public void testSetLongitude() {
		GridLocation g2 = new GridLocation("9","10");
		g2.setLongitude("0");
		assertEquals("0",g2.getLongitude());	
	}

}

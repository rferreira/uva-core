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
public class RelationshipTest {

	Relationship rl = new Relationship("poof");
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Relationship#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(rl.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Relationship#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		Relationship r2 = new Relationship("2");
		r2.setPrimitive(rl.getPrimitive());
		assertEquals("poof",r2.getCode());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Relationship#getCode()}.
	 */
	@Test
	public void testGetCode() {
		Relationship r = new Relationship("1");
		assertEquals("1",r.getCode());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Relationship#setCode()}.
	 */
	@Test
	public void testSetCode() {
		Relationship r = new Relationship("1");
		r.setCode("2");
		assertEquals("2",r.getCode());
	}

}

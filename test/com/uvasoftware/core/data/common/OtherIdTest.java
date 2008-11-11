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
public class OtherIdTest {

	OtherId id = new OtherId("id_type","id_value");
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.OtherId#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(id.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.OtherId#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		OtherId id2 = new OtherId("1","2");
		id2.setPrimitive(id.getPrimitive());
		assertEquals("id_value",id2.getValue());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.OtherId#setType(java.lang.String)}.
	 */
	@Test
	public void testSetType() {
		OtherId i = new OtherId();
		i.setType("1");
		assertEquals("1",i.getType());
	}



	/**
	 * Test method for {@link com.uvasoftware.core.data.common.OtherId#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValue() {
		OtherId i = new OtherId();
		i.setValue("1");
		assertEquals("1",i.getValue());
	}



}

/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class ElectronicIdTest {
	String type = "Barcode";
	String value = "206654";
	
	ElectronicId id = new ElectronicId(type, value);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ElectronicId#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(id.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ElectronicId#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String newvalue = "456602";
		ElectronicId newid = new ElectronicId(type, newvalue);
		
		id.setPrimitive(newid.getPrimitive());
		assertEquals(id.getPrimitive(), newid.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ElectronicId#ElectronicId(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testElectronicId() {
		assertNotNull(id);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ElectronicId#setType(java.lang.String)}.
	 */
	@Test
	public void testSetType() {
		String newtype = "Magstripe";
		id.setType(newtype);
		assertEquals(id.getType(),newtype);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ElectronicId#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValue() {
		String newvalue = "3303301a";
		id.setValue(newvalue);
		assertEquals(id.getValue(),newvalue);
	}

}

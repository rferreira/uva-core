/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

import com.uvasoftware.core.SIFRegister;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;
import com.uvasoftware.core.util.ParseSIFMode;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFRegisterTest {
	SIFRegister reg = new SIFRegister();
	com.uvasoftware.core.primitives.SIFRegister primitiveReg = ((com.uvasoftware.core.primitives.SIFMessage)reg.getPrimitive()).getSIFRegister();
	
	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#SIFRegister()}.
	 * <p>
	 * Compares primitive object values with config values 
	 */
	@Test
	public void testSIFRegister() {
		assertNotNull(reg);
		assertNotNull(reg.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#getMaxBuffer()}.
	 */
	@Test
	public void testGetMaxBuffer() {
		reg.setMaxBuffer(1);
		assertEquals(1,reg.getMaxBuffer());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#setMaxBuffer(java.math.integer)}.
	 * <p>
	 * Increments value of getMaxBuffer and tests the new value.
	 * <i>Note: Relies on getMaxBuffer()   
	 */
	@Test
	public void testSetMaxBuffer() {
		int newMaxBuff = 99;
		reg.setMaxBuffer(newMaxBuff);
		assertEquals(reg.getMaxBuffer(),newMaxBuff);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#getMode()}.
	 * <p>
	 * Compares values returned by the object's method and by the primitive's corresponding method 
	 */
	@Test
	public void testGetMode() {
		assertEquals(reg.getMode(),((com.uvasoftware.core.primitives.SIFMessage)reg.getPrimitive()).getSIFRegister().getSIFMode(),primitiveReg.getSIFMode());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#setMode(java.lang.String)}.
	 */
	@Test
	public void testSetMode() {
		String newmode = "Push";
		reg.setMode(newmode);
		assertEquals(reg.getMode(), ParseSIFMode.valueOf(newmode));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#getName()}.
	 * <p>
	 * Compares values returned by the object's method and by the primitive's corresponding method
	 */
	@Test
	public void testGetName() {
		assertEquals(reg.getName(),((com.uvasoftware.core.primitives.SIFMessage)reg.getPrimitive()).getSIFRegister().getSIFName(),primitiveReg.getSIFName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFRegister#setName(java.lang.String)}.
	 * <p>
	 * Passes setName the concatenation of the value of getName and "test", then asserts
	 * <i>Note: Relies on getName()   
	 */
	@Test
	public void testSetName() {
		String newName = reg.getName() + "test";
		reg.setName(newName);
		assertEquals(reg.getName(), newName);
	}

	@Test 
	public void setVersions() {
		reg.getVersions().add("1");
		reg.getVersions().add("2");
		assertEquals(2,reg.getVersions().size());
	}
}

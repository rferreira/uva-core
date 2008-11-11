/**
 * 
 */
package com.uvasoftware.core;


import static org.junit.Assert.*;
import org.junit.Test;

import com.uvasoftware.core.SIFUnRegister;

import junit.framework.*;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFUnregisterTest extends TestCase{

	/**
	 * Test method for {@link com.uvasoftware.core.SIFUnRegister#SIFUnregister()}.
	 */
	@Test
	public void testSIFUnregisterp() throws Exception{
		SIFUnRegister unreg = new SIFUnRegister();
		assertTrue(unreg.toString().contains("SIF_Unregister"));
		

		
	}

}

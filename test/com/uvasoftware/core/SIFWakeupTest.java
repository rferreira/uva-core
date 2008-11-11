/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;
import org.junit.Test;

import com.uvasoftware.core.SIFWakeup;

import junit.framework.*;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFWakeupTest extends TestCase{

	/**
	 * Test method for {@link com.uvasoftware.core.SIFWakeup#SIFWakeup()}.
	 */
	@Test
	public void testSIFWakeup() throws Exception{
		SIFWakeup wakeup = new SIFWakeup();
		
		assertTrue(wakeup.toString().contains("SIF_Wakeup"));
		

		
	}

}

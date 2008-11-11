/**
 * 
 */
package com.uvasoftware.core;

import org.junit.Test;

import com.uvasoftware.core.SIFPing;

import junit.framework.*;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFPingTest extends TestCase{

	/**
	 * Test method for {@link com.uvasoftware.core.SIFPing#SIFPing()}.
	 */
	@Test
	public void testSIFPing() throws Exception{
		SIFPing ping = new SIFPing();
				
		assertTrue(ping.toString().contains("SIF_Ping"));
		
	}

}

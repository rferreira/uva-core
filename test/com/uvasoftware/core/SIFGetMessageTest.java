/**
 * 
 */
package com.uvasoftware.core;

import com.uvasoftware.core.SIFGetMessage;

import org.junit.Test;
import junit.framework.*;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFGetMessageTest extends TestCase{

	/**
	 * Test method for {@link com.uvasoftware.core.SIFGetMessage#SIFGetMessage()}.
	 */
	@Test
	public void testSIFGetMessage() throws Exception{
		SIFGetMessage getmsg = new SIFGetMessage();
		
		assertTrue(getmsg.toString().contains("SIF_GetMessage"));

		
	}

}

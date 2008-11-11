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
public class AlertMessageTest {

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.AlertMessage#AlertMessage(com.uvasoftware.core.primitives.AlertMsg)}.
	 */
	@Test
	public void testAlertMessageAlertMsg() {
		AlertMessage msg = new AlertMessage("type","message");

		assertNotNull(msg);
		assertEquals("message",msg.getMessage());
		assertEquals("type",msg.getType());
	}
	
	@Test 
	public void testAlertMessageAlertMsg2() {
		
		AlertMessage msg2 = new AlertMessage("type","message");
		AlertMessage msg = new AlertMessage();
		msg.setPrimitive(msg2.getPrimitive());
		
		
		assertNotNull(msg);
		assertEquals("message",msg.getMessage());
		assertEquals("type",msg.getType());
		
	}

}

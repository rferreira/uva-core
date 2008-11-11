/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.net;

import com.uvasoftware.core.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rafael
 *
 */
public class MockZISConnectionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.net.MockZISConnection#sendMessage(com.uvasoftware.core.SIFMessage)}.
	 */
	@Test
	public void testSendMessage() throws Exception {
		//we're going to send a bogus message and expect an ack
		
		SIFZone zone = SIFZone.createSIFZone("B","mock://blah");
		SIFAck ack = zone.ping();
		
		// ah if everything worked there should be a sucess resp in here
		
		assertEquals(ack.getStatusCode(),Code.Status.SUCCESS);
		
	}

}

/**
 * 
 */
package com.uvasoftware.core;

import com.uvasoftware.core.net.HTTPSIFConnection;

import junit.framework.*;
import java.net.URI;

/**
 * @author mbabineau
 *
 */
public class HTTPSIFConnectionTest extends TestCase {

	HTTPSIFConnection testConn;
	public HTTPSIFConnectionTest(String name) {
		super(name);
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		testConn = new HTTPSIFConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.net.HTTPSIFConnection#sendMessage(SIFMessage)}.
	 */
	public void testSendMessage() {
		try {
			SIFPing ping = new SIFPing();
			testConn.setURI(new URI("http://google.com"));
			this.assertNull(testConn.sendMessage(ping));
		} catch (Exception e) {
			fail("I don't know what the f happened");
		}		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.net.HTTPSIFConnection#HTTPSIFConnection()}.
	 */
	public void testHTTPSIFConnection() {
		this.assertNotNull(testConn);
	}

}
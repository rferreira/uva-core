package com.uvasoftware.core.net;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.*;
import com.uvasoftware.core.exception.ProtocolParseException;
import com.uvasoftware.core.util.*;

public class HTTPSIFConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHTTPSIFConnection() throws URISyntaxException {
		HTTPSIFConnection conn = new HTTPSIFConnection();
		conn.setURI(new URI("http://ike/trac/login"));
		
	}
	
	
	@Test
	public void testHTTPSIFConnectionWithHTTPAUTH() throws URISyntaxException  {
		/*
		 * Clearly this will fail anywhere the ike server is unavailable 
		 */
		Config.getInstance().set(ConfigConstants.HTTP_AUTH_USERNAME, "ping");
		Config.getInstance().set(ConfigConstants.HTTP_AUTH_PASSWORD, "pong");
		
		HTTPSIFConnection conn = new HTTPSIFConnection();
		conn.setURI(new URI("http://ike/trac/login"));
		SIFPing ping = new SIFPing();
		try {
			// we expect this to not return a valid XML response
			conn.sendMessage( (SIFMessage) ping);
			
		} catch (ProtocolParseException ex1 ) {
			return;
		}catch (Exception ex) {
			fail();
		}
	}
	
	@Test
	public void testBuildHostHeader() throws URISyntaxException {
		java.net.URI u = new java.net.URI("http://blue:1234/foor?barr");
		HTTPSIFConnection conn = new HTTPSIFConnection();
		conn.setURI(u);
		assertEquals("blue:1234",conn.buildHostHeader());
	}

}

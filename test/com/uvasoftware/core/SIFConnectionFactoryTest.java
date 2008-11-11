package com.uvasoftware.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SIFConnectionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() throws Exception {
		ISIFConnection conn = SIFConnectionFactory.getConnection("https://www.example.com");
		assertNotNull(conn);
	
		
	}
	@Test
	public void testGetConnectionHTTPS() throws Exception  {
		ISIFConnection conn = SIFConnectionFactory.getConnection("http://www.example.com");
		assertNotNull(conn);
		
	}
	@Test
	public void testGetConnectionSHOULDFAIL() {
		// this should fail
		
		try {
			ISIFConnection conn = SIFConnectionFactory.getConnection("----://www.example.com");
		}catch (Exception e) {
			System.out.println(e);
			return;
		}
		
		fail();
		
		
		
	}

}

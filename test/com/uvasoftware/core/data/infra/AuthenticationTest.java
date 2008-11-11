package com.uvasoftware.core.data.infra;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationTest {
	Authentication a = new Authentication("1","2");
	@Test
	public void testAuthenticationAuthentication() {
		Authentication b = new Authentication( (com.uvasoftware.core.primitives.Authentication) a.getPrimitive());
		assertEquals("1",b.getSIFRefId());
		
	}

	@Test
	public void testAuthenticationStringString() {
		Authentication c = new Authentication("1","2");
		assertEquals("1",c.getSIFRefId());
	}

	@Test
	public void testAddAuthenticationInfo() {
		a.addAuthenticationInfo(new AuthenticationInfo("Name",AuthenticationInfo.SystemType.Application));
	}

	@Test
	public void testGetAuthenticationInfo() {
		Authentication z = new Authentication("1","2");
		z.addAuthenticationInfo(new AuthenticationInfo("Name",AuthenticationInfo.SystemType.Application));
		assertNotNull(z.getAuthenticationInfo());
	}

	@Test
	public void testGetRefId() {
		assertEquals("1",a.getSIFRefId());
	}

}

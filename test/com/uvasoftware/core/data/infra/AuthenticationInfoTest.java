package com.uvasoftware.core.data.infra;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationInfoTest {

	@Test
	public void testAuthenticationInfoAuthenticationInfo() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		AuthenticationInfo b = new AuthenticationInfo( (com.uvasoftware.core.primitives.AuthenticationInfo) a.getPrimitive());
		
		assertEquals("blue",b.getSystemName());
	}

	@Test
	public void testAuthenticationInfoStringSystemType() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		
		assertEquals("blue",a.getSystemName());
	}

	@Test
	public void testGetSysteName() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		
		assertEquals("blue",a.getSystemName());
	}

	@Test
	public void testGetSystemType() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		
		assertEquals(AuthenticationInfo.SystemType.Application,a.getSystemType());
	}

	@Test
	public void testSetUserName() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		a.setUserName("A");
		assertEquals("A",a.getUserName());
	}

	@Test
	public void testSetPassword() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		a.setPassword(AuthenticationInfo.PasswordAlgorithm.base64, "A", "B");
		assertEquals(AuthenticationInfo.PasswordAlgorithm.base64,a.getPasswordAlgorithm());
		assertEquals("A",a.getPasswordKeyName());
		assertEquals("B",a.getPassword());
	}


	@Test
	public void testSetDistinguishedName() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		a.setDistinguishedName("A");
		
	}

	@Test
	public void testGetDistinguishedName() {
		AuthenticationInfo a = new AuthenticationInfo("blue", AuthenticationInfo.SystemType.Application);
		a.setDistinguishedName("A");
		assertEquals("A",a.getDistinguishedName());
	}

}

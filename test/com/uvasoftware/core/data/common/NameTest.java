package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {
	
	
		

	@Test
	public void testGetPrimitive() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		assertNotNull(name.getPrimitive());
	}

	@Test
	public void testSetPrimitive() {
		Name n2 = new Name(Name.Type.CURRENT_LEGAL,"A","B");
		Name n3 = new Name(Name.Type.CURRENT_LEGAL,"C","D");
		
		n3.setPrimitive(n2.getPrimitive());
		
		assertEquals(n2.getLastName(),n3.getLastName());
	}

	@Test
	public void testName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		assertNotNull(name);
	}

	@Test
	public void testSetLastName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setLastName("b");
		assertEquals(name.getLastName(),"b");
	}

	@Test
	public void testSetFirstName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setFirstName("b");
		assertEquals(name.getFirstName(),"b");
	}

	@Test
	public void testSetPrefix() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setPrefix("B");
		assertEquals(name.getPrefix(),"B");
	}


	@Test
	public void testSetMiddleName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setMiddleName("B");
		assertEquals(name.getMiddleName(),"B");
	}


	@Test
	public void testSetSuffix() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setSuffix("B");
		assertEquals(name.getSuffix(),"B");
	}


	@Test
	public void testSetPreferredName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setPreferredName("B");
		assertEquals(name.getPreferredName(),"B");
	}

	
	@Test
	public void testSetShortName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setShortName("B");
		assertEquals(name.getShortName(),"B");
	}


	@Test
	public void testSetFullName() {
		Name name = new Name(Name.Type.CURRENT_LEGAL,"John","Doe");
		name.setFullName("blah blah");
		assertEquals(name.getFullName(),"blah blah");
	}


}

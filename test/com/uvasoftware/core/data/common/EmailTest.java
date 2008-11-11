package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author raferrei
 *
 */
public class EmailTest {

	String EMAIL = "a@b.com";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmail() {
		Email e = new Email(Email.Type.PRIMARY,EMAIL);
		assertNotNull(e);
	}

	@Test
	public void testGetType() {
		Email e = new Email(Email.Type.PRIMARY,EMAIL);
		assertEquals(e.getType(), Email.Type.PRIMARY);
		
	}

	@Test
	public void testSetType() {
		Email e = new Email(Email.Type.PRIMARY,EMAIL);
		e.setType(Email.Type.ALTERNATE3);
		assertEquals(e.getType(),Email.Type.ALTERNATE3);
	}

	@Test
	public void testGetValue() {
		Email e = new Email(Email.Type.PRIMARY,EMAIL);
		assertEquals(e.getValue(),EMAIL);
		
	}

	@Test
	public void testSetValue() {
		Email e = new Email(Email.Type.PRIMARY,null);
		e.setValue(EMAIL);
		assertEquals(EMAIL,e.getValue());
	}

	@Test
	public void testGetPrimitive() {
		Email e = new Email(null,null);
		Email e2 = new Email(null,null);
		
		e.setPrimitive(e2.getPrimitive());
		
		assertEquals(e.getPrimitive(),e2.getPrimitive());
	}

	
}

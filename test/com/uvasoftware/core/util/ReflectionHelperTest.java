package com.uvasoftware.core.util;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReflectionHelperTest {
	
	public class Blue  {
		private boolean hidden = false;
		
		public String echo (String str) {
			return(str);
		}
		
		public String echo2() {
			return("A");
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPrivateField() throws Exception{
		Blue o = new Blue();
		Field f = ReflectionHelper.getPrivateField(o, "hidden");
		assertEquals(false,f.get(o));
	}

	@Test
	public void testCallMethodObjectStringObjectArray() throws Exception{
		Blue o = new Blue();
		Object [] args = {"A"};
		
		assertEquals("A", ReflectionHelper.callMethod(o, "echo", args, String.class));
	}

	@Test
	public void testCallMethodObjectString() throws Exception{
		Blue o = new Blue();
		assertEquals("A", ReflectionHelper.callMethod(o, "echo2"));
	}

}

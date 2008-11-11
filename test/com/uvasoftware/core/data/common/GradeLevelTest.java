/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class GradeLevelTest {
	String code = "04";
	
	GradeLevel grade = new GradeLevel(code);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevel#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(grade.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevel#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String newcode = "UN";
		GradeLevel newgrade = new GradeLevel(newcode);
		
		grade.setPrimitive(newgrade.getPrimitive());
		assertEquals(grade.getPrimitive(),newgrade.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevel#GradeLevel(java.lang.String)}.
	 */
	@Test
	public void testGradeLevel() {
		assertNotNull(grade);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevel#setCode(java.lang.String)}.
	 */
	@Test
	public void testSetCode() {
		String newcode = "PK";
		grade.setCode(newcode);
		assertEquals(grade.getCode(),newcode);
	}

}

/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Rafael Ferreira
 *
 */
public class GradeLevelsTest {

	GradeLevels gds = null;
	
	public GradeLevelsTest() {
		gds = new GradeLevels();
		GradeLevel gd = new GradeLevel(GradeLevel.Code.GRADE_1);
		
		gds.addGradeLevel(gd);
	}
	/** 
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevels#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(gds.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevels#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		GradeLevels gds2 = new GradeLevels();
		gds2.setPrimitive(gds.getPrimitive());
		assertEquals(gds2.getGradeLevel().size(),1);
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.GradeLevels#addGradeLevel(com.uvasoftware.core.data.common.GradeLevel)}.
	 */
	@Test
	public void testAddGradeLevel() {
		gds.addGradeLevel(new GradeLevel(GradeLevel.Code.GRADE_10));
		assertEquals(GradeLevel.Code.GRADE_10,gds.getGradeLevel().get(1).getCode());
	}


}

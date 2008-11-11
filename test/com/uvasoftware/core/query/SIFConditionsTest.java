/**
 * 
 */
package com.uvasoftware.core.query;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Rafael Ferreira
 *
 */
public class SIFConditionsTest {

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#SIFConditions(com.uvasoftware.core.primitives.SIFConditions)}.
	 */
	@Test
	public void testSIFConditionsSIFConditions() {
		assertNotNull(new SIFConditions( (com.uvasoftware.core.primitives.SIFConditions) new SIFConditions(SIFConditions.Type.And).getPrimitive()));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#SIFConditions(java.lang.String)}.
	 */
	@Test
	public void testSIFConditionsString() {
		assertEquals(SIFConditions.Type.And,new SIFConditions(SIFConditions.Type.And).getType());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#addSIFCondition(com.uvasoftware.core.query.SIFCondition)}.
	 */
	@Test
	public void testAddSIFCondition() {
		SIFConditions s = new SIFConditions(SIFConditions.Type.Or);	
		s.addSIFCondition(new SIFCondition("A",SIFCondition.Operator.EQ,"B"));
		assertEquals("B",s.getSIFConditions().get(0).getValue());
	
	}

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#getSIFConditions()}.
	 */
	@Test
	public void testGetSIFConditions() {
		SIFConditions s = new SIFConditions(SIFConditions.Type.Or);	
		s.addSIFCondition(new SIFCondition("A",SIFCondition.Operator.EQ,"B"));
		assertEquals("B",s.getSIFConditions().get(0).getValue());
	
		s.addSIFCondition(new SIFCondition("A",SIFCondition.Operator.EQ,"B"));
		assertEquals(2,s.getSIFConditions().size() );
	
	}

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		SIFConditions s = new SIFConditions(SIFConditions.Type.Or);	
		s.addSIFCondition(new SIFCondition("A",SIFCondition.Operator.EQ,"B"));
		assertEquals("B",s.getSIFConditions().get(0).getValue());
	
		assertNotNull(s.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.query.SIFConditions#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		SIFConditions s = new SIFConditions(SIFConditions.Type.Or);	
		s.addSIFCondition(new SIFCondition("A",SIFCondition.Operator.EQ,"B"));
		assertEquals("B",s.getSIFConditions().get(0).getValue());
		
		SIFConditions s1 = new SIFConditions(SIFConditions.Type.None);
		s1.setPrimitive((com.uvasoftware.core.primitives.SIFConditions) s.getPrimitive());
		
		assertEquals("B",s1.getSIFConditions().get(0).getValue());
		assertEquals(1,s1.getSIFConditions().size() );
		assertEquals(SIFConditions.Type.Or, s1.getType());
		
	
	}

}

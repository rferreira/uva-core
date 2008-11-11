package com.uvasoftware.core.query;

import static org.junit.Assert.*;

import org.junit.Test;

public class SIFConditionTest {


	@Test
	public void testSIFConditionStringOperatorString() {
		assertEquals("Name",(new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getElementName() ));
		
	}

	@Test
	public void testGetElementName() {
		assertEquals("Name",(new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getElementName() ));
	}

	@Test
	public void testGetValue() {
		assertEquals("blue",(new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getValue() ));
	}

	@Test
	public void testGetOperator() {
		assertEquals(SIFCondition.Operator.EQ,(new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getOperator() ));
	}

	@Test
	public void testGetPrimitive() {
		assertNotNull((new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getPrimitive()));
	}

	@Test
	public void testSetPrimitive() {
		SIFCondition s = new SIFCondition( (com.uvasoftware.core.primitives.SIFCondition) new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getPrimitive() );
		assertEquals(SIFCondition.Operator.EQ,(new SIFCondition("Name",SIFCondition.Operator.EQ,"blue").getOperator() ));
	}

}

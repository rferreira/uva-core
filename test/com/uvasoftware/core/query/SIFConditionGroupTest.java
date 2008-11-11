package com.uvasoftware.core.query;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.SIFObjectName;



public class SIFConditionGroupTest {

	@Test
	public void testSIFConditionGroupSIFConditionGroup() {
		SIFConditionGroup s = new SIFConditionGroup(SIFConditionGroup.Type.And);
		SIFConditionGroup monkey = new SIFConditionGroup((com.uvasoftware.core.primitives.SIFConditionGroup) s.getPrimitive());
		assertNotNull(monkey);
	}

	@Test
	public void testSIFConditionGroupType() {
		SIFConditionGroup monkey = new SIFConditionGroup(SIFConditionGroup.Type.Or);
		assertNotNull(monkey);
		
	}

	@Test
	public void testAddConditions() {
		// COMPOUND QUERY TEST
		SIFQuery q = new SIFQuery(SIFObjectName.StudentPersonal);
		SIFConditions conds = new SIFConditions(SIFConditions.Type.And);
		conds.addSIFCondition(new SIFCondition("Name/Last",SIFCondition.Operator.EQ,"Smith"));
		conds.addSIFCondition(new SIFCondition("Name/First",SIFCondition.Operator.EQ,"John"));
		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.None);
		g.addConditions(conds);
		q.setSIFConditionGroup(g);
	}

	@Test
	public void testGetSIFConditions() {
		// COMPOUND QUERY TEST
		SIFQuery q = new SIFQuery(SIFObjectName.StudentPersonal);
		SIFConditions conds = new SIFConditions(SIFConditions.Type.And);
		conds.addSIFCondition(new SIFCondition("Name/Last",SIFCondition.Operator.EQ,"Smith"));
		conds.addSIFCondition(new SIFCondition("Name/First",SIFCondition.Operator.EQ,"John"));
		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.None);	
		g.addConditions(conds);
		q.setSIFConditionGroup(g);
		
		assertTrue(q.getSIFConditionGroup().getSIFConditions().get(0).getSIFConditions().size() == 2);
		assertEquals("Smith",q.getSIFConditionGroup().getSIFConditions().get(0).getSIFConditions().get(0).getValue());
		
	}

	@Test
	public void testGetType() {
		SIFConditionGroup monkey = new SIFConditionGroup(SIFConditionGroup.Type.Or);
		assertTrue(monkey.getType() == SIFConditionGroup.Type.Or);
		
	}

	@Test
	public void testGetPrimitive() {
		SIFConditionGroup monkey = new SIFConditionGroup(SIFConditionGroup.Type.Or);
		assertNotNull(monkey.getPrimitive());
	}

	@Test
	public void testSetPrimitive() {
		SIFConditionGroup s = new SIFConditionGroup(SIFConditionGroup.Type.And);
		SIFConditionGroup monkey = new SIFConditionGroup((com.uvasoftware.core.primitives.SIFConditionGroup) s.getPrimitive());
		assertTrue(monkey.getType() == SIFConditionGroup.Type.And);
	}

}

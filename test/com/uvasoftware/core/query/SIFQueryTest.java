package com.uvasoftware.core.query;

import com.uvasoftware.core.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class SIFQueryTest {
	@Test
	public void testSetSIFObjectName() {
		SIFQuery q = new SIFQuery(SIFObjectName.ActivityProvider);

		assertTrue(q.toString().contains("<SIF_QueryObject ObjectName=\"ActivityProvider\"/>"));
	}

	@Test
	public void testAddConditionSIFCondition() {
		SIFQuery query = new SIFQuery(SIFObjectName.StudentPersonal);

		query.setSIFCondition(new SIFCondition("Name/LastName", SIFCondition.Operator.EQ, "Smith"));
		System.out.println(query);
		assertTrue(query.toString().contains("ObjectName=\"StudentPersonal\"/>"));
		assertTrue(query.toString().contains("<SIF_Conditions Type=\"None\"><SIF_Condition><SIF_Element>Name/LastName</SIF_Element><SIF_Operator>EQ</SIF_Operator><SIF_Value>Smith</SIF_Value></SIF_Condition></SIF_Conditions>"));
	}

	@Test
	public void testAddConditionStringOperatorString() {
		SIFQuery query = new SIFQuery(SIFObjectName.StudentPersonal);

		query.setSIFCondition(new SIFCondition("Name/LastName", SIFCondition.Operator.EQ, "Smith"));
		System.out.println(query);
		assertTrue(query.toString().contains("ObjectName=\"StudentPersonal\"/>"));
		assertTrue(query.toString().contains("<SIF_Conditions Type=\"None\"><SIF_Condition><SIF_Element>Name/LastName</SIF_Element><SIF_Operator>EQ</SIF_Operator><SIF_Value>Smith</SIF_Value></SIF_Condition></SIF_Conditions>"));
		
	}
	
	@Test
	public void testSetSIFConditionGroup() {
		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.And);
		SIFQuery          q = new SIFQuery(SIFObjectName.ActivityProvider);

		q.setSIFConditionGroup(g);
		System.out.println(q);
		assertTrue(q.toString().contains("<SIF_ConditionGroup Type=\"And\"/>"));
	}

	@Test
	public void testGetSIFConditionGroup() {
		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.And);
		SIFQuery          q = new SIFQuery(SIFObjectName.ActivityProvider);

		q.setSIFConditionGroup(g);
		
		System.out.println(q);
		assertTrue(q.toString().contains("<SIF_ConditionGroup Type=\"And\"/>"));
		assertEquals(SIFConditionGroup.Type.And, q.getSIFConditionGroup().getType());
	}

	@Test
	public void testGetPrimitive() {
		SIFQuery query = new SIFQuery(SIFObjectName.StudentPersonal);
		query.setSIFCondition(new SIFCondition("Name/LastName", SIFCondition.Operator.EQ, "Smith"));
		
		SIFQuery query2 = new SIFQuery(SIFObjectName.StudentPersonal);
		query2.setSIFCondition(new SIFCondition("Name/LastName", SIFCondition.Operator.EQ, "Joe"));
		
		query.setPrimitive(query2.getPrimitive());
		
		assertEquals("Joe",query.getSIFCondition().getValue());
	}

	@Test
	public void testStringSanitation() {
		SIFQuery query = new SIFQuery(SIFObjectName.SIFZoneStatus);
		System.out.println(query);
		assertTrue(query.toString().contains("SIF_ZoneStatus"));
	
		query = new SIFQuery(SIFObjectName.AccountingPeriod);
		assertTrue(query.toString().contains("AccountingPeriod"));
		
		query = new SIFQuery(SIFObjectName.SIFLogEntry);
		assertTrue(query.toString().contains("SIF_LogEntry"));
	}
}



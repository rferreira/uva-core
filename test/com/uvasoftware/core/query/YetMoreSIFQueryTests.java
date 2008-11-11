/**
 * 
 */
package com.uvasoftware.core.query;

import org.junit.Test;
import static org.junit.Assert.*;
import com.uvasoftware.core.*;
/**
 * @author Rafael Ferreira
 *
 */
public class YetMoreSIFQueryTests {
	@Test
	public void simpleANDQueryTests() {
		
		// COMPOUND QUERY TEST
		SIFQuery q = new SIFQuery(SIFObjectName.StudentPersonal);
		SIFConditions conds = new SIFConditions(SIFConditions.Type.And);
		conds.addSIFCondition(new SIFCondition("Name/Last",SIFCondition.Operator.EQ,"Smith"));
		conds.addSIFCondition(new SIFCondition("Name/First",SIFCondition.Operator.EQ,"John"));
		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.None);
		g.addConditions(conds);
		q.setSIFConditionGroup(g);
		System.out.println(q);
		assertTrue(q.toString().contains("SIF_QueryObject ObjectName=\"StudentPersonal\"/><SIF_ConditionGroup Type=\"None\"><SIF_Conditions Type=\"And\"><SIF_Condition><SIF_Element>Name/Last</SIF_Element><SIF_Operator>EQ</SIF_Operator><SIF_Value>Smith</SIF_Value></SIF_Condition><SIF_Condition><SIF_Element>Name/First</SIF_Element><SIF_Operator>EQ</SIF_Operator><SIF_Value>John</SIF_Value></SIF_Condition>"));
	}
	
}

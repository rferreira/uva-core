/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.query.SIFConditions.Type;


/**
 * This class represents a SIF <code>SIF_ConditionGroup</code> object
 * 
 * <p>
 * In a nutshell, <code>SIFConditionGroup</code> are a bucket of conditions joined by an association type
 * <p>
 * <code>
 * 		SIFQuery q = new SIFQuery(SIFObjectName.StudentPersonal);<br>
 *		SIFConditions conds = new SIFConditions(SIFConditions.Type.AND);<br>
 *		conds.addSIFCondition(new SIFCondition("Name/Last",SIFCondition.Operator.EQ,"Smith"));<br>
 *		conds.addSIFCondition(new SIFCondition("Name/First",SIFCondition.Operator.EQ,"John"));<br>
 *		SIFConditionGroup g = new SIFConditionGroup(SIFConditionGroup.Type.NONE);<br>
 *		g.addConditions(conds);<br>
 *		q.setSIFConditionGroup(g);<br>
 * </code>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFConditionGroup implements ISIFObject{
	
		
	/**
	 * Represents valid SIF condition types
	 *
	 */
	public enum Type { And, Or, None }
		
		
		
	private static Logger log = Logger.getLogger(SIFConditionGroup.class.toString());
	com.uvasoftware.core.primitives.SIFConditionGroup primitive = new com.uvasoftware.core.primitives.SIFConditionGroup();
	
	/**
	 * Creates a new <code>SIFConditionGroup</code> from an XML primitive
	 * @param primitive
	 */
	public SIFConditionGroup (com.uvasoftware.core.primitives.SIFConditionGroup primitive) {
		this.primitive = primitive;
	}
	
	/**
	 * Creates a new <code>SIFConditionGroup</code> with an specific association type
	 * @param type the association type
	 */
	public SIFConditionGroup(SIFConditionGroup.Type type) {
		primitive.setType(com.uvasoftware.core.primitives.ConditionType.fromValue(type.toString()));
		
	}
	
	/**
	 * Adds a new group of <code>SIFConditions</code> to this condition group
	 * @param conditions the conditions to be addded
	 */
	public void addConditions(SIFConditions conditions) {
		this.primitive.getSIFConditions().add((com.uvasoftware.core.primitives.SIFConditions) conditions.getPrimitive());
	}
	

	/**
	 * Returns a list of all the <code>SIFConditons</code> contained in this object
	 * @return the list of <code>SIFCondtions</code>
	 */
	public List <SIFConditions> getSIFConditions() {
		ArrayList <SIFConditions> resp = new ArrayList <SIFConditions>();
		for (com.uvasoftware.core.primitives.SIFConditions e: primitive.getSIFConditions() ) {
			SIFConditions m = new SIFConditions(e);
			resp.add(m);			
		}
		return(resp);
	}
	
	/**
	 * Returns the association type of this condition group
	 * @return the type of the association 
	 */
	public SIFConditionGroup.Type getType() {
		return( SIFConditionGroup.Type.valueOf(primitive.getType().value()) );
	}
	
	/**
	 * Returns the primitive representation of this object
	 * 
	 * @see com.uvasoftware.core.ISIFObject#getPrimitive()
	 */
	public Object getPrimitive() {
		return(primitive);
	}
	
	/**
	 * Sets the primitive representation of this object
	 */
	public void setPrimitive(Object primitive) {
		this.primitive = (com.uvasoftware.core.primitives.SIFConditionGroup) primitive;

	}

}

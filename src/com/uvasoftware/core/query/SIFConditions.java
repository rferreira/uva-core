/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.query;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.SIFObjectName;

/**
 * This class represents a SIF <code>SIF_Conditions</code> object
 * 
 * <p>
 * In a nutshell, <code>SIFConditions</code> are a bucket of conditions joined by an association type
 * <p>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFConditions implements ISIFObject {
	
	/**
	 * Boolean operator for joining conditions
	 */
	public enum Type { And, Or, None }	
		
	com.uvasoftware.core.primitives.SIFConditions primitive = new com.uvasoftware.core.primitives.SIFConditions();
	
	/**
	 * Creates a new <code>SIFConditions</code> object from an XML primitive
	 * @param primitive
	 */
	public SIFConditions(com.uvasoftware.core.primitives.SIFConditions primitive) {
		this.primitive = primitive;
	}
	
	/**
	 * Creates a new <code>SIFConditions</code> with an specific association type
	 * @param type the association type
	 */
	public SIFConditions(SIFConditions.Type type) {
		
		primitive.setType(com.uvasoftware.core.primitives.ConditionType.fromValue(type.toString()));
		
		
	}
	
	/**
	 * Returns the association type of these conditions
	 * @return the association type
	 */
	public SIFConditions.Type getType() {
		return(SIFConditions.Type.valueOf(primitive.getType().value()));
	}
	/**
	 * Adds a new <code>SIFCondition</code> to this <code>SIFConditions</code> structure
	 * @param condition
	 */
	public void addSIFCondition(SIFCondition condition) {
		this.primitive.getSIFCondition().add((com.uvasoftware.core.primitives.SIFCondition) condition.getPrimitive());
	}
	
	/**
	 * Returns a list of all the <code>SIFCondition</code>  contained in this message
	 * @return a list containing a bunch of SIFCondition 
	 */
	//TODO: LAMESPEC
	public List <SIFCondition> getSIFConditions() {
		ArrayList <SIFCondition> resp = new ArrayList <SIFCondition>();
		for (com.uvasoftware.core.primitives.SIFCondition e: primitive.getSIFCondition() ) {
			SIFCondition m = new SIFCondition(e);
			resp.add(m);			
		}
		return(resp);
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
		this.primitive = (com.uvasoftware.core.primitives.SIFConditions) primitive;

	}
	

}

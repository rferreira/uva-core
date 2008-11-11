/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.query;
import com.uvasoftware.core.ISIFObject;

/**
 * Represents a condition to the SIF query 
 * @author Rafael Ferreira
 *
 */
public class SIFCondition implements ISIFObject {
	
	/**
	 * Represents the logical operators that can be used in a SIFCondition. 
	 * <p>
	 * Please note that EQ is the only supported on version 1.5 of the SIF protocol
	 * 
	 *
	 */
	public enum Operator { EQ }
	
		
	com.uvasoftware.core.primitives.SIFCondition primitive = new com.uvasoftware.core.primitives.SIFCondition();
	
	public SIFCondition(com.uvasoftware.core.primitives.SIFCondition primitive) {
		this.primitive = primitive;
	}
	
	public SIFCondition(String elementName, SIFCondition.Operator oper, String value) {
		primitive.setSIFElement(elementName);
		primitive.setSIFOperator(com.uvasoftware.core.primitives.OperatorType.fromValue(oper.toString()));
		primitive.setSIFValue(value);
	}
	
	public String getElementName() {
		return(primitive.getSIFElement());
	}
	
	public String getValue() {
		return(primitive.getSIFValue());
	}
	
	public SIFCondition.Operator getOperator() {
		return( Operator.valueOf(primitive.getSIFOperator().value()));
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
		this.primitive = (com.uvasoftware.core.primitives.SIFCondition) primitive;

	}
	

}

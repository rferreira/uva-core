package com.uvasoftware.core.query;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import javax.xml.bind.JAXBContext;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.SIFObjectName;
import com.uvasoftware.core.util.PrimitiveHelper;


/**
 * This class represents a <code>SIF_Query</code> object and it is used to query a Zone for information
 * 
 *<p>
 *
 *Using the SIFQuery object:<br/>
 *<code>
 *SIFQuery query = new SIFQuery(SIFObjectName.StudentPersonal);<br>
 *query.addCondition("Name/LastName", SIFCondition.Operator.EQ, "Smith");<br>
 *</code>
 *<p>
 *
 *<b>Import Notes:</b><br>
 *- The addCondition() method is a shortcut (around condition grouping) and it creates a single condition group with no association. If you don't know what SIFConditionGroups are you should not have to worry about it :)<br>
 *<p>
 *
 *@see SIFConditionGroup
 *@see SIFConditions
 *@author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFQuery implements ISIFObject {
	
	com.uvasoftware.core.primitives.SIFQuery primitive = new com.uvasoftware.core.primitives.SIFQuery();
		
	private static Logger log = Logger.getLogger(SIFQuery.class);
	
	/**
	 * Creates a new SIFQuery from an XML primitive
	 * @param primitive the XML primitive
	 */
	public SIFQuery(com.uvasoftware.core.primitives.SIFQuery primitive) {
		init();
		this.primitive = primitive;
	}
	
	/**
	 * Creates a new SIFQuery object 
	 * @param name the name of the SIF object being queried for
	 */
	public SIFQuery(SIFObjectName name) {
		init();
		setSIFObjectName(name);
	}
	
	
	/**
	 * Creates a new SIFQuery object 
	 * @param name the name of the SIF object being queried for
	 */
	public SIFQuery(String name) {
		init();
		primitive.getSIFQueryObject().setObjectName(name);
	}
	
	private void init() {
		log.debug("new sif query being created");
		primitive.setSIFQueryObject(new com.uvasoftware.core.primitives.SIFQueryObject());
	}
	
	/**
	 * Sets the name of the SIF object being queried for
	 * @param name the name of the SIF object
	 */
	public void setSIFObjectName(SIFObjectName name) {
		String s = _sanitize(name.toString());
		this.primitive.getSIFQueryObject().setObjectName(s);
	}
	
	/**
	 * Gets the name of the SIF object being queried for
	 * 
	 */
	public SIFObjectName getSIFObjectName() {
		
		return(SIFObjectName.valueOf(_desanitize(primitive.getSIFQueryObject().getObjectName())));
	}
	
	/*
	 * Condition Handling 
	 */

	
	/**
	 * Adds a new <code>SIF_Condition</code> to this query. Conditions narrow down the scope of the query.<br>
	 * <p>
	 * 
	 * @param condition the condition to be added
	 */
	
	public synchronized void setSIFCondition(SIFCondition condition) {
		
		
		// adding logic for a all None query 
		 SIFConditionGroup sg = new SIFConditionGroup(SIFConditionGroup.Type.None);
		 SIFConditions conds = new SIFConditions(SIFConditions.Type.None);
		 conds.addSIFCondition(condition);
		 sg.addConditions(conds);
		 setSIFConditionGroup(sg);
		 			
	}
	
	/**
	 * Returns a the single condition contained in this query
	 * @return the SIFCondition contained in this query
	 */
	public SIFCondition getSIFCondition() {
		return( new SIFCondition(primitive.getSIFConditionGroup().getSIFConditions().get(0).getSIFCondition().get(0)));
	}
	
	
	/**
	 * Adds a new condition to the query without creating a <code>SIFCondition</code> object first. 
	 * @param elementName the SIF element target of this condition (XPATH notation is OK)
	 * @param operator the logical operator for the query
	 * @param value the condition to be matched against
	 */
	public void setSIFCondition(String elementName, SIFCondition.Operator operator, String value) {
		setSIFCondition(new SIFCondition(elementName,operator,value ));
	}
	
	
	/*
	 * MISC
	 */
	
	/**
	 * Sets the <code>SIFConditionGroup</code> for this query
	 * @param value 
	 */
	public void setSIFConditionGroup(SIFConditionGroup value) {
		this.primitive.setSIFConditionGroup( (com.uvasoftware.core.primitives.SIFConditionGroup) value.getPrimitive());
	}
	
	/**
	 * Returns the <code>SIFConditionGroup</code> of this query
	 * @return the SIFConditionGroup in this query
	 */
	public SIFConditionGroup getSIFConditionGroup() {
		return(new SIFConditionGroup(primitive.getSIFConditionGroup()));
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
		this.primitive = (com.uvasoftware.core.primitives.SIFQuery) primitive;

	}
	
	
	/**
	 * Marshals the SIF object to XML 
	 * <b>Note:</b> this is a very expensive operation and it should not be used lightly. 
	 */
	public String toString() {
        try {
        	
        	// getting primitive
			Method method = this.getClass().getMethod("getPrimitive");
			Object primitive = method.invoke(this, new Object[0]);
        	
        	
        	// We need to setup the jaxb with the SIF primitive not the facade!
            JAXBContext jb = JAXBContext.newInstance(primitive.getClass());
            ByteArrayOutputStream o = new ByteArrayOutputStream();
            jb.createMarshaller().marshal(primitive,o);
            return(o.toString());
            

        } catch (Exception ex) {
            log.error(ex);
            ex.printStackTrace();
        }
        return(null);
	}
	
	/**
	 * This method takes a string and expands SIF* into SIF_*
	 * @param v
	 * @return
	 */
	private String _sanitize(String v) {
		return(v.replace("SIF", "SIF_"));
	}
	
	/**
	 * This method takes a string and expands SIF_ into SIF*
	 * @param v
	 * @return
	 */
	private String _desanitize(String v) {
		return(v.replace("SIF_", "SIF"));
	}
	
	
}

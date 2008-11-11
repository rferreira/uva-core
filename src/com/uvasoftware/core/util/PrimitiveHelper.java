package com.uvasoftware.core.util;


import com.uvasoftware.core.*;

import org.apache.log4j.Logger;


/**
 * Set of many static functions aimed at making it easier to play with jaxb primitives.<br>
 * Note: this uses reflection which might negatively impact performance
 */
public class PrimitiveHelper {
	
	private static Logger log = Logger.getLogger(PrimitiveHelper.class);
	
	
	
	/**
	 * returns the SIFObjectName that matches an XML primitive or null if it can't figure it out
	 * @param primitive
	 * @return the SIFObjectName representation of the object
	 */
	public static SIFObjectName getSIFObjectNameFromPrimitive(Object primitive) {
		// special cases (infra stuff)
		
		Class klass = primitive.getClass();
		
		if (klass == com.uvasoftware.core.data.infra.SIFZoneStatus.class) {
			return (SIFObjectName.SIFZoneStatus);
		}
		
		String name = klass.getName();
		
		if (name.lastIndexOf('.') > 0) {
			name = name.substring(name.lastIndexOf('.') +1);
			
		}
		
		name = name.replace('$','.');
		
		SIFObjectName n = SIFObjectName.valueOf(name);
		
		return n;
	}
	
	/**
	 * Returns the correct wrapper object for a primitive type or null if it can't figure it out
	 * @param primitive - the primitive you would like to wrap
	 * @return the wrapper representation of the primitive
	 * @throws Exception
	 */
	public static ISIFObject getWrapperFromPrimitive(Object primitive) throws Exception {

		SIFObjectName name = getSIFObjectNameFromPrimitive(primitive);
		
		
		ISIFObject o = (ISIFObject) Class.forName(Config.getInstance().getClassMap(name)).newInstance();
		o.setPrimitive(primitive);
			
		if (o != null ) {
			return (o);
		}
	
		return(null);
	
		
	}
}

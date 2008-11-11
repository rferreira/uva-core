/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.util;

import java.lang.reflect.*;
import org.apache.log4j.Logger;


/**
 * Helper class for dealing with reflection tasks
 * @author <a href="raf@uvasoftware.com">Rafael Ferreira</a>
 *
 */
public class ReflectionHelper {

	private static Logger log = Logger.getLogger(ReflectionHelper.class);  
	
	/**
	 * Returns a private field from a class by using some go-go-gadget reflection trick
	 * @param o
	 * @param fieldName
	 * @return
	 */
	public static Field getPrivateField (Object o, String fieldName) throws Exception {

		log.debug("dynamically pulling private field name:" + fieldName + " from object type:" + o.getClass());
		
        Field field = o.getClass().getDeclaredField(fieldName);
	    field.setAccessible(true);
	    return(field);
			    
	 }
	
	/**
	 * Calls a method via reflection
	 * @param o the target object
	 * @param methodName the name of the method
	 * @param args an array containing the method arguments
	 * @param parameterTypes this is the signature for the method to be retrived
	 * @return the return value from calling the method
	 * @throws Exception
	 */
	public static Object callMethod(Object o, String methodName, Object[] args, Class ... parameterTypes) throws Exception {
	
		log.debug("dynamically dispatching method:" + methodName + " from object type:" + o.getClass());
		
		Method method = o.getClass().getMethod(methodName, parameterTypes);
		Object ret = method.invoke(o, args);
		return(ret);
	}
	/**
	 * Calls a method via reflection with no arguments
	 * @param o the target object
	 * @param methodName the name of the method
	 * @return the return value from calling the method
	 * @throws Exception
	 */
	public static Object callMethod(Object o, String methodName) throws Exception {
		return(callMethod(o, methodName, new Object[0]));
	}
	
}

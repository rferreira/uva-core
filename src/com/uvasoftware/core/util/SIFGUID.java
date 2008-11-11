package com.uvasoftware.core.util;
import java.util.UUID;

/**
 * Generates a SIF compliant GUID 
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFGUID {
	
	
	/**
	 *  Generates a new SIFGUID 
	 *  @return a string representation of a SIF GUID
	 */
	public static String next() {
		return ( (UUID.randomUUID()).toString().replaceAll("-","").toUpperCase() );
    }

}

package com.uvasoftware.core.util;

import org.apache.log4j.Logger;
/**
 * Helper class for converting a string into a allows sif agent mode (either "Pull" or "Push")
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class ParseSIFMode {
	private static Logger log = Logger.getLogger(ParseSIFMode.class);
	
	public static String valueOf(String str) {
		
		
		if ( str.toLowerCase().contains("push") ) { return("Push");}
		else if ( str.toLowerCase().contains("pull") ) { return("Pull");}
		
		log.error("Could not parse agent type from string [" + str +"] valid modes are either Pull/Push. Defaulting to pull");
		
		return("Pull");
		
	}
}

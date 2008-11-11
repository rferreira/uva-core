package com.uvasoftware.core.util;

import java.util.UUID;
import junit.framework.*;
import java.util.regex.*;

import com.uvasoftware.core.util.*;

/**
 * @author Michael Babineau
 *
 */

public class SIFGUIDTest extends TestCase {
	
	/**
	 * Test method for {@link com.uvasoftware.core.util.SIFGUID#next()}
	 */
	public void testNextID() {
			assertTrue(Pattern.matches("[A-F0-9]{32}", SIFGUID.next()));
		}

}

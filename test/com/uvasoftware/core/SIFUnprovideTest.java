/**
 * 
 */
package com.uvasoftware.core;

import java.util.ArrayList;

import com.uvasoftware.core.SIFUnProvide;

import junit.framework.TestCase;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFUnprovideTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFUnProvide#SIFUnProvide()}.
	 */
	public void testSIFUnprovide() {
		SIFUnProvide s = new SIFUnProvide();
		String str =  s.toString();
		
		assertTrue(str.contains("SIF_Unprovide"));
		assertTrue(str.contains("SIF_Header"));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFUnProvide#unProvide(java.lang.String)}.
	 */
	public void testUnprovide() {
		SIFUnProvide s = new SIFUnProvide();
		
		s.unProvide("W4");
		String str = s.toString();

		assertTrue(str.contains("W4"));
		
		// trying to break it
		
		try { 
			s.unProvide("foo");
		}catch (IllegalArgumentException foo) {
			return;
		}
		
		
	}
	
	public void testUnprovide2() {
		ArrayList <String> l = new ArrayList<String>() ;
		l.add("W4");
		l.add("TimeWorked");
		
		SIFUnProvide b = new SIFUnProvide();
		b.unProvide(l);
		String str = b.toString();
				
		assertTrue(str.contains("W4"));
		assertTrue(str.contains("TimeWorked"));
		assertTrue(str.contains("SIF_Unprovide"));
		System.out.println(str);
	}

}
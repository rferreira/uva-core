/**
 * 
 */
package com.uvasoftware.core;

import java.util.ArrayList;

import com.uvasoftware.core.SIFProvide;

import junit.framework.TestCase;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFProvideTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFProvide#SIFProvide()}.
	 */
	public void testSIFProvide() {
		SIFProvide s = new SIFProvide();
		String str =  s.toString();
		
		assertTrue(str.contains("SIF_Provide"));
		assertTrue(str.contains("SIF_Header"));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFProvide#provide(java.lang.String)}.
	 */
	public void testProvide() {
		SIFProvide s = new SIFProvide();
		
		s.provide("W4");
		String str = s.toString();

		assertTrue(str.contains("W4"));
		
		// trying to break it
		
		try { 
			s.provide("foo");
		}catch (IllegalArgumentException foo) {
			return;
		}
		
		
	}
	
	public void testProvide2() {
		ArrayList <String> l = new ArrayList<String>() ;
		l.add("W4");
		l.add("TimeWorked");
		
		SIFProvide b = new SIFProvide();
		b.provide(l);
		String str = b.toString();
				
		assertTrue(str.contains("W4"));
		assertTrue(str.contains("TimeWorked"));
		assertTrue(str.contains("SIF_Provide"));
		System.out.println(str);
	}

}
/**
 * 
 */
package com.uvasoftware.core;

import java.util.ArrayList;

import com.uvasoftware.core.SIFSubscribe;

import junit.framework.TestCase;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFSubscribeTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFSubscribe#SIFSubscribe()}.
	 */
	public void testSIFSubscribe() {
		SIFSubscribe s = new SIFSubscribe();
		String str =  s.toString();
		
		assertTrue(str.contains("SIF_Subscribe"));
		assertTrue(str.contains("SIF_Header"));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFSubscribe#subscribe(java.lang.String)}.
	 */
	public void testSubscribe() {
		SIFSubscribe s = new SIFSubscribe();
		
		s.subscribe("W4");
		String str = s.toString();

		assertTrue(str.contains("W4"));
		
		// trying to break it
		
		try { 
			s.subscribe("foo");
		}catch (IllegalArgumentException foo) {
			return;
		}
		
		fail();
		
	}
	
	public void testSubscribe2() {
		ArrayList <String> l = new ArrayList<String>() ;
		l.add("W4");
		l.add("TimeWorked");
		
		SIFSubscribe b = new SIFSubscribe();
		b.subscribe(l);
		String str = b.toString();
				
		assertTrue(str.contains("W4"));
		assertTrue(str.contains("TimeWorked"));
		assertTrue(str.contains("SIF_Subscribe"));
		System.out.println(str);
	}

}

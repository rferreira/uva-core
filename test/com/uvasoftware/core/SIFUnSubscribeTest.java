/**
 * 
 */
package com.uvasoftware.core;

import java.util.ArrayList;

import com.uvasoftware.core.SIFUnSubscribe;

import junit.framework.TestCase;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFUnSubscribeTest extends TestCase {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFUnSubscribe#SIFUnSubscribe()}.
	 */
	public void testSIFUnSubscribe() {
		SIFUnSubscribe s = new SIFUnSubscribe();
		String str =  s.toString();
		
		assertTrue(str.contains("SIF_Unsubscribe"));
		assertTrue(str.contains("SIF_Header"));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFUnSubscribe#unSubscribe(java.lang.String)}.
	 */
	public void testUnsubscribe() {
		SIFUnSubscribe s = new SIFUnSubscribe();
		
		s.unSubscribe("W4");
		String str = s.toString();

		assertTrue(str.contains("W4"));
		
		// trying to break it
		
		try { 
			s.unSubscribe("foo");
		}catch (IllegalArgumentException foo) {
			return;
		}
		
		
	}
	
	public void testUnsubscribe2() {
		ArrayList <String> l = new ArrayList<String>() ;
		l.add("W4");
		l.add("TimeWorked");
		
		SIFUnSubscribe b = new SIFUnSubscribe();
		b.unSubscribe(l);
		String str = b.toString();
				
		assertTrue(str.contains("W4"));
		assertTrue(str.contains("TimeWorked"));
		assertTrue(str.contains("SIF_Unsubscribe"));
		System.out.println(str);
	}

}

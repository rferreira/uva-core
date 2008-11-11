package com.uvasoftware.core;


import com.uvasoftware.core.SIFSleep;

import junit.framework.TestCase;

public class SIFSleepTest extends TestCase {

	public void testSIFSleep() throws Exception{
		
		SIFSleep sleep = new SIFSleep();
		
		assertTrue(sleep.toString().contains("SIF_Sleep"));
		
	}

}

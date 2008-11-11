package com.uvasoftware.core;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import com.uvasoftware.core.util.*;

public class ClassmapTest extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testClassmap() throws InstantiationException, IllegalAccessException {
		for ( SIFObjectName i: SIFObjectName.values() ) {
			try {
				System.out.println("loading class for object:" + i.toString());
				assertNotNull(Class.forName(Config.getInstance().getClassMap(i)).newInstance());
			} catch (ClassNotFoundException e ) {
				System.out.println("could not load class:" + Config.getInstance().getClassMap(i));
			}
		}
	}

}

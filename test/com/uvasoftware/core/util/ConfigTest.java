/**
 * 
 */
 
package com.uvasoftware.core.util;

import static org.junit.Assert.*;
import java.util.regex.*;
import org.junit.Test;

import java.util.Properties;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;

/**
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class ConfigTest extends junit.framework.TestCase {

	@Test
	public void testGetFromDefaults() {
		assertNotNull(Config.getInstance().get(ConfigConstants.VERSION));
		
	}

	@Test
	public void testLoad() throws Exception{
		Properties p = new Properties();
		p.setProperty(ConfigConstants.VERSION,"0.0.0");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		p.store(out,null);
		
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

		Config.getInstance().load(in);

		assertEquals(Config.getInstance().get(ConfigConstants.VERSION),"0.0.0");
	}

	@Test
	public void testEnv() {
		System.setProperty(ConfigConstants.VERSION,"1");
		assertEquals(Config.getInstance().get(ConfigConstants.VERSION),"1");
	}
}

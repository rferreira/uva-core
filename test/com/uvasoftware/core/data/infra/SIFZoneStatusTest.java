/**
 * 
 */
package com.uvasoftware.core.data.infra;

import static org.junit.Assert.*;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.*;

/**
 * @author Rafael Ferreira
 *
 */
public class SIFZoneStatusTest {

	String xml = "com/uvasoftware/core/spec/sifzonetest.xml";
	SIFZoneStatus zone_status = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		// we're loading a valid sifzonestatus xml from a resource 
		URL url = this.getClass().getClassLoader().getResource(xml);
		System.out.println(url);
		SIFMessageMarshaller mm = SIFMessageMarshaller.getInstance();
		SIFMessage resp = mm.unmarshal(url.openStream());
		zone_status = (SIFZoneStatus) resp.getAck().getResponse().getObjectData().get(0); 
			
			
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#SIFZoneStatus()}.
	 */
	@Test
	public void testSIFZoneStatus() {
		assertNotNull(zone_status);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getZoneID()}.
	 */
	@Test
	public void testGetZoneID() {
		assertEquals("TinyZIS",zone_status.getZoneID());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getName()}.
	 */
	@Test
	public void testGetName() {
		assertNull(zone_status.getVendorName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getVendorName()}.
	 */
	@Test
	public void testGetVendorName() {
		assertNull(zone_status.getVendorName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getProduct()}.
	 */
	@Test
	public void testGetProduct() {
		assertNull(zone_status.getProduct());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getProductVersion()}.
	 */
	@Test
	public void testGetProductVersion() {
		assertNull(zone_status.getProductVersion());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getAdministratorUrl()}.
	 */
	@Test
	public void testGetAdministratorUrl() {
		assertNull(zone_status.getAdministratorUrl());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getProviders()}.
	 */
	@Test
	public void testGetProviders() {
		SIFZoneStatus.SIFProvier p = zone_status.getProviders().get(0);
		assertEquals("Uva Software - Uva Core",p.sourceId);
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getSubscribers()}.
	 */
	@Test
	public void testGetSubscribers() {
		SIFZoneStatus.SIFSubscriber p = zone_status.getSubscribers().get(0);
		assertEquals("Uva Software - Uva Core",p.sourceId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getNodes()}.
	 */
	@Test
	public void testGetNodes() {
		assertEquals(0,zone_status.getNodes().size());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(zone_status.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.infra.SIFZoneStatus#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		SIFZoneStatus z2 = new SIFZoneStatus();
		z2.setPrimitive(zone_status.getPrimitive());
		assertEquals("TinyZIS",z2.getZoneID());
	}

}

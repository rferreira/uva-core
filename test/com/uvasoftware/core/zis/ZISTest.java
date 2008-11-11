package com.uvasoftware.core.zis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.SIFZoneStatus;
import com.uvasoftware.core.zis.*;
import com.uvasoftware.core.util.*;

public class ZISTest {
	
	ZIS z = null;
	

	@Before
	public void setUp() throws Exception {
		z = new ZIS(new VolatileDAO());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZIS() {
		ZIS z = new ZIS(new VolatileDAO());
		assertNotNull(z);
	}

	@Test
	public void testEnter() {
		// sending ping message
		SIFPing ping = new SIFPing();
		ping.getHeader().setSourceId("a");
		
		ZIS z = new ZIS(new VolatileDAO());
		SIFAck ack = (SIFAck) z.enter(ping);
		
		assertEquals(Code.Status.SUCCESS, ack.getStatusCode());
		
			
	}
	
	@Test
	public void testGetStatus() {
		ZIS z = new ZIS(new VolatileDAO());
		AgentRecord a = new AgentRecord("blue");
		a.provides.add(SIFObjectName.StudentContact);
		z.DAO.putAgent(a);
		
		SIFZoneStatus st = z.DAO.getZoneStatus();
		
		System.out.println(st);
		
		assertEquals(a.sourceId,st.getProviders().get(0).sourceId);
	}
	
	@Test
	public void testRegisterNoVersion() {
		// this should fail since we're not passing  a versions id
		
		SIFRegister reg = new SIFRegister();
		reg.setName("B");
		reg.getHeader().setSourceId("B");
		reg.setMaxBuffer(1);
		SIFAck r = (SIFAck) z.enter(reg);
		
		System.out.println(r);
		
		if ( r.getStatusCode() == Code.Status.SUCCESS) fail();
		
		
		
		
	}
	@Test
	public void testRegister() {
		// this should fail since we're not passing  a versions id
		
		SIFRegister reg = new SIFRegister();
		reg.setName("B");
		reg.getHeader().setSourceId("B");
		reg.setMaxBuffer(1);
		reg.getVersions().add(Config.getInstance().get(ConfigConstants.AGENT_SIF_SUPPORT));
		SIFAck r = (SIFAck) z.enter(reg);
		
		System.out.println(r);
		
		if ( r.getStatusCode() != Code.Status.SUCCESS) fail();
		
		
		
		
	}

}

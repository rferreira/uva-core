package com.uvasoftware.core.tickets;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.SIFZone;
import com.uvasoftware.core.data.infra.SIFZoneStatus;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;

public class Ticket55 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void run() throws Exception {
		String ZIS= Config.getInstance().get(ConfigConstants.TEST_ZIS);
		SIFZone zone = SIFZone.createSIFZone("b", ZIS);
		
        SIFZoneStatus stat = zone.getSIFZoneStatus();
       
        assertNotNull(stat);
        assertTrue(stat.toString().contains("SIF_ZoneStatus"));
	}
}

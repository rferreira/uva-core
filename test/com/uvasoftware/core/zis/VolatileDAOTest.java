package com.uvasoftware.core.zis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.uvasoftware.core.*;
import com.uvasoftware.core.data.student.*;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.query.*;


public class VolatileDAOTest {
	VolatileDAO dao = new VolatileDAO();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVolatileDAO() {
		assertNotNull(new VolatileDAO());
	}

	@Test
	public void testGetAgent() {
		AgentRecord rec = new AgentRecord("blue");
		
		dao.putAgent(rec);
		assertEquals("blue", dao.getAgent("blue").sourceId);
	}

	@Test
	public void testGetMessagesForAgentBySubscription() throws Exception {
		
		AgentRecord rec = new AgentRecord("t");
		rec.subscribes.add(SIFObjectName.StudentPersonal);
		
		dao.putAgent(rec);
		
		
		SIFEvent event = new SIFEvent();
		StudentPersonal sp = new StudentPersonal();
		sp.setName(new Name(Name.Type.ALIAS, "B","C"));
		
		event.setEventData(sp,SIFObjectName.StudentPersonal.toString(), SIFEvent.Action.Add);
		
		dao.putMessage(event);
		
		// setting subscription
		

		
		// getting messages
		
		List<SIFMessage> list = dao.getMessagesForAgent("t");
		
		assertEquals(1,list.size());
		
		
	}
	
	@Test
	public void testGetMessagesForAgentByDestination() throws Exception {
		// setting subscription
		
		AgentRecord rec = new AgentRecord("t");
		
		dao.putAgent(rec);
		
		SIFEvent event = new SIFEvent();
		StudentPersonal sp = new StudentPersonal();
		sp.setName(new Name(Name.Type.ALIAS, "B","C"));
		
		event.setEventData(sp,SIFObjectName.StudentPersonal.toString(), SIFEvent.Action.Add);
		event.getHeader().setDestinationId("t");
		
		dao.putMessage(event);
		

		
		// getting messages
		
		List<SIFMessage> list = dao.getMessagesForAgent("t");
		
		assertEquals(1,list.size());
		
		
	}
	@Test
	public void testGetMessagesForAgentByRequestDestination() throws Exception {
		// setting subscription
		
		AgentRecord rec = new AgentRecord("t");
		
		dao.putAgent(rec);
		
		SIFQuery q = new SIFQuery(SIFObjectName.AccountingPeriod);
		SIFRequest r = new SIFRequest();
		r.setQuery(q);
		r.getHeader().setDestinationId("t");
		
		dao.putMessage(r);
		
		
		
		// getting messages
		
		List<SIFMessage> list = dao.getMessagesForAgent("t");
		
		assertEquals(1,list.size());
	}
	
	@Test
	public void testGetMessagesForAgentByRequestProvider() throws Exception {

		
		AgentRecord rec = new AgentRecord("t");
		rec.provides.add(SIFObjectName.AccountingPeriod);
		
		dao.putAgent(rec);
		
		SIFQuery q = new SIFQuery(SIFObjectName.AccountingPeriod);
		SIFRequest r = new SIFRequest();
		r.setQuery(q);
		//r.setDestinationId("t");
		
		dao.putMessage(r);
		
		// setting subscription

		
		// getting messages
		
		List<SIFMessage> list = dao.getMessagesForAgent("t");
		
		assertEquals(1,list.size());
	}
	
	

	@Test
	public void testPutAgent() {
		AgentRecord rec = new AgentRecord("t");
		rec.provides.add(SIFObjectName.AccountingPeriod);
		
		dao.putAgent(rec);
		// is this case the objects are going to be identical 
		assertEquals(rec,dao.getAgent("t"));
	}

	@Test
	public void testPutMessage() {
		SIFPing msg = new SIFPing();
		dao.putMessage(msg);
	}
	
	@Test
	public void test2Providers() {
		
	}

}

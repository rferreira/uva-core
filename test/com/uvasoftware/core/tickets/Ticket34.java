package com.uvasoftware.core.tickets;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.uvasoftware.core.*;
import com.uvasoftware.core.data.student.StaffPersonal;
import com.uvasoftware.core.query.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

public class Ticket34 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTicket34() {
		StaffPersonal sp = new StaffPersonal();
		sp.setRefId("1");
		SIFResponse resp = new SIFResponse();
		resp.addObjectData(sp);
		StaffPersonal sp2 = (StaffPersonal) resp.getObjectData().get(0);
		assertEquals(sp.getRefId(),sp2.getRefId());
	}

	@Test 
	public void testTicket34_2() throws Exception{
		StaffPersonal sp = new StaffPersonal();
		sp.setRefId("1");
		SIFResponse resp = new SIFResponse();
		resp.addObjectData(sp);
		
		System.out.println(resp);
		
		StaffPersonal sp2 = (StaffPersonal) resp.getObjectData(SIFObjectName.StaffPersonal).get(0);
		assertEquals(sp.getRefId(),sp2.getRefId());
	

	}
	@Test
	public void testTicket34_3() throws Exception {
		SIFZone zone = SIFZone.createSIFZone( "blue", "mock://local" );
		SIFAck ack1 =zone.register();

		if ( ack1.getStatusCode() != Code.Status.SUCCESS )
		{
			System.out.println( "error:" + ack1.getErrorDesc() );
			return;
		}

		SIFQuery query = new SIFQuery(SIFObjectName.StaffPersonal);

		SIFAck ack = zone.sendRequest(query);

		if ( ack.getStatusCode() != Code.Status.SUCCESS )
		{
			System.out.println( "error:" + ack.getErrorDesc() );
			return;
		}

		SIFResponse resp = ack.getResponse();
		
		// there's no good reason why this would return any data
		if (resp == null ) return;
		
        Iterator<ISIFObject> it = resp.getObjectData().iterator();
        BufferedWriter bw = new BufferedWriter (new FileWriter( new File("/tmp/data.txt")));
        com.uvasoftware.core.data.student.StaffPersonal sp;
        while(it.hasNext())
        {
        	sp = (com.uvasoftware.core.data.student.StaffPersonal) it.next().getPrimitive();
            bw.append( "Staff Full Name :" +sp.getName().getFullName() + "\n");
            bw.append( "Email address :"+ sp.getEmail().indexOf( 0 ) + "\n");
            bw.append( "Employee Link :" + sp.getEmployeeLink() + "\n");
        }
        
        bw.flush();
        bw.close();
		

	}
}

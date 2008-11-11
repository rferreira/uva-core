package com.uvasoftware.core;

import com.uvasoftware.core.SIFZone;
import com.uvasoftware.core.data.infra.*;
import junit.framework.TestCase;
import com.uvasoftware.core.util.*;
import org.junit.Ignore;
import org.junit.Test;


import com.uvasoftware.core.data.student.RoomType;
/**
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */

public class SIFZoneTest extends TestCase {

    String ZIS= Config.getInstance().get(ConfigConstants.TEST_ZIS);
    String ZONE="mock";
    SIFZone zone = null;
    
	protected void setUp() throws Exception {
    	//System.out.println("using zis:" + ZIS);

        zone = SIFZone.createSIFZone(ZONE, ZIS);
        
        assertNotNull(zone);
    }

    public void testCreateSIFZone() throws Exception {
    	assertNotNull(SIFZone.createSIFZone(ZONE, ZIS));
    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#getSIFZoneStatus()}.
     */
    public void testGetSIFZoneStatus() throws Exception{
        SIFZoneStatus stat = this.zone.getSIFZoneStatus();
        
        // we expect this to be null because mock doesn't really return a valid zone status - yet
        assertNotNull(stat);
        assertEquals(Config.getInstance().get(ConfigConstants.ZIS_NAME),stat.getName());
        assertTrue(stat.toString().contains("SIF_ZoneStatus"));
    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#sleep()}.
     */
    public void testSleep() throws Exception {
        SIFAck ack = zone.sleep();
        if (ack.getStatusCode() != Code.Status.SUCCESS) {
        	fail();
        }
        
    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#wakeup()}.
     */
    public void testWakeup() throws Exception{
        SIFAck ack = zone.wakeup();
        if (ack.getStatusCode() != Code.Status.SUCCESS) 
        	fail();

    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#ping()}.
     */
    public void testPing() throws Exception{
        assertEquals(zone.ping().getStatusCode(),Code.Status.SUCCESS);           
    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#getMessage()}.
     */
    public void testGetMessage() throws Exception{
    	System.out.println(zone.isAgentRegistered());
        SIFAck ack = zone.getMessage();
        System.out.println(ack);
        System.out.println(ack.getStatusCode());
        if (ack.getStatusCode() != Code.Status.NO_MESSAGE_AVAILABLE) 
        	fail();
    }

    /**
     * Test method for {@link com.uvasoftware.core.SIFZone#getZoneId()}.
     */
    public void testGetZoneId() {
        assertNotNull(zone.getZoneId());
    }
    
    public void testSendResponse() throws Exception {
    	SIFZoneStatus stat = new SIFZoneStatus();
    	
    	SIFAck ack = zone.sendResponse("1",stat,SIFGUID.next(),0,false);
    	System.out.println(ack);
    	if (ack.getStatusCode() != Code.Status.SUCCESS) 
    		fail();
    }
    
    
    public void testSendResponse2() throws Exception {
    	SIFResponse resp = new SIFResponse(SIFGUID.next(), 0, false);
    	resp.addObjectData(new SIFZoneStatus());
    	//System.out.println(resp);
    	assertTrue(resp.toString().contains("<SIF_ObjectData><SIF_ZoneStatus/></SIF_ObjectData>"));
    }
    
    public void testSendEvent() throws Exception {
    	RoomType rt = new RoomType("A","B");
    	SIFAck ack = zone.sendEvent(rt,SIFObjectName.RoomType, SIFEvent.Action.Add);
    	
    	if (ack.getStatusCode() != Code.Status.SUCCESS) fail();
    }
}


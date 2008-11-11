/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uvasoftware.core.tickets;

import org.junit.Test;


import com.uvasoftware.core.*;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;
import com.uvasoftware.core.data.student.StudentPersonal;

/**
 *
 * @author rafael
 */
public class Ticket54 {

    public Ticket54() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void runTest() throws Exception {

        
        SIFZone zone = SIFZone.createSIFZone("zone", Config.getInstance().get(ConfigConstants.TEST_ZIS));

        SIFAck ack = zone.getMessage();

        int code = ack.getStatusCode();

        if (code == 9) {

            System.out.println("No Messages");

        } else {

            if (ack.getEvent() != null) {

                SIFEvent event = ack.getEvent();

                StudentPersonal sp = (StudentPersonal) event.getEventObject();


                            
                
            } else {

                SIFResponse resp = ack.getResponse();

                StudentPersonal sp = (StudentPersonal) resp.getObjectData(SIFObjectName.StudentPersonal).get(0);


                                
                    
                System.out.println(sp.getName().getLastName());

                System.out.println(sp.getName().getFirstName());

            }

        }
        
    }
}
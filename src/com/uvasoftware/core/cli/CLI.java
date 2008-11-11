/*
 * CLI.java
 *
 * Created on July 11, 2006, 1:40 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.uvasoftware.core.cli;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import com.uvasoftware.core.*;
import com.uvasoftware.core.util.*;
import com.uvasoftware.core.data.infra.*;
import com.uvasoftware.core.exception.*;

import java.net.ConnectException;

/**
 * Class that drives Uva Core's command line interface
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class CLI {
	
	private static Logger log = Logger.getLogger(CLI.class);  
	
	public static void main(String args[]) {
	    
	    //building command line options
	    Options options = new Options();
	    options.addOption(new Option("v","verbose",false,"enable verbose mode"));
	    options.addOption(new Option("r","register",false,"send a zone registration request"));
	    options.addOption(new Option("w","wakeup",false,"send a zone wakeup request"));
	    options.addOption(new Option("s","sleep",false,"send a zone sleep request"));
	    options.addOption(new Option("p","ping",false,"send a zone ping request"));
	    options.addOption(new Option("t","zonestatus",false,"send a zone status request"));
	    options.addOption(new Option("g","getmessage",false,"send a getmessage request"));
	    options.addOption(new Option("u","unregister",false,"unregister the agent"));
	    options.addOption(new Option("h","host",true,"the destination host for the sif message (usually the ZIS)"));
	    options.addOption(new Option("a","agent",true,"the agent's name"));

	    
	    if (args.length == 0) {
//	      automatically generate the help statement
	        HelpFormatter formatter = new HelpFormatter();
	        formatter.printHelp(80, "uva-cli", "Copyright 2008 Uva Software", options, "\nFor further documentation, visit http://www.uvasoftware.com\n", true);
	    }
	    
	    // create the parser
	    CommandLineParser parser = new PosixParser();
	    try {
	        // parse the command line arguments
	        CommandLine line = parser.parse( options, args );
	        
	        if ( line.hasOption("a") ) {
	            Config.getInstance().set(ConfigConstants.AGENT_SOURCEID, line.getOptionValue("a"));
	        }
	        if ( line.hasOption("h")) {
	            System.out.println("using zone url:"+line.getOptionValue("h"));
	        }else {
	            System.err.println("Error! a zone url must be present");
	            System.exit(1);
	        }
	        
	        if (line.hasOption("v")) {
	        	System.out.println("running in debug mode");
	        	Config.getInstance().set(ConfigConstants.DEBUG_SIF, "true");
	        }
	     
	        SIFZone zone = SIFZone.createSIFZone("testzone", line.getOptionValue("h"));
	        
	        if (!zone.isAgentRegistered()) {
	        	System.out.println("Sorry but registering this agent with the Zone failed, this is probably caused by permissions on the zone.");
	        	System.exit(1);
	        }
	        SIFAck ack = null;
	  
	        System.out.print("Sending message to Zone....");	        
	        
	        if (line.hasOption("r")) {
	            checkResult(zone.register());  
	        }else if (line.hasOption("w")) {
	            checkResult(zone.wakeup());
	        }else if (line.hasOption("p")) {
	            checkResult(zone.ping());
	        }else if (line.hasOption("s")) {
	            checkResult(zone.sleep());           
	        }else if (line.hasOption("u")) {
	        	checkResult(zone.unregister());
	        }
	       	
	        
	        // handling more advanced requests 
	       if (line.hasOption("t")) {
	            SIFZoneStatus stat  = zone.getSIFZoneStatus();
	            if ( stat != null ) {
	            	System.out.println("OK");
	            	PPrint.print(stat);
	            	
	            }else {
	            	System.out.println("ERROR");
	            	System.out.println("We received an empty response from the zone");
	            }
	            
	            
	            
	        }else if (line.hasOption("g")) {
	            ack = zone.getMessage();
	            System.out.println("OK");
	            if (ack.getStatusCode() == Code.Status.NO_MESSAGE_AVAILABLE) {
	            	System.out.println("No new messages.");
	            }else if (ack.getStatusCode() == Code.Status.SUCCESS) {
	            	System.out.println(String.format("You have %n messages available", ack.getStatusDataMessages().size()));
	            }
	            
	        }
	        

	      
	       System.exit(0);
	    
	    // Handling all errors
	    }catch (Exception ex) {
	    	System.out.println("ERROR");
	        System.out.println("Oops, a generic exception was thrown, details below:");
	        ex.printStackTrace();
	        
	    }
	    
	    System.exit(1);
	    
	}
	private static void checkResult(SIFAck ack) {
		if (ack.getStatusCode() == Code.Status.SUCCESS) {
        	System.out.println("OK");
        	
        	//PPrint.print(ack);   	
        	
        }
	}
}

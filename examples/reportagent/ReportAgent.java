/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

import java.util.Properties;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.data.student.*;
import com.uvasoftware.core.util.*;
import com.uvasoftware.core.query.*;


/**
 * Example SIF Agent<br>
 * This sample agent queries a remote agent (Oracle) for information on certain objects
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */

public class ReportAgent {
	
	/**
	 * Dummy agent to service the inbound request. This agent is started just so our sif query is answered by someone<br>
	 * In this case, DummyProvider will register itself with the ZIS as the default provider for the StudentPersonal object
	 *
	 */
	private static class Oracle implements IEventHandler {
		public SIFAgent agent = null;
		
		public Oracle() {
			
			Properties p = new Properties();
			p.setProperty(ConfigConstants.AGENT_NAME, "Oracle");
			p.setProperty(ConfigConstants.AGENT_SOURCEID, "Oracle");
			p.setProperty(ConfigConstants.AGENT_ZONE_URL, "mock://local");
			
			// agent polls every 1 sec
			p.setProperty(ConfigConstants.AGENT_POLL_PERIOD, "1000");

			// we will just use the SIFAgent micro-framework here
			agent = new SIFAgent(p);
			
			// registering the new message handler
			agent.onReceiveMessage.appendHandler(this);
			
			// starting the agent
			agent.start();
			
		}

		/**
		 * Gets called whenever a new message arrive to this agent
		 */
		public void handle(Object eventSource, Object eventArgs)
				throws Exception {
			//  event
			SIFAgent ag = (SIFAgent) eventSource;
			SIFMessage msg = (SIFMessage) eventArgs;
			
			System.out.println("Polo!");
			
			StudentPersonal sp = new StudentPersonal();
			sp.setName(new Name( Name.Type.GIVEN_NAME, "John", "Smith"));
			
			ag.getZone().sendResponse(msg.getSourceId(), sp, msg.getId(), 1, false);
			
		}
	}
	
	// REPLACE THIS WITH THE URL OF YOUR ZIS/ZONE
	final static String ZIS = "mock://localhost.localdomain";
			
	public static void main(String[] args) throws Exception{
		
		// uncomment below to turn on verbose logging
		//System.getProperties().setProperty("uva.log.level", "DEBUG");
		
		Oracle ora = new Oracle();
		
		System.out.println("Uva Core example agent");
		
		Properties p = new Properties();
		p.setProperty(ConfigConstants.AGENT_NAME, "ReporterAgent");
		p.setProperty(ConfigConstants.AGENT_SOURCEID, "reporter");
		p.setProperty(ConfigConstants.AGENT_ZONE_URL, ZIS);
				
		SIFAgent reporter = new SIFAgent(p);
		
		reporter.start();
		
		/*
		 * SIMPLE QUERY
		 */
		
		SIFQuery query = new SIFQuery(SIFObjectName.StudentPersonal);
		query.setSIFCondition("Name/LastName",SIFCondition.Operator.EQ,"Smith");
		
		// sending the request 
		System.out.println("marco!");
		SIFAck ack = reporter.getZone().sendRequest("Oracle",query);
		
		// checking whther the query was accepted by the ZIS...
		if (ack.getStatusCode() != Code.Status.SUCCESS) {
			System.out.println("error:" + ack.getErrorDesc());
			System.exit(1);
			
		}
		
		// waiting to give the ZIS and agents time to process the request
		Thread.sleep(3000);
		
		// Retrieving the response 
		ack = reporter.getZone().getMessage();
		
		if (ack.getStatusCode() != Code.Status.SUCCESS) {
			System.out.println("error:" + ack.getErrorDesc());
		}
		else {
			
			
			try {
				// ok, we have a successful response, let's disassemble the response message
				SIFResponse resp = ack.getResponse();
				
				// pulling student personal object out that should contain the response
				// we're making the assumption that there's only one here 
				StudentPersonal sp = (StudentPersonal) resp.getObjectData(SIFObjectName.StudentPersonal).get(0);
				
				//now we can read the response
				System.out.println(String.format("Received: first name: %s, last name: %s", sp.getName().getFirstName(),sp.getName().getLastName()));		
	
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/*
		* COMPLEX QUERY
		*/
		
		// query root
		SIFConditionGroup root = new SIFConditionGroup(SIFConditionGroup.Type.And);
		
		// now we're going to look for first name AND last name
		SIFCondition first_name = new SIFCondition("Name/FirstName",SIFCondition.Operator.EQ,"John");
		SIFCondition last_name = new SIFCondition("Name/LastName",SIFCondition.Operator.EQ,"Doe");
		
		//putting the conditions together and setting the logical operator to AND 
		SIFConditions conds = new SIFConditions(SIFConditions.Type.And);
		
		conds.addSIFCondition(last_name);
		conds.addSIFCondition(last_name);
		
		// now we assemble everything in the condition group
		root.addConditions(conds);
		
		// we put in back in our query
		query = new SIFQuery(SIFObjectName.StudentPersonal);
		query.setSIFConditionGroup(root);
		
		// sending the request - please note that this is sync (so this thread will block until the response is available)
		System.out.println("marco!");
		ack = reporter.getZone().sendRequest("Oracle",query);
		
		// checking whther the query was accepted by the ZIS...
		if (ack.getStatusCode() != Code.Status.SUCCESS) {
			System.out.println("error:" + ack.getErrorDesc());
			System.exit(1);
			
		}

		// waiting to give the ZIS and agents time to process the request
		Thread.sleep(3000);
		
		// Retrieving the response 
		ack = reporter.getZone().getMessage();
		
		if (ack.getStatusCode() != Code.Status.SUCCESS) {
			System.out.println("error:" + ack.getErrorDesc());
		}else {
			try {
				// ok, we have a successful response, let's disassemble the response message
				SIFResponse resp = ack.getResponse();
				
				// pulling student personal object out that should contain the response
				// we're making the assumption that there's only one here 
				StudentPersonal sp = (StudentPersonal) resp.getObjectData(SIFObjectName.StudentPersonal).get(0);
				
				//now we can read the response
				System.out.println(String.format("Received: first name: %s, last name: %s", sp.getName().getFirstName(),sp.getName().getLastName()));
	
			} catch (Exception e) {
				System.out.println(e);
			}
		}	

		// stopping everything
		System.out.println("shutting down....");
		ora.agent.stop();
		reporter.stop();
		
	}
}

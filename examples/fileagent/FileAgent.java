/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
 
import com.uvasoftware.core.*;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.data.student.*;
import com.uvasoftware.core.util.*;

/**
 * Example SIF Agent<br>
 * Monitors a property file and send events whenever it is modified
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 * 
 * In essence this agent monitors a file "user.properties" containing someone's first
 * and last names and it sends out a SIF event whenever something changes. 
 * 
 * Please see http://uvasoftware.com/wiki/SampleAgent for a better explanation of this agent
 *<p>
 *Changelog:<br>
 *03-27-2008 converted to use agent micro framework<br>
 */
public class FileAgent {	
	
	/**
	 * Main handler that monitors the file for changes and sends events
	 */
	static public class Monitor implements IEventHandler {
		static long lastModified;
		static File file = null;
		
		public Monitor(File monitoredFile) {
		
			file = monitoredFile;
			lastModified = file.lastModified();
			
			
		}
		public void handle(Object source, Object eventArgs){
			
			SIFAgent agent = (SIFAgent) source;
			
			if (file.lastModified() > lastModified) {
				lastModified = file.lastModified();
				try {
					// FIRING EVENT
					Properties prop = new Properties();
					prop.load(new FileInputStream(file));
					
					// Gathering the required information for a successful StudentPersonal object
					Name name = new Name(Name.Type.GIVEN_NAME,prop.getProperty("name.first"),prop.getProperty("name.last"));
					
					// creating the object
					StudentPersonal sp = new StudentPersonal(name);
				
					// sending SIF_Event message
					System.out.println("sending SIF event");
					SIFAck ack = agent.getZone().sendEvent(sp, SIFObjectName.StudentPersonal, SIFEvent.Action.Change);
					
					if (ack.getStatusCode() != Code.Status.SUCCESS) {
						System.out.println("error:" + ack.getErrorDesc());
					}
					
					System.out.println("done");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
	}

	/**
	 * Handler for new incoming messages
	 */
	static public class NewMessageHandler implements IEventHandler {
		public void handle(Object source, Object eventArgs) {
			SIFMessage msg = (SIFMessage) eventArgs;

			System.out.println("You got mail!");
			SIFEvent ev = msg.getEvent();

			System.out.println(String.format("Event action: %s on object: %s", ev.getAction(), ev.getEventObjectName()) );

		}
	}
	
		
	public static void main(String[] args) throws Exception{
		
		System.out.println("Uva Core example agent");
		
		// this is the file we want to monitor for changes
		File file = new File("user.properties");
		
		if (!file.exists())
			throw(new Exception("could not find file user.properties"));
		
		/*
		 * Configuring agent framework
		 */
		
		//bootstrapping agent framework
		SIFAgent agent = new SIFAgent();
		
		// telling the framework the objects we're interested in providing
		agent.provides.add(SIFObjectName.StudentPersonal);
		
		// telling the framework the objects we're interested in subscribing (in this case we both provide and subscribe)
		agent.subscribes.add(SIFObjectName.StudentPersonal);
		
		//hooking our event handler
		agent.onPeriodicRun.appendHandler(new Monitor(file));

		// hooking up new message handler that is fired every time a new message arrives
		agent.onReceiveMessage.appendHandler(new NewMessageHandler());

		
		System.out.println("Monitoring file:" + file.getName());
		
		// starting agent - handles provision/subscription
		agent.start();
		
		System.out.println("daemon started");
		
		while(true){ 
			// putting main thread to sleep so timer can do its magic
			Thread.sleep(Integer.MAX_VALUE);
		}
		

	}

}

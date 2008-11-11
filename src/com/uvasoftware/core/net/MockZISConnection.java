package com.uvasoftware.core.net;

import org.apache.log4j.Logger;

import com.uvasoftware.core.zis.*;
import com.uvasoftware.core.*;


/**
 * Dummy SIF handler that can be used if you don't have a running ZIS or for unit tests
 * You can trigger it by using <i>mock://test</i> for the url 
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class MockZISConnection extends AbstractSIFConnection implements ISIFConnection{
	private static Logger log = Logger.getLogger(MockZISConnection.class);

	private static ZIS zis = new ZIS(new VolatileDAO());
	
	
	/**
	 * sendMessage handler, it takes the message (verifies that it is a SIF message) and responds with a successful ack
	 * @param message Message to be sent
	 * @return Unmarshalled response from endpoint
	 */
	public SIFMessage sendMessage(SIFMessage message) throws Exception {
		return(zis.enter(message));
		
	} 
	
	public MockZISConnection() {
	}
	

}

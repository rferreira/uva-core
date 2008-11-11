/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.net;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import com.uvasoftware.core.SIFConnectionStatus;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.SIFMessageMarshaller;


/**
 * 
 * This class facilitates writing of SIFConnection handlers, instead of implementing ISFIConnection yourself
 * you can just extend this class and get helper methods for free
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public abstract class AbstractSIFConnection {
    SIFConnectionStatus status = SIFConnectionStatus.UNKNOWN;

    URI uri = null;
    
    /**
     * Reads a message from a stream 
     */
    public SIFMessage readMessage(InputStream is) throws Exception {
        SIFMessageMarshaller mars = SIFMessageMarshaller.getInstance();
        SIFMessage response = mars.unmarshal(is);
        return (response);
    }
    
	/**
	* Writes a message to a stream
	*/
    public boolean writeMessage(SIFMessage msg, OutputStream os) throws Exception {
        SIFMessageMarshaller mars = SIFMessageMarshaller.getInstance();
        mars.marshal(msg, os);
        
        return (true);
    }

    /**
	 * Returns the uri of the connection 
     * @return the uri
     */
    public URI getURI() {
        return uri;
    }

    /**
	 * Sets the uri fo the connection
     * @param uri the uri to set
     */
    public void setURI(URI uri) {
        this.uri = uri;
    }

	/**
	* Returns the connection status
	*/
    public SIFConnectionStatus getStatus() {
        return (this.status);
    }

	/**
	* Closes the connection
	*/
    public boolean close() {
        return (true);
    }

    
    /** Creates a new instance of AbstractSIFConnection */
    public AbstractSIFConnection() {
    }

 

}

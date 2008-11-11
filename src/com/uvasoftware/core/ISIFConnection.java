/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core;


import java.net.URI;


/**
 * Interface that represents what a SIFConnection must comply with
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */

public interface ISIFConnection {
    SIFConnectionStatus getStatus();
    SIFMessage sendMessage(SIFMessage request) throws Exception;
    void setURI(URI uri);
    URI getURI();
    boolean close();
   
}

package com.uvasoftware.core;

import java.net.URI;

import com.uvasoftware.core.net.*;


/**
 * Factory class that abstracts the creation of a new SIF connection<p>
 * Currently it uses a naive method to discover the scheme. 
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFConnectionFactory {
    
	/**
	 * Returns a SIFConnection back based upon the url passed
	 * @param uri The url/uri of the SIF endpoint (agent/zis)
	 */
    public static ISIFConnection getConnection(String uri) throws IllegalArgumentException, Exception {
        URI t = new URI(uri);
        
        if (t.getScheme().contains("http")) {
            HTTPSIFConnection conn = new HTTPSIFConnection();
            conn.setURI(t);
            return((ISIFConnection)conn);
        }else if (t.getScheme().contains("mock")) {
        	MockZISConnection conn = new MockZISConnection();
        	return((ISIFConnection) conn);
        }
        
        throw new IllegalArgumentException("invalid URI scheme:" + t.getScheme());
    }
    /** Creates a new instance of SIFConnectionFactory */
    private SIFConnectionFactory() {
    }
    
}

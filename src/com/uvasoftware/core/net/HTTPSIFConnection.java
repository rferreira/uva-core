package com.uvasoftware.core.net;

import java.net.*;

import org.apache.log4j.Logger;

import com.uvasoftware.core.ISIFConnection;
import com.uvasoftware.core.SIFConnectionStatus;
import com.uvasoftware.core.SIFMessage;
import com.uvasoftware.core.util.*;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * Handles sending the SIF message down the magical HTTP/S pipe
 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class HTTPSIFConnection extends AbstractSIFConnection implements ISIFConnection{
	
	static boolean SSLBypassEnabled = false;
	
	static {
		// did the user select to bypass the ssl checks? 
		if (Config.getInstance().get(ConfigConstants.HTTP_BYPASS_SSL) != null ) {
			loadDummyTrustManager(); 
		}
		
		SSLBypassEnabled = true;
	}
	
	/**
	 * handles support for http authentication
	 * @author Rafael Ferreira <raf@uvasoftware.com>
	 *
	 */
	private class CustomAuthenticator extends Authenticator {
		
		PasswordAuthentication pa = null;
		
		public CustomAuthenticator(String username, String password) {
			pa = new PasswordAuthentication(username, password.toCharArray() );
		}
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return(pa);
			
		}
	}
		  
	private static Logger log = Logger.getLogger(HTTPSIFConnection.class);
	
	/**
	 * returns an RFC 2616 complaint host header entry 
	 * @return a string representation of the host header
	 */
	public String buildHostHeader() {
	    // trying to confirm with RFC2616 section 14.23
	    String host =  (uri.getPort() == -1) ? uri.getHost() : uri.getHost() +":" + uri.getPort();
	    log.debug("returning host header:" + host);
	    return(host);
	    
	}
	
	/**
	 * Sends SIFMessage via HTTP
	 * @param message Message to be sent
	 * @return Unmarshalled response from endpoint
	 */
	public SIFMessage sendMessage(SIFMessage message) throws Exception{
		SIFMessage response = null;
		
		log.debug("entering java native http request SIF connection, SSL bypass enabled? " + SSLBypassEnabled);
		
		HttpURLConnection http_connection = null;
		
		try {
		    http_connection = (HttpURLConnection) (this.getURI().toURL()).openConnection();
		    
		    log.debug("setting http method to: " + Config.getInstance().get(ConfigConstants.HTTP_METHOD));
		    http_connection.setRequestMethod(Config.getInstance().get(ConfigConstants.HTTP_METHOD));
		    http_connection.addRequestProperty("Content-Type",Config.getInstance().get(ConfigConstants.HTTP_CONTENTTYPE));
		    
		    
		                
		    // basic stuff
		    http_connection.setDoOutput(true);
		    http_connection.setAllowUserInteraction(false); // you may not ask the user
		    
		    
		               
		    if ( Config.getInstance().get(ConfigConstants.SERVERID)  != null ) {
		        http_connection.addRequestProperty("Server", Config.getInstance().get(ConfigConstants.SERVERID));
		    }
		    
		    // trying to confirm with RFC2616 section 14.23
		    http_connection.addRequestProperty("Host", buildHostHeader());
		    
		    status = SIFConnectionStatus.SENDING;
		    log.debug("sending request");
		    writeMessage(message,http_connection.getOutputStream());
		    http_connection.getOutputStream().flush();
		    http_connection.getOutputStream().close();

		               
		    // let's try reading from the http connection
		    http_connection.connect();
		    
		    this.status = SIFConnectionStatus.RECEIVING;
		    
		    if (http_connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
		        log.debug("request OK (200)");
		        response = this.readMessage(http_connection.getInputStream());
		    }
		    else {
		        log.error("invalid response code: " + http_connection.getResponseCode());
		        log.error(http_connection.getHeaderFields().toString());
		       
		    }
		    
		            
		}
		catch (Exception ex) {
		    log.error("generic error",ex); 
		    this.status = SIFConnectionStatus.ERROR;
		    throw(ex);
		   
		}
		finally {          
		    //TODO maybe not do this?
		    http_connection.disconnect();
		    log.debug("request done");
		 
		}
		this.status = SIFConnectionStatus.READY;
		return(response);
	}
	
	/**
	 * Creates a new instance of HttpSIFConnection
	 */
	public HTTPSIFConnection() {
		log.info("http sif connection object created");
		


		// HTTP AUTH
		
		if (Config.getInstance().get(ConfigConstants.HTTP_AUTH_USERNAME) != null ) {
			log.info("configuring HTTP authentication");
			String http_username = Config.getInstance().get(ConfigConstants.HTTP_AUTH_USERNAME);
			try {
				String http_password = Config.getInstance().getOrException(ConfigConstants.HTTP_AUTH_PASSWORD);
				log.debug("loading custom authenticator");
				CustomAuthenticator custom_auth = new CustomAuthenticator(http_username, http_password);
				Authenticator.setDefault(custom_auth);
				log.debug("loading custom authenticator...done");
				
			} catch (Exception e) {
				log.error("Incomplete HTTP configuration... HTTP subsystem will not use authentication",e);
			}

		}

	}
	/**
	 * Dummy TrustManager that bypasses certificate and hostname validation.
	 *
	 * {@link: http://wiki.rpath.com/wiki/rPath_Appliance_Platform_Agent:XML-RPC_Java_Client} 
	 *
	 *
	 */
	private static void loadDummyTrustManager() {

		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] {
			new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
				    return null;
				}
		 
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				    // Trust always
				}
		 
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				    // Trust always
				}
			    }
			};
		 
			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			// Create empty HostnameVerifier
			HostnameVerifier hv = new HostnameVerifier() {
			    public boolean verify(String arg0, SSLSession arg1) {
				    return true;
			    }
			};
		 
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
		}
		catch (Exception ex) {
			log.error("Error while loading bypass trustmanager!",ex);
		}

	}



	
}

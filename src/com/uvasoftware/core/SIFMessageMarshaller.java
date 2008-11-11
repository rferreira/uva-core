package com.uvasoftware.core;


import com.uvasoftware.core.exception.*;
import com.uvasoftware.core.util.Config;
import com.uvasoftware.core.util.ConfigConstants;

import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

/** 
 * Singleton class that deals with Jaxb for the conversion of objects into XML and Back
 * <p>
 * You should not have to deal directly with this class
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public final class SIFMessageMarshaller {
    
	/*
     * Attributes:
     */
	
	private static Logger log = Logger.getLogger(SIFMessageMarshaller.class);
	
    //jaxb marshaller instance
    private static SIFMessageMarshaller _instance = new SIFMessageMarshaller();
    private Marshaller jaxb_marshaller = null;
    private Unmarshaller jaxb_unmarshaller = null;

    /*
     * Methods:
     */
    
    /** 
     * Internal ctor for the creation of the singleton
     */
    private SIFMessageMarshaller() {
    	log.info("XML engine is starting up...");
        try {
        	
        	// We need to setup the jaxb with the SIF primitive not the facade!
            JAXBContext jb = JAXBContext.newInstance(com.uvasoftware.core.primitives.SIFMessage.class);
            this.jaxb_marshaller = jb.createMarshaller();     
            this.jaxb_unmarshaller = jb.createUnmarshaller();
            
            if (Config.getInstance().getOrException(ConfigConstants.FORMAT_XML).contains("true")) {
            	log.debug("enabling formated xml");
            	enableFormatedOutput();
            }

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }catch (Exception ex) {
            log.error(ex);
            ex.printStackTrace();
        }


        if (this.jaxb_marshaller == null || this.jaxb_unmarshaller == null)  {
            try {
                throw (new Exception("could not properly init jaxb marshallers"));                
            } catch (Exception ex) {
                log.error(ex);
                ex.printStackTrace();

            }                
        }
        log.info("done!");
        
    }
    
    /**
     * Returns an instance of the singleton class for your delight
     * @return the singleton 
     */
    public static SIFMessageMarshaller getInstance() { 
        return(_instance); 
    }

    /**
     * 	Converts message to XML and serializes it down the stream
     * 
     * @param obj the object to be marshalled (notice this is supposed to be a primitive)
     * @param out the output stream to be used 
     * @throws Exception
     */
    public void marshal(com.uvasoftware.core.primitives.SIFMessage obj, OutputStream out) throws ProtocolParseException {
    	try {
    		this.jaxb_marshaller.marshal(obj,out);
    	} catch (Exception ex) {
    		throw new ProtocolParseException(ex.getMessage());
    	}
    }
    
    /**
     * Helper method that facilitates marshalling an AbstracSIFMessage
     * @param msg the message to be marshaled
     * @param out the output stream to be used
     * @throws Exception
     */
    public void marshal(SIFMessage msg, OutputStream out) throws Exception {
    	this.marshal((com.uvasoftware.core.primitives.SIFMessage) msg.getPrimitive(), out);
    }
    
    
    /**
     * 	Converts message from XML to a java object
     * 
     * @param is the input stream to be used
     * @return a SIFMessage primitive that represents the XML message 
     * @throws Exception
     */

    public SIFMessage unmarshal(InputStream is ) throws ProtocolParseException {
    	try {
    		SIFMessage msg = new SIFMessage(jaxb_unmarshaller.unmarshal(is));
    		return(msg);
    	} catch (Exception ex) {
    		throw new ProtocolParseException(ex.getMessage());
    	}
    	    
    }


    public boolean enableFormatedOutput() {
    	log.info("enabling formated XML output");
        try {
            this.jaxb_marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        } catch (PropertyException ex) {
            return(false);
        }
        return(true);
    }

    public boolean disableFormatedOutput() {
    	log.info("disabling formated XML output");
        try {
            this.jaxb_marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.FALSE);
        } catch (PropertyException ex) {
            return(false);
        }
        return(true);
    }    



}

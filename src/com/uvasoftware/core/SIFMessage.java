package com.uvasoftware.core;

import java.io.ByteArrayOutputStream;
import org.apache.log4j.Logger;

import com.uvasoftware.core.util.*;

/**
 * Abstract  Class that should be inherited when creating a new type of SIF message
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SIFMessage implements ISIFObject{
	
	// cached info	
	// static final String PROTOCOL_VERSION = Config.getInstance().get(ConfigConstants.PROTOCOL_VERSION);  
	
	protected com.uvasoftware.core.primitives.SIFMessage message = null; 
	private static Logger log = Logger.getLogger(SIFMessage.class);
	static final String PROTOCOL = Config.getInstance().get(ConfigConstants.PROTOCOL_VERSION);

	/**
	 * Enum for all the different types of sif messages
	 */
	public static enum Type { PING, WAKEUP, SLEEP, GETMESSAGE, UNSUBSCRIBE, UNREGISTER, UNPROVIDE, SUBSCRIBE, RESPONSE, REQUEST, REGISTER, 
		PROVIDE, EVENT, NONE, ACK } 
	
	private Type type_cache = Type.NONE; 

	
	public SIFMessage() {
		//log.debug("ctor");
		message = new com.uvasoftware.core.primitives.SIFMessage();
		setProtocolVersion(PROTOCOL);

	}	
	/**
	 * Creates a new SIFMessage from an XML primitive
	 * 
	 * @param primitive
	 */
	public SIFMessage(Object primitive) {
		setPrimitive(primitive);
	}
	
	/**
	 * Returns the SIFMessage primitive that this message represents 
	 * 
	 * @return a com.uvasoftware.core.primitives.SIFMessage primitive
	 */
	public Object getPrimitive() {
		//TODO: this should return a copy of the message - rendering this immutable
		return(message);
	}

	/**
	 * Converts a primitive type into a SIFMessage
	 * TODO: FIX
	 */
	public void setPrimitive(Object primitive) {
		if (primitive instanceof com.uvasoftware.core.primitives.SIFMessage ) {
			message = (com.uvasoftware.core.primitives.SIFMessage) primitive;
		} else {
			log.error("type [" + primitive.getClass().getName() + "] does not match SIFMessage primitive");
			throw new IllegalArgumentException();

		}
		
	}
	
	/**
	 * Marshals and returns the string representation of the SIF message
	 * 
	 */
	public String toString() {
		String ret = null;
		
		try {
			SIFMessageMarshaller m = SIFMessageMarshaller.getInstance();
			ByteArrayOutputStream o = new ByteArrayOutputStream();
			m.marshal(this,o);
			ret = o.toString();
			
		}catch (Exception e) {
			log.error(e);
		}
		
		return(ret);
	}

	/**
	 * Returns the SIFAck internal to this message
	 * @return
	 */
	public final  SIFAck getAck() {
		SIFAck ack = new SIFAck();
		ack.setPrimitive(message);
		return(ack);
	}

	/**
	 * Returns the SIFEvent internal to this message
	 * @return
	 */
	public SIFEvent getEvent() {
		return(new SIFEvent(message));
	}
	
	@Deprecated()
	public SIFEvent getSIFEvent() {
		return(this.getEvent());
	}
	/**
	 * Returns the SIFPing internal to this message
	 * @return
	 */
	public SIFPing getPing() {
		SIFPing ping = new SIFPing();
		ping.setPrimitive(message);
		return(ping);
	}
	
	/**
	 * Returns the SIFProvide internal to this message
	 * @return
	 */
	public SIFProvide getProvide() {
		SIFProvide provide = new SIFProvide();
		provide.setPrimitive(message);
		return(provide);
	}

	/**
	 * Returns the SIF_GetMessage internal to this message
	 * @return
	 */
	public SIFGetMessage getGetMessage() {
		SIFGetMessage msg = new SIFGetMessage(message);
		return(msg);
	}
	
	/**
	 * Returns the SIFRegister internal to this message
	 * @return
	 */
	public SIFRegister getRegister() {
		SIFRegister register = new SIFRegister(message);
		return(register);
	}
	
	/**
	 * Returns the SIFRequest internal to this message
	 * @return
	 */
	public SIFRequest getRequest() {
		SIFRequest request = new SIFRequest();
		request.setPrimitive(message);
		return(request);
	}

	
	/**
	 * Returns the SIFSleep internal to this message
	 * @return
	 */
	public SIFSleep getSleep() {
		SIFSleep sleep = new SIFSleep();
		sleep.setPrimitive(message);
		return(sleep);
	}
	
	/**
	 * Returns the SIFSubscribe internal to this message
	 * @return
	 */
	public SIFSubscribe getSubscribe() {
		SIFSubscribe subscribe = new SIFSubscribe();
		subscribe.setPrimitive(message);
		return(subscribe);
	}
	
	/**
	 * Returns the SIFUnprovide internal to this message
	 * @return
	 */
	public SIFUnProvide getUnProvide() {
		SIFUnProvide unprovide = new SIFUnProvide();
		unprovide.setPrimitive(message);
		return(unprovide);
	}
	
	/**
	 * Returns the SIFUnregister internal to this message
	 * @return
	 */
	public SIFUnRegister getUnRegister() {
		SIFUnRegister unregister = new SIFUnRegister();
		unregister.setPrimitive(message);
		return(unregister);
	}
	
	/**
	 * Returns the SIFUnsubscribe internal to this message
	 * @return
	 */
	public SIFUnSubscribe getUnSubscribe() {
		SIFUnSubscribe unsubscribe = new SIFUnSubscribe();
		unsubscribe.setPrimitive(message);
		return(unsubscribe);
	}
	
	/**
	 * Returns the SIFWakeup internal to this message
	 * @return
	 */
	public SIFWakeup getWakeup() {
		SIFWakeup wakeup = new SIFWakeup();
		wakeup.setPrimitive(message);
		return(wakeup);
	}
	
	/**
	 * Returns the SIFResponse internal to this message
	 */
	 public SIFResponse getResponse() {
		 SIFResponse resp = new SIFResponse();
		 resp.setPrimitive(message);
		 return(resp);
	 }
	 
	 /**
	  * Returns a copy of the SIFHeader encapsulated in this message
	  * @return the sif header or null if there's an error
	  */
	 public SIFHeader getHeader() {
		 
		 Type  t = getType();
		 
		 if ( t == Type.ACK ) {
			 return(new SIFHeader(this.message.getSIFAck().getSIFHeader()));
		 
		 }else if ( t == Type.EVENT) {
			 return(new SIFHeader(this.message.getSIFEvent().getSIFHeader()));
		 
		 }else if ( t == Type.PROVIDE) {
			 return(new SIFHeader(this.message.getSIFProvide().getSIFHeader()));
		 
		 }else if ( t == Type.REGISTER) {
			 return(new SIFHeader(this.message.getSIFRegister().getSIFHeader()));
		 
		 }else if ( t == Type.REQUEST) {
			 return(new SIFHeader(this.message.getSIFRequest().getSIFHeader()));
		 
		 }else if ( t == Type.RESPONSE) {
			 return(new SIFHeader(this.message.getSIFResponse().getSIFHeader()));
		 
		 }else if ( t == Type.SUBSCRIBE) {
			 return(new SIFHeader(this.message.getSIFSubscribe().getSIFHeader()));
		 
		 }else if (t == Type.PING || t == Type.SLEEP || t == Type.WAKEUP || t == Type.GETMESSAGE) {
			 return(new SIFHeader(this.message.getSIFSystemControl().getSIFHeader()));
		 		 			 
		 }else if ( t == Type.UNPROVIDE) {
			 return(new SIFHeader(this.message.getSIFUnprovide().getSIFHeader()));
		 
		 }else if ( t == Type.UNREGISTER) {
			 return(new SIFHeader(this.message.getSIFUnregister().getSIFHeader()));
		 }
		 else if ( t == Type.UNSUBSCRIBE) {
			 return(new SIFHeader(this.message.getSIFUnsubscribe().getSIFHeader()));
		 }

		 log.error("call to getHeader failed");
		 
		 // fallback
		 return(null);
	 
	 }
	 /**
	  * Sets the SIFHeader encapsulated in this message
	  * @param value the new sif header for this message
	  */
	 public void setHeader(SIFHeader value) {
		 
		 Type  t = getType();
		 
		 if ( t == Type.ACK ) {
			 this.message.getSIFAck().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.EVENT) {
			 this.message.getSIFEvent().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.PROVIDE) {
			 this.message.getSIFProvide().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.REGISTER) {
			 this.message.getSIFRegister().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.REQUEST) {
			 this.message.getSIFRequest().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.RESPONSE) {
			 this.message.getSIFResponse().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 }else if ( t == Type.SUBSCRIBE) { 
			 this.message.getSIFSubscribe().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if (t == Type.PING || t == Type.SLEEP || t == Type.WAKEUP || t == Type.GETMESSAGE) {
			 this.message.getSIFSystemControl().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 		 			 
		 }else if ( t == Type.UNPROVIDE) {
			 this.message.getSIFUnprovide().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
		 
		 }else if ( t == Type.UNREGISTER) {
			 this.message.getSIFUnregister().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
			 
		 }
		 else if ( t == Type.UNSUBSCRIBE) {
			 this.message.getSIFUnsubscribe().setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) value.getPrimitive());
			 
		 }			 
	 
	 }
	 
	 /** 
	  * Returns the enumeration type of this message<p>
	  * You should note that this actually uncovers the type of the XML primitive and caches the result, as such, it synchronizes on the message type
	  * @return the SIFMessage.Type that matches this message or None if it can't figure it out
	  */
	 public SIFMessage.Type getType() {
		 synchronized(type_cache) {
			 if (type_cache == Type.NONE) {
				 _parseType();
			 }
		 }
		 
		 return(type_cache);
		 
	 }
	 
	 /** 
	  * Returns this message's id
	  */
	 public String getId() {
		 
		 if (this.getHeader() == null )
			 return(null);
		 return(this.getHeader().getId());
	 }
	
	 /** 
	  * Returns this message's source id
	  */
	 public String getSourceId() {
		 if (this.getHeader() == null )
			 return(null);
		 //log.debug("returning:" + this.getHeader().getSourceId());
		 return(this.getHeader().getSourceId());
	 }
	 
	 /**
	  * Generates a response ack to this message (handling all the header matching for you)
	  * @return a sifack to be sent as a response to the this message
	  */
	 public SIFAck createResponseAck() {
		 SIFAck ack = new SIFAck(this.getSourceId(),this.getId());
		 return(ack);
		 
	 }
	 
	 /**
	  * Sets message to the protocol version specified by version
	  * @param version
	  */
	 public void setProtocolVersion(String version) {
		 message.setVersion(version);
	 }
	 /**
	  * Gets the message protocol version
	  */
	 public String getProtocolVersion() {
		return(message.getVersion());
	 }
	 
	 private void _parseType() {
		// uncovering type
			// PING, WAKEUP, SLEEP, GETMESSAGE, UNSUBSCRIBE, UNREGISTER, UNPROVIDE, SUBSCRIBE, RESPONSE, REQUEST, REGISTER, 
			// PROVIDE, EVENT, NONE, ACK
			
		if (message.getSIFAck() != null ) {
			type_cache = Type.ACK;
			return;
		}else if ( message.getSIFEvent() != null ) {
			type_cache = Type.EVENT;
			return;
		}else if (message.getSIFProvide() != null) {
			type_cache = Type.PROVIDE;
			return;
		}else if (message.getSIFUnprovide() != null) {
			type_cache = Type.UNPROVIDE;
			return;
		}else if (message.getSIFRegister() != null) {
			type_cache = Type.REGISTER;
			return;
		}else if (message.getSIFUnregister() != null) {
			type_cache = Type.UNREGISTER;
			return;
		}else if (message.getSIFRequest() != null) {
			type_cache = Type.REQUEST;
			return;
		}else if (message.getSIFResponse() != null) {
			type_cache = Type.RESPONSE;
			return;
		}else if (message.getSIFSubscribe() != null) {
			type_cache = Type.SUBSCRIBE;
			return;
		}else if (message.getSIFUnsubscribe() != null) {
			type_cache = Type.UNSUBSCRIBE;
			return;
		}else if (message.getSIFRequest() != null ) {
			type_cache = Type.REQUEST;
			return;
		}else if (message.getSIFSystemControl() != null) {
			if (message.getSIFSystemControl().getSIFSystemControlData().getSIFPing() != null ) type_cache = Type.PING;
			if (message.getSIFSystemControl().getSIFSystemControlData().getSIFWakeup() != null ) type_cache = Type.WAKEUP;
			if (message.getSIFSystemControl().getSIFSystemControlData().getSIFSleep() != null ) type_cache = Type.SLEEP;
			if (message.getSIFSystemControl().getSIFSystemControlData().getSIFGetMessage() != null ) type_cache = Type.GETMESSAGE;
		}
	 }
	 
}

package com.uvasoftware.core;

import org.apache.log4j.Logger;
import com.uvasoftware.core.util.ReflectionHelper;
import com.uvasoftware.core.util.PrimitiveHelper;;

/**
 * Represents a <code>SIF_Event</code> message 
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Event</code> as follows:
 * <blockquote> 
 * <code>SIF_Event</code> is used to deliver event objects as defined in SIF. Events represent changes to a data object.
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>   
 */
public class SIFEvent extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFEvent.class);
	
	/**
	 * Define enum for attribute <code>SIF_ObjectData/SIF_EventObject/Action</code>
	 */
	public enum Action { Add, Change, Remove }
	
	/**
	 * Creates a new <code>SIF_Event</code> from an XML primitive
	 * 
	 * @param primitive
	 */
	public SIFEvent(Object primitive) {
		setPrimitive(primitive);
	}
	/**
	 * Creates a new <code>SIF_Event</code> message
	 * @param eventObject <code>SIF_EventObject</code> this <code>SIF_Event</code> regards
	 * @param eventObjectName <code>ObjectName</code> of <b>eventObject</b>
	 * @param eventAction <code>Action</code> taken for <b>eventObject</b>
	 */
	public SIFEvent() {
		
		// Initiate SIF_Event, SIFEvent.SIFObjectData, and SIFEventObject elements
		com.uvasoftware.core.primitives.SIFEvent event = new com.uvasoftware.core.primitives.SIFEvent();
		com.uvasoftware.core.primitives.SIFEvent.SIFObjectData objData = new com.uvasoftware.core.primitives.SIFEvent.SIFObjectData();
		

		// Populate what we can
		event.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		event.setSIFObjectData(objData);
		
		message.setSIFEvent(event);
	}

	public void setEventData(ISIFObject eventObject, String objectName, Action action)  throws Exception {
		com.uvasoftware.core.primitives.SIFEvent.SIFObjectData data = message.getSIFEvent().getSIFObjectData();
		
		log.debug("setting object of type:" + eventObject.getClass());
		
		// populating the object name stuff
		com.uvasoftware.core.primitives.SIFEventObject eo = new com.uvasoftware.core.primitives.SIFEventObject();
		eo.setAction(action.toString());
		
		eo.setObjectName(com.uvasoftware.core.primitives.SubscribeObjectNames.fromValue(objectName));
		
		// injecting data into primitive using reflection
		try {
			Object[] args = { eventObject.getPrimitive() };
			log.debug(eventObject.getPrimitive().getClass());
			log.debug(args.toString());
			
			ReflectionHelper.callMethod(eo, "set" + objectName, args, eventObject.getPrimitive().getClass()  );
			data.setSIFEventObject(eo);
			message.getSIFEvent().setSIFObjectData(data);
			
		} catch (Exception ex) {
			log.error("dynamically setting event object failed", ex);
			ex.printStackTrace();
			throw(ex);
		}
		
		
		
	}
	
 	// better methods:
	/**
	 * Returns the name of the object contained in this message
	 */
	public SIFObjectName getEventObjectName() {
		SIFObjectName name = null;
		if ( message.getSIFEvent().getSIFObjectData() == null) return(null);
		if ( message.getSIFEvent().getSIFObjectData().getSIFEventObject() == null) return(null);
		try {
			
			name = SIFObjectName.valueOf(message.getSIFEvent().getSIFObjectData().getSIFEventObject().getObjectName().value());
		} catch (Exception e) {
			log.error("could not parse object name",e);
		}
 		
		return(name);
	}
	/**
	 * Sets the action for this event
	 * @param action the action to set to
	 */
	public void setAction( SIFEvent.Action action ) {
		if ( message.getSIFEvent().getSIFObjectData() == null) return;
		if ( message.getSIFEvent().getSIFObjectData().getSIFEventObject() == null) return;
				
		message.getSIFEvent().getSIFObjectData().getSIFEventObject().setAction(action.toString());
	}
	
	/**
	 * Returns the action encapsulated by this event
	 * @return the event type or null if no event is currently associated with this message
	 */
	public SIFEvent.Action getAction() {
		if ( message.getSIFEvent().getSIFObjectData() == null) return(null);
		if ( message.getSIFEvent().getSIFObjectData().getSIFEventObject() == null) return(null);
				
		return(SIFEvent.Action.valueOf(message.getSIFEvent().getSIFObjectData().getSIFEventObject().getAction() ));
	}
	
	/**
	 * Returns the event object referenced by this message
	 * @return the event object itself
	 */
	public ISIFObject getEventObject() {
		log.debug("returning sif event object");
		ISIFObject ret = null;
		
		if ( message.getSIFEvent().getSIFObjectData() == null) return(null);
		if ( message.getSIFEvent().getSIFObjectData().getSIFEventObject() == null) return(null);
		
		
		com.uvasoftware.core.primitives.SubscribeObjectNames name = message.getSIFEvent().getSIFObjectData().getSIFEventObject().getObjectName();
	
		try {
			Object o = ReflectionHelper.callMethod(message.getSIFEvent().getSIFObjectData().getSIFEventObject(), "get"+ name.value());
			ret = PrimitiveHelper.getWrapperFromPrimitive(o);
		} catch (Exception ex) {
			log.error("error dynamically fetching event object", ex);
		}
		
		return(ret);
	}
}
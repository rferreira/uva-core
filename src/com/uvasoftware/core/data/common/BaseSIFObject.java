package com.uvasoftware.core.data.common;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import org.apache.log4j.Logger;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import com.uvasoftware.core.SIFObjectName;
import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.ReflectionHelper;

/**
 * Abstracts a series of behaviors common to all SIF data objects
 *  @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class BaseSIFObject implements ISIFObject{

	private static Logger log = Logger.getLogger(BaseSIFObject.class);
	
	/**
	 * Adds a  <code>SIF_ExtendedElement</code> to this data object
	 * <p>
	 * Note: This method uses reflection hence it is a litter slower than normal. 
	 * 
	 * @param el the ExtendedElement to be added
	 * @return true if the addition worked and false if not
	 */
	 public boolean addExtendedElement(ExtendedElement el) {	
		try {
			
			
			Object primitive = ReflectionHelper.callMethod(this, "getPrimitive");
			com.uvasoftware.core.primitives.SIFExtendedElements elements = (com.uvasoftware.core.primitives.SIFExtendedElements) ReflectionHelper.callMethod(primitive, "getSIFExtendedElements");
			/*
			// getting primitive
			Method method = this.getClass().getMethod("getPrimitive");
			Object primitive = method.invoke(this, new Object[0]);
			
			
			// getting extended elements
			method = primitive.getClass().getMethod("getSIFExtendedElements");
			com.uvasoftware.core.primitives.SIFExtendedElements elements = (com.uvasoftware.core.primitives.SIFExtendedElements) method.invoke(primitive, new Object[0]);
			
			*/
			
			if (elements == null ) {
				elements = new com.uvasoftware.core.primitives.SIFExtendedElements();
				
				// now we need to inject the new list
				/*
				method = primitive.getClass().getMethod("setSIFExtendedElements", elements.getClass());			
				method.invoke(primitive, elements);
				*/
				Object obs [] = { elements };
				
				ReflectionHelper.callMethod(primitive, "setSIFExtendedElements", obs, elements.getClass());
			}
			
			
			elements.getSIFExtendedElement().add( (com.uvasoftware.core.primitives.SIFExtendedElement) el.getPrimitive());
			
			return(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return(false);
	}
	 
	/**
	 * Adds a new key pair as extended SIF elements 
	 * @param name the extended element's name
	 * @param value the extended elements value
	 * @return true if it succeeds and false otherwise 
	 */
	public boolean addExtendedElement(String name, String value) {
		return(addExtendedElement(new ExtendedElement(name,value)));
		
	}
	
	/**
	 * Returns a copy of the list of <code>SIF_ExtendedElements</code> currently associated with this data object
	 * @return a List containing all the <code>SIF_ExtendedElement</code> nodes
	 */
	public List <ExtendedElement> getExtendedElements() {
		ArrayList <ExtendedElement> resp = new ArrayList <ExtendedElement> ();

		try {
			
			// getting primitive
			Method method = this.getClass().getMethod("getPrimitive");
			Object primitive = method.invoke(this, new Object[0]);
			
			
			// getting extended elements
			method = primitive.getClass().getMethod("getSIFExtendedElements");
			com.uvasoftware.core.primitives.SIFExtendedElements elements = (com.uvasoftware.core.primitives.SIFExtendedElements) method.invoke(primitive, new Object[0]);
			
			
			for (com.uvasoftware.core.primitives.SIFExtendedElement e: elements.getSIFExtendedElement()) {
				resp.add(new ExtendedElement(e.getName(),e.getValue()));
				
			}
			
					
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return(resp);
	}
	
	/**
	 * Marshals the SIF object to XML 
	 * <b>Note:</b> this is a very expensive operation and it should not be used lightly. 
	 */
	public String toString() {
        try {
        	
        	// getting primitive
			Method method = this.getClass().getMethod("getPrimitive");
			Object primitive = method.invoke(this, new Object[0]);
        	
        	
        	// We need to setup the jaxb with the SIF primitive not the facade!
            JAXBContext jb = JAXBContext.newInstance(primitive.getClass());
            ByteArrayOutputStream o = new ByteArrayOutputStream();
            jb.createMarshaller().marshal(primitive,o);
            return(o.toString());
            

        } catch (Exception ex) {
            log.error(ex);
            ex.printStackTrace();
        }
        return(null);
	}
	
	/**
	 * Returns the SIFObjectName of this object or null if it cannot figure it out
	 * @return the  SIFObjectName of this object
	 * @see com.uvasoftware.core.SIFObjectName
	 */
	public SIFObjectName getSIFObjectName() {
		
		// special cases (infra stuff)
		
		Class klass = this.getClass();
		
		if (klass == com.uvasoftware.core.data.infra.SIFZoneStatus.class) {
			return (SIFObjectName.SIFZoneStatus);
		}
		
		String name = klass.getName();
		
		if (name.lastIndexOf('.') > 0) {
			name = name.substring(name.lastIndexOf('.') +1);
			
		}
		
		name = name.replace('$','.');
		
		SIFObjectName n = SIFObjectName.valueOf(name);
		
		return n;
				
	}
	
	// HANDLING PRIMITIVES - BEWARE THIS INVOLVES SOME BLACK MAGIC
	/**
	 * Returns the primitive representation of this object
	 * 
	 * @see com.uvasoftware.core.ISIFObject#getPrimitive()
	 */
	public Object getPrimitive() {
		
		try {	
			Field f = (Field) ReflectionHelper.getPrivateField(this, "primitive");
			return f.get(this);
		}
		catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
		}
		return(null);
	}

	/**
	 * Sets the primitive representation of this object
	 * @param obj the new primitive for this object 
	 */
	public void setPrimitive(Object obj) {
		
		try {
			Field f = (Field) ReflectionHelper.getPrivateField(this, "primitive");
			f.set(this,obj);
		}
		catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
		}
		
	}
	
}

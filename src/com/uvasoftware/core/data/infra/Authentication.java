/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core.data.infra;

import com.uvasoftware.core.data.common.BaseSIFObject;
import com.uvasoftware.core.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Maps to a <code>Authentication</code> SIF object used for exposing login information from one system into the rest of the zone. 
 * 
 * @author <a href="raf@uvasoftware.com">Rafael Ferreira</a>
 *
 */
public class Authentication extends BaseSIFObject {
	com.uvasoftware.core.primitives.Authentication primitive = null;

	/**
	 * No option ctor
	 */
	public Authentication() {
		this.primitive = new com.uvasoftware.core.primitives.Authentication();
	}
	
		
	/**
	 * Creates a new object from an XML primitive
	 * @param primitive the XML primitive
	 */
	public Authentication(com.uvasoftware.core.primitives.Authentication primitive) {
		this.primitive = primitive;
	}
	
	/**
	 * Creates a new authentication object with its required attributes
	 * @param SIFRefId the sif wide unique identifier of a student or staff
	 * @param SIFRefIdType the type of sif object SIFRefId identifies
	 */
	public Authentication( String SIFRefId, String SIFRefIdType) {
		primitive = new com.uvasoftware.core.primitives.Authentication();
		
		this.primitive.setRefId(SIFGUID.next());
		this.primitive.setSifRefId(SIFRefId);
		this.primitive.setSifRefIdType(SIFRefIdType);
		
	}
	
	/**
	 * Adds a new <code>AuthenticationInfo</code> entry to this object
	 * @param info the new authenticationifo object to be added
	 */
	public void addAuthenticationInfo(AuthenticationInfo info) {
		this.primitive.getAuthenticationInfo().add( (com.uvasoftware.core.primitives.AuthenticationInfo) info.getPrimitive());
	}
	
	/**
	 * Returns a list containing all the <code>AuthenticationInfo</code> associated with this class
	 */
	public List<AuthenticationInfo> getAuthenticationInfo() {
		ArrayList<AuthenticationInfo> l = new ArrayList<AuthenticationInfo>();
		AuthenticationInfo a = null;
		
		for (com.uvasoftware.core.primitives.AuthenticationInfo i: this.primitive.getAuthenticationInfo()) {
			a = new AuthenticationInfo(i);
			l.add(a);
		}
		return(l);
		
	}
	
	/**
	 * Returns the refid associated with this <code>Authentication</code> object
	 */
	public String getRefId() { return(this.primitive.getRefId()); }
	
	/**
	 * Returns the SIF refid associated with this <code>Authentication</code> object
	 */
	public String getSIFRefId() { return(this.primitive.getSifRefId()); }
	
	/**
	 * Returns the SIF refid type associated with this <code>Authentication</code> object
	 */
	public String getSIFRefIdType() { return(this.primitive.getSifRefIdType()); }
}

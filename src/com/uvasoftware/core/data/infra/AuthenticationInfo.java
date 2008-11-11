/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core.data.infra;

import com.uvasoftware.core.data.common.BaseSIFObject;

public class AuthenticationInfo extends BaseSIFObject {
	com.uvasoftware.core.primitives.AuthenticationInfo primitive = null;
	
	/**
	 * Lists the valid authentication system types 
	 */
	public enum SystemType { Network, Application };
	
	/**
	 * Lists the valid authentication algorithms
	 */
	public enum PasswordAlgorithm { base64, MD5, SHA1, DES, TripleDES, RC2, RSA, DSA };
	
	
	/**
	 * Creates a new object from an XML primitive
	 * @param primitive the XML primitive
	 */
	public AuthenticationInfo(com.uvasoftware.core.primitives.AuthenticationInfo primitive) {
		this.primitive = primitive;
	}
	
	public AuthenticationInfo(String systemName, SystemType type) {
		this.primitive = new com.uvasoftware.core.primitives.AuthenticationInfo();
		com.uvasoftware.core.primitives.System s = new com.uvasoftware.core.primitives.System();
		s.setType(type.toString());
		s.setValue(systemName);
		this.primitive.setSystem(s);
	}
	/**
	 * Returns the system name associated with this authentication message
	 */
	public String getSystemName() { return(primitive.getSystem().getValue()); }
	
	/**
	 * Returns the system type associated with this message
	 */
	public SystemType getSystemType() { return(SystemType.valueOf(primitive.getSystem().getType())); }
	
	
	/**
	 * sets the user name associated with this message
	 * @param userName 
	 */
	public void setUserName(String userName) { this.primitive.setUsername(userName); }
	
	/**
	 * gets the username associated with this message
	 */
	public String getUserName() { return(this.primitive.getUsername()); }
	
	/**
	 * Sets all the required information for the password to be stored in this object
	 * @param pa the algorithm used to encrypt the password
	 * @param keyName the name of the key needed for decryption
	 * @param value the password itself
	 */
	public void setPassword(PasswordAlgorithm pa, String keyName, String value) {
		com.uvasoftware.core.primitives.Password pw = new com.uvasoftware.core.primitives.Password();
		pw.setAlgorithm(pa.toString());
		pw.setKeyName(keyName);
		pw.setValue(value);
		this.primitive.setPassword(pw);
	}
	
	/** 
	 * Returns the algorithm used to encrypt this password
	 */
	public PasswordAlgorithm  getPasswordAlgorithm() {
		return( PasswordAlgorithm.valueOf(this.primitive.getPassword().getAlgorithm()));
	}
	
	/**
	 * Returns the name of they key to be used for decryption
	 */
	public String getPasswordKeyName() {
		return(this.primitive.getPassword().getKeyName());
	}
	
	/**
	 * Returns the password itself
	 */
	public String getPassword() {
		return(this.primitive.getPassword().getValue());
	}
	
	/**
	 * Sets the distinguished name associated with this password
	 */
	public void setDistinguishedName(String value) { this.primitive.setDistinguishedName(value); }
	 
	/**
	 * Gets the distinguished name associated with this password
	 */
	public String getDistinguishedName() { return(this.primitive.getDistinguishedName()); }
	
	
}

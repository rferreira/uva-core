/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.data.common;

/**
 * This class represents a SIF <code>GridLocation</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class GridLocation extends BaseSIFObject {

	com.uvasoftware.core.primitives.GridLocation primitive = new com.uvasoftware.core.primitives.GridLocation();
	
	
	/**
	 * Creates a new GridLocation object with the assigned GridLocation type
	 * 
	 * @param latitude the latitude of the location
	 * @param longitude the longitude of the location
	 */
	public GridLocation(String latitude, String longitude) {
		primitive.setLatitude(latitude);
		primitive.setLongitude(longitude);
	}
	/** 
	 * Gets the <code>Latitude</code> field of the <code>GridLocation</code> element
	 * @return the latitude of the location
	 */
	public String getLatitude() {
		return(primitive.getLatitude());
	}
	/** 
	 * Sets the <code>Latitude</code> field of the <code>GridLocation</code> element
	 * @param latitude the latitude of the location
	 */
	public void setLatitude(String latitude) {
		primitive.setLatitude(latitude);
	}
	/** 
	 * Gets the <code>Longitude</code> field of the <code>GridLocation</code> element
	 * @return the longitude of the location
	 */
	public String getLongitude() {
		return(primitive.getLongitude());
	}
	/** 
	 * Sets the <code>Longitude</code> field of the <code>GridLocation</code> element
	 * @param longitude the longitude of the location
	 */
	public void setLongitude(String longitude) {
		primitive.setLongitude(longitude);
	}

}

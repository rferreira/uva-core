/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 

package com.uvasoftware.core.data.common;


/**
 * This class represents a SIF <code>Address</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class Address extends BaseSIFObject {

	com.uvasoftware.core.primitives.Address primitive = new com.uvasoftware.core.primitives.Address();
	
	/**
	 * Returns the primitive representation of this object
	 * 
	 * @see com.uvasoftware.core.ISIFObject#getPrimitive()
	 */
	public Object getPrimitive() {
		return(primitive);
	}

	/**
	 * Sets the primitive representation of this object
	 */
	public void setPrimitive(Object value) {
		primitive = (com.uvasoftware.core.primitives.Address) value;
	}

	/**
	 * Creates a new Address object
	 * 
	 * @param type the <code>Address Type</code>
	 * @param street Line 1 of the street address
	 * @param city the name of the city
	 * @param zip the ZIP/postal code
	 * @param stateCode the corresponding <code>StateCode</code>
	 * @param countryCode the corresponding <code>CountryCode</code>
	 * 
	 * @see com.uvasoftware.core.data.common.data.code.AddressType0369
	 * @see com.uvasoftware.core.data.common.data.code.StateOrProvinceCode156
	 * @see com.uvasoftware.core.data.common.data.code.CanadianProvincesAndTerritories
	 * @see com.uvasoftware.core.data.common.data.code.CountryCode26
	 */
	public Address(String type, String street, String city, String zip, String stateCode, String countryCode) {
		primitive.setType(type);
		setStreetLine1(street);
		setCity(city);
		setPostalCode(zip);
		setStatePrCode(stateCode);
		setCountryCode(countryCode);	
	}
	/***
	 * Creates a new Address object
	 * 
	 * @param type the <code>Address Type</code>
	 */
	public Address() {
			
	}

	/**
	 * Creates a new Address object from an XML primitive
	 * 
	 * @param value the XML primitive
	 */
	public Address(com.uvasoftware.core.primitives.Address value) {
		this.primitive = value;
	}
	
	/** 
	 * Sets the <code>Type</code> field of the <code>Address</code> element
	 * @param type The address type
	 * @see com.uvasoftware.core.data.common.data.code.AddressType0369
	 */
	public void setType(String type) {
		primitive.setType(type);		
	}
	
	/** 
	 * Gets the <code>Type</code> field of the <code>Address</code> element
	 * @return the value of the <code>Address/Type</code> element 
	 */
	public String getType() {
		return(primitive.getType());
	}
	
	/** 
	 * Sets the <code>Line1</code> field of the <code>Address/Street</code> element
	 * @param streetLine1 Line 1 of the street address
	 */
	public void setStreetLine1(String streetLine1) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setLine1(streetLine1);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>Line1</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/Line1</code> element 
	 */
	public String getStreetLine1() {
		return(primitive.getStreet().getLine1());
	}
	
	/** 
	 * Sets the <code>Line2</code> field of the <code>Address/Street</code> element
	 * @param streetLine1 Line 2 of the street address
	 */
	public void setStreetLine2(String streetLine2) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setLine1(streetLine2);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>Line2</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/Line2</code> element 
	 */
	public String getStreetLine2() {
		return(primitive.getStreet().getLine1());
	}
	
	/** 
	 * Sets the <code>Line3</code> field of the <code>Address/Street</code> element
	 * @param streetLine1 Line 3 of the street address
	 */
	public void setStreetLine3(String streetLine3) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setLine3(streetLine3);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>Line3</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/Line3</code> element 
	 */
	public String getStreetLine3() {
		return(primitive.getStreet().getLine3());
	}
	
	/** 
	 * Sets the <code>Complex</code> field of the <code>Address/Street</code> element
	 * @param streetComplex name of the complex
	 */
	public void setStreetComplex(String streetComplex) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setComplex(streetComplex);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>Complex</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/Complex</code> element 
	 */
	public String getStreetComplex() {
		return(primitive.getStreet().getComplex());
	}
	
	/** 
	 * Sets the <code>StreetNumber</code> field of the <code>Address/Street</code> element
	 * @param streetNumber Numerical address assigned to the building
	 */
	public void setStreetNumber(String streetNumber) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setStreetNumber(streetNumber);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>StreetNumber</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/StreetNumber</code> element 
	 */
	public String getStreetNumber() {
		return(primitive.getStreet().getStreetNumber());
	}
	
	/** 
	 * Sets the <code>StreetPrefix</code> field of the <code>Address/Street</code> element
	 * @param streetPrefix Street prefix (N, SE, etc)
	 */
	public void setStreetPrefix(String streetPrefix) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setStreetPrefix(streetPrefix);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>StreetPrefix</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/StreetPrefix</code> element 
	 */
	public String getStreetPrefix() {
		return(primitive.getStreet().getStreetPrefix());
	}
	
	/** 
	 * Sets the <code>StreetName</code> field of the <code>Address/Street</code> element
	 * @param streetName the name of the street
	 */
	public void setStreetName(String streetName) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setStreetName(streetName);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>StreetName</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/StreetName</code> element 
	 */
	public String getStreetName() {
		return(primitive.getStreet().getStreetName());
	}
	
	/** 
	 * Sets the <code>StreetType</code> field of the <code>Address/Street</code> element
	 * @param streetType the type of street (Lane, St, Blvd, etc)
	 */
	public void setStreetType(String streetType) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setStreetType(streetType);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>StreetType</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/StreetType</code> element 
	 */
	public String getStreetType() {
		return(primitive.getStreet().getStreetType());
	}
	
	/** 
	 * Sets the <code>StreetSuffix</code> field of the <code>Address/Street</code> element
	 * @param streetSuffix Street suffix (NE, SW, etc)
	 */
	public void setStreetSuffix(String streetSuffix) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setStreetSuffix(streetSuffix);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>StreetSuffix</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/StreetSuffix</code> element 
	 */
	public String getStreetSuffix() {
		return(primitive.getStreet().getStreetSuffix());
	}
	
	/** 
	 * Sets the <code>AptType</code> field of the <code>Address/Street</code> element
	 * @param streetAptType Type of apartment (e.g., Suite)
	 */
	public void setStreetAptType(String streetAptType) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setAptType(streetAptType);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>AptType</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/AptType</code> element 
	 */
	public String getStreetAptType() {
		return(primitive.getStreet().getAptType());
	}
	
	/** 
	 * Sets the <code>AptNumPrefix</code> field of the <code>Address/Street</code> element
	 * @param streetAptNumPrefix Apartment number prefix
	 */
	public void setStreetAptNumPrefix(String streetAptNumPrefix) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setAptNumPrefix(streetAptNumPrefix);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>AptNumPrefix</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/AptNumPrefix</code> element 
	 */
	public String getStreetAptNumPrefix() {
		return(primitive.getStreet().getAptNumPrefix());
	}
	
	/** 
	 * Sets the <code>AptNumber</code> field of the <code>Address/Street</code> element
	 * @param streetAptNumber Number of the apartment
	 */
	public void setStreetAptNumber(String streetAptNumber) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setAptNumber(streetAptNumber);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>AptNumber</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/AptNumber</code> element 
	 */
	public String getStreetAptNumber() {
		return(primitive.getStreet().getAptNumber());
	}
	
	/** 
	 * Sets the <code>AptNumSuffix</code> field of the <code>Address/Street</code> element
	 * @param streetAptNumSuffix Apartment number suffix
	 */
	public void setStreetAptNumSuffix(String streetAptNumSuffix) {
		//Grab the existing Street element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Street street = primitive.getStreet();
		if (street == null) {
			street = new com.uvasoftware.core.primitives.Street();
		}
		street.setAptNumSuffix(streetAptNumSuffix);
		
		primitive.setStreet(street);		
	}
	
	/** 
	 * Gets the <code>AptNumSuffix</code> field of the <code>Address/Street</code> element
	 * @return the value of the <code>Address/Street/AptNumSuffix</code> element 
	 */
	public String getStreetAptNumSuffix() {
		return(primitive.getStreet().getAptNumSuffix());
	}
	
	/** 
	 * Sets the <code>City</code> field of the <code>Address</code> element
	 * @param city the city part of the address
	 */
	public void setCity(String city) {
		primitive.setCity(city);		
	}
	
	/** 
	 * Gets the <code>City</code> field of the <code>Address</code> element
	 * @return the value of the <code>Address/City</code> element 
	 */
	public String getCity() {
		return(primitive.getCity());
	}
	
	/** 
	 * Sets the <code>County</code> field of the <code>Address</code> element
	 * @param county the county part of the address
	 */
	public void setCounty(String county) {
		primitive.setCounty(county);		
	}
	
	/** 
	 * Gets the <code>County</code> field of the <code>Address</code> element
	 * @return the value of the <code>Address/County</code> element 
	 */
	public String getCounty() {
		return(primitive.getCounty());
	}
	
	/** 
	 * Sets the <code>Code</code> field of the <code>Address/StatePr</code> element
	 * @param stateCode the state/province code
	 * @see com.uvasoftware.core.data.common.data.code.StateOrProvinceCode156
	 * @see com.uvasoftware.core.data.common.data.code.CanadianProvincesAndTerritories
	 */
	public void setStatePrCode(String stateCode) {
		//Grab the existing StatePr element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.StatePr statepr = primitive.getStatePr();
		if (statepr == null) {
			statepr = new com.uvasoftware.core.primitives.StatePr();
		}
		statepr.setCode(stateCode);
		
		primitive.setStatePr(statepr);		
	}
	
	/** 
	 * Gets the <code>Code</code> field of the <code>Address/StatePr</code> element
	 * @return the value of the <code>Address/StatePr/Code</code> element 
	 */
	public String getStatePrCode() {
		return(primitive.getStatePr().getCode());
	}
	
	/** 
	 * Sets the <code>Code</code> field of the <code>Address/Country</code> element
	 * @param countryCode the country code
	 * @see com.uvasoftware.core.data.common.data.code.CountryCode26
	 */
	public void setCountryCode(String countryCode) {
		//Grab the existing Country element and jam the new value into the appropriate sub-element
		com.uvasoftware.core.primitives.Country country = primitive.getCountry();
		if (country == null ) {
			country = new com.uvasoftware.core.primitives.Country();
		}
		country.setCode(countryCode);
		
		primitive.setCountry(country);		
	}
	
	/** 
	 * Gets the <code>Code</code> field of the <code>Address/Country</code> element
	 * @return the value of the <code>Address/Country/Code</code> element 
	 */
	public String getCountryCode() {
		return(primitive.getCountry().getCode());
	}
	
	/** 
	 * Sets the <code>PostalCode</code> field of the <code>Address</code> element
	 * @param zip the ZIP/Postal code
	 */
	public void setPostalCode(String zip) {
		primitive.setPostalCode(zip);		
	}
	
	/** 
	 * Gets the <code>PostalCode</code> field of the <code>Address</code> element
	 * @return the value of the <code>Address/PostalCode</code> element 
	 */
	public String getPostalCode() {
		return(primitive.getPostalCode());
	}
	
	/** 
	 * Sets the <code>GridLocation</code> field of the <code>Address</code> element
	 * @param gridLoc the grid location of the address
	 * @see com.uvasoftware.core.data.common.GridLocation
	 */
	public void setGridLocation(GridLocation gridLoc) {
		primitive.setGridLocation((com.uvasoftware.core.primitives.GridLocation) gridLoc.getPrimitive());		
	}
	
	/** 
	 * Gets the <code>GridLocation</code> field of the <code>Address</code> element
	 * @return the value of the <code>Address/GridLocation</code> element 
	 */
	public GridLocation getGridLocation() {
		GridLocation tmp = new GridLocation(null,null);
		tmp.setPrimitive(primitive.getGridLocation());
		return(tmp);
	}
}

package com.uvasoftware.core.data.common;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class AddressTest extends TestCase {
	String type = "01";
	String street = "742 Evergreen Terrace";
	String city = "Springfield";
	String zip = "90210";
	String state = "CA";
	String country = "US";
	
	Address addr = new Address(type, street, city, zip, state, country);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(addr.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		String newcountry = "CZ";
		Address newaddr = new Address(type, street, city, zip, state, newcountry);
		
		addr.setPrimitive(newaddr.getPrimitive());
		assertEquals(addr.getPrimitive(), newaddr.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddress() {
		assertNotNull(addr);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetLine1(java.lang.String)}.
	 */
	@Test
	public void testSetStreetLine1() {
		String newstreet = "1 Test Street";
		addr.setStreetLine1(newstreet);
		assertEquals(addr.getStreetLine1(),newstreet);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetLine2(java.lang.String)}.
	 */
	@Test
	public void testSetStreetLine2() {
		String newstreet = "2 Test Street";
		addr.setStreetLine2(newstreet);
		assertEquals(addr.getStreetLine2(),newstreet);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetLine3(java.lang.String)}.
	 */
	@Test
	public void testSetStreetLine3() {
		String newstreet = "3 Test Street";
		addr.setStreetLine3(newstreet);
		assertEquals(newstreet,addr.getStreetLine3());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetComplex(java.lang.String)}.
	 */
	@Test
	public void testSetStreetComplex() {
		String complex = "Springfield Marketplace";
		addr.setStreetComplex(complex);
		assertEquals(addr.getStreetComplex(),complex);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetNumber(java.lang.String)}.
	 */
	@Test
	public void testSetStreetNumber() {
		String number = "311";
		addr.setStreetNumber(number);
		assertEquals(addr.getStreetNumber(),number);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetPrefix(java.lang.String)}.
	 */
	@Test
	public void testSetStreetPrefix() {
		String prefix = "NE";
		addr.setStreetPrefix(prefix);
		assertEquals(addr.getStreetPrefix(),prefix);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetName(java.lang.String)}.
	 */
	@Test
	public void testSetStreetName() {
		String name = "Limerick";
		addr.setStreetName(name);
		assertEquals(addr.getStreetName(),name);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetType(java.lang.String)}.
	 */
	@Test
	public void testSetStreetType() {
		String type = "Ln";
		addr.setStreetType(type);
		assertEquals(addr.getStreetType(),type);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetSuffix(java.lang.String)}.
	 */
	@Test
	public void testSetStreetSuffix() {
		String suffix = "SW";
		addr.setStreetSuffix(suffix);
		assertEquals(addr.getStreetSuffix(),suffix);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetAptType(java.lang.String)}.
	 */
	@Test
	public void testSetStreetAptType() {
		String type = "Suite";
		addr.setStreetAptType(type);
		assertEquals(addr.getStreetAptType(),type);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetAptNumPrefix(java.lang.String)}.
	 */
	@Test
	public void testSetStreetAptNumPrefix() {
		String prefix = "C-";
		addr.setStreetAptNumPrefix(prefix);
		assertEquals(addr.getStreetAptNumPrefix(),prefix);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetAptNumber(java.lang.String)}.
	 */
	@Test
	public void testSetStreetAptNumber() {
		String num = "3068";
		addr.setStreetAptNumber(num);
		assertEquals(addr.getStreetAptNumber(),num);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStreetAptNumSuffix(java.lang.String)}.
	 */
	@Test
	public void testSetStreetAptNumSuffix() {
		String suffix = "South";
		addr.setStreetAptNumSuffix(suffix);
		assertEquals(addr.getStreetAptNumSuffix(),suffix);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setCity(java.lang.String)}.
	 */
	@Test
	public void testSetCity() {
		String city = "Carlsbad";
		addr.setCity(city);
		assertEquals(addr.getCity(),city);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setCounty(java.lang.String)}.
	 */
	@Test
	public void testSetCounty() {
		String county = "Davidson";
		addr.setCounty(county);
		assertEquals(addr.getCounty(),county);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setStatePrCode(java.lang.String)}.
	 */
	@Test
	public void testSetStatePrCode() {
		String state = "MN";
		addr.setStatePrCode(state);
		assertEquals(addr.getStatePrCode(),state);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setCountryCode(java.lang.String)}.
	 */
	@Test
	public void testSetCountryCode() {
		String country = "FJ";
		addr.setCountryCode(country);
		assertEquals(addr.getCountryCode(),country);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setPostalCode(java.lang.String)}.
	 */
	@Test
	public void testSetPostalCode() {
		String zip = "R2G3L8";
		addr.setPostalCode(zip);
		assertEquals(addr.getPostalCode(),zip);		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setGridLocation(com.uvasoftware.core.primitives.GridLocation)}.
	 */
	@Test
	public void testSetGridLocation() {
		
		String lat = "45.316907";
		String lon = "22.123552";
		GridLocation grid = new GridLocation(lat,lon);
		
		addr.setGridLocation(grid);
		
		// this is not garanteed to work since the facade's may change
		assertEquals(addr.getGridLocation().getLatitude(),grid.getLatitude());
	}
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Address#setGridLocation(com.uvasoftware.core.primitives.GridLocation)}.
	 */
	@Test
	public void testSetGridLocation2() {
		
		String lat = "45.316907";
		String lon = "22.123552";
		GridLocation grid = new GridLocation(lat,lon);
		
		addr.setGridLocation(grid);
		
		Address newaddr = new Address(type, street, city, zip, state, "GB");
		grid = new GridLocation(lat,lon);
		
		newaddr.setGridLocation(grid);
		
		addr.setPrimitive(newaddr.getPrimitive());
		
				
		// this is not garanteed to work since the facade's may change
		assertEquals(newaddr.getGridLocation().getLatitude(),addr.getGridLocation().getLatitude());
	}
	

}

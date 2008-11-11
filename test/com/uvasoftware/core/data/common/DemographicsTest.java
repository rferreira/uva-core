package com.uvasoftware.core.data.common;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.uvasoftware.core.data.code.CountryCode26;

/**
 * @author raferrei
 *
 */
public class DemographicsTest {

	Demographics demo = new Demographics();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(demo.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		Demographics d2 = new Demographics();
		Demographics d1 = new Demographics();
		d2.setCountryOfBirth(CountryCode26.AFGHANISTAN);
		d1.setPrimitive(d2.getPrimitive());
		assertEquals(d2.getCountryOfBirth(),d1.getCountryOfBirth());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#addEthnicity(com.uvasoftware.core.data.common.Demographics.Ethnicity)}.
	 */
	@Test
	public void testSetEthnicity() {
		Demographics.Ethnicity et = new Demographics.Ethnicity();
		et.code = "1";
		et.proportion = "24%";
		et.type = "brains";
		
		demo.setEthnicity(et);
		assertEquals(et.code,demo.getEthnicity().get(0).code);
		assertEquals(et.proportion,demo.getEthnicity().get(0).proportion);
		assertEquals(et.type,demo.getEthnicity().get(0).type);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setGender(java.lang.String)}.
	 */
	@Test
	public void testSetGender() {
		demo.setGender("M");
		assertEquals("M",demo.getGender());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setBirthDate(java.lang.String)}.
	 */
	@Test
	public void testSetBirthDate() {
		demo.setBirthDate("1");
		assertEquals("1",demo.getBirthDate());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setBirthDateVerification(java.lang.String)}.
	 */
	@Test
	public void testSetBirthDateVerification() {
		demo.setBirthDateVerification("1");
		assertEquals("1",demo.getBirthDateVerication());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setPlaceOfBirth(java.lang.String)}.
	 */
	@Test
	public void testSetPlaceOfBirth() {
		demo.setPlaceOfBirth("blah");
		assertEquals("blah",demo.getPlaceOfBirth());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCountyOfBirth(java.lang.String)}.
	 */
	@Test
	public void testSetCountyOfBirth() {
		demo.setCountyOfBirth("B");
		assertEquals("B",demo.getCountyOfBirth());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCountryOfBirth(java.lang.String)}.
	 */
	@Test
	public void testSetCountryOfBirth() {
		demo.setCountryOfBirth("B");
		assertEquals("B",demo.getCountryOfBirth());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCountryOfCitizenship(java.util.List)}.
	 */
	@Test
	public void testSetCountryOfCitizenship() {
		ArrayList <String> l = new ArrayList <String>();
		l.add(CountryCode26.AFGHANISTAN);
		demo.setCountryOfCitizenship(l);
		assertEquals(CountryCode26.AFGHANISTAN,demo.getCountryOfCitizenship().get(0));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCountryOfResidency(java.util.List)}.
	 */
	@Test
	public void testSetCountryOfResidency() {
		ArrayList <String> l = new ArrayList<String>();
		l.add(CountryCode26.AFGHANISTAN);
		demo.setCountryOfResidency(l);
		assertEquals(CountryCode26.AFGHANISTAN,demo.getCountryOfResidency().get(0));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCountyArrivalDate(java.lang.String)}.
	 */
	@Test
	public void testSetCountryArrivalDate() {
		demo.setCountryArrivalDate("A");
		assertEquals("A",demo.getCountryArrivalDate());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setCitizenshipStatus(java.lang.String)}.
	 */
	@Test
	public void testSetCitizenshipStatus() {
		demo.setCitizenshipStatus("A");
		assertEquals("A",demo.getCitizenshipStatus());		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setEnglishProficiency(java.lang.String)}.
	 */
	@Test
	public void testSetEnglishProficiency() {
		demo.setEnglishProficiency("A");
		assertEquals("A",demo.getEnglishProficiency());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setLanguage(java.util.List)}.
	 */
	@Test
	public void testSetLanguage() {
		ArrayList<String> l = new ArrayList<String>();
		l.add(CountryCode26.AFGHANISTAN);
		demo.setLanguage(l);
		assertEquals(CountryCode26.AFGHANISTAN,demo.getLanguage().get(0));		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setDwellingArrangement(java.lang.String)}.
	 */
	@Test
	public void testSetDwellingArrangement() {
		demo.setDwellingArrangement("A");
		assertEquals("A",demo.getDwellingArrangement());		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.Demographics#setMaritalStatus(java.lang.String)}.
	 */
	@Test
	public void testSetMaritalStatus() {
		demo.setMaritalStatus("A");
		assertEquals("A",demo.getMaritalStatus());
	}

}

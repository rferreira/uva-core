/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.data.student.LEAInfo;

import org.junit.Test;

/**
 * @author Rafael Ferreira
 *
 */
public class LEAInfoTest {

	LEAInfo li = new LEAInfo();
	
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(li.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		LEAInfo li2 = new LEAInfo();
		li2.setPrimitive(li.getPrimitive());
		assertEquals(li2.getPrimitive(),li.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		li.setRefId("blah");
		assertEquals("blah",li.getRefId());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setLocalId(java.lang.String)}.
	 */
	@Test
	public void testSetLocalId() {
		li.setLocalId("blah");
		assertEquals("blah",li.getLocalId());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setStatePrID(java.lang.String)}.
	 */
	@Test
	public void testSetStatePrID() {
		li.setStatePrID("blah");
		assertEquals("blah",li.getStatePrId());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setNCESId(java.lang.String)}.
	 */
	@Test
	public void testSetNCESId() {
		li.setNCESId("blah");
		assertEquals("blah",li.getNCESId());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setLEAName(java.lang.String)}.
	 */
	@Test
	public void testSetLEAName() {
		li.setLEAName("blah");
		assertEquals("blah",li.getLEAName());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setLEAUrl(java.lang.String)}.
	 */
	@Test
	public void testSetLEAUrl() {
		li.setLEAUrl("http://blah");
		assertEquals("http://blah",li.getLEAUrl());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setEducationAgencyType(java.lang.String)}.
	 */
	@Test
	public void testSetEducationAgencyType() {
		li.setEducationAgencyType("blah");
		assertEquals("blah",li.getEducationAgencyType());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setLEAContact(com.uvasoftware.core.data.common.ContactInfo)}.
	 */
	@Test
	public void testSetLEAContact() {
		li.setLEAContact(new ContactInfo(new Name(Name.Type.ALIAS,"John","Doe")));
		assertEquals("John",li.getLEAContact().getName().getFirstName());
		assertEquals("Doe",li.getLEAContact().getName().getLastName());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setPublishInDirectory(boolean)}.
	 */
	@Test
	public void testSetPublishInDirectory() throws Exception {
		li.setLEAContact(new ContactInfo(new Name(Name.Type.ALIAS,"John","Doe")));
		System.out.println(li);
		li.setPublishInDirectory(true);
		assertEquals(true,li.getPublishInDirectory());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#addPhoneNumber(com.uvasoftware.core.data.common.PhoneNumber)}.
	 */
	@Test
	public void testAddPhoneNumber() {
		li.addPhoneNumber(new PhoneNumber(PhoneNumber.Format.EU, "A","B"));
		assertEquals("A",li.getPhoneNumber().get(0).getType());
	}



	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#addAddress(com.uvasoftware.core.data.common.Address)}.
	 */
	@Test
	public void testAddAddress() {
		String type = "01";
		String street = "742 Evergreen Terrace";
		String city = "Springfield";
		String zip = "90210";
		String state = "CA";
		String country = "US";
		
		Address addr = new Address(type, street, city, zip, state, country);
		li.addAddress(addr);
		assertEquals(addr.getPrimitive(),li.getAddress().get(0).getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#addIdentificationInfo(com.uvasoftware.core.data.common.IdentificationInfo)}.
	 */
	@Test
	public void testAddIdentificationInfo() {
		IdentificationInfo id = new IdentificationInfo();
		li.addIdentificationInfo(id);
		assertEquals(id.getPrimitive(),li.getIdentificationInfo().get(0).getPrimitive());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setGradeLevels(com.uvasoftware.core.data.common.GradeLevels)}.
	 */
	@Test
	public void testSetGradeLevels() {
		GradeLevels gls = new GradeLevels();
		gls.addGradeLevel(new GradeLevel("1"));
		li.setGradeLevels(gls);
		assertEquals(gls.getPrimitive(),li.getGradeLevels().getPrimitive());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setOperationalStatus(java.lang.String)}.
	 */
	@Test
	public void testSetOperationalStatus() {
		li.setOperationalStatus("1");
		assertEquals("1",li.getOperationalStatus());
	}

	

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.LEAInfo#setCongressionalDistrict(java.lang.String)}.
	 */
	@Test
	public void testSetCongressionalDistrict() {
		li.setCongressionalDistrict("2");
		assertEquals("2",li.getCongressionalDistrict());
	}

	
}

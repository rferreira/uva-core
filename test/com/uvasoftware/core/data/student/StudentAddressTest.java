package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.data.common.Address;

public class StudentAddressTest {
	StudentAddress s = null;
	
	@Before
	public void setUp() throws Exception {
		
		String type = "01";
		String street = "742 Evergreen Terrace";
		String city = "Springfield";
		String zip = "90210";
		String state = "CA";
		String country = "US";
		
		Address addr = new Address(type, street, city, zip, state, country);
		s = new StudentAddress(StudentAddress.PickupOrDropoffType.NA, "A",addr);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testStudentAddressStudentAddress() {
		StudentAddress s2 = new StudentAddress( (com.uvasoftware.core.primitives.StudentAddress) s.getPrimitive());
		assertEquals(s.getAddress().getPrimitive(), s2.getAddress().getPrimitive());
	}

	@Test
	public void testGetAddress() {
		assertEquals("90210", s.getAddress().getPostalCode());
	}

	@Test
	public void testSetAddress() {
		String type = "01";
		String street = "742 Evergreen Terrace";
		String city = "Springfield";
		String zip = "1";
		String state = "CA";
		String country = "US";
		
		Address addr = new Address(type, street, city, zip, state, country);
		s.setAddress(addr);
		assertEquals(zip, s.getAddress().getPostalCode());
	}

	@Test
	public void testGetDayOfWeek() {
		assertEquals("A", s.getDayOfWeek());
	}

	@Test
	public void testSetDayOfWeek() {
		s.setDayOfWeek("B");
		assertEquals("B", s.getDayOfWeek());
	}

	@Test
	public void testGetPickupOrDropoff() {
		assertEquals(StudentAddress.PickupOrDropoffType.NA, s.getPickupOrDropoff());
	}

	@Test
	public void testSetPickupOrDropoffType() {
		s.setPickupOrDropoffType(StudentAddress.PickupOrDropoffType.Both);
		assertEquals(StudentAddress.PickupOrDropoffType.Both, s.getPickupOrDropoff());
	}

}

package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import com.uvasoftware.core.data.common.Demographics;
import com.uvasoftware.core.data.common.ElectronicId;
import com.uvasoftware.core.data.common.Email;
import com.uvasoftware.core.data.common.Name;
import com.uvasoftware.core.data.common.OtherId;
import com.uvasoftware.core.data.common.PhoneNumber;
import com.uvasoftware.core.data.common.Address;
import com.uvasoftware.core.data.student.StaffPersonal;
import com.uvasoftware.core.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StaffPersonalTest {
	StaffPersonal sp = new StaffPersonal();
	String s = SIFGUID.next();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStaffPersonal() {

		assertNotNull(sp.toString());
	}

	@Test
	public void testSetRefId() {
		sp.setRefId("1");
		assertEquals("1",sp.getRefId());
	}


	@Test
	public void testSetEmployeeLink() {
		
		sp.setEmployeeLink(s);
		assertEquals(s,sp.getEmployeeLink());
	}

	@Test
	public void testSetTitle() {
		sp.setTitle("head monkey");
		assertEquals("head monkey",sp.getTitle());
	}


	@Test
	public void testSetLocalId() {
		sp.setLocalId(s);
		assertEquals(s,sp.getLocalId());
	}


	@Test
	public void testSetStatePrId() {
		sp.setStatePrId(s);
		assertEquals(s,sp.getStatePrId());
	}


	@Test
	public void testAddElectronicId() {
		ElectronicId id = new ElectronicId("A","B");
		sp.addElectronicId(id);
		
		assertEquals("A",sp.getElectronicId().get(0).getType());
	}

	@Test
	public void testAddOtherId() {
		OtherId id = new OtherId("A","B");
		sp.addOtherId(id);
		assertEquals("A",sp.getOtherId().get(0).getType());
	}


	@Test
	public void testSetName() {
		this.sp.setName( new Name(Name.Type.NAME_OF_RECORD,"A","B"));
		assertEquals("B",sp.getName().getLastName());
	}


	@Test
	public void testAddEMail() {
		Email e = new Email(Email.Type.PRIMARY,"A");
		sp.addEMail(e);
		assertEquals(Email.Type.PRIMARY,sp.getEmail().get(0).getType());
	}

	@Test
	public void testSetDemographics() {
		Demographics d = new Demographics();
		d.setBirthDate("1");
		sp.setDemographics(d);
		
		assertEquals(d.getBirthDate(),sp.getDemographics().getBirthDate());
	}


	@Test
	public void testAddPhoneNumber() {
		PhoneNumber p = new PhoneNumber("A","B","C");
		sp.addPhoneNumber(p);
		assertEquals(p.getType(),sp.getPhoneNumber().get(0).getType());
	}

	
	@Test
	public void testAddAddress() {
		Address addr = new Address();
		addr.setCity("Phoenix");
		sp.addAddress(addr);
		assertEquals("Phoenix",sp.getAddress().get(0).getCity());
	}

}

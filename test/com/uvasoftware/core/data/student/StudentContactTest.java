package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uvasoftware.core.util.SIFGUID;
import com.uvasoftware.core.data.common.*;

public class StudentContactTest {
	
	String a = SIFGUID.next();
	String b = SIFGUID.next();
	StudentContact c = null;
	
	@Before
	public void setUp() throws Exception {
		c = new StudentContact(a,b, "E4");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStudentContactObject() {
		StudentContact c1 = new StudentContact( (com.uvasoftware.core.primitives.StudentContact) c.getPrimitive());
		assertEquals(c.getRefId(), c1.getRefId());
	}

	@Test
	public void testStudentContactStringStringString() {
		
		assertEquals("E4", c.getType());
		assertEquals(a, c.getRefId());
		assertEquals(b, c.getStudentPersonalRefId());
		
	}

	@Test
	public void testGetRefId() {
		assertEquals(a, c.getRefId());
	}


	@Test
	public void testGetStudentPersonalRefId() {
		assertEquals(b, c.getStudentPersonalRefId());
	}

	@Test
	public void testSetStudentPersonalRefId() {
		c.setStudentPersonalRefId("1");
		assertEquals("1", c.getStudentPersonalRefId());
	}

	@Test
	public void testGetType() {
		assertEquals("E4", c.getType());
	}

	@Test
	public void testSetType() {
		c.setType("A");
		assertEquals("A", c.getType());
	}

	@Test
	public void testGetName() {
		Name n = new Name( Name.Type.ALIAS, "A","B");
		c.setName(n);
		assertEquals(Name.Type.ALIAS, c.getName().getType());
		
	}


	@Test
	public void testGetDemographics() {
		Demographics d = new Demographics();
		d.setGender("Male");
		c.setDemographics(d);
		assertEquals("Male", c.getDemographics().getGender());
	}

	@Test
	public void testGetPhoneNumber() {
		PhoneNumber p = new PhoneNumber("NA", "1","2");
		c.addPhoneNumber(p);
		assertEquals(p.getNumber(), c.getPhoneNumber().get(0).getNumber());
	}

	@Test
	public void testGetEmail() {
		Email e = new Email("A", "B");
		c.addEMail(e);
		assertEquals(e.getType(), c.getEmail().get(0).getType() );
	}

	@Test
	public void testAddEMail() {
		Email e = new Email("A", "B");
		//assertNotNull(c.addEMail(e));
	}

	@Test
	public void testAddAddress() {
		
		String type = "01";
		String street = "742 Evergreen Terrace";
		String city = "Springfield";
		String zip = "90210";
		String state = "CA";
		String country = "US";
		
		Address addr = new Address(type, street, city, zip, state, country);
		
		c.addAddress(addr);
		
		assertEquals(addr.getStreetLine1() , c.getAddress().get(0).getStreetLine1() );
	}


	@Test
	public void testAddOtherId() {
		OtherId id2 = new OtherId("1","2");
		c.addOtherId(id2);
		assertEquals(id2.getType(), c.getOtherId().get(0).getType());
	}


	@Test
	public void testGetRelationship() {
		Relationship r = new Relationship("1");
		c.setRelationship(r);
		assertEquals(r.getCode(), c.getRelationship().getCode() );
		
	}


	@Test
	public void testAddEmployerType() {
		EmployerType e = new EmployerType("1");
		c.addEmployerType(e);
		assertEquals(e.getCode(), c.getEmployerType().get(0).getCode());
	}

	@Test
	public void testGetEducationalLevel() {
		c.setEducationalLevel("1");
		assertEquals("1", c.getEducationalLevel());
	}


	@Test
	public void testGetPickupRights() {
		c.setPickupRights(true);
		assertEquals(true, c.getPickupRights());
	}



}

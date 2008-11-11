/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import com.uvasoftware.core.data.common.*;
import com.uvasoftware.core.data.student.StudentPersonal;
/**
 * @author Rafael Ferreira
 *
 */
public class StudentPersonalTest {

	StudentPersonal person = null;
	
	
	@Before
	public void seutp() {
		person = new StudentPersonal();
		this.person.setName( new Name(Name.Type.NAME_OF_RECORD,"John","Doe"));
	}
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#StudentPersonal()}.
	 */
	@Test
	public void testStudentPersonal() {
		assertNotNull(person);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		StudentPersonal p = new StudentPersonal();
		p.setPrimitive(person.getPrimitive());
		assertEquals("Doe",p.getName().getLastName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		person.setRefId("1");
		assertEquals("1",person.getRefId());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addAlertMessage(com.uvasoftware.core.data.common.AlertMessage)}.
	 */
	@Test
	public void testAddAlertMessage() {
		AlertMessage msg = new AlertMessage();
		msg.setMessage("b");
		
		person.addAlertMessage(msg);
		assertEquals(msg.getMessage(),person.getAlertMessages().get(0).getMessage());
		
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#setLocalId(java.lang.String)}.
	 */
	@Test
	public void testSetLocalId() {
		person.setLocalId("b");
		assertEquals("b",person.getLocalId());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#setStatePrId(java.lang.String)}.
	 */
	@Test
	public void testSetStatePrId() {
		person.setStatePrId("b");
		assertEquals("b",person.getStatePrId());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addElectronicId(com.uvasoftware.core.data.common.ElectronicId)}.
	 */
	@Test
	public void testAddElectronicId() {
		ElectronicId id = new ElectronicId("A","B");
		person.addElectronicId(id);
		
		assertEquals("A",person.getElectronicId().get(0).getType());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addOtherId(com.uvasoftware.core.data.common.OtherId)}.
	 */
	@Test
	public void testAddOtherId() {
		OtherId id = new OtherId("A","B");
		person.addOtherId(id);
		assertEquals("A",person.getOtherId().get(0).getType());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#setName(com.uvasoftware.core.data.common.Name)}.
	 */
	@Test
	public void testSetName() {
		this.person.setName( new Name(Name.Type.NAME_OF_RECORD,"A","B"));
		assertEquals("B",person.getName().getLastName());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addEMail(com.uvasoftware.core.data.common.Email)}.
	 */
	@Test
	public void testAddEMail() {
		Email e = new Email(Email.Type.PRIMARY,"A");
		person.addEMail(e);
		assertEquals(Email.Type.PRIMARY,person.getEmail().get(0).getType());
	}


	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addGradYear(com.uvasoftware.core.data.common.GradYear)}.
	 */
	@Test
	public void testAddGradYear() {
		GradYear grad = new GradYear("A","B");
		person.addGradYear(grad);
		assertEquals(grad.getType(),person.getGradYear().get(0).getType());
		
	}
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#setDemographics(com.uvasoftware.core.data.common.Demographics)}.
	 */
	@Test
	public void testSetDemographics() {
		Demographics d = new Demographics();
		d.setBirthDate("1");
		person.setDemographics(d);
		
		assertEquals(d.getBirthDate(),person.getDemographics().getBirthDate());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.StudentPersonal#addPhoneNumber(com.uvasoftware.core.data.common.PhoneNumber)}.
	 */
	@Test
	public void testAddPhoneNumber() {
		PhoneNumber p = new PhoneNumber("A","B","C");
		person.addPhoneNumber(p);
		assertEquals(p.getType(),person.getPhoneNumber().get(0).getType());
	}
	
	@Test
	public void testAddStudentAddress() {
		String type = "01";
		String street = "742 Evergreen Terrace";
		String city = "Springfield";
		String zip = "90210";
		String state = "CA";
		String country = "US";
		
		Address addr = new Address(type, street, city, zip, state, country);
		
		StudentAddress saddr = new StudentAddress(StudentAddress.PickupOrDropoffType.Both, "NA", addr );
		
		person.addStudentAddress(saddr);
		StudentAddress saddr2 = person.getStudentAddress().get(0);
		
		assertEquals(StudentAddress.PickupOrDropoffType.Both, saddr2.getPickupOrDropoff());
		assertEquals("NA", saddr2.getDayOfWeek());
		assertEquals(city, saddr2.getAddress().getCity());
	}

	
}

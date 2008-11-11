/**
 * 
 */
package com.uvasoftware.core.data.common;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class ContactInfoTest {
	String nameType = "01";
	String nameFirst = "Jack";
	String nameLast = "Tester";
	Name name = new Name(nameType, nameFirst, nameLast);
	ContactInfo cont = new ContactInfo(name);
	
	String newfirst = "John";
	Name newname = new Name(nameType, newfirst, nameLast);
	ContactInfo newcont = new ContactInfo(newname);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(cont.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		cont.setPrimitive(newcont.getPrimitive());
		assertEquals(cont.getPrimitive(), newcont.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#ContactInfo(com.uvasoftware.core.data.common.Name)}.
	 */
	@Test
	public void testContactInfo() {
		assertNotNull(cont);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#setName(com.uvasoftware.core.data.common.Name)}.
	 */
	@Test
	public void testSetName() {
		cont.setName(newname);
		assertEquals(cont.getName().getFirstName(), newcont.getName().getFirstName());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#setEmail(java.util.List)}.
	 */
	@Test
	public void testSetEmail() {
		ArrayList<Email> list = new ArrayList<Email>(cont.getEmail());
		Email email = new Email("Primary", "jack@tester.com");
		list.add(email);
		cont.setEmail((List<Email>)list);
		assertEquals(cont.getEmail().get(0).getValue(),email.getValue());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.common.ContactInfo#setPhoneNumber(java.util.List)}.
	 */
	@Test
	public void testSetPhoneNumber() {
		ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>(cont.getPhoneNumber());
		PhoneNumber phone = new PhoneNumber("NA", "06", "555-865-5309");
		list.add(phone);
		cont.setPhoneNumber((List<PhoneNumber>)list);
		assertEquals(cont.getPhoneNumber().get(0).getNumber(),list.get(0).getNumber());
	}
}
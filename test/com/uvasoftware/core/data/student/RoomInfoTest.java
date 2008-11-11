/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.data.common.ExtendedElement;
import com.uvasoftware.core.data.common.PhoneNumber;
import com.uvasoftware.core.data.student.RoomInfo;

import java.util.ArrayList;
import java.util.List;
import com.uvasoftware.core.util.SIFGUID;

/**
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class RoomInfoTest {
	String roomNumber = "342";
	String schoolId = "A2E35B359D75101A8C3D00AA001A0000";
	RoomInfo room = new RoomInfo(schoolId, roomNumber);

	String newRoomNumber = "10";
	String newSchoolId = "D3E34B359D75101A8C3D00AA001A1652";
	RoomInfo newroom = new RoomInfo(newSchoolId, newRoomNumber);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(room.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		room.setPrimitive(newroom.getPrimitive());
		assertEquals(room.getPrimitive(), newroom.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#RoomInfo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRoomInfo() {
		assertNotNull(room);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setRoomNumber(java.lang.String)}.
	 */
	@Test
	public void testSetRoomNumber() {
		room.setRoomNumber(newRoomNumber);
		assertEquals(room.getRoomNumber(), newRoomNumber);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setStaff(java.util.List)}.
	 */
	@Test
	public void testSetStaff() {
		ArrayList<String> list = new ArrayList<String>(room.getStaff());
		list.add(SIFGUID.next());
		room.setStaff(list);
		assertEquals(room.getStaff(),list);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setBuilding(java.lang.String)}.
	 */
	@Test
	public void testSetBuilding() {
		String building = "Student Center";
		room.setBuilding(building);
		assertEquals(room.getBuilding(),building);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setHomeroomNumber(java.lang.String)}.
	 */
	@Test
	public void testSetHomeroomNumber() {
		String homeroom = "F-36";
		room.setHomeroomNumber(homeroom);
		assertEquals(room.getHomeroomNumber(),homeroom);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setSize(java.lang.String)}.
	 */
	@Test
	public void testSetSize() {
		String size = "400";
		room.setSize(size);
		assertEquals(room.getSize(),size);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setCapacity(java.lang.String)}.
	 */
	@Test
	public void testSetCapacity() {
		String capacity = "35";
		room.setCapacity(capacity);
		assertEquals(room.getCapacity(),capacity);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setPhoneNumber(java.util.List)}.
	 */
	@Test
	public void testSetPhoneNumber() {
		ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>(room.getPhoneNumber());
		PhoneNumber phone = new PhoneNumber("NA", "06", "555-865-5309");
		list.add(phone);
		room.setPhoneNumber((List<PhoneNumber>)list);
		assertEquals(room.getPhoneNumber().get(0).getNumber(),list.get(0).getNumber());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setTypeOfRoom(java.lang.String)}.
	 */
	@Test
	public void testSetTypeOfRoom() {
		String roomTypeId = SIFGUID.next();
		room.setTypeOfRoom(roomTypeId);
		assertEquals(room.getTypeOfRoom(),roomTypeId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		String refId = SIFGUID.next();
		room.setRefId(refId);
		assertEquals(room.getRefId(),refId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setSchoolInfoRefId(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolInfoRefId() {
		String newSchoolId = SIFGUID.next();
		room.setSchoolInfoRefId(newSchoolId);
		assertEquals(room.getSchoolInfoRefId(),newSchoolId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomInfo#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		String description = "Room 1048";
		room.setDescription(description);
		assertEquals(room.getDescription(),description);
	}

	
	@Test
	public void testAddExtendedElement() {
		ExtendedElement p = new ExtendedElement("myname","myvalue");
		ExtendedElement p1 = new ExtendedElement("1","2");
		
		room.addExtendedElement(p);
		room.addExtendedElement(p1);
		System.out.println(room);
		assertTrue(room.toString().contains("<SIF_ExtendedElement Name=\"myname\">myvalue</SIF_ExtendedElement>"));
		assertTrue(room.toString().contains("<SIF_ExtendedElement Name=\"1\">2</SIF_ExtendedElement>"));
	}

}
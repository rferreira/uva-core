/**
 * 
 */
package com.uvasoftware.core.data.student;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.data.student.RoomInfo;
import com.uvasoftware.core.util.SIFGUID;

/**
 * @author Uva Software - http://uvasoftware.com
 *
 */
public class RoomTypeTest {
	String description = "Gymnasium";
	String schoolId = "A2E35B359D75101A8C3D00AA001A0000";
	RoomInfo room = new RoomInfo(schoolId, description);

	String newDescription = "Study Hall";
	String newSchoolId = "D3E34B359D75101A8C3D00AA001A1652";
	RoomInfo newroom = new RoomInfo(newSchoolId, newDescription);
	
	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#getPrimitive()}.
	 */
	@Test
	public void testGetPrimitive() {
		assertNotNull(room.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		room.setPrimitive(newroom.getPrimitive());
		assertEquals(room.getPrimitive(), newroom.getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#RoomType(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRoomType() {
		assertNotNull(room);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#setRefId(java.lang.String)}.
	 */
	@Test
	public void testSetRefId() {
		String refId = SIFGUID.next();
		room.setRefId(refId);
		assertEquals(room.getRefId(),refId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#setSchoolInfoRefId(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolInfoRefId() {
		String newSchoolId = SIFGUID.next();
		room.setSchoolInfoRefId(newSchoolId);
		assertEquals(room.getSchoolInfoRefId(),newSchoolId);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.data.student.RoomType#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		String description = "Cafeteria";
		room.setDescription(description);
		assertEquals(room.getDescription(),description);
	}


}

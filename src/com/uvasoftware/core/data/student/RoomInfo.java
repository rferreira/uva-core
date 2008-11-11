package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.SIFGUID;
import java.util.List;
import java.util.ArrayList;
import com.uvasoftware.core.data.common.*;

/**
 * This class represents a SIF <code>RoomInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class RoomInfo extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.RoomInfo primitive = new com.uvasoftware.core.primitives.RoomInfo();
	
	public RoomInfo() {}
	
	/**
	 * Returns the primitive representation of this object
	 * 
	 * @see com.uvasoftware.core.ISIFObject#getPrimitive()
	 */
	@Override
	public Object getPrimitive() {
		return(primitive);
	}
	
	/**
	 * Sets the primitive representation of this object
	 */
	@Override
	public void setPrimitive(Object primitive) {
		this.primitive = (com.uvasoftware.core.primitives.RoomInfo) primitive;

	}
	
	/**
	 * Creates a new RoomInfo object
	 * @param schoolId the school's GUID
	 * @param number the room's number
	 * 
	 */
	public RoomInfo(String schoolId, String number) {
		primitive.setRefId(SIFGUID.next());
		primitive.setSchoolInfoRefId(schoolId);
		primitive.setRoomNumber(number);
	}
	
	/**
	 * Gets the <code>RoomNumber</code> field of the <code>RoomInfo</code> element
	 * @return the room's number
	 */
	public String getRoomNumber() {
		return(primitive.getRoomNumber());
	}
	
	/**
	 * Sets the <code>RoomNumber</code> field of the <code>RoomInfo</code> element
	 * @param number the room's number
	 */
	public void setRoomNumber(String number) {
		primitive.setRoomNumber(number);
	}

	/**
	 * Gets the <code>Staff</code> field of the <code>RoomInfo</code> element
	 * @return a list of StaffPersonalRefIds of the staff assigned to this room
	 */
	public List<String> getStaff() {
		ArrayList<String> list = new ArrayList<String>();
		
		for (com.uvasoftware.core.primitives.Staff s: primitive.getStaff()) {
			list.add(s.getStaffPersonalRefId());
		}
		return(list);
	}
	
	/**
	 * Sets the <code>Staff</code> field of the <code>RoomInfo</code> element
	 * @param staffIdList a list of StaffPersonalRefIds of the staff assigned to this room
	 */
	public void setStaff(List<String> staffIdList) {
		com.uvasoftware.core.primitives.Staff staff = null;
		for (String id: staffIdList) { 
			staff = new com.uvasoftware.core.primitives.Staff();
			staff.setStaffPersonalRefId(id);
			primitive.getStaff().add(staff);
		}
	}
	
	/**
	 * Gets the <code>Building</code> field of the <code>RoomInfo</code> element
	 * @return additional building information
	 */
	public String getBuilding() {
		return(primitive.getBuilding());
	}
	
	/**
	 * Sets the <code>Building</code> field of the <code>RoomInfo</code> element
	 * @param buildingInfo additional building information
	 */
	public void setBuilding(String buildingInfo) {
		primitive.setBuilding(buildingInfo);
	}
	
	/**
	 * Gets the <code>HomeroomNumber</code> field of the <code>RoomInfo</code> element
	 * @return the homeroom number
	 */
	public String getHomeroomNumber() {
		return(primitive.getHomeroomNumber());
	}
	
	/**
	 * Sets the <code>HomeroomNumber</code> field of the <code>RoomInfo</code> element
	 * @param number the homeroom number
	 */
	public void setHomeroomNumber(String number) {
		primitive.setHomeroomNumber(number);
	}	
	
	/**
	 * Gets the <code>Size</code> field of the <code>RoomInfo</code> element
	 * @return the room's size in square feet
	 */
	public String getSize() {
		return(primitive.getSize());
	}
	
	/**
	 * Sets the <code>Size</code> field of the <code>RoomInfo</code> element
	 * @param size the room's size in square feet
	 */
	public void setSize(String size) {
		primitive.setSize(size);
	}
	
	/**
	 * Gets the <code>Capacity</code> field of the <code>RoomInfo</code> element
	 * @return number of persons (usually students) that this room can hold
	 */
	public String getCapacity() {
		return(primitive.getCapacity());
	}
	
	/**
	 * Sets the <code>Capacity</code> field of the <code>RoomInfo</code> element
	 * @param capacity number of persons (usually students) that this room can hold
	 */
	public void setCapacity(String capacity) {
		primitive.setCapacity(capacity);
	}
	
	/**
	 * Gets the <code>PhoneNumber</code> field of the <code>RoomInfo</code> element
	 * @return a list of the room's phone numbers
	 */
	public List<PhoneNumber> getPhoneNumber() {
		ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
		PhoneNumber phone = null;
		for (com.uvasoftware.core.primitives.PhoneNumber p: primitive.getPhoneNumber()) {
			phone = new PhoneNumber(null, null, null);
			phone.setPrimitive(p);
			list.add(phone);
		}
		return(list);
	}
	
	/**
	 * Sets the <code>PhoneNumber</code> field of the <code>RoomInfo</code> element
	 * @param numberList a list of the room's phone numbers
	 */
	public void setPhoneNumber(List<PhoneNumber> phone) {
		for (PhoneNumber p: phone) 
			primitive.getPhoneNumber().add((com.uvasoftware.core.primitives.PhoneNumber)p.getPrimitive());
	}
	
	/**
	 * Gets the <code>TypeOfRoom/RoomTypeRefId</code> field of the <code>RoomInfo</code> element
	 * @return the RoomTypRefId of this room's type
	 */
	public String getTypeOfRoom() {
		return(primitive.getTypeOfRoom().getRoomTypeRefId());
	}
	
	/**
	 * Sets the <code>TypeOfRoom/RoomTypeRefId</code> field of the <code>RoomInfo</code> element
	 * @param roomTypeId the RoomTypeRefId of this room's type
	 */
	public void setTypeOfRoom(String roomTypeId) {
		if ( primitive.getTypeOfRoom() == null ) {
			com.uvasoftware.core.primitives.TypeOfRoom type = new com.uvasoftware.core.primitives.TypeOfRoom();
			primitive.setTypeOfRoom(type);
		}
		primitive.getTypeOfRoom().setRoomTypeRefId(roomTypeId);
	}
	
	/**
	 * Gets the <code>RefId</code> field of the <code>RoomInfo</code> element
	 * @return the GUID uniquely identifying this RoomInfo instance
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>RoomInfo</code> element
	 * @param refId the GUID uniquely identifying this RoomInfo instance
	 */
	public void setRefId(String refId) {
		primitive.setRefId(refId);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>RoomInfo</code> element
	 * @return the GUID of the school to which the room belongs
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>RoomInfo</code> element
	 * @param schoolId the GUID of the school to which the room belongs
	 */
	public void setSchoolInfoRefId(String schoolId) {
		primitive.setSchoolInfoRefId(schoolId);
	}

	/**
	 * Gets the <code>Description</code> field of the <code>RoomInfo</code> element
	 * @return the descriptive name of the room (e.g., "Staff Cafeteria")
	 */
	public String getDescription() {
		return(primitive.getDescription());
	}
	
	/**
	 * Sets the <code>Description</code> field of the <code>RoomInfo</code> element
	 * @param desc the descriptive name of the room (e.g., "Staff Cafeteria")
	 */
	public void setDescription(String desc) {
		primitive.setDescription(desc);
	}


}
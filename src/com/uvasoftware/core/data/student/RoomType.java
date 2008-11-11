package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.SIFGUID;
import java.util.List;
import java.util.ArrayList;
import com.uvasoftware.core.data.common.*;

/**
 * This class represents a SIF <code>RoomType</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class RoomType extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.RoomType primitive = new com.uvasoftware.core.primitives.RoomType();
	
	public RoomType() {}
	
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
		this.primitive = (com.uvasoftware.core.primitives.RoomType) primitive;

	}
	
	/**
	 * Creates a new RoomType object
	 * @param schoolId the school's GUID
	 * @param description of the room type
	 * 
	 */
	public RoomType(String schoolId, String description) {
		primitive.setRefId(SIFGUID.next());
		primitive.setSchoolInfoRefId(schoolId);
		primitive.setDescription(description);
	}
	
	/**
	 * Gets the <code>RefId</code> field of the <code>RoomType</code> element
	 * @return the GUID uniquely identifying this RoomType instance
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>RoomType</code> element
	 * @param refId the GUID uniquely identifying this RoomType instance
	 */
	public void setRefId(String refId) {
		primitive.setRefId(refId);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>RoomType</code> element
	 * @return the GUID of the school to which the room type belongs
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>RoomType</code> element
	 * @param schoolId the GUID of the school to which the room type belongs
	 */
	public void setSchoolInfoRefId(String schoolId) {
		primitive.setSchoolInfoRefId(schoolId);
	}

	/**
	 * Gets the <code>Description</code> field of the <code>RoomType</code> element
	 * @return the descriptive name of the room type (e.g., "Gymnasium")
	 */
	public String getDescription() {
		return(primitive.getDescription());
	}
	
	/**
	 * Sets the <code>Description</code> field of the <code>RoomType</code> element
	 * @param desc the descriptive name of the room type (e.g., "Gymnasium")
	 */
	public void setDescription(String desc) {
		primitive.setDescription(desc);
	}


}
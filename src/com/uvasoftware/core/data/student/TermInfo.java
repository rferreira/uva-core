package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.util.SIFGUID;
import com.uvasoftware.core.data.common.*;


/**
 * This class represents a SIF <code>TermInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class TermInfo extends BaseSIFObject implements ISIFObject {

	com.uvasoftware.core.primitives.TermInfo primitive = new com.uvasoftware.core.primitives.TermInfo();

	public TermInfo() {}
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
		this.primitive = (com.uvasoftware.core.primitives.TermInfo) primitive;

	}
	
	/**
	 * Creates a new TermInfo object
	 * @param schoolId the school's GUID
	 * @param schoolYear the school year for which the information is applicable, expressed as the four-digit year in which the school year ends (e.g., "2004" for the 2003-04 school year)
	 * @param startDate the term's starting date (YYYYMMDD)
	 * @param endDate the term's ending date (YYYYMMDD)
	 * 
	 */
	public TermInfo(String schoolId, String schoolYear, String startDate, String endDate) {
		primitive.setRefId(SIFGUID.next());
		primitive.setSchoolInfoRefId(schoolId);
		primitive.setSchoolYear(schoolYear);
		primitive.setStartDate(startDate);
		primitive.setEndDate(endDate);
	}
	
	/**
	 * Gets the <code>RelativeDuration</code> field of the <code>TermInfo</code> element
	 * @return the portion of the school year represented by this term, expressed in decimal form precise to 4 decimal places (e.g., 0.133)
	 */
	public String getRelativeDuration() {
		return(primitive.getRelativeDuration());
	}
	
	/**
	 * Sets the <code>RelativeDuration</code> field of the <code>TermInfo</code> element
	 * @param relativeDuration the portion of the school year represented by this term, expressed in decimal form precise to 4 decimal places (e.g., 0.133)
	 */
	public void setRelativeDuration(String relativeDuration) {
		primitive.setRelativeDuration(relativeDuration);
	}
	
	/**
	 * Gets the <code>TermCode</code> field of the <code>TermInfo</code> element
	 * @return the locally-defined term code
	 */
	public String getTermCode() {
		return(primitive.getTermCode());
	}
	
	/**
	 * Sets the <code>TermCode</code> field of the <code>TermInfo</code> element
	 * @param code the locally-defined term code
	 */
	public void setTermCode(String code) {
		primitive.setTermCode(code);
	}
	
	/**
	 * Gets the <code>Track</code> field of the <code>TermInfo</code> element
	 * @return the name, description, or code of the track that contains this term
	 */
	public String getTrack() {
		return(primitive.getTrack());
	}
	
	/**
	 * Sets the <code>Track</code> field of the <code>TermInfo</code> element
	 * @param track the name, description, or code of the track that contains this term
	 */
	public void setTrack(String track) {
		primitive.setTrack(track);
	}
	
	/**
	 * Gets the <code>TermSpan/Code</code> field of the <code>TermInfo</code> element
	 * @return the code for session type
	 * @see com.uvasoftware.core.data.code.SessionType1170
	 */
	public String getTermSpan() {
		return(primitive.getTermSpan().getCode());
	}
	
	/**
	 * Sets the <code>TermSpan/Code</code> field of the <code>TermInfo</code> element
	 * @param code the code for session type
	 * @see com.uvasoftware.core.data.code.SessionType1170
	 */
	public void setTermSpan(String code) {
		primitive.getTermSpan().setCode(code);
	}
					
	/**
	 * Gets the <code>RefId</code> field of the <code>TermInfo</code> element
	 * @return the GUID uniquely identifying this TermInfo instance
	 */
	public String getRefId() {
		return(primitive.getRefId());
	}
	
	/**
	 * Sets the <code>RefId</code> field of the <code>TermInfo</code> element
	 * @param refId the GUID uniquely identifying this TermInfo instance
	 */
	public void setRefId(String refId) {
		primitive.setRefId(refId);
	}
	
	/**
	 * Gets the <code>SchoolInfoRefId</code> field of the <code>TermInfo</code> element
	 * @return the GUID of the school for which this information is applicable
	 */
	public String getSchoolInfoRefId() {
		return(primitive.getSchoolInfoRefId());
	}
	
	/**
	 * Sets the <code>SchoolInfoRefId</code> field of the <code>TermInfo</code> element
	 * @param schoolId the GUID of the school for which this information is applicable
	 */
	public void setSchoolInfoRefId(String schoolId) {
		primitive.setSchoolInfoRefId(schoolId);
	}

	/**
	 * Gets the <code>Description</code> field of the <code>TermInfo</code> element
	 * @return the description of the term
	 */
	public String getDescription() {
		return(primitive.getDescription());
	}
	
	/**
	 * Sets the <code>Description</code> field of the <code>TermInfo</code> element
	 * @param desc the description of the term
	 */
	public void setDescription(String desc) {
		primitive.setDescription(desc);
	}
}
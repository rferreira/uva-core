package com.uvasoftware.core.data.student;

import com.uvasoftware.core.ISIFObject;
import java.util.List;
import java.util.ArrayList;


import com.uvasoftware.core.data.common.BaseSIFObject;

/**
 * This class represents a SIF <code>SchoolCourseInfo</code> object
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */
public class SchoolCourseInfoOverride extends BaseSIFObject implements ISIFObject {

	/**
	 * This class represents a SIF <code>CourseCreditsOverride</code> object
	 *
	 */
	public class CourseCreditsOverride implements ISIFObject {
		
		com.uvasoftware.core.primitives.CourseCreditsOverride primitive = new com.uvasoftware.core.primitives.CourseCreditsOverride(); 
		
		public CourseCreditsOverride() {}
		
		public Object getPrimitive() {
			return primitive;
		}
		
		public void setPrimitive(Object primitive) {
			this.primitive = (com.uvasoftware.core.primitives.CourseCreditsOverride) primitive;
		}
		public String getCode() {
			return primitive.getCode();
		}
		
		/**
		 * Sets the code attribute
		 * @param code The type of credit offered.
		 */
		public void setCode(String code) {
			primitive.setCode(code);
		}
		
		/**
		 * Gets the value attribute
		 * @return
		 */
		public String getValue() {
			return primitive.getValue();
		}
		/**
		 * Set the value attribute
		 * @param value Source: 1300 (Credit Type Offered) [STUDENTHB]
		 */
		public void setValue(String value) {
			primitive.setValue(value);
		}
	}
	
	/**
	 * This class represents a SIF <code>SubjectAreaOverride</code> object
	 *
	 */
	public class SubjectAreaOverride implements ISIFObject {
		
		com.uvasoftware.core.primitives.SubjectAreaOverride primitive = new com.uvasoftware.core.primitives.SubjectAreaOverride(); 
		
		
		public Object getPrimitive() {
			return primitive;
		}
		
		public void setPrimitive(Object primitive) {
			this.primitive = (com.uvasoftware.core.primitives.SubjectAreaOverride) primitive;
		}
		public String getCode() {
			return primitive.getCode();
		}
		
		/**
		 * Sets the code attribute
		 * @param code The subject area code (i.e., the first two digits of the course classification code).
		 */
		public void setCode(String code) {
			primitive.setCode(code);
		}
		
		/**
		 * Gets the value attribute
		 * @return
		 */
		public String getValue() {
			return primitive.getValue();
		}
		/**
		 * Set the value attribute
		 * @param value Source: Subject Area Code [PSNCCSSE]
		 */
		public void setValue(String value) {
			primitive.setValue(value);
		}
	}
	
	
	// MAIN CLASS STARTS HERE
	
	com.uvasoftware.core.primitives.SchoolCourseInfoOverride primitive = new com.uvasoftware.core.primitives.SchoolCourseInfoOverride();
	
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
		this.primitive = (com.uvasoftware.core.primitives.SchoolCourseInfoOverride) primitive;

	}
	
	/**
	 * Creates a new <code>SchoolCourseInfoOverride</code> object
	 * @param override Designates whether or not SchoolCourseInfo information has been overridden with different values for this section.
	 */
	public SchoolCourseInfoOverride(boolean override) {
		if (override)
			this.primitive.setOverride("Yes");
		else 
			this.primitive.setOverride("No");
	}
	
	/**
	 * Sets the <code>CourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * @param value Override of the school-defined course code for this section.
	 */
	public void setCourseCodeOverride(String value) {
		this.primitive.setCourseCodeOverride(value);
	}
	
	/**
	 * Gets the <code>CourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public String getCourseCodeOverride() {
		return(this.primitive.getStateCourseCodeOverride());
	}
	
	/**
	 * Sets the <code>StateCourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * @param value Override of the state-defined course code for this section.
	 */
	public void SetStateCourseCodeOverride(String value) {
		this.primitive.setStateCourseCodeOverride(value);
	}
	
	/**
	 * Gets the <code>StateCourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public String getStateCourseCodeOverride() {
		return(this.primitive.getStateCourseCodeOverride());
	}
	
	
	/**
	 * Sets the <code>DistrictCourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * @param value Override of the district-defined course code for this section.
	 */
	public void SetDistrictCourseCodeOverride(String value) {
		this.primitive.setDistrictCourseCodeOverride(value);
	}
	
	/**
	 * Gets the <code>DistrictCourseCodeOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public String getDistrictCourseCodeOverride() {
		return(this.primitive.getDistrictCourseCodeOverride());
	}
	
	/**
	 * Sets the <code>SubjectAreaOverride</code> field of the <code>SchoolCourseOverride</code> element
	 */
	public void SetSubjectAreaOverride(SubjectAreaOverride value) {
		this.primitive.setSubjectAreaOverride((com.uvasoftware.core.primitives.SubjectAreaOverride) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>SubjectAreaOverride</code> field of the <code>SchoolCourseOverride</code> element
	 */
	public SubjectAreaOverride GetSubjectAreaOverride() {
		SubjectAreaOverride i = new SubjectAreaOverride();
		i.setPrimitive(primitive.getSubjectAreaOverride());
		return(i);
	}

	
	
	/**
	 * Sets the <code>CourseTitleOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * @param value Override of the course title for this section.
	 */
	public void SetCourseTitleOverride(String value) {
		this.primitive.setCourseTitleOverride(value);
	}
	
	/**
	 * Gets the <code>CourseTitleOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public String getCourseTitleOverride() {
		return(this.primitive.getCourseTitleOverride());
	}
	
	/**
	 * Sets the <code>InstructionalLevelOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * @param value Override of the instructional level for this section. Source: 1230 (Instructional Level) [STUDENTHB]
	 */
	public void SetInstructionalLevelOverride(String value) {
		this.primitive.setInstructionalLevelOverride(value);
	}
	
	/**
	 * Gets the <code>InstructionalLevelOverride</code> field of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public String getInstructionalLevelOverride() {
		return(this.primitive.getInstructionalLevelOverride());
	}
	
	/**
	 * Adds a new  <code>CourseCreditsOverride</code> field of the <code>SchoolCourseOverride</code> element
	 */
	public void addCourseCreditsOverride(CourseCreditsOverride value) {
		this.primitive.getCourseCreditsOverride().add((com.uvasoftware.core.primitives.CourseCreditsOverride) value.getPrimitive());
	}
	
	/**
	 * Gets the <code>CourseOverride</code> child element(s) of the <code>SchoolCourseOverride</code> element
	 * 
	 */
	public List<CourseCreditsOverride> getCourseCreditsOverride() {
		ArrayList<CourseCreditsOverride> list = new ArrayList<CourseCreditsOverride>();
		CourseCreditsOverride i = null;
		for (com.uvasoftware.core.primitives.CourseCreditsOverride s: primitive.getCourseCreditsOverride()) {
			i = new CourseCreditsOverride();
			i.setPrimitive(s);
			list.add(i);
		}
		return(list);
	
	}
	
}
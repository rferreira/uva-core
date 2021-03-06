//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.07 at 09:44:38 PM MST 
//


package com.uvasoftware.core.primitives;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Description" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobStartDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobEndDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobFTE" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobFunction" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}TeachingAssignment" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}GradeClassification" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ItinerantTeacher" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}InstructionLevel" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}HRId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *       &lt;attribute name="SchoolInfoRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *       &lt;attribute name="SchoolYear" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}YearOrEmptyType" />
 *       &lt;attribute name="StaffPersonalRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "jobStartDate",
    "jobEndDate",
    "jobFTE",
    "jobFunction",
    "teachingAssignment",
    "gradeClassification",
    "itinerantTeacher",
    "instructionLevel",
    "hrId",
    "sifExtendedElements"
})
@XmlRootElement(name = "StaffAssignment")
public class StaffAssignment {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "JobStartDate")
    protected String jobStartDate;
    @XmlElement(name = "JobEndDate")
    protected String jobEndDate;
    @XmlElement(name = "JobFTE")
    protected String jobFTE;
    @XmlElement(name = "JobFunction")
    protected JobFunction jobFunction;
    @XmlElement(name = "TeachingAssignment")
    protected TeachingAssignment teachingAssignment;
    @XmlElement(name = "GradeClassification")
    protected GradeClassification gradeClassification;
    @XmlElement(name = "ItinerantTeacher")
    protected String itinerantTeacher;
    @XmlElement(name = "InstructionLevel")
    protected String instructionLevel;
    @XmlElement(name = "HRId")
    protected HRId hrId;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;
    @XmlAttribute(name = "SchoolInfoRefId", required = true)
    protected String schoolInfoRefId;
    @XmlAttribute(name = "SchoolYear", required = true)
    protected String schoolYear;
    @XmlAttribute(name = "StaffPersonalRefId", required = true)
    protected String staffPersonalRefId;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the jobStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobStartDate() {
        return jobStartDate;
    }

    /**
     * Sets the value of the jobStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobStartDate(String value) {
        this.jobStartDate = value;
    }

    /**
     * Gets the value of the jobEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobEndDate() {
        return jobEndDate;
    }

    /**
     * Sets the value of the jobEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobEndDate(String value) {
        this.jobEndDate = value;
    }

    /**
     * Gets the value of the jobFTE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobFTE() {
        return jobFTE;
    }

    /**
     * Sets the value of the jobFTE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobFTE(String value) {
        this.jobFTE = value;
    }

    /**
     * Gets the value of the jobFunction property.
     * 
     * @return
     *     possible object is
     *     {@link JobFunction }
     *     
     */
    public JobFunction getJobFunction() {
        return jobFunction;
    }

    /**
     * Sets the value of the jobFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobFunction }
     *     
     */
    public void setJobFunction(JobFunction value) {
        this.jobFunction = value;
    }

    /**
     * Gets the value of the teachingAssignment property.
     * 
     * @return
     *     possible object is
     *     {@link TeachingAssignment }
     *     
     */
    public TeachingAssignment getTeachingAssignment() {
        return teachingAssignment;
    }

    /**
     * Sets the value of the teachingAssignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingAssignment }
     *     
     */
    public void setTeachingAssignment(TeachingAssignment value) {
        this.teachingAssignment = value;
    }

    /**
     * Gets the value of the gradeClassification property.
     * 
     * @return
     *     possible object is
     *     {@link GradeClassification }
     *     
     */
    public GradeClassification getGradeClassification() {
        return gradeClassification;
    }

    /**
     * Sets the value of the gradeClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradeClassification }
     *     
     */
    public void setGradeClassification(GradeClassification value) {
        this.gradeClassification = value;
    }

    /**
     * Gets the value of the itinerantTeacher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItinerantTeacher() {
        return itinerantTeacher;
    }

    /**
     * Sets the value of the itinerantTeacher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItinerantTeacher(String value) {
        this.itinerantTeacher = value;
    }

    /**
     * Gets the value of the instructionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructionLevel() {
        return instructionLevel;
    }

    /**
     * Sets the value of the instructionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructionLevel(String value) {
        this.instructionLevel = value;
    }

    /**
     * Gets the value of the hrId property.
     * 
     * @return
     *     possible object is
     *     {@link HRId }
     *     
     */
    public HRId getHRId() {
        return hrId;
    }

    /**
     * Sets the value of the hrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link HRId }
     *     
     */
    public void setHRId(HRId value) {
        this.hrId = value;
    }

    /**
     * Gets the value of the sifExtendedElements property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedElements }
     *     
     */
    public SIFExtendedElements getSIFExtendedElements() {
        return sifExtendedElements;
    }

    /**
     * Sets the value of the sifExtendedElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedElements }
     *     
     */
    public void setSIFExtendedElements(SIFExtendedElements value) {
        this.sifExtendedElements = value;
    }

    /**
     * Gets the value of the refId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefId() {
        return refId;
    }

    /**
     * Sets the value of the refId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefId(String value) {
        this.refId = value;
    }

    /**
     * Gets the value of the schoolInfoRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolInfoRefId() {
        return schoolInfoRefId;
    }

    /**
     * Sets the value of the schoolInfoRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolInfoRefId(String value) {
        this.schoolInfoRefId = value;
    }

    /**
     * Gets the value of the schoolYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolYear() {
        return schoolYear;
    }

    /**
     * Sets the value of the schoolYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolYear(String value) {
        this.schoolYear = value;
    }

    /**
     * Gets the value of the staffPersonalRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffPersonalRefId() {
        return staffPersonalRefId;
    }

    /**
     * Sets the value of the staffPersonalRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffPersonalRefId(String value) {
        this.staffPersonalRefId = value;
    }

}

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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}LocationId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobStartDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobEndDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobFTE" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}JobClassification" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ProgramType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FundingSource" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SISId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EmployeePersonalRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *       &lt;attribute name="RefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
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
    "locationId",
    "jobStartDate",
    "jobEndDate",
    "jobFTE",
    "jobClassification",
    "programType",
    "fundingSource",
    "sisId",
    "sifExtendedElements"
})
@XmlRootElement(name = "EmployeeAssignment")
public class EmployeeAssignment {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "LocationId")
    protected LocationId locationId;
    @XmlElement(name = "JobStartDate")
    protected String jobStartDate;
    @XmlElement(name = "JobEndDate")
    protected String jobEndDate;
    @XmlElement(name = "JobFTE")
    protected String jobFTE;
    @XmlElement(name = "JobClassification")
    protected JobClassification jobClassification;
    @XmlElement(name = "ProgramType")
    protected ProgramType programType;
    @XmlElement(name = "FundingSource")
    protected FundingSource fundingSource;
    @XmlElement(name = "SISId")
    protected SISId sisId;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "EmployeePersonalRefId", required = true)
    protected String employeePersonalRefId;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;

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
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link LocationId }
     *     
     */
    public LocationId getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationId }
     *     
     */
    public void setLocationId(LocationId value) {
        this.locationId = value;
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
     * Gets the value of the jobClassification property.
     * 
     * @return
     *     possible object is
     *     {@link JobClassification }
     *     
     */
    public JobClassification getJobClassification() {
        return jobClassification;
    }

    /**
     * Sets the value of the jobClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobClassification }
     *     
     */
    public void setJobClassification(JobClassification value) {
        this.jobClassification = value;
    }

    /**
     * Gets the value of the programType property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramType }
     *     
     */
    public ProgramType getProgramType() {
        return programType;
    }

    /**
     * Sets the value of the programType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramType }
     *     
     */
    public void setProgramType(ProgramType value) {
        this.programType = value;
    }

    /**
     * Gets the value of the fundingSource property.
     * 
     * @return
     *     possible object is
     *     {@link FundingSource }
     *     
     */
    public FundingSource getFundingSource() {
        return fundingSource;
    }

    /**
     * Sets the value of the fundingSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingSource }
     *     
     */
    public void setFundingSource(FundingSource value) {
        this.fundingSource = value;
    }

    /**
     * Gets the value of the sisId property.
     * 
     * @return
     *     possible object is
     *     {@link SISId }
     *     
     */
    public SISId getSISId() {
        return sisId;
    }

    /**
     * Sets the value of the sisId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SISId }
     *     
     */
    public void setSISId(SISId value) {
        this.sisId = value;
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
     * Gets the value of the employeePersonalRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeePersonalRefId() {
        return employeePersonalRefId;
    }

    /**
     * Sets the value of the employeePersonalRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeePersonalRefId(String value) {
        this.employeePersonalRefId = value;
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

}

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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}EndDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Earned" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EmployeePersonalRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *       &lt;attribute name="ProfDevActivitiesRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
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
    "endDate",
    "earned",
    "sifExtendedElements"
})
@XmlRootElement(name = "EmployeeCredit")
public class EmployeeCredit {

    @XmlElement(name = "EndDate")
    protected String endDate;
    @XmlElement(name = "Earned")
    protected Earned earned;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "EmployeePersonalRefId", required = true)
    protected String employeePersonalRefId;
    @XmlAttribute(name = "ProfDevActivitiesRefId", required = true)
    protected String profDevActivitiesRefId;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the earned property.
     * 
     * @return
     *     possible object is
     *     {@link Earned }
     *     
     */
    public Earned getEarned() {
        return earned;
    }

    /**
     * Sets the value of the earned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Earned }
     *     
     */
    public void setEarned(Earned value) {
        this.earned = value;
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
     * Gets the value of the profDevActivitiesRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfDevActivitiesRefId() {
        return profDevActivitiesRefId;
    }

    /**
     * Sets the value of the profDevActivitiesRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfDevActivitiesRefId(String value) {
        this.profDevActivitiesRefId = value;
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

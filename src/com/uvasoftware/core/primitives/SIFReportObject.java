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
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ReportInfo"/>
 *           &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ReportData"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
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
    "reportInfo",
    "reportData",
    "sifExtendedElements"
})
@XmlRootElement(name = "SIF_ReportObject")
public class SIFReportObject {

    @XmlElement(name = "ReportInfo")
    protected ReportInfo reportInfo;
    @XmlElement(name = "ReportData")
    protected ReportData reportData;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;

    /**
     * Gets the value of the reportInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ReportInfo }
     *     
     */
    public ReportInfo getReportInfo() {
        return reportInfo;
    }

    /**
     * Sets the value of the reportInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportInfo }
     *     
     */
    public void setReportInfo(ReportInfo value) {
        this.reportInfo = value;
    }

    /**
     * Gets the value of the reportData property.
     * 
     * @return
     *     possible object is
     *     {@link ReportData }
     *     
     */
    public ReportData getReportData() {
        return reportData;
    }

    /**
     * Sets the value of the reportData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportData }
     *     
     */
    public void setReportData(ReportData value) {
        this.reportData = value;
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

}

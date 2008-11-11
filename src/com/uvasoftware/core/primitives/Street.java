//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.07 at 09:44:38 PM MST 
//


package com.uvasoftware.core.primitives;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Line1" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Line2" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Line3" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Complex" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StreetNumber" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StreetPrefix" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StreetName" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StreetType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StreetSuffix" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AptType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AptNumPrefix" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AptNumber" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AptNumSuffix" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "line1",
    "line2",
    "line3",
    "complex",
    "streetNumber",
    "streetPrefix",
    "streetName",
    "streetType",
    "streetSuffix",
    "aptType",
    "aptNumPrefix",
    "aptNumber",
    "aptNumSuffix"
})
@XmlRootElement(name = "Street")
public class Street {

    @XmlElement(name = "Line1")
    protected String line1;
    @XmlElement(name = "Line2")
    protected String line2;
    @XmlElement(name = "Line3")
    protected String line3;
    @XmlElement(name = "Complex")
    protected String complex;
    @XmlElement(name = "StreetNumber")
    protected String streetNumber;
    @XmlElement(name = "StreetPrefix")
    protected String streetPrefix;
    @XmlElement(name = "StreetName")
    protected String streetName;
    @XmlElement(name = "StreetType")
    protected String streetType;
    @XmlElement(name = "StreetSuffix")
    protected String streetSuffix;
    @XmlElement(name = "AptType")
    protected String aptType;
    @XmlElement(name = "AptNumPrefix")
    protected String aptNumPrefix;
    @XmlElement(name = "AptNumber")
    protected String aptNumber;
    @XmlElement(name = "AptNumSuffix")
    protected String aptNumSuffix;

    /**
     * Gets the value of the line1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the value of the line1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine1(String value) {
        this.line1 = value;
    }

    /**
     * Gets the value of the line2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the value of the line2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine2(String value) {
        this.line2 = value;
    }

    /**
     * Gets the value of the line3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine3() {
        return line3;
    }

    /**
     * Sets the value of the line3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine3(String value) {
        this.line3 = value;
    }

    /**
     * Gets the value of the complex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplex() {
        return complex;
    }

    /**
     * Sets the value of the complex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplex(String value) {
        this.complex = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

    /**
     * Gets the value of the streetPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetPrefix() {
        return streetPrefix;
    }

    /**
     * Sets the value of the streetPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetPrefix(String value) {
        this.streetPrefix = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetType() {
        return streetType;
    }

    /**
     * Sets the value of the streetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Gets the value of the streetSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetSuffix() {
        return streetSuffix;
    }

    /**
     * Sets the value of the streetSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetSuffix(String value) {
        this.streetSuffix = value;
    }

    /**
     * Gets the value of the aptType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAptType() {
        return aptType;
    }

    /**
     * Sets the value of the aptType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAptType(String value) {
        this.aptType = value;
    }

    /**
     * Gets the value of the aptNumPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAptNumPrefix() {
        return aptNumPrefix;
    }

    /**
     * Sets the value of the aptNumPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAptNumPrefix(String value) {
        this.aptNumPrefix = value;
    }

    /**
     * Gets the value of the aptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAptNumber() {
        return aptNumber;
    }

    /**
     * Sets the value of the aptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAptNumber(String value) {
        this.aptNumber = value;
    }

    /**
     * Gets the value of the aptNumSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAptNumSuffix() {
        return aptNumSuffix;
    }

    /**
     * Sets the value of the aptNumSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAptNumSuffix(String value) {
        this.aptNumSuffix = value;
    }

}
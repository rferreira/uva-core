//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.07 at 09:44:38 PM MST 
//


package com.uvasoftware.core.primitives;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Category"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Code"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Desc"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedDesc" minOccurs="0"/>
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
    "sifCategory",
    "sifCode",
    "sifDesc",
    "sifExtendedDesc"
})
@XmlRootElement(name = "SIF_Error")
public class SIFError {

    @XmlElement(name = "SIF_Category", required = true)
    protected BigInteger sifCategory;
    @XmlElement(name = "SIF_Code", required = true)
    protected BigInteger sifCode;
    @XmlElement(name = "SIF_Desc", required = true)
    protected String sifDesc;
    @XmlElement(name = "SIF_ExtendedDesc")
    protected String sifExtendedDesc;

    /**
     * Gets the value of the sifCategory property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSIFCategory() {
        return sifCategory;
    }

    /**
     * Sets the value of the sifCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSIFCategory(BigInteger value) {
        this.sifCategory = value;
    }

    /**
     * Gets the value of the sifCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSIFCode() {
        return sifCode;
    }

    /**
     * Sets the value of the sifCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSIFCode(BigInteger value) {
        this.sifCode = value;
    }

    /**
     * Gets the value of the sifDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFDesc() {
        return sifDesc;
    }

    /**
     * Sets the value of the sifDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFDesc(String value) {
        this.sifDesc = value;
    }

    /**
     * Gets the value of the sifExtendedDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFExtendedDesc() {
        return sifExtendedDesc;
    }

    /**
     * Sets the value of the sifExtendedDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFExtendedDesc(String value) {
        this.sifExtendedDesc = value;
    }

}

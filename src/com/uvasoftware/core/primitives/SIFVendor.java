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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Product" minOccurs="0"/>
 *         &lt;element name="SIF_Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sifName",
    "sifProduct",
    "sifVersion"
})
@XmlRootElement(name = "SIF_Vendor")
public class SIFVendor {

    @XmlElement(name = "SIF_Name")
    protected String sifName;
    @XmlElement(name = "SIF_Product")
    protected String sifProduct;
    @XmlElement(name = "SIF_Version")
    protected String sifVersion;

    /**
     * Gets the value of the sifName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFName() {
        return sifName;
    }

    /**
     * Sets the value of the sifName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFName(String value) {
        this.sifName = value;
    }

    /**
     * Gets the value of the sifProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFProduct() {
        return sifProduct;
    }

    /**
     * Sets the value of the sifProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFProduct(String value) {
        this.sifProduct = value;
    }

    /**
     * Gets the value of the sifVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFVersion() {
        return sifVersion;
    }

    /**
     * Sets the value of the sifVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFVersion(String value) {
        this.sifVersion = value;
    }

}

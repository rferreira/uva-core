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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_SecureChannel"/>
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
    "sifSecureChannel"
})
@XmlRootElement(name = "SIF_Security")
public class SIFSecurity {

    @XmlElement(name = "SIF_SecureChannel", required = true)
    protected SIFSecureChannel sifSecureChannel;

    /**
     * Gets the value of the sifSecureChannel property.
     * 
     * @return
     *     possible object is
     *     {@link SIFSecureChannel }
     *     
     */
    public SIFSecureChannel getSIFSecureChannel() {
        return sifSecureChannel;
    }

    /**
     * Sets the value of the sifSecureChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFSecureChannel }
     *     
     */
    public void setSIFSecureChannel(SIFSecureChannel value) {
        this.sifSecureChannel = value;
    }

}
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SIF_MessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SIF_MessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Header"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIF_MessageType", propOrder = {
    "sifHeader"
})
public class SIFMessageType {

    @XmlElement(name = "SIF_Header", required = true)
    protected SIFHeader sifHeader;

    /**
     * Gets the value of the sifHeader property.
     * 
     * @return
     *     possible object is
     *     {@link SIFHeader }
     *     
     */
    public SIFHeader getSIFHeader() {
        return sifHeader;
    }

    /**
     * Sets the value of the sifHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFHeader }
     *     
     */
    public void setSIFHeader(SIFHeader value) {
        this.sifHeader = value;
    }

}

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
 *     &lt;extension base="{http://www.sifinfo.org/infrastructure/1.x}SIF_MessageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_SystemControlData"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sifSystemControlData"
})
@XmlRootElement(name = "SIF_SystemControl")
public class SIFSystemControl
    extends SIFMessageType
{

    @XmlElement(name = "SIF_SystemControlData", required = true)
    protected SIFSystemControlData sifSystemControlData;

    /**
     * Gets the value of the sifSystemControlData property.
     * 
     * @return
     *     possible object is
     *     {@link SIFSystemControlData }
     *     
     */
    public SIFSystemControlData getSIFSystemControlData() {
        return sifSystemControlData;
    }

    /**
     * Sets the value of the sifSystemControlData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFSystemControlData }
     *     
     */
    public void setSIFSystemControlData(SIFSystemControlData value) {
        this.sifSystemControlData = value;
    }

}

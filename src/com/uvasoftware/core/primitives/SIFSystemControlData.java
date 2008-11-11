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
 *       &lt;choice>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Ping"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Sleep"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Wakeup"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_GetMessage"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sifPing",
    "sifSleep",
    "sifWakeup",
    "sifGetMessage"
})
@XmlRootElement(name = "SIF_SystemControlData")
public class SIFSystemControlData {

    @XmlElement(name = "SIF_Ping")
    protected SIFPing sifPing;
    @XmlElement(name = "SIF_Sleep")
    protected SIFSleep sifSleep;
    @XmlElement(name = "SIF_Wakeup")
    protected SIFWakeup sifWakeup;
    @XmlElement(name = "SIF_GetMessage")
    protected SIFGetMessage sifGetMessage;

    /**
     * Gets the value of the sifPing property.
     * 
     * @return
     *     possible object is
     *     {@link SIFPing }
     *     
     */
    public SIFPing getSIFPing() {
        return sifPing;
    }

    /**
     * Sets the value of the sifPing property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFPing }
     *     
     */
    public void setSIFPing(SIFPing value) {
        this.sifPing = value;
    }

    /**
     * Gets the value of the sifSleep property.
     * 
     * @return
     *     possible object is
     *     {@link SIFSleep }
     *     
     */
    public SIFSleep getSIFSleep() {
        return sifSleep;
    }

    /**
     * Sets the value of the sifSleep property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFSleep }
     *     
     */
    public void setSIFSleep(SIFSleep value) {
        this.sifSleep = value;
    }

    /**
     * Gets the value of the sifWakeup property.
     * 
     * @return
     *     possible object is
     *     {@link SIFWakeup }
     *     
     */
    public SIFWakeup getSIFWakeup() {
        return sifWakeup;
    }

    /**
     * Sets the value of the sifWakeup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFWakeup }
     *     
     */
    public void setSIFWakeup(SIFWakeup value) {
        this.sifWakeup = value;
    }

    /**
     * Gets the value of the sifGetMessage property.
     * 
     * @return
     *     possible object is
     *     {@link SIFGetMessage }
     *     
     */
    public SIFGetMessage getSIFGetMessage() {
        return sifGetMessage;
    }

    /**
     * Sets the value of the sifGetMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFGetMessage }
     *     
     */
    public void setSIFGetMessage(SIFGetMessage value) {
        this.sifGetMessage = value;
    }

}

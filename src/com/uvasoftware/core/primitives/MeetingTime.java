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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}TimetableDay" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}TimetablePeriod" minOccurs="0"/>
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
    "timetableDay",
    "timetablePeriod"
})
@XmlRootElement(name = "MeetingTime")
public class MeetingTime {

    @XmlElement(name = "TimetableDay")
    protected String timetableDay;
    @XmlElement(name = "TimetablePeriod")
    protected String timetablePeriod;

    /**
     * Gets the value of the timetableDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimetableDay() {
        return timetableDay;
    }

    /**
     * Sets the value of the timetableDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimetableDay(String value) {
        this.timetableDay = value;
    }

    /**
     * Gets the value of the timetablePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimetablePeriod() {
        return timetablePeriod;
    }

    /**
     * Sets the value of the timetablePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimetablePeriod(String value) {
        this.timetablePeriod = value;
    }

}

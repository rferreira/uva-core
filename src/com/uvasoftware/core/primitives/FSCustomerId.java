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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}MealStatus" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}EarnedStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="StudentPersonalRefId"/>
 *             &lt;enumeration value="StaffPersonalRefId"/>
 *             &lt;enumeration value="Other"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mealStatus",
    "earnedStatus"
})
@XmlRootElement(name = "FSCustomerId")
public class FSCustomerId {

    @XmlElement(name = "MealStatus")
    protected MealStatus mealStatus;
    @XmlElement(name = "EarnedStatus")
    protected EarnedStatus earnedStatus;
    @XmlAttribute(name = "Type", required = true)
    protected String type;
    @XmlAttribute(name = "Value", required = true)
    protected String value;

    /**
     * Gets the value of the mealStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MealStatus }
     *     
     */
    public MealStatus getMealStatus() {
        return mealStatus;
    }

    /**
     * Sets the value of the mealStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MealStatus }
     *     
     */
    public void setMealStatus(MealStatus value) {
        this.mealStatus = value;
    }

    /**
     * Gets the value of the earnedStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EarnedStatus }
     *     
     */
    public EarnedStatus getEarnedStatus() {
        return earnedStatus;
    }

    /**
     * Sets the value of the earnedStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarnedStatus }
     *     
     */
    public void setEarnedStatus(EarnedStatus value) {
        this.earnedStatus = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}

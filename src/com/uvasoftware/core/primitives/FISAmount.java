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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="FinancialAccountAccountingPeriodLocationInfoRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdOrEmptyType" />
 *       &lt;attribute name="FinancialClassRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdOrEmptyType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "FISAmount")
public class FISAmount {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "FinancialAccountAccountingPeriodLocationInfoRefId", required = true)
    protected String financialAccountAccountingPeriodLocationInfoRefId;
    @XmlAttribute(name = "FinancialClassRefId", required = true)
    protected String financialClassRefId;

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

    /**
     * Gets the value of the financialAccountAccountingPeriodLocationInfoRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialAccountAccountingPeriodLocationInfoRefId() {
        return financialAccountAccountingPeriodLocationInfoRefId;
    }

    /**
     * Sets the value of the financialAccountAccountingPeriodLocationInfoRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialAccountAccountingPeriodLocationInfoRefId(String value) {
        this.financialAccountAccountingPeriodLocationInfoRefId = value;
    }

    /**
     * Gets the value of the financialClassRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialClassRefId() {
        return financialClassRefId;
    }

    /**
     * Sets the value of the financialClassRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialClassRefId(String value) {
        this.financialClassRefId = value;
    }

}

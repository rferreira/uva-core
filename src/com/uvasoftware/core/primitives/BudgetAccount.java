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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AccountClass" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FundBreak" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FuncBreak" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ObjBreak" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}BudgetAmount" minOccurs="0"/>
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
    "accountClass",
    "fundBreak",
    "funcBreak",
    "objBreak",
    "budgetAmount"
})
@XmlRootElement(name = "BudgetAccount")
public class BudgetAccount {

    @XmlElement(name = "AccountClass")
    protected String accountClass;
    @XmlElement(name = "FundBreak")
    protected String fundBreak;
    @XmlElement(name = "FuncBreak")
    protected String funcBreak;
    @XmlElement(name = "ObjBreak")
    protected String objBreak;
    @XmlElement(name = "BudgetAmount")
    protected String budgetAmount;

    /**
     * Gets the value of the accountClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountClass() {
        return accountClass;
    }

    /**
     * Sets the value of the accountClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountClass(String value) {
        this.accountClass = value;
    }

    /**
     * Gets the value of the fundBreak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundBreak() {
        return fundBreak;
    }

    /**
     * Sets the value of the fundBreak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundBreak(String value) {
        this.fundBreak = value;
    }

    /**
     * Gets the value of the funcBreak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncBreak() {
        return funcBreak;
    }

    /**
     * Sets the value of the funcBreak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncBreak(String value) {
        this.funcBreak = value;
    }

    /**
     * Gets the value of the objBreak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjBreak() {
        return objBreak;
    }

    /**
     * Sets the value of the objBreak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjBreak(String value) {
        this.objBreak = value;
    }

    /**
     * Gets the value of the budgetAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetAmount() {
        return budgetAmount;
    }

    /**
     * Sets the value of the budgetAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetAmount(String value) {
        this.budgetAmount = value;
    }

}

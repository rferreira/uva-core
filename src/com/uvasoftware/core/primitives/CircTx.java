//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.07 at 09:44:38 PM MST 
//


package com.uvasoftware.core.primitives;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ItemTitle" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ItemElectronicId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}CallNumber" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}CopyPrice" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}DueInfo" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FineInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}HoldInfo" maxOccurs="unbounded" minOccurs="0"/>
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
    "itemTitle",
    "itemElectronicId",
    "callNumber",
    "copyPrice",
    "dueInfo",
    "fineInfo",
    "holdInfo"
})
@XmlRootElement(name = "CircTx")
public class CircTx {

    @XmlElement(name = "ItemTitle")
    protected String itemTitle;
    @XmlElement(name = "ItemElectronicId")
    protected ItemElectronicId itemElectronicId;
    @XmlElement(name = "CallNumber")
    protected String callNumber;
    @XmlElement(name = "CopyPrice")
    protected String copyPrice;
    @XmlElement(name = "DueInfo")
    protected DueInfo dueInfo;
    @XmlElement(name = "FineInfo", required = true)
    protected List<FineInfo> fineInfo;
    @XmlElement(name = "HoldInfo", required = true)
    protected List<HoldInfo> holdInfo;

    /**
     * Gets the value of the itemTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * Sets the value of the itemTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTitle(String value) {
        this.itemTitle = value;
    }

    /**
     * Gets the value of the itemElectronicId property.
     * 
     * @return
     *     possible object is
     *     {@link ItemElectronicId }
     *     
     */
    public ItemElectronicId getItemElectronicId() {
        return itemElectronicId;
    }

    /**
     * Sets the value of the itemElectronicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemElectronicId }
     *     
     */
    public void setItemElectronicId(ItemElectronicId value) {
        this.itemElectronicId = value;
    }

    /**
     * Gets the value of the callNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * Sets the value of the callNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallNumber(String value) {
        this.callNumber = value;
    }

    /**
     * Gets the value of the copyPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyPrice() {
        return copyPrice;
    }

    /**
     * Sets the value of the copyPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyPrice(String value) {
        this.copyPrice = value;
    }

    /**
     * Gets the value of the dueInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DueInfo }
     *     
     */
    public DueInfo getDueInfo() {
        return dueInfo;
    }

    /**
     * Sets the value of the dueInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DueInfo }
     *     
     */
    public void setDueInfo(DueInfo value) {
        this.dueInfo = value;
    }

    /**
     * Gets the value of the fineInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fineInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFineInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FineInfo }
     * 
     * 
     */
    public List<FineInfo> getFineInfo() {
        if (fineInfo == null) {
            fineInfo = new ArrayList<FineInfo>();
        }
        return this.fineInfo;
    }

    /**
     * Gets the value of the holdInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the holdInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHoldInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HoldInfo }
     * 
     * 
     */
    public List<HoldInfo> getHoldInfo() {
        if (holdInfo == null) {
            holdInfo = new ArrayList<HoldInfo>();
        }
        return this.holdInfo;
    }

}

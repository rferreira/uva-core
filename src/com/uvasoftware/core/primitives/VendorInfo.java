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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}VendorName" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Address" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}PhoneNumber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Email" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}ContactName" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}CustomerId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}EmployeeId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Send1099" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FederalTaxId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vendorName",
    "address",
    "phoneNumber",
    "email",
    "contactName",
    "customerId",
    "employeeId",
    "send1099",
    "federalTaxId",
    "sifExtendedElements"
})
@XmlRootElement(name = "VendorInfo")
public class VendorInfo {

    @XmlElement(name = "VendorName")
    protected String vendorName;
    @XmlElement(name = "Address")
    protected Address address;
    @XmlElement(name = "PhoneNumber", required = true)
    protected List<PhoneNumber> phoneNumber;
    @XmlElement(name = "Email", required = true)
    protected List<Email> email;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "CustomerId")
    protected String customerId;
    @XmlElement(name = "EmployeeId")
    protected EmployeeId employeeId;
    @XmlElement(name = "Send1099")
    protected Send1099 send1099;
    @XmlElement(name = "FederalTaxId")
    protected FederalTaxId federalTaxId;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;

    /**
     * Gets the value of the vendorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Sets the value of the vendorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorName(String value) {
        this.vendorName = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneNumber }
     * 
     * 
     */
    public List<PhoneNumber> getPhoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = new ArrayList<PhoneNumber>();
        }
        return this.phoneNumber;
    }

    /**
     * Gets the value of the email property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the email property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Email }
     * 
     * 
     */
    public List<Email> getEmail() {
        if (email == null) {
            email = new ArrayList<Email>();
        }
        return this.email;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeId }
     *     
     */
    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeId }
     *     
     */
    public void setEmployeeId(EmployeeId value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the send1099 property.
     * 
     * @return
     *     possible object is
     *     {@link Send1099 }
     *     
     */
    public Send1099 getSend1099() {
        return send1099;
    }

    /**
     * Sets the value of the send1099 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Send1099 }
     *     
     */
    public void setSend1099(Send1099 value) {
        this.send1099 = value;
    }

    /**
     * Gets the value of the federalTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link FederalTaxId }
     *     
     */
    public FederalTaxId getFederalTaxId() {
        return federalTaxId;
    }

    /**
     * Sets the value of the federalTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FederalTaxId }
     *     
     */
    public void setFederalTaxId(FederalTaxId value) {
        this.federalTaxId = value;
    }

    /**
     * Gets the value of the sifExtendedElements property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedElements }
     *     
     */
    public SIFExtendedElements getSIFExtendedElements() {
        return sifExtendedElements;
    }

    /**
     * Sets the value of the sifExtendedElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedElements }
     *     
     */
    public void setSIFExtendedElements(SIFExtendedElements value) {
        this.sifExtendedElements = value;
    }

    /**
     * Gets the value of the refId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefId() {
        return refId;
    }

    /**
     * Sets the value of the refId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefId(String value) {
        this.refId = value;
    }

}

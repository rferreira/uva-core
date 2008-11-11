//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.07 at 09:44:38 PM MST 
//


package com.uvasoftware.core.primitives;

import java.math.BigInteger;
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
 *     &lt;extension base="{http://www.sifinfo.org/infrastructure/1.x}SIF_MessageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Name"/>
 *         &lt;element name="SIF_Version" type="{http://www.sifinfo.org/infrastructure/1.x}VersionWithWildcardsType" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_MaxBufferSize"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Mode"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Protocol" minOccurs="0"/>
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
    "sifName",
    "sifVersion",
    "sifMaxBufferSize",
    "sifMode",
    "sifProtocol"
})
@XmlRootElement(name = "SIF_Register")
public class SIFRegister
    extends SIFMessageType
{

    @XmlElement(name = "SIF_Name", required = true)
    protected String sifName;
    @XmlElement(name = "SIF_Version", required = true)
    protected List<String> sifVersion;
    @XmlElement(name = "SIF_MaxBufferSize", required = true)
    protected BigInteger sifMaxBufferSize;
    @XmlElement(name = "SIF_Mode", required = true)
    protected String sifMode;
    @XmlElement(name = "SIF_Protocol")
    protected SIFProtocol sifProtocol;

    /**
     * Gets the value of the sifName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFName() {
        return sifName;
    }

    /**
     * Sets the value of the sifName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFName(String value) {
        this.sifName = value;
    }

    /**
     * Gets the value of the sifVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sifVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSIFVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSIFVersion() {
        if (sifVersion == null) {
            sifVersion = new ArrayList<String>();
        }
        return this.sifVersion;
    }

    /**
     * Gets the value of the sifMaxBufferSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSIFMaxBufferSize() {
        return sifMaxBufferSize;
    }

    /**
     * Sets the value of the sifMaxBufferSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSIFMaxBufferSize(BigInteger value) {
        this.sifMaxBufferSize = value;
    }

    /**
     * Gets the value of the sifMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFMode() {
        return sifMode;
    }

    /**
     * Sets the value of the sifMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFMode(String value) {
        this.sifMode = value;
    }

    /**
     * Gets the value of the sifProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link SIFProtocol }
     *     
     */
    public SIFProtocol getSIFProtocol() {
        return sifProtocol;
    }

    /**
     * Sets the value of the sifProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFProtocol }
     *     
     */
    public void setSIFProtocol(SIFProtocol value) {
        this.sifProtocol = value;
    }

}
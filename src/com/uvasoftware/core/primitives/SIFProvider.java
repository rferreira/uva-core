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
 *         &lt;element name="SIF_Object" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ProvideObjectNames" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="SourceId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sifObject"
})
@XmlRootElement(name = "SIF_Provider")
public class SIFProvider {

    @XmlElement(name = "SIF_Object", required = true)
    protected List<SIFProvider.SIFObject> sifObject;
    @XmlAttribute(name = "SourceId", required = true)
    protected String sourceId;

    /**
     * Gets the value of the sifObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sifObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSIFObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SIFProvider.SIFObject }
     * 
     * 
     */
    public List<SIFProvider.SIFObject> getSIFObject() {
        if (sifObject == null) {
            sifObject = new ArrayList<SIFProvider.SIFObject>();
        }
        return this.sifObject;
    }

    /**
     * Gets the value of the sourceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Sets the value of the sourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceId(String value) {
        this.sourceId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ProvideObjectNames" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SIFObject {

        @XmlAttribute(name = "ObjectName", required = true)
        protected ProvideObjectNames objectName;

        /**
         * Gets the value of the objectName property.
         * 
         * @return
         *     possible object is
         *     {@link ProvideObjectNames }
         *     
         */
        public ProvideObjectNames getObjectName() {
            return objectName;
        }

        /**
         * Sets the value of the objectName property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProvideObjectNames }
         *     
         */
        public void setObjectName(ProvideObjectNames value) {
            this.objectName = value;
        }

    }

}
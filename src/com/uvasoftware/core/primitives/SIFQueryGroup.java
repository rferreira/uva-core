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
 *         &lt;element name="SIF_Query" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_QueryObject"/>
 *                   &lt;element name="SIF_ConditionGroup" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIF_Conditions" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SIF_Condition" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Element"/>
 *                                                 &lt;element name="SIF_Operator">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                       &lt;enumeration value="EQ"/>
 *                                                       &lt;enumeration value="LT"/>
 *                                                       &lt;enumeration value="LE"/>
 *                                                       &lt;enumeration value="GT"/>
 *                                                       &lt;enumeration value="GE"/>
 *                                                       &lt;enumeration value="NE"/>
 *                                                       &lt;enumeration value=""/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Value"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "sifQuery"
})
@XmlRootElement(name = "SIF_QueryGroup")
public class SIFQueryGroup {

    @XmlElement(name = "SIF_Query", required = true)
    protected List<SIFQueryGroup.SIFQuery> sifQuery;

    /**
     * Gets the value of the sifQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sifQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSIFQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SIFQueryGroup.SIFQuery }
     * 
     * 
     */
    public List<SIFQueryGroup.SIFQuery> getSIFQuery() {
        if (sifQuery == null) {
            sifQuery = new ArrayList<SIFQueryGroup.SIFQuery>();
        }
        return this.sifQuery;
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
     *       &lt;sequence>
     *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_QueryObject"/>
     *         &lt;element name="SIF_ConditionGroup" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIF_Conditions" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SIF_Condition" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Element"/>
     *                                       &lt;element name="SIF_Operator">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                             &lt;enumeration value="EQ"/>
     *                                             &lt;enumeration value="LT"/>
     *                                             &lt;enumeration value="LE"/>
     *                                             &lt;enumeration value="GT"/>
     *                                             &lt;enumeration value="GE"/>
     *                                             &lt;enumeration value="NE"/>
     *                                             &lt;enumeration value=""/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Value"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "sifQueryObject",
        "sifConditionGroup"
    })
    public static class SIFQuery {

        @XmlElement(name = "SIF_QueryObject", required = true)
        protected SIFQueryObject sifQueryObject;
        @XmlElement(name = "SIF_ConditionGroup")
        protected SIFQueryGroup.SIFQuery.SIFConditionGroup sifConditionGroup;

        /**
         * Gets the value of the sifQueryObject property.
         * 
         * @return
         *     possible object is
         *     {@link SIFQueryObject }
         *     
         */
        public SIFQueryObject getSIFQueryObject() {
            return sifQueryObject;
        }

        /**
         * Sets the value of the sifQueryObject property.
         * 
         * @param value
         *     allowed object is
         *     {@link SIFQueryObject }
         *     
         */
        public void setSIFQueryObject(SIFQueryObject value) {
            this.sifQueryObject = value;
        }

        /**
         * Gets the value of the sifConditionGroup property.
         * 
         * @return
         *     possible object is
         *     {@link SIFQueryGroup.SIFQuery.SIFConditionGroup }
         *     
         */
        public SIFQueryGroup.SIFQuery.SIFConditionGroup getSIFConditionGroup() {
            return sifConditionGroup;
        }

        /**
         * Sets the value of the sifConditionGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link SIFQueryGroup.SIFQuery.SIFConditionGroup }
         *     
         */
        public void setSIFConditionGroup(SIFQueryGroup.SIFQuery.SIFConditionGroup value) {
            this.sifConditionGroup = value;
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
         *       &lt;sequence>
         *         &lt;element name="SIF_Conditions" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SIF_Condition" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Element"/>
         *                             &lt;element name="SIF_Operator">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;enumeration value="EQ"/>
         *                                   &lt;enumeration value="LT"/>
         *                                   &lt;enumeration value="LE"/>
         *                                   &lt;enumeration value="GT"/>
         *                                   &lt;enumeration value="GE"/>
         *                                   &lt;enumeration value="NE"/>
         *                                   &lt;enumeration value=""/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Value"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sifConditions"
        })
        public static class SIFConditionGroup {

            @XmlElement(name = "SIF_Conditions", required = true)
            protected List<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions> sifConditions;
            @XmlAttribute(name = "Type", required = true)
            protected ConditionType type;

            /**
             * Gets the value of the sifConditions property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sifConditions property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSIFConditions().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions }
             * 
             * 
             */
            public List<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions> getSIFConditions() {
                if (sifConditions == null) {
                    sifConditions = new ArrayList<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions>();
                }
                return this.sifConditions;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link ConditionType }
             *     
             */
            public ConditionType getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link ConditionType }
             *     
             */
            public void setType(ConditionType value) {
                this.type = value;
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
             *       &lt;sequence>
             *         &lt;element name="SIF_Condition" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Element"/>
             *                   &lt;element name="SIF_Operator">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;enumeration value="EQ"/>
             *                         &lt;enumeration value="LT"/>
             *                         &lt;enumeration value="LE"/>
             *                         &lt;enumeration value="GT"/>
             *                         &lt;enumeration value="GE"/>
             *                         &lt;enumeration value="NE"/>
             *                         &lt;enumeration value=""/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Value"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="Type" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}ConditionType" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "sifCondition"
            })
            public static class SIFConditions {

                @XmlElement(name = "SIF_Condition", required = true)
                protected List<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions.SIFCondition> sifCondition;
                @XmlAttribute(name = "Type", required = true)
                protected ConditionType type;

                /**
                 * Gets the value of the sifCondition property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the sifCondition property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSIFCondition().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions.SIFCondition }
                 * 
                 * 
                 */
                public List<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions.SIFCondition> getSIFCondition() {
                    if (sifCondition == null) {
                        sifCondition = new ArrayList<SIFQueryGroup.SIFQuery.SIFConditionGroup.SIFConditions.SIFCondition>();
                    }
                    return this.sifCondition;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ConditionType }
                 *     
                 */
                public ConditionType getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ConditionType }
                 *     
                 */
                public void setType(ConditionType value) {
                    this.type = value;
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
                 *       &lt;sequence>
                 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Element"/>
                 *         &lt;element name="SIF_Operator">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;enumeration value="EQ"/>
                 *               &lt;enumeration value="LT"/>
                 *               &lt;enumeration value="LE"/>
                 *               &lt;enumeration value="GT"/>
                 *               &lt;enumeration value="GE"/>
                 *               &lt;enumeration value="NE"/>
                 *               &lt;enumeration value=""/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_Value"/>
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
                    "sifElement",
                    "sifOperator",
                    "sifValue"
                })
                public static class SIFCondition {

                    @XmlElement(name = "SIF_Element", required = true)
                    protected String sifElement;
                    @XmlElement(name = "SIF_Operator", required = true)
                    protected String sifOperator;
                    @XmlElement(name = "SIF_Value", required = true)
                    protected String sifValue;

                    /**
                     * Gets the value of the sifElement property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSIFElement() {
                        return sifElement;
                    }

                    /**
                     * Sets the value of the sifElement property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSIFElement(String value) {
                        this.sifElement = value;
                    }

                    /**
                     * Gets the value of the sifOperator property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSIFOperator() {
                        return sifOperator;
                    }

                    /**
                     * Sets the value of the sifOperator property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSIFOperator(String value) {
                        this.sifOperator = value;
                    }

                    /**
                     * Gets the value of the sifValue property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSIFValue() {
                        return sifValue;
                    }

                    /**
                     * Sets the value of the sifValue property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSIFValue(String value) {
                        this.sifValue = value;
                    }

                }

            }

        }

    }

}
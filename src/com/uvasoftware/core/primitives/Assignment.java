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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StudentPersonalRefId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}StaffPersonalRefId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}TechnicalRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}EssentialMaterial" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Title" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Preamble" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}LearningObjective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}LearningStandardItemRefId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Prerequisite" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SourceObjectRefId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssignmentTime" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}MaxAttemptsAllowed" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AddToGradeBookFlag" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SIF_ExtendedElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdType" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "studentPersonalRefId",
    "staffPersonalRefId",
    "technicalRequirement",
    "essentialMaterial",
    "title",
    "preamble",
    "learningObjective",
    "learningStandardItemRefId",
    "prerequisite",
    "sourceObjectRefId",
    "assignmentTime",
    "maxAttemptsAllowed",
    "addToGradeBookFlag",
    "sifExtendedElements"
})
@XmlRootElement(name = "Assignment")
public class Assignment {

    @XmlElement(name = "StudentPersonalRefId", required = true)
    protected List<String> studentPersonalRefId;
    @XmlElement(name = "StaffPersonalRefId")
    protected String staffPersonalRefId;
    @XmlElement(name = "TechnicalRequirement", required = true)
    protected List<String> technicalRequirement;
    @XmlElement(name = "EssentialMaterial", required = true)
    protected List<String> essentialMaterial;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "Preamble")
    protected String preamble;
    @XmlElement(name = "LearningObjective", required = true)
    protected List<String> learningObjective;
    @XmlElement(name = "LearningStandardItemRefId", required = true)
    protected List<String> learningStandardItemRefId;
    @XmlElement(name = "Prerequisite", required = true)
    protected List<String> prerequisite;
    @XmlElement(name = "SourceObjectRefId", required = true)
    protected List<SourceObjectRefId> sourceObjectRefId;
    @XmlElement(name = "AssignmentTime")
    protected AssignmentTime assignmentTime;
    @XmlElement(name = "MaxAttemptsAllowed")
    protected String maxAttemptsAllowed;
    @XmlElement(name = "AddToGradeBookFlag")
    protected String addToGradeBookFlag;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    protected String lang;

    /**
     * Gets the value of the studentPersonalRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentPersonalRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentPersonalRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStudentPersonalRefId() {
        if (studentPersonalRefId == null) {
            studentPersonalRefId = new ArrayList<String>();
        }
        return this.studentPersonalRefId;
    }

    /**
     * Gets the value of the staffPersonalRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffPersonalRefId() {
        return staffPersonalRefId;
    }

    /**
     * Sets the value of the staffPersonalRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffPersonalRefId(String value) {
        this.staffPersonalRefId = value;
    }

    /**
     * Gets the value of the technicalRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTechnicalRequirement() {
        if (technicalRequirement == null) {
            technicalRequirement = new ArrayList<String>();
        }
        return this.technicalRequirement;
    }

    /**
     * Gets the value of the essentialMaterial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the essentialMaterial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEssentialMaterial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEssentialMaterial() {
        if (essentialMaterial == null) {
            essentialMaterial = new ArrayList<String>();
        }
        return this.essentialMaterial;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the preamble property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreamble() {
        return preamble;
    }

    /**
     * Sets the value of the preamble property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreamble(String value) {
        this.preamble = value;
    }

    /**
     * Gets the value of the learningObjective property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the learningObjective property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLearningObjective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLearningObjective() {
        if (learningObjective == null) {
            learningObjective = new ArrayList<String>();
        }
        return this.learningObjective;
    }

    /**
     * Gets the value of the learningStandardItemRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the learningStandardItemRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLearningStandardItemRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLearningStandardItemRefId() {
        if (learningStandardItemRefId == null) {
            learningStandardItemRefId = new ArrayList<String>();
        }
        return this.learningStandardItemRefId;
    }

    /**
     * Gets the value of the prerequisite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prerequisite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrerequisite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrerequisite() {
        if (prerequisite == null) {
            prerequisite = new ArrayList<String>();
        }
        return this.prerequisite;
    }

    /**
     * Gets the value of the sourceObjectRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceObjectRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceObjectRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceObjectRefId }
     * 
     * 
     */
    public List<SourceObjectRefId> getSourceObjectRefId() {
        if (sourceObjectRefId == null) {
            sourceObjectRefId = new ArrayList<SourceObjectRefId>();
        }
        return this.sourceObjectRefId;
    }

    /**
     * Gets the value of the assignmentTime property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentTime }
     *     
     */
    public AssignmentTime getAssignmentTime() {
        return assignmentTime;
    }

    /**
     * Sets the value of the assignmentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentTime }
     *     
     */
    public void setAssignmentTime(AssignmentTime value) {
        this.assignmentTime = value;
    }

    /**
     * Gets the value of the maxAttemptsAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAttemptsAllowed() {
        return maxAttemptsAllowed;
    }

    /**
     * Sets the value of the maxAttemptsAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAttemptsAllowed(String value) {
        this.maxAttemptsAllowed = value;
    }

    /**
     * Gets the value of the addToGradeBookFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddToGradeBookFlag() {
        return addToGradeBookFlag;
    }

    /**
     * Sets the value of the addToGradeBookFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddToGradeBookFlag(String value) {
        this.addToGradeBookFlag = value;
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

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
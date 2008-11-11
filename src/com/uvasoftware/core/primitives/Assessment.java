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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}MaxAttemptsAllowed" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}LearningStandardItemRefId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Title" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentInstanceForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentComment" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Duration" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}PauseFlag" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Objective" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentControl" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Rubric" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}PresentationMaterial" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}OutcomesProcessingExtension" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentFeedback" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}SelectionOrdering" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Reference" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentSectionRefId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}AssessmentItemRefId" maxOccurs="unbounded" minOccurs="0"/>
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
    "maxAttemptsAllowed",
    "learningStandardItemRefId",
    "title",
    "assessmentType",
    "assessmentInstanceForm",
    "assessmentComment",
    "duration",
    "pauseFlag",
    "objective",
    "assessmentControl",
    "rubric",
    "presentationMaterial",
    "outcomesProcessingExtension",
    "assessmentFeedback",
    "selectionOrdering",
    "reference",
    "assessmentSectionRefId",
    "assessmentItemRefId",
    "sifExtendedElements"
})
@XmlRootElement(name = "Assessment")
public class Assessment {

    @XmlElement(name = "MaxAttemptsAllowed")
    protected String maxAttemptsAllowed;
    @XmlElement(name = "LearningStandardItemRefId", required = true)
    protected List<String> learningStandardItemRefId;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "AssessmentType")
    protected String assessmentType;
    @XmlElement(name = "AssessmentInstanceForm", required = true)
    protected List<String> assessmentInstanceForm;
    @XmlElement(name = "AssessmentComment")
    protected AssessmentComment assessmentComment;
    @XmlElement(name = "Duration")
    protected Duration duration;
    @XmlElement(name = "PauseFlag")
    protected String pauseFlag;
    @XmlElement(name = "Objective", required = true)
    protected List<Objective> objective;
    @XmlElement(name = "AssessmentControl")
    protected AssessmentControl assessmentControl;
    @XmlElement(name = "Rubric", required = true)
    protected List<Rubric> rubric;
    @XmlElement(name = "PresentationMaterial")
    protected PresentationMaterial presentationMaterial;
    @XmlElement(name = "OutcomesProcessingExtension")
    protected OutcomesProcessingExtension outcomesProcessingExtension;
    @XmlElement(name = "AssessmentFeedback", required = true)
    protected List<AssessmentFeedback> assessmentFeedback;
    @XmlElement(name = "SelectionOrdering")
    protected SelectionOrdering selectionOrdering;
    @XmlElement(name = "Reference")
    protected String reference;
    @XmlElement(name = "AssessmentSectionRefId", required = true)
    protected List<String> assessmentSectionRefId;
    @XmlElement(name = "AssessmentItemRefId", required = true)
    protected List<String> assessmentItemRefId;
    @XmlElement(name = "SIF_ExtendedElements")
    protected SIFExtendedElements sifExtendedElements;
    @XmlAttribute(name = "RefId", required = true)
    protected String refId;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    protected String lang;

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
     * Gets the value of the assessmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssessmentType() {
        return assessmentType;
    }

    /**
     * Sets the value of the assessmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssessmentType(String value) {
        this.assessmentType = value;
    }

    /**
     * Gets the value of the assessmentInstanceForm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentInstanceForm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentInstanceForm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssessmentInstanceForm() {
        if (assessmentInstanceForm == null) {
            assessmentInstanceForm = new ArrayList<String>();
        }
        return this.assessmentInstanceForm;
    }

    /**
     * Gets the value of the assessmentComment property.
     * 
     * @return
     *     possible object is
     *     {@link AssessmentComment }
     *     
     */
    public AssessmentComment getAssessmentComment() {
        return assessmentComment;
    }

    /**
     * Sets the value of the assessmentComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessmentComment }
     *     
     */
    public void setAssessmentComment(AssessmentComment value) {
        this.assessmentComment = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the pauseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPauseFlag() {
        return pauseFlag;
    }

    /**
     * Sets the value of the pauseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPauseFlag(String value) {
        this.pauseFlag = value;
    }

    /**
     * Gets the value of the objective property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objective property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Objective }
     * 
     * 
     */
    public List<Objective> getObjective() {
        if (objective == null) {
            objective = new ArrayList<Objective>();
        }
        return this.objective;
    }

    /**
     * Gets the value of the assessmentControl property.
     * 
     * @return
     *     possible object is
     *     {@link AssessmentControl }
     *     
     */
    public AssessmentControl getAssessmentControl() {
        return assessmentControl;
    }

    /**
     * Sets the value of the assessmentControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessmentControl }
     *     
     */
    public void setAssessmentControl(AssessmentControl value) {
        this.assessmentControl = value;
    }

    /**
     * Gets the value of the rubric property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rubric property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRubric().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rubric }
     * 
     * 
     */
    public List<Rubric> getRubric() {
        if (rubric == null) {
            rubric = new ArrayList<Rubric>();
        }
        return this.rubric;
    }

    /**
     * Gets the value of the presentationMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link PresentationMaterial }
     *     
     */
    public PresentationMaterial getPresentationMaterial() {
        return presentationMaterial;
    }

    /**
     * Sets the value of the presentationMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresentationMaterial }
     *     
     */
    public void setPresentationMaterial(PresentationMaterial value) {
        this.presentationMaterial = value;
    }

    /**
     * Gets the value of the outcomesProcessingExtension property.
     * 
     * @return
     *     possible object is
     *     {@link OutcomesProcessingExtension }
     *     
     */
    public OutcomesProcessingExtension getOutcomesProcessingExtension() {
        return outcomesProcessingExtension;
    }

    /**
     * Sets the value of the outcomesProcessingExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutcomesProcessingExtension }
     *     
     */
    public void setOutcomesProcessingExtension(OutcomesProcessingExtension value) {
        this.outcomesProcessingExtension = value;
    }

    /**
     * Gets the value of the assessmentFeedback property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentFeedback property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentFeedback().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssessmentFeedback }
     * 
     * 
     */
    public List<AssessmentFeedback> getAssessmentFeedback() {
        if (assessmentFeedback == null) {
            assessmentFeedback = new ArrayList<AssessmentFeedback>();
        }
        return this.assessmentFeedback;
    }

    /**
     * Gets the value of the selectionOrdering property.
     * 
     * @return
     *     possible object is
     *     {@link SelectionOrdering }
     *     
     */
    public SelectionOrdering getSelectionOrdering() {
        return selectionOrdering;
    }

    /**
     * Sets the value of the selectionOrdering property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectionOrdering }
     *     
     */
    public void setSelectionOrdering(SelectionOrdering value) {
        this.selectionOrdering = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the assessmentSectionRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentSectionRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentSectionRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssessmentSectionRefId() {
        if (assessmentSectionRefId == null) {
            assessmentSectionRefId = new ArrayList<String>();
        }
        return this.assessmentSectionRefId;
    }

    /**
     * Gets the value of the assessmentItemRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentItemRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentItemRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssessmentItemRefId() {
        if (assessmentItemRefId == null) {
            assessmentItemRefId = new ArrayList<String>();
        }
        return this.assessmentItemRefId;
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

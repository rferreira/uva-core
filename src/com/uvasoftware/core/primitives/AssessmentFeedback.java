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
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}FeedbackTitle" minOccurs="0"/>
 *         &lt;element ref="{http://www.sifinfo.org/infrastructure/1.x}Content" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AssessmentFeedbackRefId" use="required" type="{http://www.sifinfo.org/infrastructure/1.x}RefIdOrEmptyType" />
 *       &lt;attribute name="View" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="All"/>
 *             &lt;enumeration value="Administrator"/>
 *             &lt;enumeration value="AdminAuthority"/>
 *             &lt;enumeration value="Assessor"/>
 *             &lt;enumeration value="Author"/>
 *             &lt;enumeration value="Candidate"/>
 *             &lt;enumeration value="InvigilatorProctor"/>
 *             &lt;enumeration value="Psychometrician"/>
 *             &lt;enumeration value="Scorer"/>
 *             &lt;enumeration value="Tutor"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "feedbackTitle",
    "content"
})
@XmlRootElement(name = "AssessmentFeedback")
public class AssessmentFeedback {

    @XmlElement(name = "FeedbackTitle")
    protected String feedbackTitle;
    @XmlElement(name = "Content")
    protected String content;
    @XmlAttribute(name = "AssessmentFeedbackRefId", required = true)
    protected String assessmentFeedbackRefId;
    @XmlAttribute(name = "View", required = true)
    protected String view;

    /**
     * Gets the value of the feedbackTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    /**
     * Sets the value of the feedbackTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedbackTitle(String value) {
        this.feedbackTitle = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the assessmentFeedbackRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssessmentFeedbackRefId() {
        return assessmentFeedbackRefId;
    }

    /**
     * Sets the value of the assessmentFeedbackRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssessmentFeedbackRefId(String value) {
        this.assessmentFeedbackRefId = value;
    }

    /**
     * Gets the value of the view property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getView() {
        return view;
    }

    /**
     * Sets the value of the view property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setView(String value) {
        this.view = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.10.13 at 02:43:05 PM MSK 
//


package by.it.yaroshchuk.jd02_09.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for education complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="education"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="institution" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="degree"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="degree1"/&gt;
 *               &lt;enumeration value="degree2"/&gt;
 *               &lt;enumeration value="degree3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="startYear" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
 *         &lt;element name="graduateYear" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "education", propOrder = {
    "institution",
    "degree",
    "startYear",
    "graduateYear"
})
public class Education {

    @XmlElement(required = true)
    protected String institution;
    @XmlElement(required = true)
    protected String degree;
    @XmlElement(required = true)
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar startYear;
    @XmlElement(required = true)
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar graduateYear;

    @Override
    public String toString() {
        return "Education{" +
                "institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                ", startYear=" + startYear +
                ", graduateYear=" + graduateYear +
                '}';
    }

    /**
     * Gets the value of the institution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the value of the institution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitution(String value) {
        this.institution = value;
    }

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegree(String value) {
        this.degree = value;
    }

    /**
     * Gets the value of the startYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartYear() {
        return startYear;
    }

    /**
     * Sets the value of the startYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartYear(XMLGregorianCalendar value) {
        this.startYear = value;
    }

    /**
     * Gets the value of the graduateYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGraduateYear() {
        return graduateYear;
    }

    /**
     * Sets the value of the graduateYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGraduateYear(XMLGregorianCalendar value) {
        this.graduateYear = value;
    }

}
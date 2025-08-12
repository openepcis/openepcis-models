package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.AwardPrizeDetails;
import io.openepcis.model.interfaces.Country;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.Year;
import java.util.LinkedHashMap;


/**
 * Describes a prize or award won by a product or organization.
 *
 * <p>Java class for AwardPrizeDetails complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="AwardPrizeDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="awardPrizeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="awardPrizeCountryCode" type="{}Country"/>
 *         <element name="awardPrizeDescription" type="{}LangString" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="awardPrizeJury" type="{}LangString" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="awardPrizeName" type="{}LangString" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="awardPrizeYear" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *       </sequence>
 *       <attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardPrizeDetails", propOrder = {
        "awardPrizeCode",
        "awardPrizeCountryCode",
        "awardPrizeDescription",
        "awardPrizeJury",
        "awardPrizeName",
        "awardPrizeYear"
})
public class AwardPrizeDetailsXMLImpl implements AwardPrizeDetails {

    @XmlElement(required = true)
    protected String awardPrizeCode;
    @XmlElement(required = true)
    protected Country awardPrizeCountryCode;
    protected LinkedHashMap<String, String> awardPrizeDescription;
    protected LinkedHashMap<String, String> awardPrizeJury;
    protected LinkedHashMap<String, String> awardPrizeName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3.class)
    @XmlSchemaType(name = "gYear")
    protected Year awardPrizeYear;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anyURI")
    protected String id;

    /**
     * Gets the value of the awardPrizeCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAwardPrizeCode() {
        return awardPrizeCode;
    }

    /**
     * Sets the value of the awardPrizeCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAwardPrizeCode(String value) {
        this.awardPrizeCode = value;
    }

    /**
     * Gets the value of the awardPrizeCountryCode property.
     *
     * @return possible object is
     * {@link Country }
     */
    public Country getAwardPrizeCountryCode() {
        return awardPrizeCountryCode;
    }

    /**
     * Sets the value of the awardPrizeCountryCode property.
     *
     * @param value allowed object is
     *              {@link Country }
     */
    public void setAwardPrizeCountryCode(Country value) {
        this.awardPrizeCountryCode = value;
    }

    /**
     * Gets the value of the awardPrizeDescription property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardPrizeDescription property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAwardPrizeDescription().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkedHashMap<String, String> }
     * </p>
     *
     * @return The value of the awardPrizeDescription property.
     */
    public LinkedHashMap<String, String> getAwardPrizeDescription() {
        if (awardPrizeDescription == null) {
            awardPrizeDescription = new LinkedHashMap<>();
        }
        return this.awardPrizeDescription;
    }

    @Override
    public void setAwardPrizeDescription(LinkedHashMap value) {
        this.awardPrizeDescription = value;
    }

    /**
     * Gets the value of the awardPrizeJury property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardPrizeJury property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAwardPrizeJury().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkedHashMap<String, String> }
     * </p>
     *
     * @return The value of the awardPrizeJury property.
     */
    public LinkedHashMap<String, String> getAwardPrizeJury() {
        if (awardPrizeJury == null) {
            awardPrizeJury = new LinkedHashMap<>();
        }
        return this.awardPrizeJury;
    }

    @Override
    public void setAwardPrizeJury(final LinkedHashMap value) {
        this.awardPrizeJury = value;
    }

    /**
     * Gets the value of the awardPrizeName property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardPrizeName property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAwardPrizeName().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkedHashMap<String, String> }
     * </p>
     *
     * @return The value of the awardPrizeName property.
     */
    public LinkedHashMap<String, String> getAwardPrizeName() {
        if (awardPrizeName == null) {
            awardPrizeName = new LinkedHashMap<>();
        }
        return this.awardPrizeName;
    }

    @Override
    public void setAwardPrizeName(final LinkedHashMap value) {
        this.awardPrizeName = value;
    }

    /**
     * Gets the value of the awardPrizeYear property.
     *
     * @return possible object is
     * {@link String }
     */
    public Year getAwardPrizeYear() {
        return awardPrizeYear;
    }

    /**
     * Sets the value of the awardPrizeYear property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAwardPrizeYear(Year value) {
        this.awardPrizeYear = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

}


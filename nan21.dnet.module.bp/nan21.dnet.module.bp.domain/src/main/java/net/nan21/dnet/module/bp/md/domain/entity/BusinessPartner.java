/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;
import net.nan21.dnet.module.bp.md.domain.eventhandler.BusinessPartnerEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** 
 Entity eligible to have business relationships with.
 Can be private individuals, companies or groups.	 
 */
@Entity
@Table(name = BusinessPartner.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = BusinessPartner.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CODE" }) })
@Customizer(BusinessPartnerEventHandler.class)
@NamedQueries({
        @NamedQuery(name = BusinessPartner.NQ_FIND_BY_ID, query = "SELECT e FROM BusinessPartner e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BusinessPartner.NQ_FIND_BY_IDS, query = "SELECT e FROM BusinessPartner e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BusinessPartner.NQ_FIND_BY_CODE, query = "SELECT e FROM BusinessPartner e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BusinessPartner extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "BP_BUSINESS_PARTNER";
    public static final String SEQUENCE_NAME = "BP_BUSINESS_PARTNER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BusinessPartner.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BusinessPartner.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "BusinessPartner.findByCode";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Specifies whether a business partner is one of:
    		- private individual
    		- organization			 
    		Cannot be altered at a later stage.
     */
    @Column(name = "TYPE", length = 16)
    private String type;

    /** TaxPayerNo. */
    @Column(name = "TAXPAYERNO", length = 255)
    private String taxPayerNo;

    /** FirstName. */
    @Column(name = "FIRSTNAME", length = 255)
    private String firstName;

    /** LastName. */
    @Column(name = "LASTNAME", length = 255)
    private String lastName;

    /** MiddleName. */
    @Column(name = "MIDDLENAME", length = 255)
    private String middleName;

    /** Gender. */
    @Column(name = "GENDER", length = 16)
    private String gender;

    /** IdentityCardNo. */
    @Column(name = "IDENTITYCARDNO", length = 255)
    private String identityCardNo;

    /** PassportNo. */
    @Column(name = "PASSPORTNO", length = 255)
    private String passportNo;

    /** BirthDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDATE")
    private Date birthDate;

    /** CompanyName. */
    @Column(name = "COMPANYNAME", length = 255)
    private String companyName;

    /** RegistrationNo. */
    @Column(name = "REGISTRATIONNO", length = 32)
    private String registrationNo;

    /** RegistrationDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "REGISTRATIONDATE")
    private Date registrationDate;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CompanyLegalForm.class)
    @JoinColumn(name = "LEGALFORM_ID", referencedColumnName = "ID")
    private CompanyLegalForm legalForm;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Transient
    public String getBusinessObject() {
        return "BusinessPartner." + this.type;
    }

    public void setBusinessObject(String businessObject) {

    }

    public String getTaxPayerNo() {
        return this.taxPayerNo;
    }

    public void setTaxPayerNo(String taxPayerNo) {
        this.taxPayerNo = taxPayerNo;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCardNo() {
        return this.identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNo() {
        return this.registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CompanyLegalForm getLegalForm() {
        return this.legalForm;
    }

    public void setLegalForm(CompanyLegalForm legalForm) {
        this.legalForm = legalForm;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "BP-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}

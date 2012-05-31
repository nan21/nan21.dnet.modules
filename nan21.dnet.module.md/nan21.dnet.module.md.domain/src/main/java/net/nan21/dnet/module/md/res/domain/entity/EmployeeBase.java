/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** EmployeeBase. */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITYTYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = EmployeeBase.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = EmployeeBase.NQ_FIND_BY_ID, query = "SELECT e FROM EmployeeBase e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = EmployeeBase.NQ_FIND_BY_IDS, query = "SELECT e FROM EmployeeBase e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class EmployeeBase extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_RES_EMPL";
    public static final String SEQUENCE_NAME = "MD_RES_EMPL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "EmployeeBase.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "EmployeeBase.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EntityType. */
    @Column(name = "ENTITYTYPE", length = 32)
    private String entityType;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** LastName. */
    @Column(name = "LASTNAME", nullable = false, length = 255)
    @NotBlank
    private String lastName;

    /** FirstName. */
    @Column(name = "FIRSTNAME", length = 255)
    private String firstName;

    /** NamePrefix. */
    @Column(name = "NAMEPREFIX", length = 255)
    private String namePrefix;

    /** NameSuffix. */
    @Column(name = "NAMESUFFIX", length = 255)
    private String nameSuffix;

    /** MiddleName. */
    @Column(name = "MIDDLENAME", length = 255)
    private String middleName;

    /** NickName. */
    @Column(name = "NICKNAME", length = 255)
    private String nickName;

    /** PreviousLastName. */
    @Column(name = "PREVIOUSLASTNAME", length = 255)
    private String previousLastName;

    /** Birthdate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDATE")
    private Date birthdate;

    /** Gender. */
    @Column(name = "GENDER", length = 16)
    private String gender;

    /** MaritalStatus. */
    @Column(name = "MARITALSTATUS", length = 16)
    private String maritalStatus;

    /** HasDisability. */
    @Column(name = "HASDISABILITY", nullable = false)
    @NotNull
    private Boolean hasDisability;

    /** SsnNo. */
    @Column(name = "SSNNO", length = 32)
    private String ssnNo;

    /** SinNo. */
    @Column(name = "SINNO", length = 32)
    private String sinNo;

    /** PassportNo. */
    @Column(name = "PASSPORTNO", length = 32)
    private String passportNo;

    /** OfficeEmail. */
    @Column(name = "OFFICEEMAIL", length = 128)
    private String officeEmail;

    /** FirstHireDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "FIRSTHIREDATE")
    private Date firstHireDate;

    /** CurrentHireDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "CURRENTHIREDATE")
    private Date currentHireDate;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    private Organization employer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "CITIZENSHIP_ID", referencedColumnName = "ID")
    private Country citizenship;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNamePrefix() {
        return this.namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getNameSuffix() {
        return this.nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Transient
    public String getName() {
        return this.lastName + " " + this.firstName;
    }

    public void setName(String name) {

    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPreviousLastName() {
        return this.previousLastName;
    }

    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = previousLastName;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Transient
    public Integer getAge() {
        return 0;
    }

    public void setAge(Integer age) {

    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getHasDisability() {
        return this.hasDisability;
    }

    public void setHasDisability(Boolean hasDisability) {
        this.hasDisability = hasDisability;
    }

    public String getSsnNo() {
        return this.ssnNo;
    }

    public void setSsnNo(String ssnNo) {
        this.ssnNo = ssnNo;
    }

    public String getSinNo() {
        return this.sinNo;
    }

    public void setSinNo(String sinNo) {
        this.sinNo = sinNo;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getOfficeEmail() {
        return this.officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public Date getFirstHireDate() {
        return this.firstHireDate;
    }

    public void setFirstHireDate(Date firstHireDate) {
        this.firstHireDate = firstHireDate;
    }

    public Date getCurrentHireDate() {
        return this.currentHireDate;
    }

    public void setCurrentHireDate(Date currentHireDate) {
        this.currentHireDate = currentHireDate;
    }

    public Organization getEmployer() {
        return this.employer;
    }

    public void setEmployer(Organization employer) {
        this.employer = employer;
    }

    public Country getCitizenship() {
        return this.citizenship;
    }

    public void setCitizenship(Country citizenship) {
        this.citizenship = citizenship;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getHasDisability() == null) {
            event.updateAttributeWithObject("hasDisability", false);
        }
        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "E-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}

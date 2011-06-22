/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.domain.entity;

import java.io.Serializable;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.core.domain.session.Session;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Employee. */
@Entity
@Table(name = "HR_EMPLOYEE", uniqueConstraints = { @UniqueConstraint(name = "UK_CODE", columnNames = {
        "CLIENTID", "CODE" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Employee.findByIds", query = "SELECT e FROM Employee e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Employee.findByCode", query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Employee implements Serializable, IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Employee.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Employee.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Employee.findByCode";

    /** Code. */
    @Column(name = "CODE")
    private String code;

    /** LastName. */
    @Column(name = "LASTNAME", nullable = false)
    @NotBlank
    private String lastName;

    /** FirstName. */
    @Column(name = "FIRSTNAME")
    private String firstName;

    /** NamePrefix. */
    @Column(name = "NAMEPREFIX")
    private String namePrefix;

    /** NameSuffix. */
    @Column(name = "NAMESUFFIX")
    private String nameSuffix;

    /** MiddleName. */
    @Column(name = "MIDDLENAME")
    private String middleName;

    /** NickName. */
    @Column(name = "NICKNAME")
    private String nickName;

    /** PreviousLastName. */
    @Column(name = "PREVIOUSLASTNAME")
    private String previousLastName;

    /** Birthdate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDATE")
    private Date birthdate;

    /** Gender. */
    @Column(name = "GENDER")
    private String gender;

    /** MaritalStatus. */
    @Column(name = "MARITALSTATUS")
    private String maritalStatus;

    /** HasDisability. */
    @Column(name = "HASDISABILITY", nullable = false)
    @NotNull
    private Boolean hasDisability;

    /** SsnNo. */
    @Column(name = "SSNNO")
    private String ssnNo;

    /** SinNo. */
    @Column(name = "SINNO")
    private String sinNo;

    /** PassportNo. */
    @Column(name = "PASSPORTNO")
    private String passportNo;

    /** OfficeEmail. */
    @Column(name = "OFFICEEMAIL")
    private String officeEmail;

    /** FirstHireDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "FIRSTHIREDATE")
    private Date firstHireDate;

    /** CurrentHireDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "CURRENTHIREDATE")
    private Date currentHireDate;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false)
    @NotBlank
    private String modifiedBy;
    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;
    @Id
    @GeneratedValue
    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    private Organization employer;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "CITIZENSHIP_ID", referencedColumnName = "ID")
    private Country citizenship;

    /* ============== getters - setters ================== */

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

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

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
        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.hasDisability == null) {
            event.updateAttributeWithObject("hasDisability", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        Employee e = (Employee) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}

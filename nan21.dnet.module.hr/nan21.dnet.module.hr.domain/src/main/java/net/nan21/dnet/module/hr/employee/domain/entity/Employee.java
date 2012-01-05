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
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Employee. */
@Entity
@Table(name = Employee.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Employee.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CODE" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = Employee.NQ_FIND_BY_ID, query = "SELECT e FROM Employee e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Employee.NQ_FIND_BY_IDS, query = "SELECT e FROM Employee e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Employee.NQ_FIND_BY_CODE, query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Employee implements Serializable, IModelWithId, IModelWithClientId {

    public static final String TABLE_NAME = "HR_EMPLOYEE";
    public static final String SEQUENCE_NAME = "HR_EMPLOYEE_SEQ";

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
    @Column(name = "CODE", length = 32)
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

    /** AssignToPosition. */
    @Column(name = "ASSIGNTOPOSITION", nullable = false)
    @NotNull
    private Boolean assignToPosition;

    /** BaseSalary. */
    @Column(name = "BASESALARY", scale = 2)
    private Float baseSalary;

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
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    private Organization employer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "CITIZENSHIP_ID", referencedColumnName = "ID")
    private Country citizenship;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EmploymentType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private EmploymentType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
    @JoinColumn(name = "JOB_ID", referencedColumnName = "ID")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    private Organization organization;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
    @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
    private Grade grade;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Payroll.class)
    @JoinColumn(name = "PAYROLL_ID", referencedColumnName = "ID")
    private Payroll payroll;

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

    public Boolean getAssignToPosition() {
        return this.assignToPosition;
    }

    public void setAssignToPosition(Boolean assignToPosition) {
        this.assignToPosition = assignToPosition;
    }

    public Float getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Transient
    public String getBusinessObject() {
        return "Employee";
    }

    public void setBusinessObject(String businessObject) {

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

    public EmploymentType getType() {
        return this.type;
    }

    public void setType(EmploymentType type) {
        this.type = type;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Payroll getPayroll() {
        return this.payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
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
        if (this.assignToPosition == null) {
            event.updateAttributeWithObject("assignToPosition", false);
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "E-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}

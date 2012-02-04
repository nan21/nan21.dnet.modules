/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Employee.class, sort = { @SortField(field = EmployeeDs.fNAME) })
public class EmployeeDs extends AbstractDsModel<Employee> implements
        IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fCODE = "code";
    public static final String fACTIVE = "active";
    public static final String fNOTES = "notes";
    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fEMPLOYERID = "employerId";
    public static final String fEMPLOYERCODE = "employerCode";
    public static final String fBUSINESSOBJECT = "businessObject";
    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fMIDDLENAME = "middleName";
    public static final String fBIRTHDATE = "birthdate";
    public static final String fGENDER = "gender";
    public static final String fMARITALSTATUS = "maritalStatus";
    public static final String fSINNO = "sinNo";
    public static final String fSSNNO = "ssnNo";
    public static final String fHASDISABILITY = "hasDisability";
    public static final String fFIRSTHIREDATE = "firstHireDate";
    public static final String fCURRENTHIREDATE = "currentHireDate";
    public static final String fOFFICEEMAIL = "officeEmail";
    public static final String fCITIZENSHIPID = "citizenshipId";
    public static final String fCITIZENSHIPCODE = "citizenshipCode";
    public static final String fPASSPORTNO = "passportNo";
    public static final String fCLASSNAME = "className";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fASSIGNTOPOSITION = "assignToPosition";
    public static final String fGRADEID = "gradeId";
    public static final String fGRADECODE = "gradeCode";
    public static final String fJOBID = "jobId";
    public static final String fJOBCODE = "jobCode";
    public static final String fJOBNAME = "jobName";
    public static final String fPOSITIONID = "positionId";
    public static final String fPOSITIONCODE = "positionCode";
    public static final String fPOSITIONNAME = "positionName";
    public static final String fPOSORGID = "posOrgId";
    public static final String fPOSORGCODE = "posOrgCode";
    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATIONCODE = "organizationCode";
    public static final String fBASESALARY = "baseSalary";
    public static final String fPAYROLLID = "payrollId";
    public static final String fPAYROLL = "payroll";

    @DsField()
    private String name;

    @DsField()
    private String code;

    @DsField()
    private Boolean active;

    @DsField()
    private String notes;

    @DsField()
    private Long id;

    @DsField()
    private String uuid;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "employer.id")
    private Long employerId;

    @DsField(join = "left", path = "employer.code")
    private String employerCode;

    @DsField(fetch = false)
    private String businessObject;

    @DsField()
    private String firstName;

    @DsField()
    private String lastName;

    @DsField()
    private String middleName;

    @DsField()
    private Date birthdate;

    @DsField()
    private String gender;

    @DsField()
    private String maritalStatus;

    @DsField()
    private String sinNo;

    @DsField()
    private String ssnNo;

    @DsField()
    private Boolean hasDisability;

    @DsField()
    private Date firstHireDate;

    @DsField()
    private Date currentHireDate;

    @DsField()
    private String officeEmail;

    @DsField(join = "left", path = "citizenship.id")
    private Long citizenshipId;

    @DsField(join = "left", path = "citizenship.code")
    private String citizenshipCode;

    @DsField()
    private String passportNo;

    @DsField(fetch = false)
    private String className;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField()
    private Boolean assignToPosition;

    @DsField(join = "left", path = "grade.id")
    private Long gradeId;

    @DsField(join = "left", path = "grade.code")
    private String gradeCode;

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.code")
    private String jobCode;

    @DsField(join = "left", path = "job.name")
    private String jobName;

    @DsField(join = "left", path = "position.id")
    private Long positionId;

    @DsField(join = "left", path = "position.code")
    private String positionCode;

    @DsField(join = "left", path = "position.name")
    private String positionName;

    @DsField(join = "left", path = "position.organization.id")
    private Long posOrgId;

    @DsField(join = "left", path = "position.organization.code")
    private String posOrgCode;

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organizationCode;

    @DsField()
    private Float baseSalary;

    @DsField(join = "left", path = "payroll.id")
    private Long payrollId;

    @DsField(join = "left", path = "payroll.name")
    private String payroll;

    public EmployeeDs() {
        super();
    }

    public EmployeeDs(Employee e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getEmployerId() {
        return this.employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public String getEmployerCode() {
        return this.employerCode;
    }

    public void setEmployerCode(String employerCode) {
        this.employerCode = employerCode;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
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

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public String getSinNo() {
        return this.sinNo;
    }

    public void setSinNo(String sinNo) {
        this.sinNo = sinNo;
    }

    public String getSsnNo() {
        return this.ssnNo;
    }

    public void setSsnNo(String ssnNo) {
        this.ssnNo = ssnNo;
    }

    public Boolean getHasDisability() {
        return this.hasDisability;
    }

    public void setHasDisability(Boolean hasDisability) {
        this.hasDisability = hasDisability;
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

    public String getOfficeEmail() {
        return this.officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public Long getCitizenshipId() {
        return this.citizenshipId;
    }

    public void setCitizenshipId(Long citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public String getCitizenshipCode() {
        return this.citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAssignToPosition() {
        return this.assignToPosition;
    }

    public void setAssignToPosition(Boolean assignToPosition) {
        this.assignToPosition = assignToPosition;
    }

    public Long getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionCode() {
        return this.positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return this.positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Long getPosOrgId() {
        return this.posOrgId;
    }

    public void setPosOrgId(Long posOrgId) {
        this.posOrgId = posOrgId;
    }

    public String getPosOrgCode() {
        return this.posOrgCode;
    }

    public void setPosOrgCode(String posOrgCode) {
        this.posOrgCode = posOrgCode;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Float getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Long getPayrollId() {
        return this.payrollId;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }

    public String getPayroll() {
        return this.payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

}

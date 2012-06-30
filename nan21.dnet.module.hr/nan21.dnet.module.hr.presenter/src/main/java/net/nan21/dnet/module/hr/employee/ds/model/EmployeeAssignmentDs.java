/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EmployeeAssignment.class)
public class EmployeeAssignmentDs extends
        AbstractAuditableDs<EmployeeAssignment> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fEMPLOYEECODE = "employeeCode";
    public static final String fEMPLOYERID = "employerId";
    public static final String fEMPLOYERCODE = "employerCode";
    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fMIDDLENAME = "middleName";
    public static final String fNAME = "name";
    public static final String fCLASSNAME = "className";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";
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
    public static final String fPOSORG = "posOrg";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fBASESALARY = "baseSalary";
    public static final String fPAYROLLID = "payrollId";
    public static final String fPAYROLL = "payroll";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "employee.code")
    private String employeeCode;

    @DsField(join = "left", path = "employee.employer.id")
    private Long employerId;

    @DsField(join = "left", path = "employee.employer.code")
    private String employerCode;

    @DsField(join = "left", path = "employee.firstName")
    private String firstName;

    @DsField(join = "left", path = "employee.lastName")
    private String lastName;

    @DsField(join = "left", path = "employee.middleName")
    private String middleName;

    @DsField(join = "left", orderBy = "lastName,firstName", fetch = false, path = "employee.name")
    private String name;

    @DsField(fetch = false)
    private String className;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

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

    @DsField(join = "left", path = "position.org.id")
    private Long posOrgId;

    @DsField(join = "left", path = "position.org.code")
    private String posOrg;

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField()
    private Float baseSalary;

    @DsField(join = "left", path = "payroll.id")
    private Long payrollId;

    @DsField(join = "left", path = "payroll.name")
    private String payroll;

    public EmployeeAssignmentDs() {
        super();
    }

    public EmployeeAssignmentDs(EmployeeAssignment e) {
        super(e);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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

    public String getPosOrg() {
        return this.posOrg;
    }

    public void setPosOrg(String posOrg) {
        this.posOrg = posOrg;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
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

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class EmployeeDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long employerId;

    private Long employerId_From;
    private Long employerId_To;

    private String employerCode;

    private String businessObject;

    private String code;

    private String firstName;

    private String lastName;

    private String middleName;

    private Date birthdate;

    private Date birthdate_From;
    private Date birthdate_To;

    private String gender;

    private String maritalStatus;

    private String sinNo;

    private String ssnNo;

    private Boolean hasDisability;

    private Date firstHireDate;

    private Date firstHireDate_From;
    private Date firstHireDate_To;

    private Date currentHireDate;

    private Date currentHireDate_From;
    private Date currentHireDate_To;

    private String officeEmail;

    private Long citizenshipId;

    private Long citizenshipId_From;
    private Long citizenshipId_To;

    private String citizenshipCode;

    private String passportNo;

    private String className;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Boolean assignToPosition;

    private Long gradeId;

    private Long gradeId_From;
    private Long gradeId_To;

    private String gradeCode;

    private Long jobId;

    private Long jobId_From;
    private Long jobId_To;

    private String jobCode;

    private String jobName;

    private Long positionId;

    private Long positionId_From;
    private Long positionId_To;

    private String positionCode;

    private String positionName;

    private Long posOrgId;

    private Long posOrgId_From;
    private Long posOrgId_To;

    private String posOrgCode;

    private Long organizationId;

    private Long organizationId_From;
    private Long organizationId_To;

    private String organizationCode;

    private Float baseSalary;

    private Float baseSalary_From;
    private Float baseSalary_To;

    private Long payrollId;

    private Long payrollId_From;
    private Long payrollId_To;

    private String payroll;

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
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

    public Long getEmployerId() {
        return this.employerId;
    }

    public Long getEmployerId_From() {
        return this.employerId_From;
    }

    public Long getEmployerId_To() {
        return this.employerId_To;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public void setEmployerId_From(Long employerId_From) {
        this.employerId_From = employerId_From;
    }

    public void setEmployerId_To(Long employerId_To) {
        this.employerId_To = employerId_To;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getBirthdate_From() {
        return this.birthdate_From;
    }

    public Date getBirthdate_To() {
        return this.birthdate_To;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthdate_From(Date birthdate_From) {
        this.birthdate_From = birthdate_From;
    }

    public void setBirthdate_To(Date birthdate_To) {
        this.birthdate_To = birthdate_To;
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

    public Date getFirstHireDate_From() {
        return this.firstHireDate_From;
    }

    public Date getFirstHireDate_To() {
        return this.firstHireDate_To;
    }

    public void setFirstHireDate(Date firstHireDate) {
        this.firstHireDate = firstHireDate;
    }

    public void setFirstHireDate_From(Date firstHireDate_From) {
        this.firstHireDate_From = firstHireDate_From;
    }

    public void setFirstHireDate_To(Date firstHireDate_To) {
        this.firstHireDate_To = firstHireDate_To;
    }

    public Date getCurrentHireDate() {
        return this.currentHireDate;
    }

    public Date getCurrentHireDate_From() {
        return this.currentHireDate_From;
    }

    public Date getCurrentHireDate_To() {
        return this.currentHireDate_To;
    }

    public void setCurrentHireDate(Date currentHireDate) {
        this.currentHireDate = currentHireDate;
    }

    public void setCurrentHireDate_From(Date currentHireDate_From) {
        this.currentHireDate_From = currentHireDate_From;
    }

    public void setCurrentHireDate_To(Date currentHireDate_To) {
        this.currentHireDate_To = currentHireDate_To;
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

    public Long getCitizenshipId_From() {
        return this.citizenshipId_From;
    }

    public Long getCitizenshipId_To() {
        return this.citizenshipId_To;
    }

    public void setCitizenshipId(Long citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public void setCitizenshipId_From(Long citizenshipId_From) {
        this.citizenshipId_From = citizenshipId_From;
    }

    public void setCitizenshipId_To(Long citizenshipId_To) {
        this.citizenshipId_To = citizenshipId_To;
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

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
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

    public Long getGradeId_From() {
        return this.gradeId_From;
    }

    public Long getGradeId_To() {
        return this.gradeId_To;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public void setGradeId_From(Long gradeId_From) {
        this.gradeId_From = gradeId_From;
    }

    public void setGradeId_To(Long gradeId_To) {
        this.gradeId_To = gradeId_To;
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

    public Long getJobId_From() {
        return this.jobId_From;
    }

    public Long getJobId_To() {
        return this.jobId_To;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobId_From(Long jobId_From) {
        this.jobId_From = jobId_From;
    }

    public void setJobId_To(Long jobId_To) {
        this.jobId_To = jobId_To;
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

    public Long getPositionId_From() {
        return this.positionId_From;
    }

    public Long getPositionId_To() {
        return this.positionId_To;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public void setPositionId_From(Long positionId_From) {
        this.positionId_From = positionId_From;
    }

    public void setPositionId_To(Long positionId_To) {
        this.positionId_To = positionId_To;
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

    public Long getPosOrgId_From() {
        return this.posOrgId_From;
    }

    public Long getPosOrgId_To() {
        return this.posOrgId_To;
    }

    public void setPosOrgId(Long posOrgId) {
        this.posOrgId = posOrgId;
    }

    public void setPosOrgId_From(Long posOrgId_From) {
        this.posOrgId_From = posOrgId_From;
    }

    public void setPosOrgId_To(Long posOrgId_To) {
        this.posOrgId_To = posOrgId_To;
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

    public Long getOrganizationId_From() {
        return this.organizationId_From;
    }

    public Long getOrganizationId_To() {
        return this.organizationId_To;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationId_From(Long organizationId_From) {
        this.organizationId_From = organizationId_From;
    }

    public void setOrganizationId_To(Long organizationId_To) {
        this.organizationId_To = organizationId_To;
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

    public Float getBaseSalary_From() {
        return this.baseSalary_From;
    }

    public Float getBaseSalary_To() {
        return this.baseSalary_To;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary_From(Float baseSalary_From) {
        this.baseSalary_From = baseSalary_From;
    }

    public void setBaseSalary_To(Float baseSalary_To) {
        this.baseSalary_To = baseSalary_To;
    }

    public Long getPayrollId() {
        return this.payrollId;
    }

    public Long getPayrollId_From() {
        return this.payrollId_From;
    }

    public Long getPayrollId_To() {
        return this.payrollId_To;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }

    public void setPayrollId_From(Long payrollId_From) {
        this.payrollId_From = payrollId_From;
    }

    public void setPayrollId_To(Long payrollId_To) {
        this.payrollId_To = payrollId_To;
    }

    public String getPayroll() {
        return this.payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

}

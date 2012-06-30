/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeAssignmentDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private String employeeCode;

    private Long employerId;

    private Long employerId_From;
    private Long employerId_To;

    private String employerCode;

    private String firstName;

    private String lastName;

    private String middleName;

    private String name;

    private String className;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

    private Date validTo;

    private Date validTo_From;
    private Date validTo_To;

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

    private String posOrg;

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Float baseSalary;

    private Float baseSalary_From;
    private Float baseSalary_To;

    private Long payrollId;

    private Long payrollId_From;
    private Long payrollId_To;

    private String payroll;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Long getEmployeeId_From() {
        return this.employeeId_From;
    }

    public Long getEmployeeId_To() {
        return this.employeeId_To;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeId_From(Long employeeId_From) {
        this.employeeId_From = employeeId_From;
    }

    public void setEmployeeId_To(Long employeeId_To) {
        this.employeeId_To = employeeId_To;
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

    public Date getValidFrom_From() {
        return this.validFrom_From;
    }

    public Date getValidFrom_To() {
        return this.validFrom_To;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidFrom_From(Date validFrom_From) {
        this.validFrom_From = validFrom_From;
    }

    public void setValidFrom_To(Date validFrom_To) {
        this.validFrom_To = validFrom_To;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public Date getValidTo_From() {
        return this.validTo_From;
    }

    public Date getValidTo_To() {
        return this.validTo_To;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public void setValidTo_From(Date validTo_From) {
        this.validTo_From = validTo_From;
    }

    public void setValidTo_To(Date validTo_To) {
        this.validTo_To = validTo_To;
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

    public String getPosOrg() {
        return this.posOrg;
    }

    public void setPosOrg(String posOrg) {
        this.posOrg = posOrg;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
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

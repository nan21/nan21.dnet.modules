/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeDsFilter extends AbstractAuditableDsFilter {

    private String code;

    private Long employerId;

    private Long employerId_From;
    private Long employerId_To;

    private String employerCode;

    private String businessObject;

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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

}

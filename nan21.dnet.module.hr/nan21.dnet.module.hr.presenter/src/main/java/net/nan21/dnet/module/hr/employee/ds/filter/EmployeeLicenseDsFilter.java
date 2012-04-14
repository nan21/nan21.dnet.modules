/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeLicenseDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private Long licenseTypeId;

    private Long licenseTypeId_From;
    private Long licenseTypeId_To;

    private String licenseType;

    private String documentNo;

    private String issuedBy;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

    private Date validTo;

    private Date validTo_From;
    private Date validTo_To;

    private String notes;

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

    public Long getLicenseTypeId() {
        return this.licenseTypeId;
    }

    public Long getLicenseTypeId_From() {
        return this.licenseTypeId_From;
    }

    public Long getLicenseTypeId_To() {
        return this.licenseTypeId_To;
    }

    public void setLicenseTypeId(Long licenseTypeId) {
        this.licenseTypeId = licenseTypeId;
    }

    public void setLicenseTypeId_From(Long licenseTypeId_From) {
        this.licenseTypeId_From = licenseTypeId_From;
    }

    public void setLicenseTypeId_To(Long licenseTypeId_To) {
        this.licenseTypeId_To = licenseTypeId_To;
    }

    public String getLicenseType() {
        return this.licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getDocumentNo() {
        return this.documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getIssuedBy() {
        return this.issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

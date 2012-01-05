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

public class EmployeeLicenseDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

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

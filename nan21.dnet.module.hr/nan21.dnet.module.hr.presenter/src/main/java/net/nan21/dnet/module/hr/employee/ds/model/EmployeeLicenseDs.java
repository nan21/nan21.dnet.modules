/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;

@Ds(entity = EmployeeLicense.class)
public class EmployeeLicenseDs extends AbstractAuditableDs<EmployeeLicense> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fLICENSETYPEID = "licenseTypeId";
    public static final String fLICENSETYPE = "licenseType";
    public static final String fDOCUMENTNO = "documentNo";
    public static final String fISSUEDBY = "issuedBy";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";
    public static final String fNOTES = "notes";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "licenseType.id")
    private Long licenseTypeId;

    @DsField(join = "left", path = "licenseType.name")
    private String licenseType;

    @DsField()
    private String documentNo;

    @DsField()
    private String issuedBy;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    @DsField()
    private String notes;

    public EmployeeLicenseDs() {
        super();
    }

    public EmployeeLicenseDs(EmployeeLicense e) {
        super(e);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getLicenseTypeId() {
        return this.licenseTypeId;
    }

    public void setLicenseTypeId(Long licenseTypeId) {
        this.licenseTypeId = licenseTypeId;
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

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

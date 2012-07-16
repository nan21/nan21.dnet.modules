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
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

@Ds(entity = EmployeeEducation.class)
public class EmployeeEducationDs extends AbstractAuditableDs<EmployeeEducation> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fFROMDATE = "fromDate";
    public static final String fTODATE = "toDate";
    public static final String fINSTITUTE = "institute";
    public static final String fDEGREE = "degree";
    public static final String fNOTES = "notes";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField()
    private Date fromDate;

    @DsField()
    private Date toDate;

    @DsField()
    private String institute;

    @DsField()
    private String degree;

    @DsField()
    private String notes;

    public EmployeeEducationDs() {
        super();
    }

    public EmployeeEducationDs(EmployeeEducation e) {
        super(e);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getInstitute() {
        return this.institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

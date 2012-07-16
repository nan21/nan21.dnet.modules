/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;

@Ds(entity = Absence.class)
public class AbsenceDs extends AbstractAuditableDs<Absence> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fEMPLOYEECODE = "employeeCode";
    public static final String fEMPLOYEE = "employee";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fREASONID = "reasonId";
    public static final String fREASON = "reason";
    public static final String fEVENTDATE = "eventDate";
    public static final String fHOURS = "hours";
    public static final String fNOTES = "notes";
    public static final String fPOSTED = "posted";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "employee.code")
    private String employeeCode;

    @DsField(join = "left", orderBy = "lastName,firstName", fetch = false, path = "employee.name")
    private String employee;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "reason.id")
    private Long reasonId;

    @DsField(join = "left", path = "reason.name")
    private String reason;

    @DsField()
    private Date eventDate;

    @DsField()
    private Integer hours;

    @DsField()
    private String notes;

    @DsField()
    private Boolean posted;

    public AbsenceDs() {
        super();
    }

    public AbsenceDs(Absence e) {
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

    public String getEmployee() {
        return this.employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
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

    public Long getReasonId() {
        return this.reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

}

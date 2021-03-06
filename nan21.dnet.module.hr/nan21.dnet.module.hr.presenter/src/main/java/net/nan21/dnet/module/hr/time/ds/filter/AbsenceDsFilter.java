/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AbsenceDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private String employeeCode;

    private String employee;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Long reasonId;

    private Long reasonId_From;
    private Long reasonId_To;

    private String reason;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    private Integer hours;

    private Integer hours_From;
    private Integer hours_To;

    private String notes;

    private Boolean posted;

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

    public String getEmployee() {
        return this.employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
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

    public Long getReasonId() {
        return this.reasonId;
    }

    public Long getReasonId_From() {
        return this.reasonId_From;
    }

    public Long getReasonId_To() {
        return this.reasonId_To;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public void setReasonId_From(Long reasonId_From) {
        this.reasonId_From = reasonId_From;
    }

    public void setReasonId_To(Long reasonId_To) {
        this.reasonId_To = reasonId_To;
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

    public Date getEventDate_From() {
        return this.eventDate_From;
    }

    public Date getEventDate_To() {
        return this.eventDate_To;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDate_From(Date eventDate_From) {
        this.eventDate_From = eventDate_From;
    }

    public void setEventDate_To(Date eventDate_To) {
        this.eventDate_To = eventDate_To;
    }

    public Integer getHours() {
        return this.hours;
    }

    public Integer getHours_From() {
        return this.hours_From;
    }

    public Integer getHours_To() {
        return this.hours_To;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setHours_From(Integer hours_From) {
        this.hours_From = hours_From;
    }

    public void setHours_To(Integer hours_To) {
        this.hours_To = hours_To;
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

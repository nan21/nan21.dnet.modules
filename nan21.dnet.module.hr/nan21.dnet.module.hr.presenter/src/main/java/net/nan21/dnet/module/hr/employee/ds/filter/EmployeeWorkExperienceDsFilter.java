/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeWorkExperienceDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private Date fromDate;

    private Date fromDate_From;
    private Date fromDate_To;

    private Date toDate;

    private Date toDate_From;
    private Date toDate_To;

    private String institute;

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

    public Date getFromDate() {
        return this.fromDate;
    }

    public Date getFromDate_From() {
        return this.fromDate_From;
    }

    public Date getFromDate_To() {
        return this.fromDate_To;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setFromDate_From(Date fromDate_From) {
        this.fromDate_From = fromDate_From;
    }

    public void setFromDate_To(Date fromDate_To) {
        this.fromDate_To = fromDate_To;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public Date getToDate_From() {
        return this.toDate_From;
    }

    public Date getToDate_To() {
        return this.toDate_To;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setToDate_From(Date toDate_From) {
        this.toDate_From = toDate_From;
    }

    public void setToDate_To(Date toDate_To) {
        this.toDate_To = toDate_To;
    }

    public String getInstitute() {
        return this.institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

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

public class EmployeeWorkExperienceDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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

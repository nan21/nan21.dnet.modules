/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class PayrollPeriodDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

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

    private Long payrollId;

    private Long payrollId_From;
    private Long payrollId_To;

    private String payrollName;

    private Date startDate;

    private Date startDate_From;
    private Date startDate_To;

    private Date endDate;

    private Date endDate_From;
    private Date endDate_To;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getPayrollName() {
        return this.payrollName;
    }

    public void setPayrollName(String payrollName) {
        this.payrollName = payrollName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getStartDate_From() {
        return this.startDate_From;
    }

    public Date getStartDate_To() {
        return this.startDate_To;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartDate_From(Date startDate_From) {
        this.startDate_From = startDate_From;
    }

    public void setStartDate_To(Date startDate_To) {
        this.startDate_To = startDate_To;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getEndDate_From() {
        return this.endDate_From;
    }

    public Date getEndDate_To() {
        return this.endDate_To;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate_From(Date endDate_From) {
        this.endDate_From = endDate_From;
    }

    public void setEndDate_To(Date endDate_To) {
        this.endDate_To = endDate_To;
    }

}

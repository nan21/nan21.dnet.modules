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

public class ElementValueDsFilter extends AbstractDsFilter implements
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

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private String employeeName;

    private String value;

    private Long periodId;

    private Long periodId_From;
    private Long periodId_To;

    private String period;

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

    public Long getElementId() {
        return this.elementId;
    }

    public Long getElementId_From() {
        return this.elementId_From;
    }

    public Long getElementId_To() {
        return this.elementId_To;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public void setElementId_From(Long elementId_From) {
        this.elementId_From = elementId_From;
    }

    public void setElementId_To(Long elementId_To) {
        this.elementId_To = elementId_To;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
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

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPeriodId() {
        return this.periodId;
    }

    public Long getPeriodId_From() {
        return this.periodId_From;
    }

    public Long getPeriodId_To() {
        return this.periodId_To;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public void setPeriodId_From(Long periodId_From) {
        this.periodId_From = periodId_From;
    }

    public void setPeriodId_To(Long periodId_To) {
        this.periodId_To = periodId_To;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}

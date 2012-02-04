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

public class VariableDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private String name;

    private String code;

    private Boolean active;

    private String notes;

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

    private Long crossReferenceId;

    private Long crossReferenceId_From;
    private Long crossReferenceId_To;

    private String crossReference;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Long getCrossReferenceId() {
        return this.crossReferenceId;
    }

    public Long getCrossReferenceId_From() {
        return this.crossReferenceId_From;
    }

    public Long getCrossReferenceId_To() {
        return this.crossReferenceId_To;
    }

    public void setCrossReferenceId(Long crossReferenceId) {
        this.crossReferenceId = crossReferenceId;
    }

    public void setCrossReferenceId_From(Long crossReferenceId_From) {
        this.crossReferenceId_From = crossReferenceId_From;
    }

    public void setCrossReferenceId_To(Long crossReferenceId_To) {
        this.crossReferenceId_To = crossReferenceId_To;
    }

    public String getCrossReference() {
        return this.crossReference;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

}

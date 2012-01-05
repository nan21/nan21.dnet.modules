/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class InvTransactionTypeDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

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

    private Long sourceTypeId;

    private Long sourceTypeId_From;
    private Long sourceTypeId_To;

    private String sourceType;

    private Long actionId;

    private Long actionId_From;
    private Long actionId_To;

    private String action;

    private Boolean hasFromInventory;

    private Boolean hasToInventory;

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

    public Long getSourceTypeId() {
        return this.sourceTypeId;
    }

    public Long getSourceTypeId_From() {
        return this.sourceTypeId_From;
    }

    public Long getSourceTypeId_To() {
        return this.sourceTypeId_To;
    }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public void setSourceTypeId_From(Long sourceTypeId_From) {
        this.sourceTypeId_From = sourceTypeId_From;
    }

    public void setSourceTypeId_To(Long sourceTypeId_To) {
        this.sourceTypeId_To = sourceTypeId_To;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Long getActionId() {
        return this.actionId;
    }

    public Long getActionId_From() {
        return this.actionId_From;
    }

    public Long getActionId_To() {
        return this.actionId_To;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public void setActionId_From(Long actionId_From) {
        this.actionId_From = actionId_From;
    }

    public void setActionId_To(Long actionId_To) {
        this.actionId_To = actionId_To;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getHasFromInventory() {
        return this.hasFromInventory;
    }

    public void setHasFromInventory(Boolean hasFromInventory) {
        this.hasFromInventory = hasFromInventory;
    }

    public Boolean getHasToInventory() {
        return this.hasToInventory;
    }

    public void setHasToInventory(Boolean hasToInventory) {
        this.hasToInventory = hasToInventory;
    }

}

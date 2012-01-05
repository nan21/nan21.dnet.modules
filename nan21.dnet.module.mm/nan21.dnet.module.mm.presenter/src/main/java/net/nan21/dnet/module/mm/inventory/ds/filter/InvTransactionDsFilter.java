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

public class InvTransactionDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

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

    private Long transactionTypeId;

    private Long transactionTypeId_From;
    private Long transactionTypeId_To;

    private String transactionType;

    private Boolean hasFromInventory;

    private Boolean hasToInventory;

    private Long fromInventoryId;

    private Long fromInventoryId_From;
    private Long fromInventoryId_To;

    private String fromInventory;

    private Long toInventoryId;

    private Long toInventoryId_From;
    private Long toInventoryId_To;

    private String toInventory;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

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

    public Long getTransactionTypeId() {
        return this.transactionTypeId;
    }

    public Long getTransactionTypeId_From() {
        return this.transactionTypeId_From;
    }

    public Long getTransactionTypeId_To() {
        return this.transactionTypeId_To;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public void setTransactionTypeId_From(Long transactionTypeId_From) {
        this.transactionTypeId_From = transactionTypeId_From;
    }

    public void setTransactionTypeId_To(Long transactionTypeId_To) {
        this.transactionTypeId_To = transactionTypeId_To;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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

    public Long getFromInventoryId() {
        return this.fromInventoryId;
    }

    public Long getFromInventoryId_From() {
        return this.fromInventoryId_From;
    }

    public Long getFromInventoryId_To() {
        return this.fromInventoryId_To;
    }

    public void setFromInventoryId(Long fromInventoryId) {
        this.fromInventoryId = fromInventoryId;
    }

    public void setFromInventoryId_From(Long fromInventoryId_From) {
        this.fromInventoryId_From = fromInventoryId_From;
    }

    public void setFromInventoryId_To(Long fromInventoryId_To) {
        this.fromInventoryId_To = fromInventoryId_To;
    }

    public String getFromInventory() {
        return this.fromInventory;
    }

    public void setFromInventory(String fromInventory) {
        this.fromInventory = fromInventory;
    }

    public Long getToInventoryId() {
        return this.toInventoryId;
    }

    public Long getToInventoryId_From() {
        return this.toInventoryId_From;
    }

    public Long getToInventoryId_To() {
        return this.toInventoryId_To;
    }

    public void setToInventoryId(Long toInventoryId) {
        this.toInventoryId = toInventoryId;
    }

    public void setToInventoryId_From(Long toInventoryId_From) {
        this.toInventoryId_From = toInventoryId_From;
    }

    public void setToInventoryId_To(Long toInventoryId_To) {
        this.toInventoryId_To = toInventoryId_To;
    }

    public String getToInventory() {
        return this.toInventory;
    }

    public void setToInventory(String toInventory) {
        this.toInventory = toInventory;
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

}

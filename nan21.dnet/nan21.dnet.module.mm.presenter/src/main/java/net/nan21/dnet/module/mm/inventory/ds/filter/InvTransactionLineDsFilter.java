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

public class InvTransactionLineDsFilter extends AbstractDsFilter implements
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

    private Long transactionId;

    private Long transactionId_From;
    private Long transactionId_To;

    private Long fromInventoryId;

    private Long fromInventoryId_From;
    private Long fromInventoryId_To;

    private Long toInventoryId;

    private Long toInventoryId_From;
    private Long toInventoryId_To;

    private Long itemId;

    private Long itemId_From;
    private Long itemId_To;

    private String itemCode;

    private String item;

    private Long fromSubInventoryId;

    private Long fromSubInventoryId_From;
    private Long fromSubInventoryId_To;

    private String fromSubInventory;

    private Long fromLocatorId;

    private Long fromLocatorId_From;
    private Long fromLocatorId_To;

    private String fromLocator;

    private Long toSubInventoryId;

    private Long toSubInventoryId_From;
    private Long toSubInventoryId_To;

    private String toSubInventory;

    private Long toLocatorId;

    private Long toLocatorId_From;
    private Long toLocatorId_To;

    private String toLocator;

    private Float quantity;

    private Float quantity_From;
    private Float quantity_To;

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

    public Long getTransactionId() {
        return this.transactionId;
    }

    public Long getTransactionId_From() {
        return this.transactionId_From;
    }

    public Long getTransactionId_To() {
        return this.transactionId_To;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionId_From(Long transactionId_From) {
        this.transactionId_From = transactionId_From;
    }

    public void setTransactionId_To(Long transactionId_To) {
        this.transactionId_To = transactionId_To;
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

    public Long getItemId() {
        return this.itemId;
    }

    public Long getItemId_From() {
        return this.itemId_From;
    }

    public Long getItemId_To() {
        return this.itemId_To;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemId_From(Long itemId_From) {
        this.itemId_From = itemId_From;
    }

    public void setItemId_To(Long itemId_To) {
        this.itemId_To = itemId_To;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getFromSubInventoryId() {
        return this.fromSubInventoryId;
    }

    public Long getFromSubInventoryId_From() {
        return this.fromSubInventoryId_From;
    }

    public Long getFromSubInventoryId_To() {
        return this.fromSubInventoryId_To;
    }

    public void setFromSubInventoryId(Long fromSubInventoryId) {
        this.fromSubInventoryId = fromSubInventoryId;
    }

    public void setFromSubInventoryId_From(Long fromSubInventoryId_From) {
        this.fromSubInventoryId_From = fromSubInventoryId_From;
    }

    public void setFromSubInventoryId_To(Long fromSubInventoryId_To) {
        this.fromSubInventoryId_To = fromSubInventoryId_To;
    }

    public String getFromSubInventory() {
        return this.fromSubInventory;
    }

    public void setFromSubInventory(String fromSubInventory) {
        this.fromSubInventory = fromSubInventory;
    }

    public Long getFromLocatorId() {
        return this.fromLocatorId;
    }

    public Long getFromLocatorId_From() {
        return this.fromLocatorId_From;
    }

    public Long getFromLocatorId_To() {
        return this.fromLocatorId_To;
    }

    public void setFromLocatorId(Long fromLocatorId) {
        this.fromLocatorId = fromLocatorId;
    }

    public void setFromLocatorId_From(Long fromLocatorId_From) {
        this.fromLocatorId_From = fromLocatorId_From;
    }

    public void setFromLocatorId_To(Long fromLocatorId_To) {
        this.fromLocatorId_To = fromLocatorId_To;
    }

    public String getFromLocator() {
        return this.fromLocator;
    }

    public void setFromLocator(String fromLocator) {
        this.fromLocator = fromLocator;
    }

    public Long getToSubInventoryId() {
        return this.toSubInventoryId;
    }

    public Long getToSubInventoryId_From() {
        return this.toSubInventoryId_From;
    }

    public Long getToSubInventoryId_To() {
        return this.toSubInventoryId_To;
    }

    public void setToSubInventoryId(Long toSubInventoryId) {
        this.toSubInventoryId = toSubInventoryId;
    }

    public void setToSubInventoryId_From(Long toSubInventoryId_From) {
        this.toSubInventoryId_From = toSubInventoryId_From;
    }

    public void setToSubInventoryId_To(Long toSubInventoryId_To) {
        this.toSubInventoryId_To = toSubInventoryId_To;
    }

    public String getToSubInventory() {
        return this.toSubInventory;
    }

    public void setToSubInventory(String toSubInventory) {
        this.toSubInventory = toSubInventory;
    }

    public Long getToLocatorId() {
        return this.toLocatorId;
    }

    public Long getToLocatorId_From() {
        return this.toLocatorId_From;
    }

    public Long getToLocatorId_To() {
        return this.toLocatorId_To;
    }

    public void setToLocatorId(Long toLocatorId) {
        this.toLocatorId = toLocatorId;
    }

    public void setToLocatorId_From(Long toLocatorId_From) {
        this.toLocatorId_From = toLocatorId_From;
    }

    public void setToLocatorId_To(Long toLocatorId_To) {
        this.toLocatorId_To = toLocatorId_To;
    }

    public String getToLocator() {
        return this.toLocator;
    }

    public void setToLocator(String toLocator) {
        this.toLocator = toLocator;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public Float getQuantity_From() {
        return this.quantity_From;
    }

    public Float getQuantity_To() {
        return this.quantity_To;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setQuantity_From(Float quantity_From) {
        this.quantity_From = quantity_From;
    }

    public void setQuantity_To(Float quantity_To) {
        this.quantity_To = quantity_To;
    }

}

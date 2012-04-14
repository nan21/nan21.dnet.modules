/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseInventoryTransactionDsFilter extends
        AbstractAuditableDsFilter {

    private Long supplierId;

    private Long supplierId_From;
    private Long supplierId_To;

    private String supplier;

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

    public Long getSupplierId() {
        return this.supplierId;
    }

    public Long getSupplierId_From() {
        return this.supplierId_From;
    }

    public Long getSupplierId_To() {
        return this.supplierId_To;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierId_From(Long supplierId_From) {
        this.supplierId_From = supplierId_From;
    }

    public void setSupplierId_To(Long supplierId_To) {
        this.supplierId_To = supplierId_To;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

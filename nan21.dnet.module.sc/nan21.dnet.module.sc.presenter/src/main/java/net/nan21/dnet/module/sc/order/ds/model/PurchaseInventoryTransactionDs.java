/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

@Ds(entity = PurchaseInventoryTransaction.class)
public class PurchaseInventoryTransactionDs extends
        AbstractAuditableDs<PurchaseInventoryTransaction> {

    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIER = "supplier";
    public static final String fTRANSACTIONTYPEID = "transactionTypeId";
    public static final String fTRANSACTIONTYPE = "transactionType";
    public static final String fHASFROMINVENTORY = "hasFromInventory";
    public static final String fHASTOINVENTORY = "hasToInventory";
    public static final String fFROMINVENTORYID = "fromInventoryId";
    public static final String fFROMINVENTORY = "fromInventory";
    public static final String fTOINVENTORYID = "toInventoryId";
    public static final String fTOINVENTORY = "toInventory";
    public static final String fEVENTDATE = "eventDate";

    @DsField(join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(join = "left", path = "supplier.code")
    private String supplier;

    @DsField(join = "left", path = "transactionType.id")
    private Long transactionTypeId;

    @DsField(join = "left", path = "transactionType.name")
    private String transactionType;

    @DsField(join = "left", path = "transactionType.hasFromInventory")
    private Boolean hasFromInventory;

    @DsField(join = "left", path = "transactionType.hasToInventory")
    private Boolean hasToInventory;

    @DsField(join = "left", path = "fromInventory.id")
    private Long fromInventoryId;

    @DsField(join = "left", path = "fromInventory.code")
    private String fromInventory;

    @DsField(join = "left", path = "toInventory.id")
    private Long toInventoryId;

    @DsField(join = "left", path = "toInventory.code")
    private String toInventory;

    @DsField()
    private Date eventDate;

    public PurchaseInventoryTransactionDs() {
        super();
    }

    public PurchaseInventoryTransactionDs(PurchaseInventoryTransaction e) {
        super(e);
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
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

    public void setFromInventoryId(Long fromInventoryId) {
        this.fromInventoryId = fromInventoryId;
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

    public void setToInventoryId(Long toInventoryId) {
        this.toInventoryId = toInventoryId;
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

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

}

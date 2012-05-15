/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvTransaction.class, sort = { @SortField(field = InvTransactionDs.fEVENTDATE, desc = true) })
public class InvTransactionDs extends AbstractAuditableDs<InvTransaction> {

    public static final String fTRANSACTIONTYPEID = "transactionTypeId";
    public static final String fTRANSACTIONTYPE = "transactionType";
    public static final String fHASFROMINVENTORY = "hasFromInventory";
    public static final String fHASTOINVENTORY = "hasToInventory";
    public static final String fFROMINVENTORYID = "fromInventoryId";
    public static final String fFROMINVENTORY = "fromInventory";
    public static final String fTOINVENTORYID = "toInventoryId";
    public static final String fTOINVENTORY = "toInventory";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";
    public static final String fEVENTDATE = "eventDate";
    public static final String fDOCDATE = "docDate";

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
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    @DsField()
    private Date eventDate;

    @DsField()
    private Date docDate;

    public InvTransactionDs() {
        super();
    }

    public InvTransactionDs(InvTransaction e) {
        super(e);
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

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

}

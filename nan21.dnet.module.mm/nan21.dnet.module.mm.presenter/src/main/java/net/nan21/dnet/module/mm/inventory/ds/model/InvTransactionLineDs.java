/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvTransactionLine.class)
public class InvTransactionLineDs extends
        AbstractAuditableDs<InvTransactionLine> {

    public static final String fTRANSACTIONID = "transactionId";
    public static final String fFROMINVENTORYID = "fromInventoryId";
    public static final String fTOINVENTORYID = "toInventoryId";
    public static final String fITEMID = "itemId";
    public static final String fITEMCODE = "itemCode";
    public static final String fITEM = "item";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";
    public static final String fFROMSUBINVENTORYID = "fromSubInventoryId";
    public static final String fFROMSUBINVENTORY = "fromSubInventory";
    public static final String fFROMLOCATORID = "fromLocatorId";
    public static final String fFROMLOCATOR = "fromLocator";
    public static final String fTOSUBINVENTORYID = "toSubInventoryId";
    public static final String fTOSUBINVENTORY = "toSubInventory";
    public static final String fTOLOCATORID = "toLocatorId";
    public static final String fTOLOCATOR = "toLocator";
    public static final String fQUANTITY = "quantity";

    @DsField(join = "left", path = "invTransaction.id")
    private Long transactionId;

    @DsField(join = "left", path = "invTransaction.fromInventory.id")
    private Long fromInventoryId;

    @DsField(join = "left", path = "invTransaction.toInventory.id")
    private Long toInventoryId;

    @DsField(join = "left", path = "item.id")
    private Long itemId;

    @DsField(join = "left", path = "item.code")
    private String itemCode;

    @DsField(join = "left", path = "item.name")
    private String item;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    @DsField(join = "left", path = "fromSubInventory.id")
    private Long fromSubInventoryId;

    @DsField(join = "left", path = "fromSubInventory.name")
    private String fromSubInventory;

    @DsField(join = "left", path = "fromLocator.id")
    private Long fromLocatorId;

    @DsField(join = "left", path = "fromLocator.name")
    private String fromLocator;

    @DsField(join = "left", path = "toSubInventory.id")
    private Long toSubInventoryId;

    @DsField(join = "left", path = "toSubInventory.name")
    private String toSubInventory;

    @DsField(join = "left", path = "toLocator.id")
    private Long toLocatorId;

    @DsField(join = "left", path = "toLocator.name")
    private String toLocator;

    @DsField()
    private Float quantity;

    public InvTransactionLineDs() {
        super();
    }

    public InvTransactionLineDs(InvTransactionLine e) {
        super(e);
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFromInventoryId() {
        return this.fromInventoryId;
    }

    public void setFromInventoryId(Long fromInventoryId) {
        this.fromInventoryId = fromInventoryId;
    }

    public Long getToInventoryId() {
        return this.toInventoryId;
    }

    public void setToInventoryId(Long toInventoryId) {
        this.toInventoryId = toInventoryId;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public Long getUomId() {
        return this.uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Long getFromSubInventoryId() {
        return this.fromSubInventoryId;
    }

    public void setFromSubInventoryId(Long fromSubInventoryId) {
        this.fromSubInventoryId = fromSubInventoryId;
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

    public void setFromLocatorId(Long fromLocatorId) {
        this.fromLocatorId = fromLocatorId;
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

    public void setToSubInventoryId(Long toSubInventoryId) {
        this.toSubInventoryId = toSubInventoryId;
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

    public void setToLocatorId(Long toLocatorId) {
        this.toLocatorId = toLocatorId;
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

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

}

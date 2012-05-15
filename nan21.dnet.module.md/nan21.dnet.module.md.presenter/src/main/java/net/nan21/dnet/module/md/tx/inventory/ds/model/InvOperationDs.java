/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvOperation;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvOperation.class, sort = { @SortField(field = InvOperationDs.fEVENTDATE, desc = true) })
public class InvOperationDs extends AbstractAuditableDs<InvOperation> {

    public static final String fITEMID = "itemId";
    public static final String fITEMCODE = "itemCode";
    public static final String fITEM = "item";
    public static final String fEVENTDATE = "eventDate";
    public static final String fINVENTORYID = "inventoryId";
    public static final String fINVENTORY = "inventory";
    public static final String fINVENTORYNAME = "inventoryName";
    public static final String fSUBINVENTORYID = "subInventoryId";
    public static final String fSUBINVENTORY = "subInventory";
    public static final String fLOCATORID = "locatorId";
    public static final String fLOCATOR = "locator";
    public static final String fTRANSACTIONID = "transactionId";
    public static final String fTRANSACTIONLINEID = "transactionLineId";
    public static final String fDIRECTION = "direction";
    public static final String fQUANTITY = "quantity";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";

    @DsField(join = "left", path = "item.id")
    private Long itemId;

    @DsField(join = "left", path = "item.code")
    private String itemCode;

    @DsField(join = "left", path = "item.name")
    private String item;

    @DsField()
    private Date eventDate;

    @DsField(join = "left", path = "inventory.id")
    private Long inventoryId;

    @DsField(join = "left", path = "inventory.code")
    private String inventory;

    @DsField(join = "left", path = "inventory.name")
    private String inventoryName;

    @DsField(join = "left", path = "subInventory.id")
    private Long subInventoryId;

    @DsField(join = "left", path = "subInventory.name")
    private String subInventory;

    @DsField(join = "left", path = "locator.id")
    private Long locatorId;

    @DsField(join = "left", path = "locator.name")
    private String locator;

    @DsField(join = "left", path = "transactionLine.invTransaction.id")
    private Long transactionId;

    @DsField(join = "left", path = "transactionLine.id")
    private Long transactionLineId;

    @DsField()
    private String direction;

    @DsField()
    private Float quantity;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    public InvOperationDs() {
        super();
    }

    public InvOperationDs(InvOperation e) {
        super(e);
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

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getInventoryName() {
        return this.inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public Long getSubInventoryId() {
        return this.subInventoryId;
    }

    public void setSubInventoryId(Long subInventoryId) {
        this.subInventoryId = subInventoryId;
    }

    public String getSubInventory() {
        return this.subInventory;
    }

    public void setSubInventory(String subInventory) {
        this.subInventory = subInventory;
    }

    public Long getLocatorId() {
        return this.locatorId;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public String getLocator() {
        return this.locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionLineId() {
        return this.transactionLineId;
    }

    public void setTransactionLineId(Long transactionLineId) {
        this.transactionLineId = transactionLineId;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
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

}

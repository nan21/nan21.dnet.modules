/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvTransactionLine.class)
public class InvTransactionLineDs extends AbstractDsModel<InvTransactionLine>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fTRANSACTIONID = "transactionId";
    public static final String fFROMINVENTORYID = "fromInventoryId";
    public static final String fTOINVENTORYID = "toInventoryId";
    public static final String fITEMID = "itemId";
    public static final String fITEMCODE = "itemCode";
    public static final String fITEM = "item";
    public static final String fFROMSUBINVENTORYID = "fromSubInventoryId";
    public static final String fFROMSUBINVENTORY = "fromSubInventory";
    public static final String fFROMLOCATORID = "fromLocatorId";
    public static final String fFROMLOCATOR = "fromLocator";
    public static final String fTOSUBINVENTORYID = "toSubInventoryId";
    public static final String fTOSUBINVENTORY = "toSubInventory";
    public static final String fTOLOCATORID = "toLocatorId";
    public static final String fTOLOCATOR = "toLocator";
    public static final String fQUANTITY = "quantity";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

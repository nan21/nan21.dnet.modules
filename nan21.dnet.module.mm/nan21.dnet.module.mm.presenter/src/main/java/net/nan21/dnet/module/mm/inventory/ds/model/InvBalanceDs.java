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

import net.nan21.dnet.module.mm.inventory.domain.entity.InvBalance;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvBalance.class)
public class InvBalanceDs extends AbstractDsModel<InvBalance> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fSUBINVENTORYID = "subInventoryId";
    public static final String fSUBINVENTORY = "subInventory";
    public static final String fLOCATORID = "locatorId";
    public static final String fLOCATOR = "locator";
    public static final String fITEMID = "itemId";
    public static final String fITEM = "item";
    public static final String fITEMNAME = "itemName";
    public static final String fQUANTITY = "quantity";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";

    @DsField()
    private Long id;

    @DsField()
    private String uuid;

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

    @DsField(fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "subInventory.id")
    private Long subInventoryId;

    @DsField(join = "left", path = "subInventory.name")
    private String subInventory;

    @DsField(join = "left", path = "locator.id")
    private Long locatorId;

    @DsField(join = "left", path = "locator.name")
    private String locator;

    @DsField(join = "left", path = "item.id")
    private Long itemId;

    @DsField(join = "left", path = "item.code")
    private String item;

    @DsField(join = "left", path = "item.name")
    private String itemName;

    @DsField()
    private Float quantity;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    public InvBalanceDs() {
        super();
    }

    public InvBalanceDs(InvBalance e) {
        super(e);
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

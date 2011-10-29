/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.pj.md.domain.entity.ItemText;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ItemText.class)
public class ItemTextDs extends AbstractDsModel<ItemText> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fITEMID = "itemId";
    public static final String fITEMTEXTTYPEID = "itemTextTypeId";
    public static final String fITEMTEXTTYPE = "itemTextType";
    public static final String fCONTENT = "content";

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

    @DsField(join = "left", path = "item.id")
    private Long itemId;

    @DsField(join = "left", path = "itemTextType.id")
    private Long itemTextTypeId;

    @DsField(join = "left", path = "itemTextType.name")
    private String itemTextType;

    @DsField()
    private String content;

    public ItemTextDs() {
        super();
    }

    public ItemTextDs(ItemText e) {
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

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemTextTypeId() {
        return this.itemTextTypeId;
    }

    public void setItemTextTypeId(Long itemTextTypeId) {
        this.itemTextTypeId = itemTextTypeId;
    }

    public String getItemTextType() {
        return this.itemTextType;
    }

    public void setItemTextType(String itemTextType) {
        this.itemTextType = itemTextType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

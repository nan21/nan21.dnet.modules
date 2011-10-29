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

import net.nan21.dnet.module.pj.md.domain.entity.ItemLink;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ItemLink.class)
public class ItemLinkDs extends AbstractDsModel<ItemLink> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fSOURCEITEMID = "sourceItemId";
    public static final String fSOURCEITEM = "sourceItem";
    public static final String fTARGETITEMID = "targetItemId";
    public static final String fTARGETITEM = "targetItem";
    public static final String fLINKTYPEID = "linkTypeId";
    public static final String fLINKTYPE = "linkType";

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

    @DsField(join = "left", path = "sourceItem.id")
    private Long sourceItemId;

    @DsField(join = "left", path = "sourceItem.summary")
    private String sourceItem;

    @DsField(join = "left", path = "targetItem.id")
    private Long targetItemId;

    @DsField(join = "left", path = "targetItem.summary")
    private String targetItem;

    @DsField(join = "left", path = "linkType.id")
    private Long linkTypeId;

    @DsField(join = "left", path = "linkType.name")
    private String linkType;

    public ItemLinkDs() {
        super();
    }

    public ItemLinkDs(ItemLink e) {
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

    public Long getSourceItemId() {
        return this.sourceItemId;
    }

    public void setSourceItemId(Long sourceItemId) {
        this.sourceItemId = sourceItemId;
    }

    public String getSourceItem() {
        return this.sourceItem;
    }

    public void setSourceItem(String sourceItem) {
        this.sourceItem = sourceItem;
    }

    public Long getTargetItemId() {
        return this.targetItemId;
    }

    public void setTargetItemId(Long targetItemId) {
        this.targetItemId = targetItemId;
    }

    public String getTargetItem() {
        return this.targetItem;
    }

    public void setTargetItem(String targetItem) {
        this.targetItem = targetItem;
    }

    public Long getLinkTypeId() {
        return this.linkTypeId;
    }

    public void setLinkTypeId(Long linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

}

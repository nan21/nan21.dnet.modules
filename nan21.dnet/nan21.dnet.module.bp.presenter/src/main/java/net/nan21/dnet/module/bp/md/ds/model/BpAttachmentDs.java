/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bp.md.domain.entity.BpAttachment;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = BpAttachment.class)
public class BpAttachmentDs extends AbstractDsModel<BpAttachment> implements
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
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fCATEGORY = "category";
    public static final String fBUSINESSPARTNERID = "businessPartnerId";
    public static final String fBUSINESSPARTNER = "businessPartner";
    public static final String fBUSINESSPARTNERBO = "businessPartnerBO";
    public static final String fNAME = "name";
    public static final String fLOCATION = "location";
    public static final String fNOTES = "notes";
    public static final String fURL = "url";

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

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "type.category")
    private String category;

    @DsField(join = "left", path = "bpartner.id")
    private Long businessPartnerId;

    @DsField(join = "left", path = "bpartner.code")
    private String businessPartner;

    @DsField(join = "left", fetch = false, path = "bpartner.businessObject")
    private String businessPartnerBO;

    @DsField()
    private String name;

    @DsField()
    private String location;

    @DsField()
    private String notes;

    @DsField(fetch = false)
    private String url;

    public BpAttachmentDs() {
        super();
    }

    public BpAttachmentDs(BpAttachment e) {
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

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public String getBusinessPartner() {
        return this.businessPartner;
    }

    public void setBusinessPartner(String businessPartner) {
        this.businessPartner = businessPartner;
    }

    public String getBusinessPartnerBO() {
        return this.businessPartnerBO;
    }

    public void setBusinessPartnerBO(String businessPartnerBO) {
        this.businessPartnerBO = businessPartnerBO;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

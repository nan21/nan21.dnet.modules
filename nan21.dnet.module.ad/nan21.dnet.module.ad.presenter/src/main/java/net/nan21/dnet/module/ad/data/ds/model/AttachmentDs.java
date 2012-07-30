/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

@Ds(entity = Attachment.class)
public class AttachmentDs extends AbstractAuditableDs<Attachment> {

    public static final String fTARGETUUID = "targetUuid";
    public static final String fTARGETTYPE = "targetType";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fCATEGORY = "category";
    public static final String fBASEURL = "baseUrl";
    public static final String fNAME = "name";
    public static final String fLOCATION = "location";
    public static final String fNOTES = "notes";
    public static final String fURL = "url";

    @DsField()
    private String targetUuid;

    @DsField()
    private String targetType;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "type.category")
    private String category;

    @DsField(join = "left", path = "type.baseUrl")
    private String baseUrl;

    @DsField()
    private String name;

    @DsField()
    private String location;

    @DsField()
    private String notes;

    @DsField(fetch = false)
    private String url;

    public AttachmentDs() {
        super();
    }

    public AttachmentDs(Attachment e) {
        super(e);
    }

    public String getTargetUuid() {
        return this.targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
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

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
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

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDateFormat.class, sort = { @SortField(field = SysDateFormatDs.fNAME) })
public class SysDateFormatDs extends AbstractDsModel<SysDateFormat> implements
        IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fDESCRIPTION = "description";
    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fEXTJSDATEFORMAT = "extjsDateFormat";
    public static final String fEXTJSTIMEFORMAT = "extjsTimeFormat";
    public static final String fEXTJSDATETIMEFORMAT = "extjsDateTimeFormat";
    public static final String fEXTJSALTFORMATS = "extjsAltFormats";
    public static final String fJAVADATEFORMAT = "javaDateFormat";
    public static final String fJAVATIMEFORMAT = "javaTimeFormat";
    public static final String fJAVADATETIMEFORMAT = "javaDateTimeFormat";

    @DsField()
    private String name;

    @DsField()
    private Boolean active;

    @DsField()
    private String description;

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

    @DsField()
    private String extjsDateFormat;

    @DsField()
    private String extjsTimeFormat;

    @DsField()
    private String extjsDateTimeFormat;

    @DsField()
    private String extjsAltFormats;

    @DsField()
    private String javaDateFormat;

    @DsField()
    private String javaTimeFormat;

    @DsField()
    private String javaDateTimeFormat;

    public SysDateFormatDs() {
        super();
    }

    public SysDateFormatDs(SysDateFormat e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getExtjsDateFormat() {
        return this.extjsDateFormat;
    }

    public void setExtjsDateFormat(String extjsDateFormat) {
        this.extjsDateFormat = extjsDateFormat;
    }

    public String getExtjsTimeFormat() {
        return this.extjsTimeFormat;
    }

    public void setExtjsTimeFormat(String extjsTimeFormat) {
        this.extjsTimeFormat = extjsTimeFormat;
    }

    public String getExtjsDateTimeFormat() {
        return this.extjsDateTimeFormat;
    }

    public void setExtjsDateTimeFormat(String extjsDateTimeFormat) {
        this.extjsDateTimeFormat = extjsDateTimeFormat;
    }

    public String getExtjsAltFormats() {
        return this.extjsAltFormats;
    }

    public void setExtjsAltFormats(String extjsAltFormats) {
        this.extjsAltFormats = extjsAltFormats;
    }

    public String getJavaDateFormat() {
        return this.javaDateFormat;
    }

    public void setJavaDateFormat(String javaDateFormat) {
        this.javaDateFormat = javaDateFormat;
    }

    public String getJavaTimeFormat() {
        return this.javaTimeFormat;
    }

    public void setJavaTimeFormat(String javaTimeFormat) {
        this.javaTimeFormat = javaTimeFormat;
    }

    public String getJavaDateTimeFormat() {
        return this.javaDateTimeFormat;
    }

    public void setJavaDateTimeFormat(String javaDateTimeFormat) {
        this.javaDateTimeFormat = javaDateTimeFormat;
    }

}

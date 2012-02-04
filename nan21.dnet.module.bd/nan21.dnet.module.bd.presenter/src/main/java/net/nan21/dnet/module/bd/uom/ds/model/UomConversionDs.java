/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = UomConversion.class)
public class UomConversionDs extends AbstractDsModel<UomConversion> implements
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
    public static final String fSOURCEID = "sourceId";
    public static final String fSOURCECODE = "sourceCode";
    public static final String fTARGETID = "targetId";
    public static final String fTARGETCODE = "targetCode";
    public static final String fMULTIPLYWITH = "multiplyWith";
    public static final String fDIVIDETO = "divideTo";
    public static final String fACTIVE = "active";

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

    @DsField(join = "left", path = "source.id")
    private Long sourceId;

    @DsField(join = "left", path = "source.code")
    private String sourceCode;

    @DsField(join = "left", path = "target.id")
    private Long targetId;

    @DsField(join = "left", path = "target.code")
    private String targetCode;

    @DsField()
    private Float multiplyWith;

    @DsField()
    private Float divideTo;

    @DsField()
    private Boolean active;

    public UomConversionDs() {
        super();
    }

    public UomConversionDs(UomConversion e) {
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

    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getTargetId() {
        return this.targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetCode() {
        return this.targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Float getMultiplyWith() {
        return this.multiplyWith;
    }

    public void setMultiplyWith(Float multiplyWith) {
        this.multiplyWith = multiplyWith;
    }

    public Float getDivideTo() {
        return this.divideTo;
    }

    public void setDivideTo(Float divideTo) {
        this.divideTo = divideTo;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}

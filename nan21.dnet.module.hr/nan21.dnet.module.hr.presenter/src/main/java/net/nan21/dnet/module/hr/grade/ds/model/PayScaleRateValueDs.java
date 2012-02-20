/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScaleRateValue.class)
public class PayScaleRateValueDs extends AbstractDsModel<PayScaleRateValue>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fSCALERATEID = "scaleRateId";
    public static final String fSCALEPOINTID = "scalePointId";
    public static final String fSCALEPOINTCODE = "scalePointCode";
    public static final String fVALUE = "value";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";

    @DsField(noUpdate = true)
    private Long id;

    @DsField(noUpdate = true)
    private String uuid;

    @DsField(noUpdate = true)
    private Long clientId;

    @DsField(noUpdate = true)
    private Date createdAt;

    @DsField(noUpdate = true)
    private Date modifiedAt;

    @DsField(noUpdate = true)
    private String createdBy;

    @DsField(noUpdate = true)
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(noUpdate = true, fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "scaleRate.id")
    private Long scaleRateId;

    @DsField(join = "left", path = "scalePoint.id")
    private Long scalePointId;

    @DsField(join = "left", path = "scalePoint.code")
    private String scalePointCode;

    @DsField()
    private Float value;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    public PayScaleRateValueDs() {
        super();
    }

    public PayScaleRateValueDs(PayScaleRateValue e) {
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

    public Long getScaleRateId() {
        return this.scaleRateId;
    }

    public void setScaleRateId(Long scaleRateId) {
        this.scaleRateId = scaleRateId;
    }

    public Long getScalePointId() {
        return this.scalePointId;
    }

    public void setScalePointId(Long scalePointId) {
        this.scalePointId = scalePointId;
    }

    public String getScalePointCode() {
        return this.scalePointCode;
    }

    public void setScalePointCode(String scalePointCode) {
        this.scalePointCode = scalePointCode;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

}

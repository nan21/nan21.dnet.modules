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

import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = GradeRateValue.class)
public class GradeRateValueDs extends AbstractDsModel<GradeRateValue> implements
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
    public static final String fGRADEID = "gradeId";
    public static final String fGRADENAME = "gradeName";
    public static final String fGRADERATEID = "gradeRateId";
    public static final String fGRADERATENAME = "gradeRateName";
    public static final String fFIXVALUE = "fixValue";
    public static final String fMINVALUE = "minValue";
    public static final String fMAXVALUE = "maxValue";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";

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

    @DsField(join = "left", path = "grade.id")
    private Long gradeId;

    @DsField(join = "left", path = "grade.name")
    private String gradeName;

    @DsField(join = "left", path = "gradeRate.id")
    private Long gradeRateId;

    @DsField(join = "left", path = "gradeRate.name")
    private String gradeRateName;

    @DsField()
    private Float fixValue;

    @DsField()
    private Float minValue;

    @DsField()
    private Float maxValue;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    public GradeRateValueDs() {
        super();
    }

    public GradeRateValueDs(GradeRateValue e) {
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

    public Long getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getGradeRateId() {
        return this.gradeRateId;
    }

    public void setGradeRateId(Long gradeRateId) {
        this.gradeRateId = gradeRateId;
    }

    public String getGradeRateName() {
        return this.gradeRateName;
    }

    public void setGradeRateName(String gradeRateName) {
        this.gradeRateName = gradeRateName;
    }

    public Float getFixValue() {
        return this.fixValue;
    }

    public void setFixValue(Float fixValue) {
        this.fixValue = fixValue;
    }

    public Float getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public Float getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
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

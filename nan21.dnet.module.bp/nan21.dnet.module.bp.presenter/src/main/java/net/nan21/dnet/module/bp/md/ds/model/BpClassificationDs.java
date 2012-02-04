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

import net.nan21.dnet.module.bp.md.domain.entity.BpClassification;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = BpClassification.class)
public class BpClassificationDs extends AbstractDsModel<BpClassification>
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
    public static final String fBUSINESSPARTNERID = "businessPartnerId";
    public static final String fBUSINESSPARTNER = "businessPartner";
    public static final String fBUSINESSPARTNERBO = "businessPartnerBO";
    public static final String fCLASSIFICATIONSYSTEMID = "classificationSystemId";
    public static final String fCLASSIFICATIONSYSTEM = "classificationSystem";
    public static final String fCLASSIFICATIONID = "classificationId";
    public static final String fCLASSIFICATIONCODE = "classificationCode";
    public static final String fCLASSIFICATIONNAME = "classificationName";

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

    @DsField(join = "left", path = "bp.id")
    private Long businessPartnerId;

    @DsField(join = "left", path = "bp.code")
    private String businessPartner;

    @DsField(join = "left", fetch = false, path = "bp.businessObject")
    private String businessPartnerBO;

    @DsField(join = "left", path = "classSystem.id")
    private Long classificationSystemId;

    @DsField(join = "left", path = "classSystem.code")
    private String classificationSystem;

    @DsField(join = "left", path = "classCode.id")
    private Long classificationId;

    @DsField(join = "left", path = "classCode.code")
    private String classificationCode;

    @DsField(join = "left", path = "classCode.name")
    private String classificationName;

    public BpClassificationDs() {
        super();
    }

    public BpClassificationDs(BpClassification e) {
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

    public Long getClassificationSystemId() {
        return this.classificationSystemId;
    }

    public void setClassificationSystemId(Long classificationSystemId) {
        this.classificationSystemId = classificationSystemId;
    }

    public String getClassificationSystem() {
        return this.classificationSystem;
    }

    public void setClassificationSystem(String classificationSystem) {
        this.classificationSystem = classificationSystem;
    }

    public Long getClassificationId() {
        return this.classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationCode() {
        return this.classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassificationName() {
        return this.classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

}

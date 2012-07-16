/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.bp.domain.entity.BpClassification;

@Ds(entity = BpClassification.class)
public class BpClassificationDs extends AbstractAuditableDs<BpClassification> {

    public static final String fBUSINESSPARTNERID = "businessPartnerId";
    public static final String fBUSINESSPARTNER = "businessPartner";
    public static final String fBUSINESSPARTNERBO = "businessPartnerBO";
    public static final String fCLASSIFICATIONSYSTEMID = "classificationSystemId";
    public static final String fCLASSIFICATIONSYSTEM = "classificationSystem";
    public static final String fCLASSIFICATIONID = "classificationId";
    public static final String fCLASSIFICATIONCODE = "classificationCode";
    public static final String fCLASSIFICATIONNAME = "classificationName";

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

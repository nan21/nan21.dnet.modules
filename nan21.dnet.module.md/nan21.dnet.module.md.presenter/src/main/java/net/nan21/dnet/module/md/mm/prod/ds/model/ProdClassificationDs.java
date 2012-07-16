/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;

@Ds(entity = ProdClassification.class)
public class ProdClassificationDs extends
        AbstractAuditableDs<ProdClassification> {

    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fCLASSIFICATIONSYSTEMID = "classificationSystemId";
    public static final String fCLASSIFICATIONSYSTEM = "classificationSystem";
    public static final String fCLASSIFICATIONID = "classificationId";
    public static final String fCLASSIFICATIONCODE = "classificationCode";
    public static final String fCLASSIFICATIONNAME = "classificationName";

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

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

    public ProdClassificationDs() {
        super();
    }

    public ProdClassificationDs(ProdClassification e) {
        super(e);
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

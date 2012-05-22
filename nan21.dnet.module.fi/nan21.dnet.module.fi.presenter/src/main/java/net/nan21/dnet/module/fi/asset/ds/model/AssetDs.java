/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Asset.class, sort = { @SortField(field = AssetDs.fNAME) })
public class AssetDs extends AbstractTypeWithCodeDs<Asset> {

    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fINITIALVALUE = "initialValue";
    public static final String fRESIDUALVALUE = "residualValue";
    public static final String fDEPRECIATIONAMOUNT = "depreciationAmount";

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "category.id")
    private Long categoryId;

    @DsField(join = "left", path = "category.code")
    private String category;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField()
    private Float initialValue;

    @DsField()
    private Float residualValue;

    @DsField()
    private Float depreciationAmount;

    public AssetDs() {
        super();
    }

    public AssetDs(Asset e) {
        super(e);
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getInitialValue() {
        return this.initialValue;
    }

    public void setInitialValue(Float initialValue) {
        this.initialValue = initialValue;
    }

    public Float getResidualValue() {
        return this.residualValue;
    }

    public void setResidualValue(Float residualValue) {
        this.residualValue = residualValue;
    }

    public Float getDepreciationAmount() {
        return this.depreciationAmount;
    }

    public void setDepreciationAmount(Float depreciationAmount) {
        this.depreciationAmount = depreciationAmount;
    }

}

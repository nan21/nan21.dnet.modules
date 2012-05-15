/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.ds.param;

import java.util.Date;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ProductPriceReportDsParam extends EmptyParam {

    public static final String fVALIDAT = "validAt";
    public static final String fPRODUCTCATEGORYID = "productCategoryId";
    public static final String fPRODUCTCATEGORY = "productCategory";

    private Date validAt;
    private Long productCategoryId;
    private String productCategory;

    public Date getValidAt() {
        return this.validAt;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

    public Long getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

}

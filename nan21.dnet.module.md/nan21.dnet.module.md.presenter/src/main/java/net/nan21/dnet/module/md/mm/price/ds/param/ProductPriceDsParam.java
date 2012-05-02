/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ProductPriceDsParam extends EmptyParam {

    public static final String fPRODUCTCATEGORYID = "productCategoryId";
    public static final String fPRODUCTCATEGORY = "productCategory";

    private Long productCategoryId;
    private String productCategory;

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

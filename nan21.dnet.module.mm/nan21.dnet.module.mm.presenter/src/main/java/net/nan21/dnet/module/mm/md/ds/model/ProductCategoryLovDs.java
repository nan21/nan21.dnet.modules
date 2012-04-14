/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductCategoryLovDs.fCODE) })
public class ProductCategoryLovDs extends
        AbstractTypeWithCodeLov<ProductCategory> {

    public ProductCategoryLovDs() {
        super();
    }

    public ProductCategoryLovDs(ProductCategory e) {
        super(e);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeCategory.class, sort = { @SortField(field = ProductAttributeCategoryDs.fNAME) })
public class ProductAttributeCategoryDs extends
        AbstractTypeDs<ProductAttributeCategory> {

    public ProductAttributeCategoryDs() {
        super();
    }

    public ProductAttributeCategoryDs(ProductAttributeCategory e) {
        super(e);
    }

}

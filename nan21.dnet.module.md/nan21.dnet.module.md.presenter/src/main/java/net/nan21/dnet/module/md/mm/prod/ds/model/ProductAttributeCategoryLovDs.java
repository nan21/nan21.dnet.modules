/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductAttributeCategoryLovDs.fNAME) })
public class ProductAttributeCategoryLovDs extends
        AbstractTypeLov<ProductAttributeCategory> {

    public ProductAttributeCategoryLovDs() {
        super();
    }

    public ProductAttributeCategoryLovDs(ProductAttributeCategory e) {
        super(e);
    }

}

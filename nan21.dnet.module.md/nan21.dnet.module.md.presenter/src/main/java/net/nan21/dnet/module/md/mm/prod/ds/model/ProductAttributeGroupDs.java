/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeGroup.class, sort = { @SortField(field = ProductAttributeGroupDs.fNAME) })
public class ProductAttributeGroupDs extends
        AbstractTypeDs<ProductAttributeGroup> {

    public ProductAttributeGroupDs() {
        super();
    }

    public ProductAttributeGroupDs(ProductAttributeGroup e) {
        super(e);
    }

}

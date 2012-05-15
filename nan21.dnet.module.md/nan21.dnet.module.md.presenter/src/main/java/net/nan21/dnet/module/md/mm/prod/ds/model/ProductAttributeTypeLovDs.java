/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductAttributeTypeLovDs.fNAME) })
public class ProductAttributeTypeLovDs extends
        AbstractTypeLov<ProductAttributeType> {

    public ProductAttributeTypeLovDs() {
        super();
    }

    public ProductAttributeTypeLovDs(ProductAttributeType e) {
        super(e);
    }

}

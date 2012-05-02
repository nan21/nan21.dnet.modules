/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductManufacturer.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductManufacturerLovDs.fCODE) })
public class ProductManufacturerLovDs extends
        AbstractTypeWithCodeLov<ProductManufacturer> {

    public ProductManufacturerLovDs() {
        super();
    }

    public ProductManufacturerLovDs(ProductManufacturer e) {
        super(e);
    }

}

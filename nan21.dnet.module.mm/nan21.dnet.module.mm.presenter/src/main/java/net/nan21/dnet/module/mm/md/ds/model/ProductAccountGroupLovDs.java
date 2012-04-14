/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAccountGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductAccountGroupLovDs.fCODE) })
public class ProductAccountGroupLovDs extends
        AbstractTypeWithCodeLov<ProductAccountGroup> {

    public ProductAccountGroupLovDs() {
        super();
    }

    public ProductAccountGroupLovDs(ProductAccountGroup e) {
        super(e);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TaxCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = TaxCategoryLovDs.fNAME) })
public class TaxCategoryLovDs extends AbstractTypeLov<TaxCategory> {

    public TaxCategoryLovDs() {
        super();
    }

    public TaxCategoryLovDs(TaxCategory e) {
        super(e);
    }

}

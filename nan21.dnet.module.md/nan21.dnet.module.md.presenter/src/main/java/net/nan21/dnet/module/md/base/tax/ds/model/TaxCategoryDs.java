/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TaxCategory.class, sort = { @SortField(field = TaxCategoryDs.fNAME) })
public class TaxCategoryDs extends AbstractTypeDs<TaxCategory> {

    public TaxCategoryDs() {
        super();
    }

    public TaxCategoryDs(TaxCategory e) {
        super(e);
    }

}

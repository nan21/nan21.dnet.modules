/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Currency.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CurrencyLovDs.fCODE) })
public class CurrencyLovDs extends AbstractTypeWithCodeLov<Currency> {

    public CurrencyLovDs() {
        super();
    }

    public CurrencyLovDs(Currency e) {
        super(e);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

@Ds(entity = CurrencyXRateProvider.class, sort = { @SortField(field = CurrencyXRateProviderDs.fNAME) })
public class CurrencyXRateProviderDs extends
        AbstractTypeWithCodeDs<CurrencyXRateProvider> {

    public CurrencyXRateProviderDs() {
        super();
    }

    public CurrencyXRateProviderDs(CurrencyXRateProvider e) {
        super(e);
    }

}

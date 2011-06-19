/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

public class CurrencyXRateProviderLovDsConv extends
        AbstractDsConverter<CurrencyXRateProviderLovDs, CurrencyXRateProvider>
        implements
        IDsConverter<CurrencyXRateProviderLovDs, CurrencyXRateProvider> {

    protected void modelToEntityAttributes(CurrencyXRateProviderLovDs ds,
            CurrencyXRateProvider e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CurrencyXRateProviderLovDs ds,
            CurrencyXRateProvider e) throws Exception {
    }

    @Override
    public void entityToModel(CurrencyXRateProvider e,
            CurrencyXRateProviderLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

public class CurrencyXRateProviderDsConv extends
        AbstractDsConverter<CurrencyXRateProviderDs, CurrencyXRateProvider>
        implements IDsConverter<CurrencyXRateProviderDs, CurrencyXRateProvider> {

    protected void modelToEntityAttributes(CurrencyXRateProviderDs ds,
            CurrencyXRateProvider e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(CurrencyXRateProviderDs ds,
            CurrencyXRateProvider e) throws Exception {
    }

    @Override
    public void entityToModel(CurrencyXRateProvider e,
            CurrencyXRateProviderDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}

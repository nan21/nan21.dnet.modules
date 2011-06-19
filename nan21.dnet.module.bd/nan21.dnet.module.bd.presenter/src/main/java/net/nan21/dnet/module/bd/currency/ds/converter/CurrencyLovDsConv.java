/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyLovDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

public class CurrencyLovDsConv extends
        AbstractDsConverter<CurrencyLovDs, Currency> implements
        IDsConverter<CurrencyLovDs, Currency> {

    protected void modelToEntityAttributes(CurrencyLovDs ds, Currency e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CurrencyLovDs ds, Currency e)
            throws Exception {
    }

    @Override
    public void entityToModel(Currency e, CurrencyLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

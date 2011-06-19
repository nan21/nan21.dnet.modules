/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

public class CurrencyDsConv extends AbstractDsConverter<CurrencyDs, Currency>
        implements IDsConverter<CurrencyDs, Currency> {

    protected void modelToEntityAttributes(CurrencyDs ds, Currency e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setIso3(ds.getIso3());
        e.setStandardPrecision(ds.getStandardPrecision());
        e.setSymbol(ds.getSymbol());
    }

    protected void modelToEntityReferences(CurrencyDs ds, Currency e)
            throws Exception {
    }

    @Override
    public void entityToModel(Currency e, CurrencyDs ds) throws Exception {
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
        ds.setIso3(e.getIso3());
        ds.setStandardPrecision(e.getStandardPrecision());
        ds.setSymbol(e.getSymbol());
    }

}

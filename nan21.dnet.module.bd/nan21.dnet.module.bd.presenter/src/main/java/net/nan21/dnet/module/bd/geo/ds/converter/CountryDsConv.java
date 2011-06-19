/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.CountryDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

public class CountryDsConv extends AbstractDsConverter<CountryDs, Country>
        implements IDsConverter<CountryDs, Country> {

    protected void modelToEntityAttributes(CountryDs ds, Country e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setIso2(ds.getIso2());
        e.setIso3(ds.getIso3());
        e.setHasRegions(ds.getHasRegions());
        e.setDefaultCurrency(ds.getCurrency());
        e.setDefaultLanguage(ds.getLanguage());
    }

    protected void modelToEntityReferences(CountryDs ds, Country e)
            throws Exception {
    }

    @Override
    public void entityToModel(Country e, CountryDs ds) throws Exception {
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
        ds.setIso2(e.getIso2());
        ds.setIso3(e.getIso3());
        ds.setHasRegions(e.getHasRegions());
        ds.setCurrency(e.getDefaultCurrency());
        ds.setLanguage(e.getDefaultLanguage());
    }

}

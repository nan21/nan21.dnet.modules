/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

public class CountryLovDsConv extends
        AbstractDsConverter<CountryLovDs, Country> implements
        IDsConverter<CountryLovDs, Country> {

    protected void modelToEntityAttributes(CountryLovDs ds, Country e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CountryLovDs ds, Country e)
            throws Exception {
    }

    @Override
    public void entityToModel(Country e, CountryLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

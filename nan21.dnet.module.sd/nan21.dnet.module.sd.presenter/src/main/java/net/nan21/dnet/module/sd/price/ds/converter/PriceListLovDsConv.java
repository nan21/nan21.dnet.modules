/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.price.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs;
import net.nan21.dnet.module.sd.price.domain.entity.PriceList;

public class PriceListLovDsConv extends
        AbstractDsConverter<PriceListLovDs, PriceList> implements
        IDsConverter<PriceListLovDs, PriceList> {

    protected void modelToEntityAttributes(PriceListLovDs ds, PriceList e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PriceListLovDs ds, PriceList e)
            throws Exception {
    }

    @Override
    public void entityToModel(PriceList e, PriceListLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

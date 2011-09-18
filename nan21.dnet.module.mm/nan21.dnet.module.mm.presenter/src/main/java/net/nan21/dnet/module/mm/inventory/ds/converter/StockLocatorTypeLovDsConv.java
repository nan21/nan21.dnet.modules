/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorTypeLovDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocatorType;

public class StockLocatorTypeLovDsConv extends
        AbstractDsConverter<StockLocatorTypeLovDs, StockLocatorType> implements
        IDsConverter<StockLocatorTypeLovDs, StockLocatorType> {

    protected void modelToEntityAttributes(StockLocatorTypeLovDs ds,
            StockLocatorType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(StockLocatorTypeLovDs ds,
            StockLocatorType e) throws Exception {
    }

    @Override
    public void entityToModel(StockLocatorType e, StockLocatorTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

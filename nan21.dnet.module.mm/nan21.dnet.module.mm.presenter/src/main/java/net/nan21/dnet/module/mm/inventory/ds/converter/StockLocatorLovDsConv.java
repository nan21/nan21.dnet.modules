/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;

public class StockLocatorLovDsConv extends
        AbstractDsConverter<StockLocatorLovDs, StockLocator> implements
        IDsConverter<StockLocatorLovDs, StockLocator> {

    protected void modelToEntityAttributes(StockLocatorLovDs ds, StockLocator e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(StockLocatorLovDs ds, StockLocator e)
            throws Exception {
    }

    @Override
    public void entityToModel(StockLocator e, StockLocatorLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSubInventoryId(((e.getSubInventory() != null)) ? e
                .getSubInventory().getId() : null);
    }

}

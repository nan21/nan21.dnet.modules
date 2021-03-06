/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.org.business.service.ISubInventoryService;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.StockLocatorDs;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;

public class StockLocatorDsConv extends
        AbstractDsConverter<StockLocatorDs, StockLocator> implements
        IDsConverter<StockLocatorDs, StockLocator> {

    @Override
    protected void modelToEntityReferences(StockLocatorDs ds, StockLocator e,
            boolean isInsert) throws Exception {

        if (ds.getSubInventoryId() != null) {
            if (e.getSubInventory() == null
                    || !e.getSubInventory().getId()
                            .equals(ds.getSubInventoryId())) {
                e.setSubInventory((SubInventory) this.em.find(
                        SubInventory.class, ds.getSubInventoryId()));
            }
        } else {
            this.lookup_subInventory_SubInventory(ds, e);
        }

    }

    protected void lookup_subInventory_SubInventory(StockLocatorDs ds,
            StockLocator e) throws Exception {
        if (ds.getSubInventory() != null && !ds.getSubInventory().equals("")) {
            SubInventory x = null;
            try {
                x = ((ISubInventoryService) findEntityService(SubInventory.class))
                        .findByName(ds.getSubInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SubInventory` reference:  `subInventory` = "
                                + ds.getSubInventory() + "  ");
            }
            e.setSubInventory(x);

        } else {
            e.setSubInventory(null);
        }
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.inventory.business.service.ISubInventoryService;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;

public class StockLocatorDsConv extends
        AbstractDsConverter<StockLocatorDs, StockLocator> implements
        IDsConverter<StockLocatorDs, StockLocator> {

    protected void modelToEntityAttributes(StockLocatorDs ds, StockLocator e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(StockLocatorDs ds, StockLocator e)
            throws Exception {

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
                x = ((ISubInventoryService) getService(ISubInventoryService.class))
                        .findByName(ds.getClientId(), ds.getSubInventory());
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

    @Override
    public void entityToModel(StockLocator e, StockLocatorDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSubInventoryId(((e.getSubInventory() != null)) ? e
                .getSubInventory().getId() : null);
        ds.setSubInventory(((e.getSubInventory() != null)) ? e
                .getSubInventory().getName() : null);
        ds.setLocatorTypeId(((e.getLocatorType() != null)) ? e.getLocatorType()
                .getId() : null);
        ds.setLocatorType(((e.getLocatorType() != null)) ? e.getLocatorType()
                .getName() : null);
    }

}

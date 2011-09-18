/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryLovDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;

public class SubInventoryLovDsConv extends
        AbstractDsConverter<SubInventoryLovDs, SubInventory> implements
        IDsConverter<SubInventoryLovDs, SubInventory> {

    protected void modelToEntityAttributes(SubInventoryLovDs ds, SubInventory e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SubInventoryLovDs ds, SubInventory e)
            throws Exception {
    }

    @Override
    public void entityToModel(SubInventory e, SubInventoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setInventoryId(((e.getInventory() != null)) ? e.getInventory()
                .getId() : null);
    }

}

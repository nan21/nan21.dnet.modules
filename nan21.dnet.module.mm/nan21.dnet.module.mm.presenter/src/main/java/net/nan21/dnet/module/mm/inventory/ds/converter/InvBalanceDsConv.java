/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvBalanceDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvBalance;

public class InvBalanceDsConv extends
        AbstractDsConverter<InvBalanceDs, InvBalance> implements
        IDsConverter<InvBalanceDs, InvBalance> {

    protected void modelToEntityAttributes(InvBalanceDs ds, InvBalance e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setQuantity(ds.getQuantity());
    }

    protected void modelToEntityReferences(InvBalanceDs ds, InvBalance e)
            throws Exception {
    }

    @Override
    public void entityToModel(InvBalance e, InvBalanceDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setQuantity(e.getQuantity());
        ds.setSubInventoryId(((e.getSubInventory() != null)) ? e
                .getSubInventory().getId() : null);
        ds.setSubInventory(((e.getSubInventory() != null)) ? e
                .getSubInventory().getName() : null);
        ds.setLocatorId(((e.getLocator() != null)) ? e.getLocator().getId()
                : null);
        ds.setLocator(((e.getLocator() != null)) ? e.getLocator().getName()
                : null);
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItem(((e.getItem() != null)) ? e.getItem().getCode() : null);
        ds.setItemName(((e.getItem() != null)) ? e.getItem().getName() : null);
        ds.setUomId(((e.getUom() != null)) ? e.getUom().getId() : null);
        ds.setUom(((e.getUom() != null)) ? e.getUom().getCode() : null);
    }

}

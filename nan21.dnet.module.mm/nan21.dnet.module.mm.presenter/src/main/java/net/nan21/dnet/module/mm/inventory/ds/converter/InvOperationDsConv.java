/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvOperationDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvOperation;

public class InvOperationDsConv extends
        AbstractDsConverter<InvOperationDs, InvOperation> implements
        IDsConverter<InvOperationDs, InvOperation> {

    protected void modelToEntityAttributes(InvOperationDs ds, InvOperation e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDirection(ds.getDirection());
        e.setQuantity(ds.getQuantity());
    }

    protected void modelToEntityReferences(InvOperationDs ds, InvOperation e)
            throws Exception {
    }

    @Override
    public void entityToModel(InvOperation e, InvOperationDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDirection(e.getDirection());
        ds.setQuantity(e.getQuantity());
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItemCode(((e.getItem() != null)) ? e.getItem().getCode() : null);
        ds.setItem(((e.getItem() != null)) ? e.getItem().getName() : null);
        ds.setInventoryId(((e.getInventory() != null)) ? e.getInventory()
                .getId() : null);
        ds.setInventory(((e.getInventory() != null)) ? e.getInventory()
                .getCode() : null);
        ds.setInventoryName(((e.getInventory() != null)) ? e.getInventory()
                .getName() : null);
        ds.setSubInventoryId(((e.getSubInventory() != null)) ? e
                .getSubInventory().getId() : null);
        ds.setSubInventory(((e.getSubInventory() != null)) ? e
                .getSubInventory().getName() : null);
        ds.setLocatorId(((e.getLocator() != null)) ? e.getLocator().getId()
                : null);
        ds.setLocator(((e.getLocator() != null)) ? e.getLocator().getName()
                : null);
        ds.setTransactionId(((e.getTransactionLine() != null) && (e
                .getTransactionLine().getInvTransaction() != null)) ? e
                .getTransactionLine().getInvTransaction().getId() : null);
        ds.setTransactionLineId(((e.getTransactionLine() != null)) ? e
                .getTransactionLine().getId() : null);
    }

}

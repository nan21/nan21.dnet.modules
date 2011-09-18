/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.inventory.business.service.IStockLocatorService;
import net.nan21.dnet.module.mm.inventory.business.service.ISubInventoryService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;

public class InvTransactionLineDsConv extends
        AbstractDsConverter<InvTransactionLineDs, InvTransactionLine> implements
        IDsConverter<InvTransactionLineDs, InvTransactionLine> {

    protected void modelToEntityAttributes(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setQuantity(ds.getQuantity());
    }

    protected void modelToEntityReferences(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {

        if (ds.getTransactionId() != null) {
            if (e.getInvTransaction() == null
                    || !e.getInvTransaction().getId()
                            .equals(ds.getTransactionId())) {
                e.setInvTransaction((InvTransaction) this.em.find(
                        InvTransaction.class, ds.getTransactionId()));
            }
        }
        if (ds.getItemId() != null) {
            if (e.getItem() == null
                    || !e.getItem().getId().equals(ds.getItemId())) {
                e.setItem((Product) this.em.find(Product.class, ds.getItemId()));
            }
        } else {
            this.lookup_item_Product(ds, e);
        }
        if (ds.getFromSubInventoryId() != null) {
            if (e.getFromSubInventory() == null
                    || !e.getFromSubInventory().getId()
                            .equals(ds.getFromSubInventoryId())) {
                e.setFromSubInventory((SubInventory) this.em.find(
                        SubInventory.class, ds.getFromSubInventoryId()));
            }
        } else {
            this.lookup_fromSubInventory_SubInventory(ds, e);
        }
        if (ds.getToSubInventoryId() != null) {
            if (e.getToSubInventory() == null
                    || !e.getToSubInventory().getId()
                            .equals(ds.getToSubInventoryId())) {
                e.setToSubInventory((SubInventory) this.em.find(
                        SubInventory.class, ds.getToSubInventoryId()));
            }
        } else {
            this.lookup_toSubInventory_SubInventory(ds, e);
        }
        if (ds.getFromLocatorId() != null) {
            if (e.getFromLocator() == null
                    || !e.getFromLocator().getId()
                            .equals(ds.getFromLocatorId())) {
                e.setFromLocator((StockLocator) this.em.find(
                        StockLocator.class, ds.getFromLocatorId()));
            }
        } else {
            this.lookup_fromLocator_StockLocator(ds, e);
        }
        if (ds.getToLocatorId() != null) {
            if (e.getToLocator() == null
                    || !e.getToLocator().getId().equals(ds.getToLocatorId())) {
                e.setToLocator((StockLocator) this.em.find(StockLocator.class,
                        ds.getToLocatorId()));
            }
        } else {
            this.lookup_toLocator_StockLocator(ds, e);
        }
    }

    protected void lookup_item_Product(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {
        if (ds.getItemCode() != null && !ds.getItemCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) getService(IProductService.class))
                        .findByCode(ds.getClientId(), ds.getItemCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `itemCode` = "
                                + ds.getItemCode() + "  ");
            }
            e.setItem(x);
        } else {
            e.setItem(null);
        }
    }

    protected void lookup_fromSubInventory_SubInventory(
            InvTransactionLineDs ds, InvTransactionLine e) throws Exception {
        if (ds.getFromSubInventory() != null
                && !ds.getFromSubInventory().equals("")) {
            SubInventory x = null;
            try {
                x = ((ISubInventoryService) getService(ISubInventoryService.class))
                        .findByName(ds.getClientId(), ds.getFromSubInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SubInventory` reference:  `fromSubInventory` = "
                                + ds.getFromSubInventory() + "  ");
            }
            e.setFromSubInventory(x);
        } else {
            e.setFromSubInventory(null);
        }
    }

    protected void lookup_toSubInventory_SubInventory(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {
        if (ds.getToSubInventory() != null
                && !ds.getToSubInventory().equals("")) {
            SubInventory x = null;
            try {
                x = ((ISubInventoryService) getService(ISubInventoryService.class))
                        .findByName(ds.getClientId(), ds.getToSubInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SubInventory` reference:  `toSubInventory` = "
                                + ds.getToSubInventory() + "  ");
            }
            e.setToSubInventory(x);
        } else {
            e.setToSubInventory(null);
        }
    }

    protected void lookup_fromLocator_StockLocator(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {
        if (ds.getFromLocator() != null && !ds.getFromLocator().equals("")) {
            StockLocator x = null;
            try {
                x = ((IStockLocatorService) getService(IStockLocatorService.class))
                        .findByName(ds.getClientId(), ds.getFromLocator());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `StockLocator` reference:  `fromLocator` = "
                                + ds.getFromLocator() + "  ");
            }
            e.setFromLocator(x);
        } else {
            e.setFromLocator(null);
        }
    }

    protected void lookup_toLocator_StockLocator(InvTransactionLineDs ds,
            InvTransactionLine e) throws Exception {
        if (ds.getToLocator() != null && !ds.getToLocator().equals("")) {
            StockLocator x = null;
            try {
                x = ((IStockLocatorService) getService(IStockLocatorService.class))
                        .findByName(ds.getClientId(), ds.getToLocator());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `StockLocator` reference:  `toLocator` = "
                                + ds.getToLocator() + "  ");
            }
            e.setToLocator(x);
        } else {
            e.setToLocator(null);
        }
    }

    @Override
    public void entityToModel(InvTransactionLine e, InvTransactionLineDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setQuantity(e.getQuantity());
        ds.setTransactionId(((e.getInvTransaction() != null)) ? e
                .getInvTransaction().getId() : null);
        ds.setFromInventoryId(((e.getInvTransaction() != null) && (e
                .getInvTransaction().getFromInventory() != null)) ? e
                .getInvTransaction().getFromInventory().getId() : null);
        ds.setToInventoryId(((e.getInvTransaction() != null) && (e
                .getInvTransaction().getToInventory() != null)) ? e
                .getInvTransaction().getToInventory().getId() : null);
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItemCode(((e.getItem() != null)) ? e.getItem().getCode() : null);
        ds.setItem(((e.getItem() != null)) ? e.getItem().getName() : null);
        ds.setFromSubInventoryId(((e.getFromSubInventory() != null)) ? e
                .getFromSubInventory().getId() : null);
        ds.setFromSubInventory(((e.getFromSubInventory() != null)) ? e
                .getFromSubInventory().getName() : null);
        ds.setFromLocatorId(((e.getFromLocator() != null)) ? e.getFromLocator()
                .getId() : null);
        ds.setFromLocator(((e.getFromLocator() != null)) ? e.getFromLocator()
                .getName() : null);
        ds.setToSubInventoryId(((e.getToSubInventory() != null)) ? e
                .getToSubInventory().getId() : null);
        ds.setToSubInventory(((e.getToSubInventory() != null)) ? e
                .getToSubInventory().getName() : null);
        ds.setToLocatorId(((e.getToLocator() != null)) ? e.getToLocator()
                .getId() : null);
        ds.setToLocator(((e.getToLocator() != null)) ? e.getToLocator()
                .getName() : null);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.business.service.IStockLocatorService;
import net.nan21.dnet.module.md.org.business.service.ISubInventoryService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDs;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

public class InvTransactionLineDsConv extends
        AbstractDsConverter<InvTransactionLineDs, InvTransactionLine> implements
        IDsConverter<InvTransactionLineDs, InvTransactionLine> {

    @Override
    protected void modelToEntityReferences(InvTransactionLineDs ds,
            InvTransactionLine e, boolean isInsert) throws Exception {

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

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
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
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getItemCode());
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

    protected void lookup_uom_Uom(InvTransactionLineDs ds, InvTransactionLine e)
            throws Exception {
        if (ds.getUom() != null && !ds.getUom().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getUom());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uom` = "
                                + ds.getUom() + "  ");
            }
            e.setUom(x);

        } else {
            e.setUom(null);
        }
    }

    protected void lookup_fromSubInventory_SubInventory(
            InvTransactionLineDs ds, InvTransactionLine e) throws Exception {
        if (ds.getFromSubInventory() != null
                && !ds.getFromSubInventory().equals("")) {
            SubInventory x = null;
            try {
                x = ((ISubInventoryService) findEntityService(SubInventory.class))
                        .findByName(ds.getFromSubInventory());
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
                x = ((ISubInventoryService) findEntityService(SubInventory.class))
                        .findByName(ds.getToSubInventory());
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
                x = ((IStockLocatorService) findEntityService(StockLocator.class))
                        .findByName(ds.getFromLocator());
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
                x = ((IStockLocatorService) findEntityService(StockLocator.class))
                        .findByName(ds.getToLocator());
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

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public class PurchaseInvoiceItemDsConv extends
        AbstractDsConverter<PurchaseInvoiceItemDs, PurchaseInvoiceItem>
        implements IDsConverter<PurchaseInvoiceItemDs, PurchaseInvoiceItem> {

    @Override
    protected void modelToEntityReferences(PurchaseInvoiceItemDs ds,
            PurchaseInvoiceItem e, boolean isInsert) throws Exception {

        if (ds.getInvoiceId() != null) {
            if (e.getInvoice() == null
                    || !e.getInvoice().getId().equals(ds.getInvoiceId())) {
                e.setInvoice((PurchaseInvoice) this.em.find(
                        PurchaseInvoice.class, ds.getInvoiceId()));
            }
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

        if (ds.getItemId() != null) {
            if (e.getItem() == null
                    || !e.getItem().getId().equals(ds.getItemId())) {
                e.setItem((Product) this.em.find(Product.class, ds.getItemId()));
            }
        } else {
            this.lookup_item_Product(ds, e);
        }

    }

    protected void lookup_uom_Uom(PurchaseInvoiceItemDs ds,
            PurchaseInvoiceItem e) throws Exception {
        if (ds.getUomCode() != null && !ds.getUomCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uomCode` = "
                                + ds.getUomCode() + "  ");
            }
            e.setUom(x);

        } else {
            e.setUom(null);
        }
    }

    protected void lookup_item_Product(PurchaseInvoiceItemDs ds,
            PurchaseInvoiceItem e) throws Exception {
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

}

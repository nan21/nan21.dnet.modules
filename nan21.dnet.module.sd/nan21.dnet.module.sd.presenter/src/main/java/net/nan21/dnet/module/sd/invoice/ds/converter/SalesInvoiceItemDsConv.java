/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceItemDsConv extends
        AbstractDsConverter<SalesInvoiceItemDs, SalesInvoiceItem> implements
        IDsConverter<SalesInvoiceItemDs, SalesInvoiceItem> {

    protected void modelToEntityAttributes(SalesInvoiceItemDs ds,
            SalesInvoiceItem e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setQuantity(ds.getQuantity());
        e.setUnitPrice(ds.getUnitPrice());
        e.setNetAmount(ds.getNetAmount());
    }

    protected void modelToEntityReferences(SalesInvoiceItemDs ds,
            SalesInvoiceItem e) throws Exception {

        if (ds.getInvoiceId() != null) {
            if (e.getInvoice() == null
                    || !e.getInvoice().getId().equals(ds.getInvoiceId())) {
                e.setInvoice((SalesInvoice) this.em.getReference(
                        SalesInvoice.class, ds.getInvoiceId()));
            }
        }
        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.getReference(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }
        if (ds.getItemId() != null) {
            if (e.getItem() == null
                    || !e.getItem().getId().equals(ds.getItemId())) {
                e.setItem((Product) this.em.getReference(Product.class,
                        ds.getItemId()));
            }
        } else {
            this.lookup_item_Product(ds, e);
        }
    }

    protected void lookup_uom_Uom(SalesInvoiceItemDs ds, SalesInvoiceItem e)
            throws Exception {
        if (ds.getUomCode() != null) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uomCode` = "
                                + ds.getUomCode() + "  ");
            }
            e.setUom(x);
        }
    }

    protected void lookup_item_Product(SalesInvoiceItemDs ds, SalesInvoiceItem e)
            throws Exception {
        if (ds.getItemCode() != null) {
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
        }
    }

    @Override
    public void entityToModel(SalesInvoiceItem e, SalesInvoiceItemDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setQuantity(e.getQuantity());
        ds.setUnitPrice(e.getUnitPrice());
        ds.setNetAmount(e.getNetAmount());
        ds.setInvoiceId(((e.getInvoice() != null)) ? e.getInvoice().getId()
                : null);
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItemCode(((e.getItem() != null)) ? e.getItem().getCode() : null);
        ds.setItemName(((e.getItem() != null)) ? e.getItem().getName() : null);
        ds.setUomId(((e.getUom() != null)) ? e.getUom().getId() : null);
        ds.setUomCode(((e.getUom() != null)) ? e.getUom().getCode() : null);
    }

}

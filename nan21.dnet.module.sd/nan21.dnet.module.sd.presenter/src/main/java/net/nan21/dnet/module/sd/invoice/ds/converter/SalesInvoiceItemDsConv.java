/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceItemDsConv extends
        AbstractDsConverter<SalesInvoiceItemDs, SalesInvoiceItem> implements
        IDsConverter<SalesInvoiceItemDs, SalesInvoiceItem> {

    @Override
    protected void modelToEntityReferences(SalesInvoiceItemDs ds,
            SalesInvoiceItem e, boolean isInsert) throws Exception {

        if (isInsert) {
            if (ds.getSalesInvoiceId() != null) {
                if (e.getSalesInvoice() == null
                        || !e.getSalesInvoice().getId()
                                .equals(ds.getSalesInvoiceId())) {
                    e.setSalesInvoice((SalesInvoice) this.em.find(
                            SalesInvoice.class, ds.getSalesInvoiceId()));
                }
            }
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }

        if (ds.getTaxId() != null) {
            if (e.getTax() == null || !e.getTax().getId().equals(ds.getTaxId())) {
                e.setTax((Tax) this.em.find(Tax.class, ds.getTaxId()));
            }
        } else {
            this.lookup_tax_Tax(ds, e);
        }

    }

    protected void lookup_uom_Uom(SalesInvoiceItemDs ds, SalesInvoiceItem e)
            throws Exception {
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

    protected void lookup_product_Product(SalesInvoiceItemDs ds,
            SalesInvoiceItem e) throws Exception {
        if (ds.getProductCode() != null && !ds.getProductCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getProductCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `productCode` = "
                                + ds.getProductCode() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

    protected void lookup_tax_Tax(SalesInvoiceItemDs ds, SalesInvoiceItem e)
            throws Exception {
        if (ds.getTax() != null && !ds.getTax().equals("")) {
            Tax x = null;
            try {
                x = ((ITaxService) findEntityService(Tax.class)).findByName(ds
                        .getTax());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Tax` reference:  `tax` = "
                                + ds.getTax() + "  ");
            }
            e.setTax(x);

        } else {
            e.setTax(null);
        }
    }

}

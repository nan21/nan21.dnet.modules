/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemProductDs;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public class PaymentItemProductDsConv extends
        AbstractDsConverter<PaymentItemProductDs, PaymentItem> implements
        IDsConverter<PaymentItemProductDs, PaymentItem> {

    @Override
    protected void modelToEntityReferences(PaymentItemProductDs ds,
            PaymentItem e, boolean isInsert) throws Exception {

        if (ds.getPaymentId() != null) {
            if (e.getPayment() == null
                    || !e.getPayment().getId().equals(ds.getPaymentId())) {
                e.setPayment((Payment) this.em.find(Payment.class,
                        ds.getPaymentId()));
            }
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

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

    }

    protected void lookup_product_Product(PaymentItemProductDs ds, PaymentItem e)
            throws Exception {
        if (ds.getProduct() != null && !ds.getProduct().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getProduct());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `product` = "
                                + ds.getProduct() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

    protected void lookup_uom_Uom(PaymentItemProductDs ds, PaymentItem e)
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

}

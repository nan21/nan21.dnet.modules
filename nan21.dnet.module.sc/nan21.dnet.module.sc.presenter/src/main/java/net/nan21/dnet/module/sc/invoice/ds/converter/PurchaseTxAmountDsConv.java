/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

public class PurchaseTxAmountDsConv extends
        AbstractDsConverter<PurchaseTxAmountDs, PurchaseTxAmount> implements
        IDsConverter<PurchaseTxAmountDs, PurchaseTxAmount> {

    @Override
    protected void modelToEntityReferences(PurchaseTxAmountDs ds,
            PurchaseTxAmount e, boolean isInsert) throws Exception {

        if (isInsert) {
            if (ds.getOrderId() != null) {
                if (e.getOrder() == null
                        || !e.getOrder().getId().equals(ds.getOrderId())) {
                    e.setOrder((PurchaseOrder) this.em.find(
                            PurchaseOrder.class, ds.getOrderId()));
                }
            }
        }

        if (isInsert) {
            if (ds.getInvoiceId() != null) {
                if (e.getInvoice() == null
                        || !e.getInvoice().getId().equals(ds.getInvoiceId())) {
                    e.setInvoice((PurchaseInvoice) this.em.find(
                            PurchaseInvoice.class, ds.getInvoiceId()));
                }
            }
        }

        if (ds.getPaymentMethodId() != null) {
            if (e.getPaymentMethod() == null
                    || !e.getPaymentMethod().getId()
                            .equals(ds.getPaymentMethodId())) {
                e.setPaymentMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getPaymentMethodId()));
            }
        } else {
            this.lookup_paymentMethod_PaymentMethod(ds, e);
        }

    }

    protected void lookup_paymentMethod_PaymentMethod(PurchaseTxAmountDs ds,
            PurchaseTxAmount e) throws Exception {
        if (ds.getPaymentMethod() != null && !ds.getPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
                        .findByName(ds.getPaymentMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `paymentMethod` = "
                                + ds.getPaymentMethod() + "  ");
            }
            e.setPaymentMethod(x);

        } else {
            e.setPaymentMethod(null);
        }
    }

}

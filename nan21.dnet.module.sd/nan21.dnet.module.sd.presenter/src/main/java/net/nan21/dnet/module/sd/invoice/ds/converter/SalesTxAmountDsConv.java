/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

public class SalesTxAmountDsConv extends
        AbstractDsConverter<SalesTxAmountDs, SalesTxAmount> implements
        IDsConverter<SalesTxAmountDs, SalesTxAmount> {

    @Override
    protected void modelToEntityReferences(SalesTxAmountDs ds, SalesTxAmount e,
            boolean isInsert) throws Exception {

        if (isInsert) {
            if (ds.getOrderId() != null) {
                if (e.getOrder() == null
                        || !e.getOrder().getId().equals(ds.getOrderId())) {
                    e.setOrder((SalesOrder) this.em.find(SalesOrder.class,
                            ds.getOrderId()));
                }
            }
        }

        if (isInsert) {
            if (ds.getInvoiceId() != null) {
                if (e.getInvoice() == null
                        || !e.getInvoice().getId().equals(ds.getInvoiceId())) {
                    e.setInvoice((SalesInvoice) this.em.find(
                            SalesInvoice.class, ds.getInvoiceId()));
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

    protected void lookup_paymentMethod_PaymentMethod(SalesTxAmountDs ds,
            SalesTxAmount e) throws Exception {
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

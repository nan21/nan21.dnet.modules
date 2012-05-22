/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.PaymentInAmountDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;

public class PaymentInAmountDsConv extends
        AbstractDsConverter<PaymentInAmountDs, PaymentInAmount> implements
        IDsConverter<PaymentInAmountDs, PaymentInAmount> {

    @Override
    protected void modelToEntityReferences(PaymentInAmountDs ds,
            PaymentInAmount e, boolean isInsert) throws Exception {

        if (ds.getPaymentId() != null) {
            if (e.getPayment() == null
                    || !e.getPayment().getId().equals(ds.getPaymentId())) {
                e.setPayment((Payment) this.em.find(Payment.class,
                        ds.getPaymentId()));
            }
        }

    }

}

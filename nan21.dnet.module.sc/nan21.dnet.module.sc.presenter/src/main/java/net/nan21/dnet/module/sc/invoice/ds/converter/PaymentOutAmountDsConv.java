/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;

public class PaymentOutAmountDsConv extends
        AbstractDsConverter<PaymentOutAmountDs, PaymentOutAmount> implements
        IDsConverter<PaymentOutAmountDs, PaymentOutAmount> {

    @Override
    protected void modelToEntityReferences(PaymentOutAmountDs ds,
            PaymentOutAmount e, boolean isInsert) throws Exception {

        if (ds.getPaymentId() != null) {
            if (e.getPayment() == null
                    || !e.getPayment().getId().equals(ds.getPaymentId())) {
                e.setPayment((Payment) this.em.find(Payment.class,
                        ds.getPaymentId()));
            }
        }

    }

}

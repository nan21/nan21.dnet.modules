/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.acc.business.service.IAccItemService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemAccItemDs;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public class PaymentItemAccItemDsConv extends
        AbstractDsConverter<PaymentItemAccItemDs, PaymentItem> implements
        IDsConverter<PaymentItemAccItemDs, PaymentItem> {

    @Override
    protected void modelToEntityReferences(PaymentItemAccItemDs ds,
            PaymentItem e, boolean isInsert) throws Exception {

        if (ds.getPaymentId() != null) {
            if (e.getPayment() == null
                    || !e.getPayment().getId().equals(ds.getPaymentId())) {
                e.setPayment((Payment) this.em.find(Payment.class,
                        ds.getPaymentId()));
            }
        }

        if (ds.getAccItemId() != null) {
            if (e.getAccItem() == null
                    || !e.getAccItem().getId().equals(ds.getAccItemId())) {
                e.setAccItem((AccItem) this.em.find(AccItem.class,
                        ds.getAccItemId()));
            }
        } else {
            this.lookup_accItem_AccItem(ds, e);
        }

    }

    protected void lookup_accItem_AccItem(PaymentItemAccItemDs ds, PaymentItem e)
            throws Exception {
        if (ds.getAccItem() != null && !ds.getAccItem().equals("")) {
            AccItem x = null;
            try {
                x = ((IAccItemService) findEntityService(AccItem.class))
                        .findByName(ds.getAccItem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccItem` reference:  `accItem` = "
                                + ds.getAccItem() + "  ");
            }
            e.setAccItem(x);

        } else {
            e.setAccItem(null);
        }
    }

}

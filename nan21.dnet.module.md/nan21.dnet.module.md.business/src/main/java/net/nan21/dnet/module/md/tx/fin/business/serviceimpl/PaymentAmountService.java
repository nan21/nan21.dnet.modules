/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;

public class PaymentAmountService extends AbstractEntityService<PaymentAmount> {

    public PaymentAmountService() {
        super();
    }

    public PaymentAmountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentAmount> getEntityClass() {
        return PaymentAmount.class;
    }

    public List<PaymentAmount> findByPayment(Payment payment) {
        return this.findByPaymentId(payment.getId());
    }

    public List<PaymentAmount> findByPaymentId(Long paymentId) {
        return (List<PaymentAmount>) this.em
                .createQuery(
                        "select e from PaymentAmount e where e.clientId = :pClientId and e.payment.id = :pPaymentId",
                        PaymentAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentId", paymentId).getResultList();
    }

}

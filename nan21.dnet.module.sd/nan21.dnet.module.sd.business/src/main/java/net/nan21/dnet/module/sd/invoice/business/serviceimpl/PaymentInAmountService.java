/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;

public class PaymentInAmountService extends
        AbstractEntityService<PaymentInAmount> implements
        IPaymentInAmountService {

    public PaymentInAmountService() {
        super();
    }

    public PaymentInAmountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentInAmount> getEntityClass() {
        return PaymentInAmount.class;
    }

    public List<PaymentInAmount> findByTxAmount(SalesTxAmount txAmount) {
        return this.findByTxAmountId(txAmount.getId());
    }

    public List<PaymentInAmount> findByTxAmountId(Long txAmountId) {
        return (List<PaymentInAmount>) this.em
                .createQuery(
                        "select e from PaymentInAmount e where e.clientId = :pClientId and e.txAmount.id = :pTxAmountId",
                        PaymentInAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTxAmountId", txAmountId).getResultList();
    }

}

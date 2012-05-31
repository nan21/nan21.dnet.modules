/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public class PaymentItemService extends AbstractEntityService<PaymentItem> {

    public PaymentItemService() {
        super();
    }

    public PaymentItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentItem> getEntityClass() {
        return PaymentItem.class;
    }

    public List<PaymentItem> findByPayment(Payment payment) {
        return this.findByPaymentId(payment.getId());
    }

    public List<PaymentItem> findByPaymentId(Long paymentId) {
        return (List<PaymentItem>) this.em
                .createQuery(
                        "select e from PaymentItem e where e.clientId = :pClientId and e.payment.id = :pPaymentId",
                        PaymentItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentId", paymentId).getResultList();
    }

    public List<PaymentItem> findByAccItem(AccItem accItem) {
        return this.findByAccItemId(accItem.getId());
    }

    public List<PaymentItem> findByAccItemId(Long accItemId) {
        return (List<PaymentItem>) this.em
                .createQuery(
                        "select e from PaymentItem e where e.clientId = :pClientId and e.accItem.id = :pAccItemId",
                        PaymentItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccItemId", accItemId).getResultList();
    }

    public List<PaymentItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<PaymentItem> findByProductId(Long productId) {
        return (List<PaymentItem>) this.em
                .createQuery(
                        "select e from PaymentItem e where e.clientId = :pClientId and e.product.id = :pProductId",
                        PaymentItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<PaymentItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<PaymentItem> findByUomId(Long uomId) {
        return (List<PaymentItem>) this.em
                .createQuery(
                        "select e from PaymentItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        PaymentItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseTxAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

public class PurchaseTxAmountService extends
        AbstractEntityService<PurchaseTxAmount> implements
        IPurchaseTxAmountService {

    public PurchaseTxAmountService() {
        super();
    }

    public PurchaseTxAmountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseTxAmount> getEntityClass() {
        return PurchaseTxAmount.class;
    }

    public List<PurchaseTxAmount> findByOrder(PurchaseOrder order) {
        return this.findByOrderId(order.getId());
    }

    public List<PurchaseTxAmount> findByOrderId(Long orderId) {
        return (List<PurchaseTxAmount>) this.em
                .createQuery(
                        "select e from PurchaseTxAmount e where e.clientId = :pClientId and e.order.id = :pOrderId",
                        PurchaseTxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrderId", orderId).getResultList();
    }

    public List<PurchaseTxAmount> findByInvoice(PurchaseInvoice invoice) {
        return this.findByInvoiceId(invoice.getId());
    }

    public List<PurchaseTxAmount> findByInvoiceId(Long invoiceId) {
        return (List<PurchaseTxAmount>) this.em
                .createQuery(
                        "select e from PurchaseTxAmount e where e.clientId = :pClientId and e.invoice.id = :pInvoiceId",
                        PurchaseTxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInvoiceId", invoiceId).getResultList();
    }

}

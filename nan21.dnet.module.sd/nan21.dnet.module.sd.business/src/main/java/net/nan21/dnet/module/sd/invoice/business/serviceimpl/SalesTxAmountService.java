/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesTxAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

public class SalesTxAmountService extends AbstractEntityService<SalesTxAmount>
        implements ISalesTxAmountService {

    public SalesTxAmountService() {
        super();
    }

    public SalesTxAmountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesTxAmount> getEntityClass() {
        return SalesTxAmount.class;
    }

    public List<SalesTxAmount> findByOrder(SalesOrder order) {
        return this.findByOrderId(order.getId());
    }

    public List<SalesTxAmount> findByOrderId(Long orderId) {
        return (List<SalesTxAmount>) this.em
                .createQuery(
                        "select e from SalesTxAmount e where e.clientId = :pClientId and e.order.id = :pOrderId",
                        SalesTxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrderId", orderId).getResultList();
    }

    public List<SalesTxAmount> findByInvoice(SalesInvoice invoice) {
        return this.findByInvoiceId(invoice.getId());
    }

    public List<SalesTxAmount> findByInvoiceId(Long invoiceId) {
        return (List<SalesTxAmount>) this.em
                .createQuery(
                        "select e from SalesTxAmount e where e.clientId = :pClientId and e.invoice.id = :pInvoiceId",
                        SalesTxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInvoiceId", invoiceId).getResultList();
    }

}

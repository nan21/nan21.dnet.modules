/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

public class PurchaseInvoiceService extends
        AbstractEntityService<PurchaseInvoice> implements
        IPurchaseInvoiceService {

    public PurchaseInvoiceService() {
        super();
    }

    public PurchaseInvoiceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoice> getEntityClass() {
        return PurchaseInvoice.class;
    }

    public List<PurchaseInvoice> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<PurchaseInvoice> findByCurrencyId(Long currencyId) {
        return (List<PurchaseInvoice>) this.em
                .createQuery(
                        "select e from PurchaseInvoice e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        PurchaseInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<PurchaseInvoice> findBySupplier(BusinessPartner supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<PurchaseInvoice> findBySupplierId(Long supplierId) {
        return (List<PurchaseInvoice>) this.em
                .createQuery(
                        "select e from PurchaseInvoice e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
                        PurchaseInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<PurchaseInvoice> findByCustomer(Organization customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<PurchaseInvoice> findByCustomerId(Long customerId) {
        return (List<PurchaseInvoice>) this.em
                .createQuery(
                        "select e from PurchaseInvoice e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
                        PurchaseInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<PurchaseInvoice> findByPurchaseOrder(PurchaseOrder purchaseOrder) {
        return this.findByPurchaseOrderId(purchaseOrder.getId());
    }

    public List<PurchaseInvoice> findByPurchaseOrderId(Long purchaseOrderId) {
        return (List<PurchaseInvoice>) this.em
                .createQuery(
                        "select e from PurchaseInvoice e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
                        PurchaseInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseOrderId", purchaseOrderId)
                .getResultList();
    }

    public List<PurchaseInvoice> findByLines(PurchaseInvoiceItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<PurchaseInvoice> findByLinesId(Long linesId) {
        return (List<PurchaseInvoice>) this.em
                .createQuery(
                        "select distinct e from PurchaseInvoice e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        PurchaseInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

}

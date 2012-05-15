/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemTaxService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

public class PurchaseInvoiceItemTaxService extends
        AbstractEntityService<PurchaseInvoiceItemTax> implements
        IPurchaseInvoiceItemTaxService {

    public PurchaseInvoiceItemTaxService() {
        super();
    }

    public PurchaseInvoiceItemTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoiceItemTax> getEntityClass() {
        return PurchaseInvoiceItemTax.class;
    }

    public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItem(
            PurchaseInvoiceItem purchaseInvoiceItem) {
        return this.findByPurchaseInvoiceItemId(purchaseInvoiceItem.getId());
    }

    public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItemId(
            Long purchaseInvoiceItemId) {
        return (List<PurchaseInvoiceItemTax>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItemTax e where e.clientId = :pClientId and e.purchaseInvoiceItem.id = :pPurchaseInvoiceItemId",
                        PurchaseInvoiceItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseInvoiceItemId", purchaseInvoiceItemId)
                .getResultList();
    }

    public List<PurchaseInvoiceItemTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseInvoiceItemTax> findByTaxId(Long taxId) {
        return (List<PurchaseInvoiceItemTax>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseInvoiceItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

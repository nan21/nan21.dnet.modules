/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceTaxService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

public class PurchaseInvoiceTaxService extends
        AbstractEntityService<PurchaseInvoiceTax> implements
        IPurchaseInvoiceTaxService {

    public PurchaseInvoiceTaxService() {
        super();
    }

    public PurchaseInvoiceTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoiceTax> getEntityClass() {
        return PurchaseInvoiceTax.class;
    }

    public List<PurchaseInvoiceTax> findByPurchaseInvoice(
            PurchaseInvoice purchaseInvoice) {
        return this.findByPurchaseInvoiceId(purchaseInvoice.getId());
    }

    public List<PurchaseInvoiceTax> findByPurchaseInvoiceId(
            Long purchaseInvoiceId) {
        return (List<PurchaseInvoiceTax>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceTax e where e.clientId = :pClientId and e.purchaseInvoice.id = :pPurchaseInvoiceId",
                        PurchaseInvoiceTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseInvoiceId", purchaseInvoiceId)
                .getResultList();
    }

    public List<PurchaseInvoiceTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseInvoiceTax> findByTaxId(Long taxId) {
        return (List<PurchaseInvoiceTax>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseInvoiceTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

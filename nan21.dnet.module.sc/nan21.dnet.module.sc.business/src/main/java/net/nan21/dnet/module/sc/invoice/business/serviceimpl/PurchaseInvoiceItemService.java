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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public class PurchaseInvoiceItemService extends
        AbstractEntityService<PurchaseInvoiceItem> {

    public PurchaseInvoiceItemService() {
        super();
    }

    public PurchaseInvoiceItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoiceItem> getEntityClass() {
        return PurchaseInvoiceItem.class;
    }

    public List<PurchaseInvoiceItem> findByPurchaseInvoice(
            PurchaseInvoice purchaseInvoice) {
        return this.findByPurchaseInvoiceId(purchaseInvoice.getId());
    }

    public List<PurchaseInvoiceItem> findByPurchaseInvoiceId(
            Long purchaseInvoiceId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.purchaseInvoice.id = :pPurchaseInvoiceId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseInvoiceId", purchaseInvoiceId)
                .getResultList();
    }

    public List<PurchaseInvoiceItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<PurchaseInvoiceItem> findByProductId(Long productId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.product.id = :pProductId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<PurchaseInvoiceItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<PurchaseInvoiceItem> findByUomId(Long uomId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

    public List<PurchaseInvoiceItem> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseInvoiceItem> findByTaxId(Long taxId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

    public List<PurchaseInvoiceItem> findByItemTaxes(
            PurchaseInvoiceItemTax itemTaxes) {
        return this.findByItemTaxesId(itemTaxes.getId());
    }

    public List<PurchaseInvoiceItem> findByItemTaxesId(Long itemTaxesId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select distinct e from PurchaseInvoiceItem e , IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemTaxesId", itemTaxesId).getResultList();
    }

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

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

    public List<PurchaseInvoiceItem> findByInvoice(PurchaseInvoice invoice) {
        return this.findByInvoiceId(invoice.getId());
    }

    public List<PurchaseInvoiceItem> findByInvoiceId(Long invoiceId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.invoice.id = :pInvoiceId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInvoiceId", invoiceId).getResultList();
    }

    public List<PurchaseInvoiceItem> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<PurchaseInvoiceItem> findByItemId(Long itemId) {
        return (List<PurchaseInvoiceItem>) this.em
                .createQuery(
                        "select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.item.id = :pItemId",
                        PurchaseInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemId", itemId).getResultList();
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

}

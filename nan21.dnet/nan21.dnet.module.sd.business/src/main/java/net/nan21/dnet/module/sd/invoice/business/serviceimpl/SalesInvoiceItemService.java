/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceItemService extends
        AbstractEntityService<SalesInvoiceItem> {

    public SalesInvoiceItemService() {
        super();
    }

    public SalesInvoiceItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceItem> getEntityClass() {
        return SalesInvoiceItem.class;
    }

    public List<SalesInvoiceItem> findByInvoice(SalesInvoice invoice) {
        return this.findByInvoiceId(invoice.getId());
    }

    public List<SalesInvoiceItem> findByInvoiceId(Long invoiceId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.invoice.id = :pInvoiceId",
                        SalesInvoiceItem.class)
                .setParameter("pInvoiceId", invoiceId).getResultList();
    }

    public List<SalesInvoiceItem> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<SalesInvoiceItem> findByItemId(Long itemId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.item.id = :pItemId",
                        SalesInvoiceItem.class).setParameter("pItemId", itemId)
                .getResultList();
    }

    public List<SalesInvoiceItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<SalesInvoiceItem> findByUomId(Long uomId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.uom.id = :pUomId",
                        SalesInvoiceItem.class).setParameter("pUomId", uomId)
                .getResultList();
    }

}

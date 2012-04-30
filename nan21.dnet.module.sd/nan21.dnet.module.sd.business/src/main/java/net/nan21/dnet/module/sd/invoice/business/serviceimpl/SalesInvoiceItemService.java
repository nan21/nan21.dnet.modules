/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

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

    public List<SalesInvoiceItem> findBySalesInvoice(SalesInvoice salesInvoice) {
        return this.findBySalesInvoiceId(salesInvoice.getId());
    }

    public List<SalesInvoiceItem> findBySalesInvoiceId(Long salesInvoiceId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.clientId = :pClientId and e.salesInvoice.id = :pSalesInvoiceId",
                        SalesInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesInvoiceId", salesInvoiceId)
                .getResultList();
    }

    public List<SalesInvoiceItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<SalesInvoiceItem> findByProductId(Long productId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.clientId = :pClientId and e.product.id = :pProductId",
                        SalesInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<SalesInvoiceItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<SalesInvoiceItem> findByUomId(Long uomId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        SalesInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

    public List<SalesInvoiceItem> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesInvoiceItem> findByTaxId(Long taxId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select e from SalesInvoiceItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

    public List<SalesInvoiceItem> findByItemTaxes(SalesInvoiceItemTax itemTaxes) {
        return this.findByItemTaxesId(itemTaxes.getId());
    }

    public List<SalesInvoiceItem> findByItemTaxesId(Long itemTaxesId) {
        return (List<SalesInvoiceItem>) this.em
                .createQuery(
                        "select distinct e from SalesInvoiceItem e , IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
                        SalesInvoiceItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemTaxesId", itemTaxesId).getResultList();
    }

}

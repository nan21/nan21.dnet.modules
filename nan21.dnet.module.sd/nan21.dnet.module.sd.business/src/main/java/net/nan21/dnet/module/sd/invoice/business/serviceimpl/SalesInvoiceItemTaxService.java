/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceItemTaxService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

public class SalesInvoiceItemTaxService extends
        AbstractEntityService<SalesInvoiceItemTax> implements
        ISalesInvoiceItemTaxService {

    public SalesInvoiceItemTaxService() {
        super();
    }

    public SalesInvoiceItemTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceItemTax> getEntityClass() {
        return SalesInvoiceItemTax.class;
    }

    public List<SalesInvoiceItemTax> findBySalesInvoiceItem(
            SalesInvoiceItem salesInvoiceItem) {
        return this.findBySalesInvoiceItemId(salesInvoiceItem.getId());
    }

    public List<SalesInvoiceItemTax> findBySalesInvoiceItemId(
            Long salesInvoiceItemId) {
        return (List<SalesInvoiceItemTax>) this.em
                .createQuery(
                        "select e from SalesInvoiceItemTax e where e.clientId = :pClientId and e.salesInvoiceItem.id = :pSalesInvoiceItemId",
                        SalesInvoiceItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesInvoiceItemId", salesInvoiceItemId)
                .getResultList();
    }

    public List<SalesInvoiceItemTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesInvoiceItemTax> findByTaxId(Long taxId) {
        return (List<SalesInvoiceItemTax>) this.em
                .createQuery(
                        "select e from SalesInvoiceItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesInvoiceItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

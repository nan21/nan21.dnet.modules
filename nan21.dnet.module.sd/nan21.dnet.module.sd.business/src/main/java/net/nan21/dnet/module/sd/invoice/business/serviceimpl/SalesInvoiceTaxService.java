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
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceTaxService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

public class SalesInvoiceTaxService extends
        AbstractEntityService<SalesInvoiceTax> implements
        ISalesInvoiceTaxService {

    public SalesInvoiceTaxService() {
        super();
    }

    public SalesInvoiceTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceTax> getEntityClass() {
        return SalesInvoiceTax.class;
    }

    public List<SalesInvoiceTax> findBySalesInvoice(SalesInvoice salesInvoice) {
        return this.findBySalesInvoiceId(salesInvoice.getId());
    }

    public List<SalesInvoiceTax> findBySalesInvoiceId(Long salesInvoiceId) {
        return (List<SalesInvoiceTax>) this.em
                .createQuery(
                        "select e from SalesInvoiceTax e where e.clientId = :pClientId and e.salesInvoice.id = :pSalesInvoiceId",
                        SalesInvoiceTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesInvoiceId", salesInvoiceId)
                .getResultList();
    }

    public List<SalesInvoiceTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesInvoiceTax> findByTaxId(Long taxId) {
        return (List<SalesInvoiceTax>) this.em
                .createQuery(
                        "select e from SalesInvoiceTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesInvoiceTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

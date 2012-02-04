/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceAttachmentService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceAttachment;

public class SalesInvoiceAttachmentService extends
        AbstractEntityService<SalesInvoiceAttachment> implements
        ISalesInvoiceAttachmentService {

    public SalesInvoiceAttachmentService() {
        super();
    }

    public SalesInvoiceAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceAttachment> getEntityClass() {
        return SalesInvoiceAttachment.class;
    }

    public List<SalesInvoiceAttachment> findByInvoice(SalesInvoice invoice) {
        return this.findByInvoiceId(invoice.getId());
    }

    public List<SalesInvoiceAttachment> findByInvoiceId(Long invoiceId) {
        return (List<SalesInvoiceAttachment>) this.em
                .createQuery(
                        "select e from SalesInvoiceAttachment e where e.invoice.id = :pInvoiceId",
                        SalesInvoiceAttachment.class)
                .setParameter("pInvoiceId", invoiceId).getResultList();
    }

}

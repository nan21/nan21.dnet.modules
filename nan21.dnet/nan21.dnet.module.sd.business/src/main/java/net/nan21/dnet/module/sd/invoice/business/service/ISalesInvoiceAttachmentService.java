/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceAttachment;

public interface ISalesInvoiceAttachmentService extends
        IEntityService<SalesInvoiceAttachment> {

    public List<SalesInvoiceAttachment> findByInvoice(SalesInvoice invoice);

    public List<SalesInvoiceAttachment> findByInvoiceId(Long invoiceId);

}

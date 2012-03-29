/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

public interface ISalesInvoiceTaxService extends
        IEntityService<SalesInvoiceTax> {

    public List<SalesInvoiceTax> findBySalesInvoice(SalesInvoice salesInvoice);

    public List<SalesInvoiceTax> findBySalesInvoiceId(Long salesInvoiceId);

    public List<SalesInvoiceTax> findByTax(Tax tax);

    public List<SalesInvoiceTax> findByTaxId(Long taxId);

}

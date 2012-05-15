/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

public interface ISalesInvoiceItemTaxService extends
        IEntityService<SalesInvoiceItemTax> {

    public List<SalesInvoiceItemTax> findBySalesInvoiceItem(
            SalesInvoiceItem salesInvoiceItem);

    public List<SalesInvoiceItemTax> findBySalesInvoiceItemId(
            Long salesInvoiceItemId);

    public List<SalesInvoiceItemTax> findByTax(Tax tax);

    public List<SalesInvoiceItemTax> findByTaxId(Long taxId);

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public interface ISalesInvoiceItemService extends
        IEntityService<SalesInvoiceItem> {

    public List<SalesInvoiceItem> findByInvoice(SalesInvoice invoice);

    public List<SalesInvoiceItem> findByInvoiceId(Long invoiceId);

    public List<SalesInvoiceItem> findByItem(Product item);

    public List<SalesInvoiceItem> findByItemId(Long itemId);

    public List<SalesInvoiceItem> findByUom(Uom uom);

    public List<SalesInvoiceItem> findByUomId(Long uomId);

}

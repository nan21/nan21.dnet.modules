/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public interface IPurchaseInvoiceItemService extends
        IEntityService<PurchaseInvoiceItem> {

    public List<PurchaseInvoiceItem> findByInvoice(PurchaseInvoice invoice);

    public List<PurchaseInvoiceItem> findByInvoiceId(Long invoiceId);

    public List<PurchaseInvoiceItem> findByItem(Product item);

    public List<PurchaseInvoiceItem> findByItemId(Long itemId);

    public List<PurchaseInvoiceItem> findByUom(Uom uom);

    public List<PurchaseInvoiceItem> findByUomId(Long uomId);

}

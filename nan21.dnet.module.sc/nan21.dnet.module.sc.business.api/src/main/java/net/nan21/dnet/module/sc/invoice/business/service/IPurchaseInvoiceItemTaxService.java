/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

public interface IPurchaseInvoiceItemTaxService extends
        IEntityService<PurchaseInvoiceItemTax> {

    public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItem(
            PurchaseInvoiceItem purchaseInvoiceItem);

    public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItemId(
            Long purchaseInvoiceItemId);

    public List<PurchaseInvoiceItemTax> findByTax(Tax tax);

    public List<PurchaseInvoiceItemTax> findByTaxId(Long taxId);

}

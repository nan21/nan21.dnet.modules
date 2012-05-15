/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

public interface IPurchaseInvoiceTaxService extends
        IEntityService<PurchaseInvoiceTax> {

    public List<PurchaseInvoiceTax> findByPurchaseInvoice(
            PurchaseInvoice purchaseInvoice);

    public List<PurchaseInvoiceTax> findByPurchaseInvoiceId(
            Long purchaseInvoiceId);

    public List<PurchaseInvoiceTax> findByTax(Tax tax);

    public List<PurchaseInvoiceTax> findByTaxId(Long taxId);

}

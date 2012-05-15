/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public interface IPurchaseInvoiceItemService extends
        IEntityService<PurchaseInvoiceItem> {

    public List<PurchaseInvoiceItem> findByPurchaseInvoice(
            PurchaseInvoice purchaseInvoice);

    public List<PurchaseInvoiceItem> findByPurchaseInvoiceId(
            Long purchaseInvoiceId);

    public List<PurchaseInvoiceItem> findByProduct(Product product);

    public List<PurchaseInvoiceItem> findByProductId(Long productId);

    public List<PurchaseInvoiceItem> findByUom(Uom uom);

    public List<PurchaseInvoiceItem> findByUomId(Long uomId);

    public List<PurchaseInvoiceItem> findByTax(Tax tax);

    public List<PurchaseInvoiceItem> findByTaxId(Long taxId);

    public List<PurchaseInvoiceItem> findByItemTaxes(
            PurchaseInvoiceItemTax itemTaxes);

    public List<PurchaseInvoiceItem> findByItemTaxesId(Long itemTaxesId);

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public interface ISalesInvoiceItemService extends
        IEntityService<SalesInvoiceItem> {

    public List<SalesInvoiceItem> findBySalesInvoice(SalesInvoice salesInvoice);

    public List<SalesInvoiceItem> findBySalesInvoiceId(Long salesInvoiceId);

    public List<SalesInvoiceItem> findByProduct(Product product);

    public List<SalesInvoiceItem> findByProductId(Long productId);

    public List<SalesInvoiceItem> findByUom(Uom uom);

    public List<SalesInvoiceItem> findByUomId(Long uomId);

    public List<SalesInvoiceItem> findByTax(Tax tax);

    public List<SalesInvoiceItem> findByTaxId(Long taxId);

    public List<SalesInvoiceItem> findByItemTaxes(SalesInvoiceItemTax itemTaxes);

    public List<SalesInvoiceItem> findByItemTaxesId(Long itemTaxesId);

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

public interface IPurchaseInvoiceService extends
        IEntityService<PurchaseInvoice> {

    public List<PurchaseInvoice> findByCurrency(Currency currency);

    public List<PurchaseInvoice> findByCurrencyId(Long currencyId);

    public List<PurchaseInvoice> findBySupplier(BusinessPartner supplier);

    public List<PurchaseInvoice> findBySupplierId(Long supplierId);

    public List<PurchaseInvoice> findByCustomer(Organization customer);

    public List<PurchaseInvoice> findByCustomerId(Long customerId);

    public List<PurchaseInvoice> findByPurchaseOrder(PurchaseOrder purchaseOrder);

    public List<PurchaseInvoice> findByPurchaseOrderId(Long purchaseOrderId);

    public List<PurchaseInvoice> findByLines(PurchaseInvoiceItem lines);

    public List<PurchaseInvoice> findByLinesId(Long linesId);

}

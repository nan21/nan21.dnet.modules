/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public interface ISalesInvoiceService extends IEntityService<SalesInvoice> {

    public List<SalesInvoice> findByStatus(SalesInvoiceStatus status);

    public List<SalesInvoice> findByStatusId(Long statusId);

    public List<SalesInvoice> findByType(SalesInvoiceType type);

    public List<SalesInvoice> findByTypeId(Long typeId);

    public List<SalesInvoice> findByCurrency(Currency currency);

    public List<SalesInvoice> findByCurrencyId(Long currencyId);

    public List<SalesInvoice> findByCustomer(BusinessPartner customer);

    public List<SalesInvoice> findByCustomerId(Long customerId);

    public List<SalesInvoice> findByBillToLocation(Location billToLocation);

    public List<SalesInvoice> findByBillToLocationId(Long billToLocationId);

    public List<SalesInvoice> findByBillToContact(Contact billToContact);

    public List<SalesInvoice> findByBillToContactId(Long billToContactId);

    public List<SalesInvoice> findBySupplier(BusinessPartner supplier);

    public List<SalesInvoice> findBySupplierId(Long supplierId);

    public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder);

    public List<SalesInvoice> findBySalesOrderId(Long salesOrderId);

    public List<SalesInvoice> findByLines(SalesInvoiceItem lines);

    public List<SalesInvoice> findByLinesId(Long linesId);

}

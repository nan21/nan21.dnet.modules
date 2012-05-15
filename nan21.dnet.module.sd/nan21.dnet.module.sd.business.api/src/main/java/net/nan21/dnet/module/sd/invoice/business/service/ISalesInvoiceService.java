/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public interface ISalesInvoiceService extends IEntityService<SalesInvoice> {

    public List<SalesInvoice> findByPriceList(PriceList priceList);

    public List<SalesInvoice> findByPriceListId(Long priceListId);

    public List<SalesInvoice> findByCurrency(Currency currency);

    public List<SalesInvoice> findByCurrencyId(Long currencyId);

    public List<SalesInvoice> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<SalesInvoice> findByPaymentMethodId(Long paymentMethodId);

    public List<SalesInvoice> findByPaymentTerm(PaymentMethod paymentTerm);

    public List<SalesInvoice> findByPaymentTermId(Long paymentTermId);

    public List<SalesInvoice> findByDocType(TxDocType docType);

    public List<SalesInvoice> findByDocTypeId(Long docTypeId);

    public List<SalesInvoice> findByCustomer(BusinessPartner customer);

    public List<SalesInvoice> findByCustomerId(Long customerId);

    public List<SalesInvoice> findByBillToLocation(Location billToLocation);

    public List<SalesInvoice> findByBillToLocationId(Long billToLocationId);

    public List<SalesInvoice> findByBillToContact(Contact billToContact);

    public List<SalesInvoice> findByBillToContactId(Long billToContactId);

    public List<SalesInvoice> findBySupplier(Organization supplier);

    public List<SalesInvoice> findBySupplierId(Long supplierId);

    public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder);

    public List<SalesInvoice> findBySalesOrderId(Long salesOrderId);

    public List<SalesInvoice> findByLines(SalesInvoiceItem lines);

    public List<SalesInvoice> findByLinesId(Long linesId);

    public List<SalesInvoice> findByTaxes(SalesInvoiceTax taxes);

    public List<SalesInvoice> findByTaxesId(Long taxesId);

    public void doPost(SalesInvoice invoice) throws Exception;

    public void doUnPost(SalesInvoice invoice) throws Exception;

}

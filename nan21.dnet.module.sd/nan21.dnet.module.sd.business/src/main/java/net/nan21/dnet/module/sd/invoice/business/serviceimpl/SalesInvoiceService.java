/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd._businessdelegates.invoice.SalesInvoiceToAccDocBD;

public class SalesInvoiceService extends AbstractEntityService<SalesInvoice>
        implements ISalesInvoiceService {

    public SalesInvoiceService() {
        super();
    }

    public SalesInvoiceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoice> getEntityClass() {
        return SalesInvoice.class;
    }

    public List<SalesInvoice> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<SalesInvoice> findByPriceListId(Long priceListId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListId", priceListId).getResultList();
    }

    public List<SalesInvoice> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<SalesInvoice> findByCurrencyId(Long currencyId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<SalesInvoice> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<SalesInvoice> findByPaymentMethodId(Long paymentMethodId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<SalesInvoice> findByPaymentTerm(PaymentMethod paymentTerm) {
        return this.findByPaymentTermId(paymentTerm.getId());
    }

    public List<SalesInvoice> findByPaymentTermId(Long paymentTermId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentTermId", paymentTermId).getResultList();
    }

    public List<SalesInvoice> findByDocType(TxDocType docType) {
        return this.findByDocTypeId(docType.getId());
    }

    public List<SalesInvoice> findByDocTypeId(Long docTypeId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocTypeId", docTypeId).getResultList();
    }

    public List<SalesInvoice> findByCustomer(BusinessPartner customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<SalesInvoice> findByCustomerId(Long customerId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<SalesInvoice> findByBillToLocation(Location billToLocation) {
        return this.findByBillToLocationId(billToLocation.getId());
    }

    public List<SalesInvoice> findByBillToLocationId(Long billToLocationId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.billToLocation.id = :pBillToLocationId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBillToLocationId", billToLocationId)
                .getResultList();
    }

    public List<SalesInvoice> findByBillToContact(Contact billToContact) {
        return this.findByBillToContactId(billToContact.getId());
    }

    public List<SalesInvoice> findByBillToContactId(Long billToContactId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.billToContact.id = :pBillToContactId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBillToContactId", billToContactId)
                .getResultList();
    }

    public List<SalesInvoice> findBySupplier(Organization supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<SalesInvoice> findBySupplierId(Long supplierId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder) {
        return this.findBySalesOrderId(salesOrder.getId());
    }

    public List<SalesInvoice> findBySalesOrderId(Long salesOrderId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

    public List<SalesInvoice> findByLines(SalesInvoiceItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<SalesInvoice> findByLinesId(Long linesId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select distinct e from SalesInvoice e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

    public List<SalesInvoice> findByTaxes(SalesInvoiceTax taxes) {
        return this.findByTaxesId(taxes.getId());
    }

    public List<SalesInvoice> findByTaxesId(Long taxesId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select distinct e from SalesInvoice e , IN (e.taxes) c where e.clientId = :pClientId and c.id = :pTaxesId",
                        SalesInvoice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxesId", taxesId).getResultList();
    }

    public void doPost(SalesInvoice invoice) throws Exception {
        this.getBusinessDelegate(SalesInvoiceToAccDocBD.class).post(invoice);
    }

    public void doUnPost(SalesInvoice invoice) throws Exception {
        this.getBusinessDelegate(SalesInvoiceToAccDocBD.class).unPost(invoice);
    }

}

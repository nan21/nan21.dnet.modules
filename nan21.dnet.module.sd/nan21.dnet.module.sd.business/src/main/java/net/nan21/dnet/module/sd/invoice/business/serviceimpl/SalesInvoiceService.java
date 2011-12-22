/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

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

    public List<SalesInvoice> findByStatus(SalesInvoiceStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<SalesInvoice> findByStatusId(Long statusId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.status.id = :pStatusId",
                        SalesInvoice.class).setParameter("pStatusId", statusId)
                .getResultList();
    }

    public List<SalesInvoice> findByType(SalesInvoiceType type) {
        return this.findByTypeId(type.getId());
    }

    public List<SalesInvoice> findByTypeId(Long typeId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.type.id = :pTypeId",
                        SalesInvoice.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<SalesInvoice> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<SalesInvoice> findByCurrencyId(Long currencyId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.currency.id = :pCurrencyId",
                        SalesInvoice.class)
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<SalesInvoice> findByCustomer(BusinessPartner customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<SalesInvoice> findByCustomerId(Long customerId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.customer.id = :pCustomerId",
                        SalesInvoice.class)
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<SalesInvoice> findByBillToLocation(Location billToLocation) {
        return this.findByBillToLocationId(billToLocation.getId());
    }

    public List<SalesInvoice> findByBillToLocationId(Long billToLocationId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.billToLocation.id = :pBillToLocationId",
                        SalesInvoice.class)
                .setParameter("pBillToLocationId", billToLocationId)
                .getResultList();
    }

    public List<SalesInvoice> findByBillToContact(Contact billToContact) {
        return this.findByBillToContactId(billToContact.getId());
    }

    public List<SalesInvoice> findByBillToContactId(Long billToContactId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.billToContact.id = :pBillToContactId",
                        SalesInvoice.class)
                .setParameter("pBillToContactId", billToContactId)
                .getResultList();
    }

    public List<SalesInvoice> findBySupplier(Organization supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<SalesInvoice> findBySupplierId(Long supplierId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.supplier.id = :pSupplierId",
                        SalesInvoice.class)
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder) {
        return this.findBySalesOrderId(salesOrder.getId());
    }

    public List<SalesInvoice> findBySalesOrderId(Long salesOrderId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select e from SalesInvoice e where e.salesOrder.id = :pSalesOrderId",
                        SalesInvoice.class)
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

    public List<SalesInvoice> findByLines(SalesInvoiceItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<SalesInvoice> findByLinesId(Long linesId) {
        return (List<SalesInvoice>) this.em
                .createQuery(
                        "select distinct e from SalesInvoice e , IN (e.lines) c where c.id = :pLinesId",
                        SalesInvoice.class).setParameter("pLinesId", linesId)
                .getResultList();
    }

}

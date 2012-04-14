/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.fin.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderToInvoiceBD;

public class SalesOrderService extends AbstractEntityService<SalesOrder>
        implements ISalesOrderService {

    public SalesOrderService() {
        super();
    }

    public SalesOrderService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrder> getEntityClass() {
        return SalesOrder.class;
    }

    public List<SalesOrder> findByDocType(FinDocType docType) {
        return this.findByDocTypeId(docType.getId());
    }

    public List<SalesOrder> findByDocTypeId(Long docTypeId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocTypeId", docTypeId).getResultList();
    }

    public List<SalesOrder> findByCustomer(BusinessPartner customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<SalesOrder> findByCustomerId(Long customerId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<SalesOrder> findBySupplier(Organization supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<SalesOrder> findBySupplierId(Long supplierId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<SalesOrder> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<SalesOrder> findByPriceListId(Long priceListId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListId", priceListId).getResultList();
    }

    public List<SalesOrder> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<SalesOrder> findByCurrencyId(Long currencyId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<SalesOrder> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<SalesOrder> findByPaymentMethodId(Long paymentMethodId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<SalesOrder> findByPaymentTerm(PaymentMethod paymentTerm) {
        return this.findByPaymentTermId(paymentTerm.getId());
    }

    public List<SalesOrder> findByPaymentTermId(Long paymentTermId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentTermId", paymentTermId).getResultList();
    }

    public List<SalesOrder> findByInventory(Organization inventory) {
        return this.findByInventoryId(inventory.getId());
    }

    public List<SalesOrder> findByInventoryId(Long inventoryId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.inventory.id = :pInventoryId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInventoryId", inventoryId).getResultList();
    }

    public List<SalesOrder> findByDeliveryMethod(DeliveryMethod deliveryMethod) {
        return this.findByDeliveryMethodId(deliveryMethod.getId());
    }

    public List<SalesOrder> findByDeliveryMethodId(Long deliveryMethodId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.deliveryMethod.id = :pDeliveryMethodId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDeliveryMethodId", deliveryMethodId)
                .getResultList();
    }

    public List<SalesOrder> findByCarrier(Organization carrier) {
        return this.findByCarrierId(carrier.getId());
    }

    public List<SalesOrder> findByCarrierId(Long carrierId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.carrier.id = :pCarrierId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCarrierId", carrierId).getResultList();
    }

    public List<SalesOrder> findByBillTo(BusinessPartner billTo) {
        return this.findByBillToId(billTo.getId());
    }

    public List<SalesOrder> findByBillToId(Long billToId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.billTo.id = :pBillToId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBillToId", billToId).getResultList();
    }

    public List<SalesOrder> findByBillToLocation(Location billToLocation) {
        return this.findByBillToLocationId(billToLocation.getId());
    }

    public List<SalesOrder> findByBillToLocationId(Long billToLocationId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.billToLocation.id = :pBillToLocationId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBillToLocationId", billToLocationId)
                .getResultList();
    }

    public List<SalesOrder> findByShipTo(BusinessPartner shipTo) {
        return this.findByShipToId(shipTo.getId());
    }

    public List<SalesOrder> findByShipToId(Long shipToId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.shipTo.id = :pShipToId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pShipToId", shipToId).getResultList();
    }

    public List<SalesOrder> findByShipToLocation(Location shipToLocation) {
        return this.findByShipToLocationId(shipToLocation.getId());
    }

    public List<SalesOrder> findByShipToLocationId(Long shipToLocationId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.clientId = :pClientId and e.shipToLocation.id = :pShipToLocationId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pShipToLocationId", shipToLocationId)
                .getResultList();
    }

    public List<SalesOrder> findByLines(SalesOrderItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<SalesOrder> findByLinesId(Long linesId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select distinct e from SalesOrder e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        SalesOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

    public void doGenerateInvoice(SalesOrder salesOrder) throws Exception {
        this.getBusinessDelegate(SalesOrderToInvoiceBD.class).generateInvoice(
                salesOrder);
    }

}

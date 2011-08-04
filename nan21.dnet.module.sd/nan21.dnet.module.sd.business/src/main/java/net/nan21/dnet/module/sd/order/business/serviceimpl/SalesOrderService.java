/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;
import net.nan21.dnet.module.sd.price.domain.entity.PriceList;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

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

    public List<SalesOrder> findByStatus(SalesOrderStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<SalesOrder> findByStatusId(Long statusId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.status.id = :pStatusId",
                        SalesOrder.class).setParameter("pStatusId", statusId)
                .getResultList();
    }

    public List<SalesOrder> findByType(SalesOrderType type) {
        return this.findByTypeId(type.getId());
    }

    public List<SalesOrder> findByTypeId(Long typeId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.type.id = :pTypeId",
                        SalesOrder.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<SalesOrder> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<SalesOrder> findByPriceListId(Long priceListId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.priceList.id = :pPriceListId",
                        SalesOrder.class)
                .setParameter("pPriceListId", priceListId).getResultList();
    }

    public List<SalesOrder> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<SalesOrder> findByCurrencyId(Long currencyId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.currency.id = :pCurrencyId",
                        SalesOrder.class)
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<SalesOrder> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<SalesOrder> findByPaymentMethodId(Long paymentMethodId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.paymentMethod.id = :pPaymentMethodId",
                        SalesOrder.class)
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<SalesOrder> findByDeliveryMethod(DeliveryMethod deliveryMethod) {
        return this.findByDeliveryMethodId(deliveryMethod.getId());
    }

    public List<SalesOrder> findByDeliveryMethodId(Long deliveryMethodId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.deliveryMethod.id = :pDeliveryMethodId",
                        SalesOrder.class)
                .setParameter("pDeliveryMethodId", deliveryMethodId)
                .getResultList();
    }

    public List<SalesOrder> findByCustomer(BusinessPartner customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<SalesOrder> findByCustomerId(Long customerId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.customer.id = :pCustomerId",
                        SalesOrder.class)
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<SalesOrder> findBySupplier(BusinessPartner supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<SalesOrder> findBySupplierId(Long supplierId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.supplier.id = :pSupplierId",
                        SalesOrder.class)
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<SalesOrder> findByBillTo(BusinessPartner billTo) {
        return this.findByBillToId(billTo.getId());
    }

    public List<SalesOrder> findByBillToId(Long billToId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.billTo.id = :pBillToId",
                        SalesOrder.class).setParameter("pBillToId", billToId)
                .getResultList();
    }

    public List<SalesOrder> findByBillToLocation(Location billToLocation) {
        return this.findByBillToLocationId(billToLocation.getId());
    }

    public List<SalesOrder> findByBillToLocationId(Long billToLocationId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.billToLocation.id = :pBillToLocationId",
                        SalesOrder.class)
                .setParameter("pBillToLocationId", billToLocationId)
                .getResultList();
    }

    public List<SalesOrder> findByShipTo(BusinessPartner shipTo) {
        return this.findByShipToId(shipTo.getId());
    }

    public List<SalesOrder> findByShipToId(Long shipToId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.shipTo.id = :pShipToId",
                        SalesOrder.class).setParameter("pShipToId", shipToId)
                .getResultList();
    }

    public List<SalesOrder> findByShipToLocation(Location shipToLocation) {
        return this.findByShipToLocationId(shipToLocation.getId());
    }

    public List<SalesOrder> findByShipToLocationId(Long shipToLocationId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.shipToLocation.id = :pShipToLocationId",
                        SalesOrder.class)
                .setParameter("pShipToLocationId", shipToLocationId)
                .getResultList();
    }

    public List<SalesOrder> findByLines(SalesOrderItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<SalesOrder> findByLinesId(Long linesId) {
        return (List<SalesOrder>) this.em
                .createQuery(
                        "select e from SalesOrder e where e.lines.id = :pLinesId",
                        SalesOrder.class).setParameter("pLinesId", linesId)
                .getResultList();
    }

}

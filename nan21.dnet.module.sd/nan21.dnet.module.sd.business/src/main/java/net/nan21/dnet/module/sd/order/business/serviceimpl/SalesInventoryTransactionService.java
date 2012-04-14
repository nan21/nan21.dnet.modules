/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.order.business.service.ISalesInventoryTransactionService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;

public class SalesInventoryTransactionService extends
        AbstractEntityService<SalesInventoryTransaction> implements
        ISalesInventoryTransactionService {

    public SalesInventoryTransactionService() {
        super();
    }

    public SalesInventoryTransactionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInventoryTransaction> getEntityClass() {
        return SalesInventoryTransaction.class;
    }

    public List<SalesInventoryTransaction> findByCustomer(
            BusinessPartner customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<SalesInventoryTransaction> findByCustomerId(Long customerId) {
        return (List<SalesInventoryTransaction>) this.em
                .createQuery(
                        "select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
                        SalesInventoryTransaction.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<SalesInventoryTransaction> findByDeliveryLocation(
            Location deliveryLocation) {
        return this.findByDeliveryLocationId(deliveryLocation.getId());
    }

    public List<SalesInventoryTransaction> findByDeliveryLocationId(
            Long deliveryLocationId) {
        return (List<SalesInventoryTransaction>) this.em
                .createQuery(
                        "select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.deliveryLocation.id = :pDeliveryLocationId",
                        SalesInventoryTransaction.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDeliveryLocationId", deliveryLocationId)
                .getResultList();
    }

    public List<SalesInventoryTransaction> findBySalesOrder(
            SalesOrder salesOrder) {
        return this.findBySalesOrderId(salesOrder.getId());
    }

    public List<SalesInventoryTransaction> findBySalesOrderId(Long salesOrderId) {
        return (List<SalesInventoryTransaction>) this.em
                .createQuery(
                        "select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
                        SalesInventoryTransaction.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

}

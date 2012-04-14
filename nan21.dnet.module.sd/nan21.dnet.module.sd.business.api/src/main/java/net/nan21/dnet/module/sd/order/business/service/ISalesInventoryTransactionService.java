/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;

public interface ISalesInventoryTransactionService extends
        IEntityService<SalesInventoryTransaction> {

    public List<SalesInventoryTransaction> findByCustomer(
            BusinessPartner customer);

    public List<SalesInventoryTransaction> findByCustomerId(Long customerId);

    public List<SalesInventoryTransaction> findByDeliveryLocation(
            Location deliveryLocation);

    public List<SalesInventoryTransaction> findByDeliveryLocationId(
            Long deliveryLocationId);

    public List<SalesInventoryTransaction> findBySalesOrder(
            SalesOrder salesOrder);

    public List<SalesInventoryTransaction> findBySalesOrderId(Long salesOrderId);

}

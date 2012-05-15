/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

public interface IPurchaseInventoryTransactionService extends
        IEntityService<PurchaseInventoryTransaction> {

    public List<PurchaseInventoryTransaction> findBySupplier(
            BusinessPartner supplier);

    public List<PurchaseInventoryTransaction> findBySupplierId(Long supplierId);

    public List<PurchaseInventoryTransaction> findByPurchaseOrder(
            PurchaseOrder purchaseOrder);

    public List<PurchaseInventoryTransaction> findByPurchaseOrderId(
            Long purchaseOrderId);

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseInventoryTransactionService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

public class PurchaseInventoryTransactionService extends
        AbstractEntityService<PurchaseInventoryTransaction> implements
        IPurchaseInventoryTransactionService {

    public PurchaseInventoryTransactionService() {
        super();
    }

    public PurchaseInventoryTransactionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInventoryTransaction> getEntityClass() {
        return PurchaseInventoryTransaction.class;
    }

    public List<PurchaseInventoryTransaction> findBySupplier(
            BusinessPartner supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<PurchaseInventoryTransaction> findBySupplierId(Long supplierId) {
        return (List<PurchaseInventoryTransaction>) this.em
                .createQuery(
                        "select e from PurchaseInventoryTransaction e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
                        PurchaseInventoryTransaction.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<PurchaseInventoryTransaction> findByPurchaseOrder(
            PurchaseOrder purchaseOrder) {
        return this.findByPurchaseOrderId(purchaseOrder.getId());
    }

    public List<PurchaseInventoryTransaction> findByPurchaseOrderId(
            Long purchaseOrderId) {
        return (List<PurchaseInventoryTransaction>) this.em
                .createQuery(
                        "select e from PurchaseInventoryTransaction e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
                        PurchaseInventoryTransaction.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseOrderId", purchaseOrderId)
                .getResultList();
    }

}

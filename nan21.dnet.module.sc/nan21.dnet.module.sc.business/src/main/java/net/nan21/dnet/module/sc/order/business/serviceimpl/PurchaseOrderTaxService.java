/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderTaxService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderTax;

public class PurchaseOrderTaxService extends
        AbstractEntityService<PurchaseOrderTax> implements
        IPurchaseOrderTaxService {

    public PurchaseOrderTaxService() {
        super();
    }

    public PurchaseOrderTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrderTax> getEntityClass() {
        return PurchaseOrderTax.class;
    }

    public List<PurchaseOrderTax> findByPurchaseOrder(
            PurchaseOrder purchaseOrder) {
        return this.findByPurchaseOrderId(purchaseOrder.getId());
    }

    public List<PurchaseOrderTax> findByPurchaseOrderId(Long purchaseOrderId) {
        return (List<PurchaseOrderTax>) this.em
                .createQuery(
                        "select e from PurchaseOrderTax e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
                        PurchaseOrderTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseOrderId", purchaseOrderId)
                .getResultList();
    }

    public List<PurchaseOrderTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseOrderTax> findByTaxId(Long taxId) {
        return (List<PurchaseOrderTax>) this.em
                .createQuery(
                        "select e from PurchaseOrderTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseOrderTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

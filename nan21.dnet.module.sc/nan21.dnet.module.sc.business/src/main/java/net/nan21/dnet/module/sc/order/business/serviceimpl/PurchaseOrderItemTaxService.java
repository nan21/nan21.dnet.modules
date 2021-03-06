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
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemTaxService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public class PurchaseOrderItemTaxService extends
        AbstractEntityService<PurchaseOrderItemTax> implements
        IPurchaseOrderItemTaxService {

    public PurchaseOrderItemTaxService() {
        super();
    }

    public PurchaseOrderItemTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrderItemTax> getEntityClass() {
        return PurchaseOrderItemTax.class;
    }

    public List<PurchaseOrderItemTax> findByPurchaseOrderItem(
            PurchaseOrderItem purchaseOrderItem) {
        return this.findByPurchaseOrderItemId(purchaseOrderItem.getId());
    }

    public List<PurchaseOrderItemTax> findByPurchaseOrderItemId(
            Long purchaseOrderItemId) {
        return (List<PurchaseOrderItemTax>) this.em
                .createQuery(
                        "select e from PurchaseOrderItemTax e where e.clientId = :pClientId and e.purchaseOrderItem.id = :pPurchaseOrderItemId",
                        PurchaseOrderItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseOrderItemId", purchaseOrderItemId)
                .getResultList();
    }

    public List<PurchaseOrderItemTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseOrderItemTax> findByTaxId(Long taxId) {
        return (List<PurchaseOrderItemTax>) this.em
                .createQuery(
                        "select e from PurchaseOrderItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseOrderItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}

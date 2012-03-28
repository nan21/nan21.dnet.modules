/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

public class PurchaseOrderItemService extends
        AbstractEntityService<PurchaseOrderItem> {

    public PurchaseOrderItemService() {
        super();
    }

    public PurchaseOrderItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrderItem> getEntityClass() {
        return PurchaseOrderItem.class;
    }

    public List<PurchaseOrderItem> findByPurchaseOrder(
            PurchaseOrder purchaseOrder) {
        return this.findByPurchaseOrderId(purchaseOrder.getId());
    }

    public List<PurchaseOrderItem> findByPurchaseOrderId(Long purchaseOrderId) {
        return (List<PurchaseOrderItem>) this.em
                .createQuery(
                        "select e from PurchaseOrderItem e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
                        PurchaseOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseOrderId", purchaseOrderId)
                .getResultList();
    }

    public List<PurchaseOrderItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<PurchaseOrderItem> findByProductId(Long productId) {
        return (List<PurchaseOrderItem>) this.em
                .createQuery(
                        "select e from PurchaseOrderItem e where e.clientId = :pClientId and e.product.id = :pProductId",
                        PurchaseOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<PurchaseOrderItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<PurchaseOrderItem> findByUomId(Long uomId) {
        return (List<PurchaseOrderItem>) this.em
                .createQuery(
                        "select e from PurchaseOrderItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        PurchaseOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

    public List<PurchaseOrderItem> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<PurchaseOrderItem> findByTaxId(Long taxId) {
        return (List<PurchaseOrderItem>) this.em
                .createQuery(
                        "select e from PurchaseOrderItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        PurchaseOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

    public List<PurchaseOrderItem> findByItemTaxes(
            PurchaseOrderItemTax itemTaxes) {
        return this.findByItemTaxesId(itemTaxes.getId());
    }

    public List<PurchaseOrderItem> findByItemTaxesId(Long itemTaxesId) {
        return (List<PurchaseOrderItem>) this.em
                .createQuery(
                        "select distinct e from PurchaseOrderItem e , IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
                        PurchaseOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemTaxesId", itemTaxesId).getResultList();
    }

}

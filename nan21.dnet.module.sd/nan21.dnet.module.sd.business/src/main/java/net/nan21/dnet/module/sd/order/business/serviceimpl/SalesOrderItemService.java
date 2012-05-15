/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderItemService extends
        AbstractEntityService<SalesOrderItem> {

    public SalesOrderItemService() {
        super();
    }

    public SalesOrderItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderItem> getEntityClass() {
        return SalesOrderItem.class;
    }

    public List<SalesOrderItem> findBySalesOrder(SalesOrder salesOrder) {
        return this.findBySalesOrderId(salesOrder.getId());
    }

    public List<SalesOrderItem> findBySalesOrderId(Long salesOrderId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
                        SalesOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

    public List<SalesOrderItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<SalesOrderItem> findByProductId(Long productId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.clientId = :pClientId and e.product.id = :pProductId",
                        SalesOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<SalesOrderItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<SalesOrderItem> findByUomId(Long uomId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        SalesOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

    public List<SalesOrderItem> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesOrderItem> findByTaxId(Long taxId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

    public List<SalesOrderItem> findByItemTaxes(SalesOrderItemTax itemTaxes) {
        return this.findByItemTaxesId(itemTaxes.getId());
    }

    public List<SalesOrderItem> findByItemTaxesId(Long itemTaxesId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select distinct e from SalesOrderItem e , IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
                        SalesOrderItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemTaxesId", itemTaxesId).getResultList();
    }

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderItemService extends
        AbstractEntityService<SalesOrderItem> implements ISalesOrderItemService {

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
                        "select e from SalesOrderItem e where e.salesOrder.id = :pSalesOrderId",
                        SalesOrderItem.class)
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

    public List<SalesOrderItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<SalesOrderItem> findByProductId(Long productId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.product.id = :pProductId",
                        SalesOrderItem.class)
                .setParameter("pProductId", productId).getResultList();
    }

    public List<SalesOrderItem> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<SalesOrderItem> findByUomId(Long uomId) {
        return (List<SalesOrderItem>) this.em
                .createQuery(
                        "select e from SalesOrderItem e where e.uom.id = :pUomId",
                        SalesOrderItem.class).setParameter("pUomId", uomId)
                .getResultList();
    }

}

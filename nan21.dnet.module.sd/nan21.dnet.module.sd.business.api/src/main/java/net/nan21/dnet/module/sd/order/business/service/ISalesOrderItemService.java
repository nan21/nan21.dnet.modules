/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public interface ISalesOrderItemService extends IEntityService<SalesOrderItem> {

    public List<SalesOrderItem> findBySalesOrder(SalesOrder salesOrder);

    public List<SalesOrderItem> findBySalesOrderId(Long salesOrderId);

    public List<SalesOrderItem> findByProduct(Product product);

    public List<SalesOrderItem> findByProductId(Long productId);

    public List<SalesOrderItem> findByUom(Uom uom);

    public List<SalesOrderItem> findByUomId(Long uomId);

    public List<SalesOrderItem> findByTax(Tax tax);

    public List<SalesOrderItem> findByTaxId(Long taxId);

    public List<SalesOrderItem> findByItemTaxes(SalesOrderItemTax itemTaxes);

    public List<SalesOrderItem> findByItemTaxesId(Long itemTaxesId);

}

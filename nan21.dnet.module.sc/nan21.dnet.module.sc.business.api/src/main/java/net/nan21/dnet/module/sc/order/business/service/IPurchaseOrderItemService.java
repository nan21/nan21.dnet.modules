/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

public interface IPurchaseOrderItemService extends
        IEntityService<PurchaseOrderItem> {

    public List<PurchaseOrderItem> findByPurchaseOrder(
            PurchaseOrder purchaseOrder);

    public List<PurchaseOrderItem> findByPurchaseOrderId(Long purchaseOrderId);

    public List<PurchaseOrderItem> findByProduct(Product product);

    public List<PurchaseOrderItem> findByProductId(Long productId);

    public List<PurchaseOrderItem> findByUom(Uom uom);

    public List<PurchaseOrderItem> findByUomId(Long uomId);

    public List<PurchaseOrderItem> findByTax(Tax tax);

    public List<PurchaseOrderItem> findByTaxId(Long taxId);

    public List<PurchaseOrderItem> findByItemTaxes(
            PurchaseOrderItemTax itemTaxes);

    public List<PurchaseOrderItem> findByItemTaxesId(Long itemTaxesId);

}

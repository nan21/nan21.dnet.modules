/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public interface IPurchaseOrderItemTaxService extends
        IEntityService<PurchaseOrderItemTax> {

    public List<PurchaseOrderItemTax> findBySalesOrderItem(
            PurchaseOrderItem salesOrderItem);

    public List<PurchaseOrderItemTax> findBySalesOrderItemId(
            Long salesOrderItemId);

    public List<PurchaseOrderItemTax> findByTax(Tax tax);

    public List<PurchaseOrderItemTax> findByTaxId(Long taxId);

}

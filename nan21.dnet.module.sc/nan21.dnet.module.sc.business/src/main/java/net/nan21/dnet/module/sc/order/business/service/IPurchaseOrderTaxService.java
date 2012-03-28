/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderTax;

public interface IPurchaseOrderTaxService extends
        IEntityService<PurchaseOrderTax> {

    public List<PurchaseOrderTax> findBySalesOrder(PurchaseOrder salesOrder);

    public List<PurchaseOrderTax> findBySalesOrderId(Long salesOrderId);

    public List<PurchaseOrderTax> findByTax(Tax tax);

    public List<PurchaseOrderTax> findByTaxId(Long taxId);

}

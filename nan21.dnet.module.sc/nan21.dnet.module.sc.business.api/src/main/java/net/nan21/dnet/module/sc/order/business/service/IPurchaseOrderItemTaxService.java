/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public interface IPurchaseOrderItemTaxService extends
        IEntityService<PurchaseOrderItemTax> {

    public List<PurchaseOrderItemTax> findByPurchaseOrderItem(
            PurchaseOrderItem purchaseOrderItem);

    public List<PurchaseOrderItemTax> findByPurchaseOrderItemId(
            Long purchaseOrderItemId);

    public List<PurchaseOrderItemTax> findByTax(Tax tax);

    public List<PurchaseOrderItemTax> findByTaxId(Long taxId);

}

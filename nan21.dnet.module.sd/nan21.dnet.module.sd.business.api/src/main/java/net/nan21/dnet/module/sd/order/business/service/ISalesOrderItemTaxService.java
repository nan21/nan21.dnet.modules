/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public interface ISalesOrderItemTaxService extends
        IEntityService<SalesOrderItemTax> {

    public List<SalesOrderItemTax> findBySalesOrderItem(
            SalesOrderItem salesOrderItem);

    public List<SalesOrderItemTax> findBySalesOrderItemId(Long salesOrderItemId);

    public List<SalesOrderItemTax> findByTax(Tax tax);

    public List<SalesOrderItemTax> findByTaxId(Long taxId);

}

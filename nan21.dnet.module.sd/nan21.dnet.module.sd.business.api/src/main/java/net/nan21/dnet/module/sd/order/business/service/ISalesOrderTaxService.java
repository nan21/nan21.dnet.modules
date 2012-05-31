/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

public interface ISalesOrderTaxService extends IEntityService<SalesOrderTax> {

    public List<SalesOrderTax> findBySalesOrder(SalesOrder salesOrder);

    public List<SalesOrderTax> findBySalesOrderId(Long salesOrderId);

    public List<SalesOrderTax> findByTax(Tax tax);

    public List<SalesOrderTax> findByTaxId(Long taxId);

}

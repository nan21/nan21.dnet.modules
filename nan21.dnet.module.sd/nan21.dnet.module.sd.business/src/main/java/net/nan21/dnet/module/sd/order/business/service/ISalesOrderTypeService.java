/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;

public interface ISalesOrderTypeService extends IEntityService<SalesOrderType> {

    public SalesOrderType findByName(String name);

}

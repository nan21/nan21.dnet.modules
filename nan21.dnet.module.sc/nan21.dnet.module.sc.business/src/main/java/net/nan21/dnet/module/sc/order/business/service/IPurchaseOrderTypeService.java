/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderType;

public interface IPurchaseOrderTypeService extends
        IEntityService<PurchaseOrderType> {

    public PurchaseOrderType findByName(String name);

}

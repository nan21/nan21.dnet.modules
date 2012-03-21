/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderStatus;

public interface IPurchaseOrderStatusService extends
        IEntityService<PurchaseOrderStatus> {

    public PurchaseOrderStatus findByName(String name);

}

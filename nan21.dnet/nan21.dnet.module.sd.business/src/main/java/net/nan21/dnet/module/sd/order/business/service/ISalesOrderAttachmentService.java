/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderAttachment;

public interface ISalesOrderAttachmentService extends
        IEntityService<SalesOrderAttachment> {

    public List<SalesOrderAttachment> findByOrder(SalesOrder order);

    public List<SalesOrderAttachment> findByOrderId(Long orderId);

}

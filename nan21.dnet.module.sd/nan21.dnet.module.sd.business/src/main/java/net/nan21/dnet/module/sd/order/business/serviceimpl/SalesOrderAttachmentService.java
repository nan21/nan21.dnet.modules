/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderAttachmentService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderAttachment;

public class SalesOrderAttachmentService extends
        AbstractEntityService<SalesOrderAttachment> implements
        ISalesOrderAttachmentService {

    public SalesOrderAttachmentService() {
        super();
    }

    public SalesOrderAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderAttachment> getEntityClass() {
        return SalesOrderAttachment.class;
    }

    public List<SalesOrderAttachment> findByOrder(SalesOrder order) {
        return this.findByOrderId(order.getId());
    }

    public List<SalesOrderAttachment> findByOrderId(Long orderId) {
        return (List<SalesOrderAttachment>) this.em
                .createQuery(
                        "select e from SalesOrderAttachment e where e.order.id = :pOrderId",
                        SalesOrderAttachment.class)
                .setParameter("pOrderId", orderId).getResultList();
    }

}

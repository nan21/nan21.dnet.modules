/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;

public class SalesOrderStatusService extends
        AbstractEntityService<SalesOrderStatus> implements
        ISalesOrderStatusService {

    public SalesOrderStatusService() {
        super();
    }

    public SalesOrderStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderStatus> getEntityClass() {
        return SalesOrderStatus.class;
    }

    public SalesOrderStatus findByName(String name) {
        return (SalesOrderStatus) this.em
                .createNamedQuery(SalesOrderStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

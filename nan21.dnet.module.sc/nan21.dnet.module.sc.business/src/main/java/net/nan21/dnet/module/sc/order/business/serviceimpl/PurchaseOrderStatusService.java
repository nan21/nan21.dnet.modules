/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderStatus;

public class PurchaseOrderStatusService extends
        AbstractEntityService<PurchaseOrderStatus> implements
        IPurchaseOrderStatusService {

    public PurchaseOrderStatusService() {
        super();
    }

    public PurchaseOrderStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrderStatus> getEntityClass() {
        return PurchaseOrderStatus.class;
    }

    public PurchaseOrderStatus findByName(String name) {
        return (PurchaseOrderStatus) this.em
                .createNamedQuery(PurchaseOrderStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

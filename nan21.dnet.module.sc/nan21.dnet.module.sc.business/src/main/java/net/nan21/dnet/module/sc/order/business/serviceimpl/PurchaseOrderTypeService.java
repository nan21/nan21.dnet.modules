/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderType;

public class PurchaseOrderTypeService extends
        AbstractEntityService<PurchaseOrderType> implements
        IPurchaseOrderTypeService {

    public PurchaseOrderTypeService() {
        super();
    }

    public PurchaseOrderTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrderType> getEntityClass() {
        return PurchaseOrderType.class;
    }

    public PurchaseOrderType findByName(String name) {
        return (PurchaseOrderType) this.em
                .createNamedQuery(PurchaseOrderType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

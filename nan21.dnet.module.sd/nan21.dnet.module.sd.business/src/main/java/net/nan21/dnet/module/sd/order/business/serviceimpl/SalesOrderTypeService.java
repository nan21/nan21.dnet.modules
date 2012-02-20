/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;

public class SalesOrderTypeService extends
        AbstractEntityService<SalesOrderType> implements ISalesOrderTypeService {

    public SalesOrderTypeService() {
        super();
    }

    public SalesOrderTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderType> getEntityClass() {
        return SalesOrderType.class;
    }

    public SalesOrderType findByName(String name) {
        return (SalesOrderType) this.em
                .createNamedQuery(SalesOrderType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

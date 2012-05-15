/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.business.service.IAccItemService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItem;

public class AccItemService extends AbstractEntityService<AccItem> implements
        IAccItemService {

    public AccItemService() {
        super();
    }

    public AccItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccItem> getEntityClass() {
        return AccItem.class;
    }

    public AccItem findByName(String name) {
        return (AccItem) this.em.createNamedQuery(AccItem.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

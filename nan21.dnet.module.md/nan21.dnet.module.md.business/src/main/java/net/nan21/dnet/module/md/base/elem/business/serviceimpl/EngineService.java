/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.elem.business.service.IEngineService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.elem.domain.entity.Engine;

public class EngineService extends AbstractEntityService<Engine> implements
        IEngineService {

    public EngineService() {
        super();
    }

    public EngineService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Engine> getEntityClass() {
        return Engine.class;
    }

    public Engine findByName(String name) {
        return (Engine) this.em.createNamedQuery(Engine.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

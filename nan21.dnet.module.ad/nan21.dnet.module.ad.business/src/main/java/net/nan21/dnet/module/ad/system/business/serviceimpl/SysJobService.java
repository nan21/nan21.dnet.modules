/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysJobService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

public class SysJobService extends AbstractEntityService<SysJob> implements
        ISysJobService {

    public SysJobService() {
        super();
    }

    public SysJobService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysJob> getEntityClass() {
        return SysJob.class;
    }

    public SysJob findByName(String name) {
        return (SysJob) this.em.createNamedQuery(SysJob.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public SysJob findByJclass(String javaClass) {
        return (SysJob) this.em.createNamedQuery(SysJob.NQ_FIND_BY_JCLASS)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJavaClass", javaClass).getSingleResult();
    }

}

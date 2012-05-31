/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

public class SysTimerService extends AbstractEntityService<SysTimer> {

    public SysTimerService() {
        super();
    }

    public SysTimerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysTimer> getEntityClass() {
        return SysTimer.class;
    }

    public SysTimer findByName(SysJobCtx jobCtx, String name) {
        return (SysTimer) this.em.createNamedQuery(SysTimer.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobCtx", jobCtx).setParameter("pName", name)
                .getSingleResult();
    }

    public SysTimer findByName(Long jobCtxId, String name) {
        return (SysTimer) this.em
                .createNamedQuery(SysTimer.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobCtxId", jobCtxId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<SysTimer> findByJobCtx(SysJobCtx jobCtx) {
        return this.findByJobCtxId(jobCtx.getId());
    }

    public List<SysTimer> findByJobCtxId(Long jobCtxId) {
        return (List<SysTimer>) this.em
                .createQuery(
                        "select e from SysTimer e where e.clientId = :pClientId and e.jobCtx.id = :pJobCtxId",
                        SysTimer.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobCtxId", jobCtxId).getResultList();
    }

}

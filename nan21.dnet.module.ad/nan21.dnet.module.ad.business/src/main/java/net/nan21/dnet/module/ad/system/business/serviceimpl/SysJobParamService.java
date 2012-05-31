/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysJobParamService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

public class SysJobParamService extends AbstractEntityService<SysJobParam>
        implements ISysJobParamService {

    public SysJobParamService() {
        super();
    }

    public SysJobParamService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysJobParam> getEntityClass() {
        return SysJobParam.class;
    }

    public SysJobParam findByName(SysJob job, String name) {
        return (SysJobParam) this.em
                .createNamedQuery(SysJobParam.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJob", job).setParameter("pName", name)
                .getSingleResult();
    }

    public SysJobParam findByName(Long jobId, String name) {
        return (SysJobParam) this.em
                .createNamedQuery(SysJobParam.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).setParameter("pName", name)
                .getSingleResult();
    }

    public List<SysJobParam> findByJob(SysJob job) {
        return this.findByJobId(job.getId());
    }

    public List<SysJobParam> findByJobId(Long jobId) {
        return (List<SysJobParam>) this.em
                .createQuery(
                        "select e from SysJobParam e where e.clientId = :pClientId and e.job.id = :pJobId",
                        SysJobParam.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).getResultList();
    }

}

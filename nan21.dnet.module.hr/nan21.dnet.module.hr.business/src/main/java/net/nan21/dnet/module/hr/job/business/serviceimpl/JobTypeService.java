/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IJobTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

public class JobTypeService extends AbstractEntityService<JobType> implements
        IJobTypeService {

    public JobTypeService() {
        super();
    }

    public JobTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<JobType> getEntityClass() {
        return JobType.class;
    }

    public JobType findByName(String name) {
        return (JobType) this.em.createNamedQuery(JobType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

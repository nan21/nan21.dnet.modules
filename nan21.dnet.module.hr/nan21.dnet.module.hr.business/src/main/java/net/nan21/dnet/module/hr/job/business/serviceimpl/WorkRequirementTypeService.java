/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

public class WorkRequirementTypeService extends
        AbstractEntityService<WorkRequirementType> implements
        IWorkRequirementTypeService {

    public WorkRequirementTypeService() {
        super();
    }

    public WorkRequirementTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WorkRequirementType> getEntityClass() {
        return WorkRequirementType.class;
    }

    public WorkRequirementType findByName(String name) {
        return (WorkRequirementType) this.em
                .createNamedQuery(WorkRequirementType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

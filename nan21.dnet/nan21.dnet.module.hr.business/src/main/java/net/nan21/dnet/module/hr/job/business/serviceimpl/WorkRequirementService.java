/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

public class WorkRequirementService extends
        AbstractEntityService<WorkRequirement> implements
        IWorkRequirementService {

    public WorkRequirementService() {
        super();
    }

    public WorkRequirementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WorkRequirement> getEntityClass() {
        return WorkRequirement.class;
    }

    public WorkRequirement findByName(Long clientId, String name) {
        return (WorkRequirement) this.em
                .createNamedQuery(WorkRequirement.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<WorkRequirement> findByType(WorkRequirementType type) {
        return this.findByTypeId(type.getId());
    }

    public List<WorkRequirement> findByTypeId(Long typeId) {
        return (List<WorkRequirement>) this.em
                .createQuery(
                        "select e from WorkRequirement e where e.type.id = :pTypeId",
                        WorkRequirement.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}

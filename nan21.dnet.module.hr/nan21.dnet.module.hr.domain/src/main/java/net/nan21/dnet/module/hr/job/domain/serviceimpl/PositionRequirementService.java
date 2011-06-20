/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import net.nan21.dnet.module.hr.job.domain.service.IPositionRequirementService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;

public class PositionRequirementService extends
        AbstractEntityService<PositionRequirement> implements
        IPositionRequirementService {

    public PositionRequirementService() {
        super();
    }

    public PositionRequirementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PositionRequirement> getEntityClass() {
        return PositionRequirement.class;
    }

    public List<PositionRequirement> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<PositionRequirement> findByPositionId(Long positionId) {
        return (List<PositionRequirement>) this.em
                .createQuery(
                        "select e from PositionRequirement where e.position.id = :pPositionId",
                        PositionRequirement.class)
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<PositionRequirement> findByRequirement(
            WorkRequirement requirement) {
        return this.findByRequirementId(requirement.getId());
    }

    public List<PositionRequirement> findByRequirementId(Long requirementId) {
        return (List<PositionRequirement>) this.em
                .createQuery(
                        "select e from PositionRequirement where e.requirement.id = :pRequirementId",
                        PositionRequirement.class)
                .setParameter("pRequirementId", requirementId).getResultList();
    }

}

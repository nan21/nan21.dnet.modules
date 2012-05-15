/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;

public interface IPositionRequirementService extends
        IEntityService<PositionRequirement> {

    public List<PositionRequirement> findByPosition(Position position);

    public List<PositionRequirement> findByPositionId(Long positionId);

    public List<PositionRequirement> findByRequirement(
            WorkRequirement requirement);

    public List<PositionRequirement> findByRequirementId(Long requirementId);

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

public interface IWorkRequirementService extends
        IEntityService<WorkRequirement> {

    public WorkRequirement findByName(String name);

    public List<WorkRequirement> findByType(WorkRequirementType type);

    public List<WorkRequirement> findByTypeId(Long typeId);

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

public interface IWorkRequirementTypeService extends
        IEntityService<WorkRequirementType> {

    public WorkRequirementType findByName(String name);

}

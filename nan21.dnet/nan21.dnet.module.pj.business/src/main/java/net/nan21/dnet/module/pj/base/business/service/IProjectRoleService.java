/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

public interface IProjectRoleService extends IEntityService<ProjectRole> {

    public ProjectRole findByName(Long clientId, String name);

    public List<ProjectRole> findByProjectTypes(ProjectType projectTypes);

    public List<ProjectRole> findByProjectTypesId(Long projectTypesId);

}

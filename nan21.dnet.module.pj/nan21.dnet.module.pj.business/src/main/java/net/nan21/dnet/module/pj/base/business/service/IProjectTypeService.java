/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

public interface IProjectTypeService extends IEntityService<ProjectType> {

    public ProjectType findByName(Long clientId, String name);

    public List<ProjectType> findByCategory(ProjectCategory category);

    public List<ProjectType> findByCategoryId(Long categoryId);

    public List<ProjectType> findByProjectRoles(ProjectRole projectRoles);

    public List<ProjectType> findByProjectRolesId(Long projectRolesId);

    public List<ProjectType> findByItemTypes(ItemType itemTypes);

    public List<ProjectType> findByItemTypesId(Long itemTypesId);

}

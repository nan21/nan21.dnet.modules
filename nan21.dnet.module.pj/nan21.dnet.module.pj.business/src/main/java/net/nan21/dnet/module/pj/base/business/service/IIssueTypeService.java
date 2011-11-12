/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import net.nan21.dnet.module.pj.base.domain.entity.IssueType;

public interface IIssueTypeService extends IEntityService<IssueType> {

    public IssueType findByName(Long clientId, String name);

    public List<IssueType> findByCategory(IssueCategory category);

    public List<IssueType> findByCategoryId(Long categoryId);

    public List<IssueType> findByProjectTypes(ProjectType projectTypes);

    public List<IssueType> findByProjectTypesId(Long projectTypesId);

}

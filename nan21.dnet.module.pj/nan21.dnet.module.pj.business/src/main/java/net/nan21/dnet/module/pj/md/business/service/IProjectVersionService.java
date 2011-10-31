/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public interface IProjectVersionService extends IEntityService<ProjectVersion> {

    public ProjectVersion findByName(Long clientId, String name);

    public List<ProjectVersion> findByProject(Project project);

    public List<ProjectVersion> findByProjectId(Long projectId);

    public List<ProjectVersion> findByProjectVersion(
            ProjectVersion projectVersion);

    public List<ProjectVersion> findByProjectVersionId(Long projectVersionId);

    public List<ProjectVersion> findByAffectingItems(Item affectingItems);

    public List<ProjectVersion> findByAffectingItemsId(Long affectingItemsId);

}

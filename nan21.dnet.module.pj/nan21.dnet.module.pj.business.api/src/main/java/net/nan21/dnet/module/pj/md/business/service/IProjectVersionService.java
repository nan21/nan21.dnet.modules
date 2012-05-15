/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public interface IProjectVersionService extends IEntityService<ProjectVersion> {

    public ProjectVersion findByName(Project project, String name);

    public ProjectVersion findByName(Long projectId, String name);

    public List<ProjectVersion> findByProject(Project project);

    public List<ProjectVersion> findByProjectId(Long projectId);

    public List<ProjectVersion> findByAffectingIssues(Issue affectingIssues);

    public List<ProjectVersion> findByAffectingIssuesId(Long affectingIssuesId);

}

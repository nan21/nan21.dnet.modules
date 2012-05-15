/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

public interface IProjectComponentService extends
        IEntityService<ProjectComponent> {

    public ProjectComponent findByName(Project project, String name);

    public ProjectComponent findByName(Long projectId, String name);

    public List<ProjectComponent> findByComponentLead(Assignable componentLead);

    public List<ProjectComponent> findByComponentLeadId(Long componentLeadId);

    public List<ProjectComponent> findByProject(Project project);

    public List<ProjectComponent> findByProjectId(Long projectId);

    public List<ProjectComponent> findByAffectingIssues(Issue affectingIssues);

    public List<ProjectComponent> findByAffectingIssuesId(Long affectingIssuesId);

}

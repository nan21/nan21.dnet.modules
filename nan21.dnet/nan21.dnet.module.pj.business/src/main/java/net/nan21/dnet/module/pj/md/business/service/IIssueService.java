/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import net.nan21.dnet.module.pj.md.domain.entity.Issue;

public interface IIssueService extends IEntityService<Issue> {

    public Issue findByCode(Long clientId, String code);

    public List<Issue> findByProject(Project project);

    public List<Issue> findByProjectId(Long projectId);

    public List<Issue> findByStatus(IssueStatus status);

    public List<Issue> findByStatusId(Long statusId);

    public List<Issue> findByType(IssueType type);

    public List<Issue> findByTypeId(Long typeId);

    public List<Issue> findByPriority(IssuePriority priority);

    public List<Issue> findByPriorityId(Long priorityId);

    public List<Issue> findByResolution(IssueResolution resolution);

    public List<Issue> findByResolutionId(Long resolutionId);

    public List<Issue> findBySeverity(IssueSeverity severity);

    public List<Issue> findBySeverityId(Long severityId);

    public List<Issue> findByReportedVersion(ProjectVersion reportedVersion);

    public List<Issue> findByReportedVersionId(Long reportedVersionId);

    public List<Issue> findByTargetVersion(ProjectVersion targetVersion);

    public List<Issue> findByTargetVersionId(Long targetVersionId);

    public List<Issue> findByFixedInVersion(ProjectVersion fixedInVersion);

    public List<Issue> findByFixedInVersionId(Long fixedInVersionId);

    public List<Issue> findByAffectedVersions(ProjectVersion affectedVersions);

    public List<Issue> findByAffectedVersionsId(Long affectedVersionsId);

    public List<Issue> findByAffectedComponents(
            ProjectComponent affectedComponents);

    public List<Issue> findByAffectedComponentsId(Long affectedComponentsId);

    public List<Issue> findByAssignee(ProjectMember assignee);

    public List<Issue> findByAssigneeId(Long assigneeId);

    public List<Issue> findByAssigneeRole(ProjectRole assigneeRole);

    public List<Issue> findByAssigneeRoleId(Long assigneeRoleId);

}

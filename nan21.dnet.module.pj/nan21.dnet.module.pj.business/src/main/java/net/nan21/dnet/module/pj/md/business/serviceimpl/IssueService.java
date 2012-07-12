/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IIssueService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

public class IssueService extends AbstractEntityService<Issue> implements
        IIssueService {

    public IssueService() {
        super();
    }

    public IssueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Issue> getEntityClass() {
        return Issue.class;
    }

    public Issue findByCode(String code) {
        return (Issue) this.em.createNamedQuery(Issue.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public List<Issue> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<Issue> findByProjectId(Long projectId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.project.id = :pProjectId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProjectId", projectId).getResultList();
    }

    public List<Issue> findByStatus(IssueStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<Issue> findByStatusId(Long statusId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.status.id = :pStatusId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pStatusId", statusId).getResultList();
    }

    public List<Issue> findByType(IssueType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Issue> findByTypeId(Long typeId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<Issue> findByPriority(IssuePriority priority) {
        return this.findByPriorityId(priority.getId());
    }

    public List<Issue> findByPriorityId(Long priorityId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.priority.id = :pPriorityId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriorityId", priorityId).getResultList();
    }

    public List<Issue> findByResolution(IssueResolution resolution) {
        return this.findByResolutionId(resolution.getId());
    }

    public List<Issue> findByResolutionId(Long resolutionId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.resolution.id = :pResolutionId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pResolutionId", resolutionId).getResultList();
    }

    public List<Issue> findBySeverity(IssueSeverity severity) {
        return this.findBySeverityId(severity.getId());
    }

    public List<Issue> findBySeverityId(Long severityId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.severity.id = :pSeverityId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSeverityId", severityId).getResultList();
    }

    public List<Issue> findByReportedVersion(ProjectVersion reportedVersion) {
        return this.findByReportedVersionId(reportedVersion.getId());
    }

    public List<Issue> findByReportedVersionId(Long reportedVersionId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.reportedVersion.id = :pReportedVersionId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pReportedVersionId", reportedVersionId)
                .getResultList();
    }

    public List<Issue> findByTargetVersion(ProjectVersion targetVersion) {
        return this.findByTargetVersionId(targetVersion.getId());
    }

    public List<Issue> findByTargetVersionId(Long targetVersionId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.targetVersion.id = :pTargetVersionId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTargetVersionId", targetVersionId)
                .getResultList();
    }

    public List<Issue> findByFixedInVersion(ProjectVersion fixedInVersion) {
        return this.findByFixedInVersionId(fixedInVersion.getId());
    }

    public List<Issue> findByFixedInVersionId(Long fixedInVersionId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.fixedInVersion.id = :pFixedInVersionId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFixedInVersionId", fixedInVersionId)
                .getResultList();
    }

    public List<Issue> findByAssignee(ProjectMember assignee) {
        return this.findByAssigneeId(assignee.getId());
    }

    public List<Issue> findByAssigneeId(Long assigneeId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.assignee.id = :pAssigneeId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssigneeId", assigneeId).getResultList();
    }

    public List<Issue> findByAssigneeRole(ProjectRole assigneeRole) {
        return this.findByAssigneeRoleId(assigneeRole.getId());
    }

    public List<Issue> findByAssigneeRoleId(Long assigneeRoleId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select e from Issue e where e.clientId = :pClientId and e.assigneeRole.id = :pAssigneeRoleId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssigneeRoleId", assigneeRoleId)
                .getResultList();
    }

    public List<Issue> findByAffectedVersions(ProjectVersion affectedVersions) {
        return this.findByAffectedVersionsId(affectedVersions.getId());
    }

    public List<Issue> findByAffectedVersionsId(Long affectedVersionsId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select distinct e from Issue e , IN (e.affectedVersions) c where e.clientId = :pClientId and c.id = :pAffectedVersionsId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAffectedVersionsId", affectedVersionsId)
                .getResultList();
    }

    public List<Issue> findByAffectedComponents(
            ProjectComponent affectedComponents) {
        return this.findByAffectedComponentsId(affectedComponents.getId());
    }

    public List<Issue> findByAffectedComponentsId(Long affectedComponentsId) {
        return (List<Issue>) this.em
                .createQuery(
                        "select distinct e from Issue e , IN (e.affectedComponents) c where e.clientId = :pClientId and c.id = :pAffectedComponentsId",
                        Issue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAffectedComponentsId", affectedComponentsId)
                .getResultList();
    }

}

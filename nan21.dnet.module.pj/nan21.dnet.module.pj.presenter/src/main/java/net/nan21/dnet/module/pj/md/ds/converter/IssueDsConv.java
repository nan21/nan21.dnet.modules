/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IIssuePriorityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueResolutionService;
import net.nan21.dnet.module.pj.base.business.service.IIssueSeverityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueStatusService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTypeService;
import net.nan21.dnet.module.pj.base.business.service.IProjectRoleService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.business.service.IProjectVersionService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueDs;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

public class IssueDsConv extends AbstractDsConverter<IssueDs, Issue> implements
        IDsConverter<IssueDs, Issue> {

    protected void modelToEntityReferences(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getProjectId() != null) {
            if (e.getProject() == null
                    || !e.getProject().getId().equals(ds.getProjectId())) {
                e.setProject((Project) this.em.find(Project.class,
                        ds.getProjectId()));
            }
        } else {
            this.lookup_project_Project(ds, e);
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((IssueType) this.em.find(IssueType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_IssueType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((IssueStatus) this.em.find(IssueStatus.class,
                        ds.getStatusId()));
            }
        } else {
            this.lookup_status_IssueStatus(ds, e);
        }
        if (ds.getPriorityId() != null) {
            if (e.getPriority() == null
                    || !e.getPriority().getId().equals(ds.getPriorityId())) {
                e.setPriority((IssuePriority) this.em.find(IssuePriority.class,
                        ds.getPriorityId()));
            }
        } else {
            this.lookup_priority_IssuePriority(ds, e);
        }
        if (ds.getResolutionId() != null) {
            if (e.getResolution() == null
                    || !e.getResolution().getId().equals(ds.getResolutionId())) {
                e.setResolution((IssueResolution) this.em.find(
                        IssueResolution.class, ds.getResolutionId()));
            }
        } else {
            this.lookup_resolution_IssueResolution(ds, e);
        }
        if (ds.getSeverityId() != null) {
            if (e.getSeverity() == null
                    || !e.getSeverity().getId().equals(ds.getSeverityId())) {
                e.setSeverity((IssueSeverity) this.em.find(IssueSeverity.class,
                        ds.getSeverityId()));
            }
        } else {
            this.lookup_severity_IssueSeverity(ds, e);
        }
        if (ds.getAssigneeId() != null) {
            if (e.getAssignee() == null
                    || !e.getAssignee().getId().equals(ds.getAssigneeId())) {
                e.setAssignee((ProjectMember) this.em.find(ProjectMember.class,
                        ds.getAssigneeId()));
            }
        }
        if (ds.getAssigneeRoleId() != null) {
            if (e.getAssigneeRole() == null
                    || !e.getAssigneeRole().getId()
                            .equals(ds.getAssigneeRoleId())) {
                e.setAssigneeRole((ProjectRole) this.em.find(ProjectRole.class,
                        ds.getAssigneeRoleId()));
            }
        } else {
            this.lookup_assigneeRole_ProjectRole(ds, e);
        }
        if (ds.getReportedVersionId() != null) {
            if (e.getReportedVersion() == null
                    || !e.getReportedVersion().getId()
                            .equals(ds.getReportedVersionId())) {
                e.setReportedVersion((ProjectVersion) this.em.find(
                        ProjectVersion.class, ds.getReportedVersionId()));
            }
        } else {
            this.lookup_reportedVersion_ProjectVersion(ds, e);
        }
        if (ds.getTargetVersionId() != null) {
            if (e.getTargetVersion() == null
                    || !e.getTargetVersion().getId()
                            .equals(ds.getTargetVersionId())) {
                e.setTargetVersion((ProjectVersion) this.em.find(
                        ProjectVersion.class, ds.getTargetVersionId()));
            }
        } else {
            this.lookup_targetVersion_ProjectVersion(ds, e);
        }
        if (ds.getFixedInVersionId() != null) {
            if (e.getFixedInVersion() == null
                    || !e.getFixedInVersion().getId()
                            .equals(ds.getFixedInVersionId())) {
                e.setFixedInVersion((ProjectVersion) this.em.find(
                        ProjectVersion.class, ds.getFixedInVersionId()));
            }
        } else {
            this.lookup_fixedInVersion_ProjectVersion(ds, e);
        }
    }

    protected void lookup_project_Project(IssueDs ds, Issue e) throws Exception {
        if (ds.getProject() != null && !ds.getProject().equals("")) {
            Project x = null;
            try {
                x = ((IProjectService) findEntityService(Project.class))
                        .findByCode(ds.getClientId(), ds.getProject());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Project` reference:  `project` = "
                                + ds.getProject() + "  ");
            }
            e.setProject(x);
            ds.setProjectId(x.getId());
        } else {
            e.setProject(null);
        }
    }

    protected void lookup_type_IssueType(IssueDs ds, Issue e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            IssueType x = null;
            try {
                x = ((IIssueTypeService) findEntityService(IssueType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_IssueStatus(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            IssueStatus x = null;
            try {
                x = ((IIssueStatusService) findEntityService(IssueStatus.class))
                        .findByName(ds.getClientId(), ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
        }
    }

    protected void lookup_priority_IssuePriority(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getPriority() != null && !ds.getPriority().equals("")) {
            IssuePriority x = null;
            try {
                x = ((IIssuePriorityService) findEntityService(IssuePriority.class))
                        .findByName(ds.getClientId(), ds.getPriority());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssuePriority` reference:  `priority` = "
                                + ds.getPriority() + "  ");
            }
            e.setPriority(x);

        } else {
            e.setPriority(null);
        }
    }

    protected void lookup_resolution_IssueResolution(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getResolution() != null && !ds.getResolution().equals("")) {
            IssueResolution x = null;
            try {
                x = ((IIssueResolutionService) findEntityService(IssueResolution.class))
                        .findByName(ds.getClientId(), ds.getResolution());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueResolution` reference:  `resolution` = "
                                + ds.getResolution() + "  ");
            }
            e.setResolution(x);

        } else {
            e.setResolution(null);
        }
    }

    protected void lookup_severity_IssueSeverity(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getSeverity() != null && !ds.getSeverity().equals("")) {
            IssueSeverity x = null;
            try {
                x = ((IIssueSeverityService) findEntityService(IssueSeverity.class))
                        .findByName(ds.getClientId(), ds.getSeverity());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueSeverity` reference:  `severity` = "
                                + ds.getSeverity() + "  ");
            }
            e.setSeverity(x);

        } else {
            e.setSeverity(null);
        }
    }

    protected void lookup_assigneeRole_ProjectRole(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getAssigneeRole() != null && !ds.getAssigneeRole().equals("")) {
            ProjectRole x = null;
            try {
                x = ((IProjectRoleService) findEntityService(ProjectRole.class))
                        .findByName(ds.getClientId(), ds.getAssigneeRole());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectRole` reference:  `assigneeRole` = "
                                + ds.getAssigneeRole() + "  ");
            }
            e.setAssigneeRole(x);

        } else {
            e.setAssigneeRole(null);
        }
    }

    protected void lookup_reportedVersion_ProjectVersion(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getProjectId() != null && !ds.getProjectId().equals("")
                && ds.getReportedVersion() != null
                && !ds.getReportedVersion().equals("")) {
            ProjectVersion x = null;
            try {
                x = ((IProjectVersionService) findEntityService(ProjectVersion.class))
                        .findByName(ds.getClientId(), ds.getProjectId(),
                                ds.getReportedVersion());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectVersion` reference:  `projectId` = "
                                + ds.getProjectId() + " , `reportedVersion` = "
                                + ds.getReportedVersion() + "  ");
            }
            e.setReportedVersion(x);

        } else {
            e.setReportedVersion(null);
        }
    }

    protected void lookup_targetVersion_ProjectVersion(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getProjectId() != null && !ds.getProjectId().equals("")
                && ds.getTargetVersion() != null
                && !ds.getTargetVersion().equals("")) {
            ProjectVersion x = null;
            try {
                x = ((IProjectVersionService) findEntityService(ProjectVersion.class))
                        .findByName(ds.getClientId(), ds.getProjectId(),
                                ds.getTargetVersion());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectVersion` reference:  `projectId` = "
                                + ds.getProjectId() + " , `targetVersion` = "
                                + ds.getTargetVersion() + "  ");
            }
            e.setTargetVersion(x);

        } else {
            e.setTargetVersion(null);
        }
    }

    protected void lookup_fixedInVersion_ProjectVersion(IssueDs ds, Issue e)
            throws Exception {
        if (ds.getProjectId() != null && !ds.getProjectId().equals("")
                && ds.getFixedInVersion() != null
                && !ds.getFixedInVersion().equals("")) {
            ProjectVersion x = null;
            try {
                x = ((IProjectVersionService) findEntityService(ProjectVersion.class))
                        .findByName(ds.getClientId(), ds.getProjectId(),
                                ds.getFixedInVersion());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectVersion` reference:  `projectId` = "
                                + ds.getProjectId() + " , `fixedInVersion` = "
                                + ds.getFixedInVersion() + "  ");
            }
            e.setFixedInVersion(x);

        } else {
            e.setFixedInVersion(null);
        }
    }

}

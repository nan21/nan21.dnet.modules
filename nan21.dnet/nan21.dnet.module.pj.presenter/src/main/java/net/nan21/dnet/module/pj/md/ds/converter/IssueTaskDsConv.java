/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskStatusService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.business.service.IIssueService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs;
import net.nan21.dnet.module.pj.md.domain.entity.IssueTask;

public class IssueTaskDsConv extends
        AbstractDsConverter<IssueTaskDs, IssueTask> implements
        IDsConverter<IssueTaskDs, IssueTask> {

    protected void modelToEntityReferences(IssueTaskDs ds, IssueTask e)
            throws Exception {
        if (ds.getIssueId() != null) {
            if (e.getIssue() == null
                    || !e.getIssue().getId().equals(ds.getIssueId())) {
                e.setIssue((Issue) this.em.find(Issue.class, ds.getIssueId()));
            }
        } else {
            this.lookup_issue_Issue(ds, e);
        }
        if (ds.getAssigneeId() != null) {
            if (e.getAssignee() == null
                    || !e.getAssignee().getId().equals(ds.getAssigneeId())) {
                e.setAssignee((ProjectMember) this.em.find(ProjectMember.class,
                        ds.getAssigneeId()));
            }
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((IssueTaskType) this.em.find(IssueTaskType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_IssueTaskType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((IssueTaskStatus) this.em.find(
                        IssueTaskStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_IssueTaskStatus(ds, e);
        }
    }

    protected void lookup_issue_Issue(IssueTaskDs ds, IssueTask e)
            throws Exception {
        if (ds.getIssue() != null && !ds.getIssue().equals("")) {
            Issue x = null;
            try {
                x = ((IIssueService) findEntityService(Issue.class))
                        .findByCode(ds.getClientId(), ds.getIssue());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Issue` reference:  `issue` = "
                                + ds.getIssue() + "  ");
            }
            e.setIssue(x);

        } else {
            e.setIssue(null);
        }
    }

    protected void lookup_type_IssueTaskType(IssueTaskDs ds, IssueTask e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            IssueTaskType x = null;
            try {
                x = ((IIssueTaskTypeService) findEntityService(IssueTaskType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueTaskType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_IssueTaskStatus(IssueTaskDs ds, IssueTask e)
            throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            IssueTaskStatus x = null;
            try {
                x = ((IIssueTaskStatusService) findEntityService(IssueTaskStatus.class))
                        .findByName(ds.getClientId(), ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueTaskStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
        }
    }

}

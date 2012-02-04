/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.module.pj.md.domain.entity.IssueTask;

public interface IIssueTaskService extends IEntityService<IssueTask> {

    public List<IssueTask> findByIssue(Issue issue);

    public List<IssueTask> findByIssueId(Long issueId);

    public List<IssueTask> findByType(IssueTaskType type);

    public List<IssueTask> findByTypeId(Long typeId);

    public List<IssueTask> findByStatus(IssueTaskStatus status);

    public List<IssueTask> findByStatusId(Long statusId);

    public List<IssueTask> findByAssignee(ProjectMember assignee);

    public List<IssueTask> findByAssigneeId(Long assigneeId);

}

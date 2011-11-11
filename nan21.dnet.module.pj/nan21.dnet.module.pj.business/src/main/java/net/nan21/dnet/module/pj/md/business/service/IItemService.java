/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import net.nan21.dnet.module.pj.md.domain.entity.Item;

public interface IItemService extends IEntityService<Item> {

    public Item findByCode(Long clientId, String code);

    public List<Item> findByProject(Project project);

    public List<Item> findByProjectId(Long projectId);

    public List<Item> findByStatus(ItemStatus status);

    public List<Item> findByStatusId(Long statusId);

    public List<Item> findByType(ItemType type);

    public List<Item> findByTypeId(Long typeId);

    public List<Item> findByPriority(ItemPriority priority);

    public List<Item> findByPriorityId(Long priorityId);

    public List<Item> findByResolution(ItemResolution resolution);

    public List<Item> findByResolutionId(Long resolutionId);

    public List<Item> findBySeverity(ItemSeverity severity);

    public List<Item> findBySeverityId(Long severityId);

    public List<Item> findByReportedVersion(ProjectVersion reportedVersion);

    public List<Item> findByReportedVersionId(Long reportedVersionId);

    public List<Item> findByTargetVersion(ProjectVersion targetVersion);

    public List<Item> findByTargetVersionId(Long targetVersionId);

    public List<Item> findByFixedInVersion(ProjectVersion fixedInVersion);

    public List<Item> findByFixedInVersionId(Long fixedInVersionId);

    public List<Item> findByAffectedVersions(ProjectVersion affectedVersions);

    public List<Item> findByAffectedVersionsId(Long affectedVersionsId);

    public List<Item> findByAffectedComponents(
            ProjectComponent affectedComponents);

    public List<Item> findByAffectedComponentsId(Long affectedComponentsId);

    public List<Item> findByAssignee(ProjectMember assignee);

    public List<Item> findByAssigneeId(Long assigneeId);

    public List<Item> findByAssigneeRole(ProjectRole assigneeRole);

    public List<Item> findByAssigneeRoleId(Long assigneeRoleId);

}

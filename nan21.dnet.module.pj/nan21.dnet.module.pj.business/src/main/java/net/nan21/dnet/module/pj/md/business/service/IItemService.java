/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.module.pj.md.domain.entity.Item;

public interface IItemService extends IEntityService<Item> {

    public List<Item> findByProject(Project project);

    public List<Item> findByProjectId(Long projectId);

    public List<Item> findByItem(Item item);

    public List<Item> findByItemId(Long itemId);

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

    public List<Item> findByAssignee(Assignable assignee);

    public List<Item> findByAssigneeId(Long assigneeId);

    public List<Item> findByAssigneeRole(ProjectRole assigneeRole);

    public List<Item> findByAssigneeRoleId(Long assigneeRoleId);

}

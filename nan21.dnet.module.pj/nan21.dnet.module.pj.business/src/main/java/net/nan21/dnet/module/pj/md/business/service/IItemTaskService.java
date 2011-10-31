/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskType;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.module.pj.md.domain.entity.ItemTask;

public interface IItemTaskService extends IEntityService<ItemTask> {

    public List<ItemTask> findByItem(Item item);

    public List<ItemTask> findByItemId(Long itemId);

    public List<ItemTask> findByType(ItemTaskType type);

    public List<ItemTask> findByTypeId(Long typeId);

    public List<ItemTask> findByStatus(ItemTaskStatus status);

    public List<ItemTask> findByStatusId(Long statusId);

    public List<ItemTask> findByAssignee(ProjectMember assignee);

    public List<ItemTask> findByAssigneeId(Long assigneeId);

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskType;
import net.nan21.dnet.module.pj.md.business.service.IItemTaskService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ItemTask;

public class ItemTaskService extends AbstractEntityService<ItemTask> implements
        IItemTaskService {

    public ItemTaskService() {
        super();
    }

    public ItemTaskService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemTask> getEntityClass() {
        return ItemTask.class;
    }

    public List<ItemTask> findByItem(Item item) {
        return this.findByItemId(item.getId());
    }

    public List<ItemTask> findByItemId(Long itemId) {
        return (List<ItemTask>) this.em
                .createQuery(
                        "select e from ItemTask e where e.item.id = :pItemId",
                        ItemTask.class).setParameter("pItemId", itemId)
                .getResultList();
    }

    public List<ItemTask> findByType(ItemTaskType type) {
        return this.findByTypeId(type.getId());
    }

    public List<ItemTask> findByTypeId(Long typeId) {
        return (List<ItemTask>) this.em
                .createQuery(
                        "select e from ItemTask e where e.type.id = :pTypeId",
                        ItemTask.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<ItemTask> findByStatus(ItemTaskStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<ItemTask> findByStatusId(Long statusId) {
        return (List<ItemTask>) this.em
                .createQuery(
                        "select e from ItemTask e where e.status.id = :pStatusId",
                        ItemTask.class).setParameter("pStatusId", statusId)
                .getResultList();
    }

    public List<ItemTask> findByAssignee(ProjectMember assignee) {
        return this.findByAssigneeId(assignee.getId());
    }

    public List<ItemTask> findByAssigneeId(Long assigneeId) {
        return (List<ItemTask>) this.em
                .createQuery(
                        "select e from ItemTask e where e.assignee.id = :pAssigneeId",
                        ItemTask.class).setParameter("pAssigneeId", assigneeId)
                .getResultList();
    }

}

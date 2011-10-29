/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IItemService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

public class ItemService extends AbstractEntityService<Item> implements
        IItemService {

    public ItemService() {
        super();
    }

    public ItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Item> getEntityClass() {
        return Item.class;
    }

    public List<Item> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<Item> findByProjectId(Long projectId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.project.id = :pProjectId",
                        Item.class).setParameter("pProjectId", projectId)
                .getResultList();
    }

    public List<Item> findByItem(Item item) {
        return this.findByItemId(item.getId());
    }

    public List<Item> findByItemId(Long itemId) {
        return (List<Item>) this.em
                .createQuery("select e from Item e where e.item.id = :pItemId",
                        Item.class).setParameter("pItemId", itemId)
                .getResultList();
    }

    public List<Item> findByStatus(ItemStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<Item> findByStatusId(Long statusId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.status.id = :pStatusId",
                        Item.class).setParameter("pStatusId", statusId)
                .getResultList();
    }

    public List<Item> findByType(ItemType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Item> findByTypeId(Long typeId) {
        return (List<Item>) this.em
                .createQuery("select e from Item e where e.type.id = :pTypeId",
                        Item.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<Item> findByPriority(ItemPriority priority) {
        return this.findByPriorityId(priority.getId());
    }

    public List<Item> findByPriorityId(Long priorityId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.priority.id = :pPriorityId",
                        Item.class).setParameter("pPriorityId", priorityId)
                .getResultList();
    }

    public List<Item> findByResolution(ItemResolution resolution) {
        return this.findByResolutionId(resolution.getId());
    }

    public List<Item> findByResolutionId(Long resolutionId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.resolution.id = :pResolutionId",
                        Item.class).setParameter("pResolutionId", resolutionId)
                .getResultList();
    }

    public List<Item> findBySeverity(ItemSeverity severity) {
        return this.findBySeverityId(severity.getId());
    }

    public List<Item> findBySeverityId(Long severityId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.severity.id = :pSeverityId",
                        Item.class).setParameter("pSeverityId", severityId)
                .getResultList();
    }

    public List<Item> findByAssignee(Assignable assignee) {
        return this.findByAssigneeId(assignee.getId());
    }

    public List<Item> findByAssigneeId(Long assigneeId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.assignee.id = :pAssigneeId",
                        Item.class).setParameter("pAssigneeId", assigneeId)
                .getResultList();
    }

    public List<Item> findByAssigneeRole(ProjectRole assigneeRole) {
        return this.findByAssigneeRoleId(assigneeRole.getId());
    }

    public List<Item> findByAssigneeRoleId(Long assigneeRoleId) {
        return (List<Item>) this.em
                .createQuery(
                        "select e from Item e where e.assigneeRole.id = :pAssigneeRoleId",
                        Item.class)
                .setParameter("pAssigneeRoleId", assigneeRoleId)
                .getResultList();
    }

}

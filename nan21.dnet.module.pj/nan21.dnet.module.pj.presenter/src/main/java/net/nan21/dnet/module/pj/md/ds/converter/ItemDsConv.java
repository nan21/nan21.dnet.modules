/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.business.service.IItemPriorityService;
import net.nan21.dnet.module.pj.base.business.service.IItemResolutionService;
import net.nan21.dnet.module.pj.base.business.service.IItemSeverityService;
import net.nan21.dnet.module.pj.base.business.service.IItemStatusService;
import net.nan21.dnet.module.pj.base.business.service.IItemTypeService;
import net.nan21.dnet.module.pj.base.business.service.IProjectRoleService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ItemDs;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

public class ItemDsConv extends AbstractDsConverter<ItemDs, Item> implements
        IDsConverter<ItemDs, Item> {

    protected void modelToEntityAttributes(ItemDs ds, Item e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setInstanceType(ds.getInstanceType());
        e.setSummary(ds.getSummary());
        e.setDueDate(ds.getDueDate());
        e.setResolutionDate(ds.getResolutionDate());
    }

    protected void modelToEntityReferences(ItemDs ds, Item e) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ItemType) this.em.find(ItemType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ItemType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((ItemStatus) this.em.find(ItemStatus.class,
                        ds.getStatusId()));
            }
        } else {
            this.lookup_status_ItemStatus(ds, e);
        }
        if (ds.getPriorityId() != null) {
            if (e.getPriority() == null
                    || !e.getPriority().getId().equals(ds.getPriorityId())) {
                e.setPriority((ItemPriority) this.em.find(ItemPriority.class,
                        ds.getPriorityId()));
            }
        } else {
            this.lookup_priority_ItemPriority(ds, e);
        }
        if (ds.getResolutionId() != null) {
            if (e.getResolution() == null
                    || !e.getResolution().getId().equals(ds.getResolutionId())) {
                e.setResolution((ItemResolution) this.em.find(
                        ItemResolution.class, ds.getResolutionId()));
            }
        } else {
            this.lookup_resolution_ItemResolution(ds, e);
        }
        if (ds.getSeverityId() != null) {
            if (e.getSeverity() == null
                    || !e.getSeverity().getId().equals(ds.getSeverityId())) {
                e.setSeverity((ItemSeverity) this.em.find(ItemSeverity.class,
                        ds.getSeverityId()));
            }
        } else {
            this.lookup_severity_ItemSeverity(ds, e);
        }
        if (ds.getAssigneeId() != null) {
            if (e.getAssignee() == null
                    || !e.getAssignee().getId().equals(ds.getAssigneeId())) {
                e.setAssignee((Assignable) this.em.find(Assignable.class,
                        ds.getAssigneeId()));
            }
        } else {
            this.lookup_assignee_Assignable(ds, e);
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
    }

    protected void lookup_type_ItemType(ItemDs ds, Item e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ItemType x = null;
            try {
                x = ((IItemTypeService) getService(IItemTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_ItemStatus(ItemDs ds, Item e) throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            ItemStatus x = null;
            try {
                x = ((IItemStatusService) getService(IItemStatusService.class))
                        .findByName(ds.getClientId(), ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);
        } else {
            e.setStatus(null);
        }
    }

    protected void lookup_priority_ItemPriority(ItemDs ds, Item e)
            throws Exception {
        if (ds.getPriority() != null && !ds.getPriority().equals("")) {
            ItemPriority x = null;
            try {
                x = ((IItemPriorityService) getService(IItemPriorityService.class))
                        .findByName(ds.getClientId(), ds.getPriority());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemPriority` reference:  `priority` = "
                                + ds.getPriority() + "  ");
            }
            e.setPriority(x);
        } else {
            e.setPriority(null);
        }
    }

    protected void lookup_resolution_ItemResolution(ItemDs ds, Item e)
            throws Exception {
        if (ds.getResolution() != null && !ds.getResolution().equals("")) {
            ItemResolution x = null;
            try {
                x = ((IItemResolutionService) getService(IItemResolutionService.class))
                        .findByName(ds.getClientId(), ds.getResolution());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemResolution` reference:  `resolution` = "
                                + ds.getResolution() + "  ");
            }
            e.setResolution(x);
        } else {
            e.setResolution(null);
        }
    }

    protected void lookup_severity_ItemSeverity(ItemDs ds, Item e)
            throws Exception {
        if (ds.getSeverity() != null && !ds.getSeverity().equals("")) {
            ItemSeverity x = null;
            try {
                x = ((IItemSeverityService) getService(IItemSeverityService.class))
                        .findByName(ds.getClientId(), ds.getSeverity());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemSeverity` reference:  `severity` = "
                                + ds.getSeverity() + "  ");
            }
            e.setSeverity(x);
        } else {
            e.setSeverity(null);
        }
    }

    protected void lookup_assignee_Assignable(ItemDs ds, Item e)
            throws Exception {
        if (ds.getAssignee() != null && !ds.getAssignee().equals("")) {
            Assignable x = null;
            try {
                x = ((IAssignableService) getService(IAssignableService.class))
                        .findByName(ds.getClientId(), ds.getAssignee());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Assignable` reference:  `assignee` = "
                                + ds.getAssignee() + "  ");
            }
            e.setAssignee(x);
        } else {
            e.setAssignee(null);
        }
    }

    protected void lookup_assigneeRole_ProjectRole(ItemDs ds, Item e)
            throws Exception {
        if (ds.getAssigneeRole() != null && !ds.getAssigneeRole().equals("")) {
            ProjectRole x = null;
            try {
                x = ((IProjectRoleService) getService(IProjectRoleService.class))
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

    @Override
    public void entityToModel(Item e, ItemDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setInstanceType(e.getInstanceType());
        ds.setSummary(e.getSummary());
        ds.setDueDate(e.getDueDate());
        ds.setResolutionDate(e.getResolutionDate());
        ds.setProjectId(((e.getProject() != null)) ? e.getProject().getId()
                : null);
        ds.setProjectCode(((e.getProject() != null)) ? e.getProject().getCode()
                : null);
        ds.setProject(((e.getProject() != null)) ? e.getProject().getName()
                : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setStatusId(((e.getStatus() != null)) ? e.getStatus().getId() : null);
        ds.setStatus(((e.getStatus() != null)) ? e.getStatus().getName() : null);
        ds.setPriorityId(((e.getPriority() != null)) ? e.getPriority().getId()
                : null);
        ds.setPriority(((e.getPriority() != null)) ? e.getPriority().getName()
                : null);
        ds.setResolutionId(((e.getResolution() != null)) ? e.getResolution()
                .getId() : null);
        ds.setResolution(((e.getResolution() != null)) ? e.getResolution()
                .getName() : null);
        ds.setSeverityId(((e.getSeverity() != null)) ? e.getSeverity().getId()
                : null);
        ds.setSeverity(((e.getSeverity() != null)) ? e.getSeverity().getName()
                : null);
        ds.setAssigneeId(((e.getAssignee() != null)) ? e.getAssignee().getId()
                : null);
        ds.setAssignee(((e.getAssignee() != null)) ? e.getAssignee().getName()
                : null);
        ds.setAssigneeRoleId(((e.getAssigneeRole() != null)) ? e
                .getAssigneeRole().getId() : null);
        ds.setAssigneeRole(((e.getAssigneeRole() != null)) ? e
                .getAssigneeRole().getName() : null);
    }

}

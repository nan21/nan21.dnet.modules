/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IItemTaskStatusService;
import net.nan21.dnet.module.pj.base.business.service.IItemTaskTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskType;
import net.nan21.dnet.module.pj.md.business.service.IItemService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ItemTaskDs;
import net.nan21.dnet.module.pj.md.domain.entity.ItemTask;

public class ItemTaskDsConv extends AbstractDsConverter<ItemTaskDs, ItemTask>
        implements IDsConverter<ItemTaskDs, ItemTask> {

    protected void modelToEntityAttributes(ItemTaskDs ds, ItemTask e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSummary(ds.getSummary());
        e.setDescription(ds.getDescription());
    }

    protected void modelToEntityReferences(ItemTaskDs ds, ItemTask e)
            throws Exception {

        if (ds.getItemId() != null) {
            if (e.getItem() == null
                    || !e.getItem().getId().equals(ds.getItemId())) {
                e.setItem((Item) this.em.find(Item.class, ds.getItemId()));
            }
        } else {
            this.lookup_item_Item(ds, e);
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
                e.setType((ItemTaskType) this.em.find(ItemTaskType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ItemTaskType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((ItemTaskStatus) this.em.find(ItemTaskStatus.class,
                        ds.getStatusId()));
            }
        } else {
            this.lookup_status_ItemTaskStatus(ds, e);
        }
    }

    protected void lookup_item_Item(ItemTaskDs ds, ItemTask e) throws Exception {
        if (ds.getItem() != null && !ds.getItem().equals("")) {
            Item x = null;
            try {
                x = ((IItemService) getService(IItemService.class)).findByCode(
                        ds.getClientId(), ds.getItem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Item` reference:  `item` = "
                                + ds.getItem() + "  ");
            }
            e.setItem(x);
        } else {
            e.setItem(null);
        }
    }

    protected void lookup_type_ItemTaskType(ItemTaskDs ds, ItemTask e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ItemTaskType x = null;
            try {
                x = ((IItemTaskTypeService) getService(IItemTaskTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemTaskType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_ItemTaskStatus(ItemTaskDs ds, ItemTask e)
            throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            ItemTaskStatus x = null;
            try {
                x = ((IItemTaskStatusService) getService(IItemTaskStatusService.class))
                        .findByName(ds.getClientId(), ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemTaskStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);
        } else {
            e.setStatus(null);
        }
    }

    @Override
    public void entityToModel(ItemTask e, ItemTaskDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSummary(e.getSummary());
        ds.setDescription(e.getDescription());
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItem(((e.getItem() != null)) ? e.getItem().getCode() : null);
        ds.setItemSummary(((e.getItem() != null)) ? e.getItem().getSummary()
                : null);
        ds.setPriorityId(((e.getItem() != null) && (e.getItem().getPriority() != null)) ? e
                .getItem().getPriority().getId()
                : null);
        ds.setPriority(((e.getItem() != null) && (e.getItem().getPriority() != null)) ? e
                .getItem().getPriority().getName()
                : null);
        ds.setPrioritySequenceNo(((e.getItem() != null) && (e.getItem()
                .getPriority() != null)) ? e.getItem().getPriority()
                .getSequenceNo() : null);
        ds.setItemBusinessObject(((e.getItem() != null)) ? e.getItem()
                .getBusinessObject() : null);
        ds.setItemClassName(((e.getItem() != null)) ? e.getItem()
                .getClassName() : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setStatusId(((e.getStatus() != null)) ? e.getStatus().getId() : null);
        ds.setStatus(((e.getStatus() != null)) ? e.getStatus().getName() : null);
        ds.setAssigneeId(((e.getAssignee() != null)) ? e.getAssignee().getId()
                : null);
        ds.setAssignee(((e.getAssignee() != null) && (e.getAssignee()
                .getMember() != null)) ? e.getAssignee().getMember().getName()
                : null);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfAvailableTaskDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfTaskInstance;

public class WfAvailableTaskDsConv extends
        AbstractDsConverter<WfAvailableTaskDs, WfTaskInstance> implements
        IDsConverter<WfAvailableTaskDs, WfTaskInstance> {

    protected void modelToEntityAttributes(WfAvailableTaskDs ds,
            WfTaskInstance e) throws Exception {
        e.setProcessId(ds.getProcessId());
        e.setTaskKey(ds.getTaskKey());
        e.setProcessInstanceId(ds.getProcessInstanceId());
        e.setExecutionId(ds.getExecutionId());
        e.setName(ds.getName());
        e.setDescription(ds.getDescription());
        e.setAssignee(ds.getOwner());
        e.setStartTime(ds.getStartTime());
        e.setEndTime(ds.getEndTime());
        e.setDuration(ds.getDuration());
        e.setDeleteReason(ds.getDeleteReason());
        e.setPriority(ds.getPriority());
        e.setDueDate(ds.getDueDate());
    }

    protected void modelToEntityReferences(WfAvailableTaskDs ds,
            WfTaskInstance e) throws Exception {
    }

    @Override
    public void entityToModel(WfTaskInstance e, WfAvailableTaskDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setProcessId(e.getProcessId());
        ds.setTaskKey(e.getTaskKey());
        ds.setProcessInstanceId(e.getProcessInstanceId());
        ds.setExecutionId(e.getExecutionId());
        ds.setName(e.getName());
        ds.setDescription(e.getDescription());
        ds.setOwner(e.getAssignee());
        ds.setStartTime(e.getStartTime());
        ds.setEndTime(e.getEndTime());
        ds.setDuration(e.getDuration());
        ds.setDeleteReason(e.getDeleteReason());
        ds.setPriority(e.getPriority());
        ds.setDueDate(e.getDueDate());
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

public class ActTaskInstanceHistoryDsConv extends
        AbstractDsConverter<ActTaskInstanceHistoryDs, ActTaskInstanceHistory>
        implements
        IDsConverter<ActTaskInstanceHistoryDs, ActTaskInstanceHistory> {

    protected void modelToEntityAttributes(ActTaskInstanceHistoryDs ds,
            ActTaskInstanceHistory e) throws Exception {
        e.setTaskDefinitionKey(ds.getTaskDefinitionKey());
        e.setProcessInstanceId(ds.getProcessInstanceId());
        e.setExecutionId(ds.getExecutionId());
        e.setName(ds.getName());
        e.setDescription(ds.getDescription());
        e.setAssignee(ds.getAssignee());
        e.setStartTime(ds.getStartTime());
        e.setEndTime(ds.getEndTime());
        e.setDuration(ds.getDuration());
        e.setDeleteReason(ds.getDeleteReason());
        e.setPriority(ds.getPriority());
        e.setDueDate(ds.getDueDate());
    }

    protected void modelToEntityReferences(ActTaskInstanceHistoryDs ds,
            ActTaskInstanceHistory e) throws Exception {
    }

    @Override
    public void entityToModel(ActTaskInstanceHistory e,
            ActTaskInstanceHistoryDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setTaskDefinitionKey(e.getTaskDefinitionKey());
        ds.setProcessInstanceId(e.getProcessInstanceId());
        ds.setExecutionId(e.getExecutionId());
        ds.setName(e.getName());
        ds.setDescription(e.getDescription());
        ds.setAssignee(e.getAssignee());
        ds.setStartTime(e.getStartTime());
        ds.setEndTime(e.getEndTime());
        ds.setDuration(e.getDuration());
        ds.setDeleteReason(e.getDeleteReason());
        ds.setPriority(e.getPriority());
        ds.setDueDate(e.getDueDate());
        ds.setProcessDefinitionId(((e.getProcessDefinition() != null)) ? e
                .getProcessDefinition().getId() : null);
    }

}

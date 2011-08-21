/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

public class ActMyTaskDsConv extends AbstractDsConverter<ActMyTaskDs, ActTask>
        implements IDsConverter<ActMyTaskDs, ActTask> {

    protected void modelToEntityAttributes(ActMyTaskDs ds, ActTask e)
            throws Exception {
        e.setTaskDefinitionKey(ds.getTaskKey());
        e.setProcessInstanceId(ds.getProcessInstanceId());
        e.setExecutionId(ds.getExecutionId());
        e.setName(ds.getName());
        e.setDescription(ds.getDescription());
        e.setAssignee(ds.getOwner());
        e.setCreatedAt(ds.getStartTime());
        e.setPriority(ds.getPriority());
        e.setDueDate(ds.getDueDate());
    }

    protected void modelToEntityReferences(ActMyTaskDs ds, ActTask e)
            throws Exception {
    }

    @Override
    public void entityToModel(ActTask e, ActMyTaskDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setTaskKey(e.getTaskDefinitionKey());
        ds.setProcessInstanceId(e.getProcessInstanceId());
        ds.setExecutionId(e.getExecutionId());
        ds.setName(e.getName());
        ds.setDescription(e.getDescription());
        ds.setOwner(e.getAssignee());
        ds.setStartTime(e.getCreatedAt());
        ds.setPriority(e.getPriority());
        ds.setDueDate(e.getDueDate());
        ds.setProcessId(((e.getProcessDefinition() != null)) ? e
                .getProcessDefinition().getId() : null);
        ds.setProcess(((e.getProcessDefinition() != null)) ? e
                .getProcessDefinition().getName() : null);
    }

}

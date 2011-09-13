/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public class WfDefNodeDsConv extends
        AbstractDsConverter<WfDefNodeDs, WfDefNode> implements
        IDsConverter<WfDefNodeDs, WfDefNode> {

    protected void modelToEntityAttributes(WfDefNodeDs ds, WfDefNode e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setAssignToUser(ds.getAssignToUser());
        e.setAssignToGroup(ds.getAssignToGroup());
        e.setStartWithPrevious(ds.getStartWithPrevious());
        e.setTaskType(ds.getTaskType());
    }

    protected void modelToEntityReferences(WfDefNodeDs ds, WfDefNode e)
            throws Exception {

        if (ds.getProcessId() != null) {
            if (e.getProcess() == null
                    || !e.getProcess().getId().equals(ds.getProcessId())) {
                e.setProcess((WfDefProcess) this.em.find(WfDefProcess.class,
                        ds.getProcessId()));
            }
        }
    }

    @Override
    public void entityToModel(WfDefNode e, WfDefNodeDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setAssignToUser(e.getAssignToUser());
        ds.setAssignToGroup(e.getAssignToGroup());
        ds.setStartWithPrevious(e.getStartWithPrevious());
        ds.setTaskType(e.getTaskType());
        ds.setProcessId(((e.getProcess() != null)) ? e.getProcess().getId()
                : null);
        ds.setProcess(((e.getProcess() != null)) ? e.getProcess().getName()
                : null);
    }

}

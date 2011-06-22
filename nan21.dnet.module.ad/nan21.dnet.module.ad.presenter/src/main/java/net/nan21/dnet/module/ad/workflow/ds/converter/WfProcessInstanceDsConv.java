/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcessInstance;

public class WfProcessInstanceDsConv extends
        AbstractDsConverter<WfProcessInstanceDs, WfProcessInstance> implements
        IDsConverter<WfProcessInstanceDs, WfProcessInstance> {

    protected void modelToEntityAttributes(WfProcessInstanceDs ds,
            WfProcessInstance e) throws Exception {
        e.setProcessInstanceId(ds.getProcessInstanceId());
        e.setStartTime(ds.getStartTime());
        e.setEndTime(ds.getEndTime());
        e.setDuration(ds.getDuration());
        e.setStartedBy(ds.getStartedBy());
        e.setStartAction(ds.getStartAction());
        e.setEndAction(ds.getEndAction());
    }

    protected void modelToEntityReferences(WfProcessInstanceDs ds,
            WfProcessInstance e) throws Exception {
    }

    @Override
    public void entityToModel(WfProcessInstance e, WfProcessInstanceDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setProcessInstanceId(e.getProcessInstanceId());
        ds.setStartTime(e.getStartTime());
        ds.setEndTime(e.getEndTime());
        ds.setDuration(e.getDuration());
        ds.setStartedBy(e.getStartedBy());
        ds.setStartAction(e.getStartAction());
        ds.setEndAction(e.getEndAction());
        ds.setProcessId(((e.getProcess() != null)) ? e.getProcess().getId()
                : null);
        ds.setProcess(((e.getProcess() != null)) ? e.getProcess().getName()
                : null);
    }

}

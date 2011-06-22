/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceRunningDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcessInstance;

public class WfProcessInstanceRunningDsConv extends
        AbstractDsConverter<WfProcessInstanceRunningDs, WfProcessInstance>
        implements IDsConverter<WfProcessInstanceRunningDs, WfProcessInstance> {

    protected void modelToEntityAttributes(WfProcessInstanceRunningDs ds,
            WfProcessInstance e) throws Exception {
        e.setProcessInstanceId(ds.getProcessInstanceId());
        e.setStartTime(ds.getStartTime());
        e.setEndTime(ds.getEndTime());
        e.setDuration(ds.getDuration());
        e.setStartedBy(ds.getStartedBy());
        e.setStartAction(ds.getStartAction());
        e.setEndAction(ds.getEndAction());
    }

    protected void modelToEntityReferences(WfProcessInstanceRunningDs ds,
            WfProcessInstance e) throws Exception {
    }

    @Override
    public void entityToModel(WfProcessInstance e, WfProcessInstanceRunningDs ds)
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
        ds.setProcessVersion(((e.getProcess() != null)) ? e.getProcess()
                .getVersion() : null);
    }

}

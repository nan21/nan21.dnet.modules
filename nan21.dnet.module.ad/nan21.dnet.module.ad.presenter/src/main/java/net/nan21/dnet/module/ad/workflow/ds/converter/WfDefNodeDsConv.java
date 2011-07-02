/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeTypeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public class WfDefNodeDsConv extends
        AbstractDsConverter<WfDefNodeDs, WfDefNode> implements
        IDsConverter<WfDefNodeDs, WfDefNode> {

    protected void modelToEntityAttributes(WfDefNodeDs ds, WfDefNode e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
    }

    protected void modelToEntityReferences(WfDefNodeDs ds, WfDefNode e)
            throws Exception {

        if (ds.getProcessId() != null) {
            if (e.getProcess() == null
                    || !e.getProcess().getId().equals(ds.getProcessId())) {
                e.setProcess((WfDefProcess) this.em.getReference(
                        WfDefProcess.class, ds.getProcessId()));
            }
        }
        if (ds.getTypeId() != null) {
            if (e.getTaskType() == null
                    || !e.getTaskType().getId().equals(ds.getTypeId())) {
                e.setTaskType((WfDefNodeType) this.em.getReference(
                        WfDefNodeType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_taskType_WfDefNodeType(ds, e);
        }
    }

    protected void lookup_taskType_WfDefNodeType(WfDefNodeDs ds, WfDefNode e)
            throws Exception {
        WfDefNodeType x = null;
        try {
            x = ((IWfDefNodeTypeService) getService(IWfDefNodeTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setTaskType(x);
    }

    @Override
    public void entityToModel(WfDefNode e, WfDefNodeDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setTypeId(((e.getTaskType() != null)) ? e.getTaskType().getId()
                : null);
        ds.setType(((e.getTaskType() != null)) ? e.getTaskType().getName()
                : null);
        ds.setProcessId(((e.getProcess() != null)) ? e.getProcess().getId()
                : null);
        ds.setProcess(((e.getProcess() != null)) ? e.getProcess().getName()
                : null);
    }

}

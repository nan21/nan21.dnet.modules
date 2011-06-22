/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import net.nan21.dnet.module.ad.workflow.domain.service.IWfDefNodeService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

public class WfDefTransitionDsConv extends
        AbstractDsConverter<WfDefTransitionDs, WfDefTransition> implements
        IDsConverter<WfDefTransitionDs, WfDefTransition> {

    protected void modelToEntityAttributes(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {

        if (ds.getProcessId() != null) {
            if (e.getProcess() == null
                    || !e.getProcess().getId().equals(ds.getProcessId())) {
                e.setProcess((WfDefProcess) this.em.getReference(
                        WfDefProcess.class, ds.getProcessId()));
            }
        }
        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((WfDefNode) this.em.getReference(WfDefNode.class,
                        ds.getSourceId()));
            }
        } else {
            this.lookup_source_WfDefNode(ds, e);
        }
        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((WfDefNode) this.em.getReference(WfDefNode.class,
                        ds.getTargetId()));
            }
        } else {
            this.lookup_target_WfDefNode(ds, e);
        }
    }

    protected void lookup_source_WfDefNode(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {
        WfDefNode x = null;
        try {
            x = ((IWfDefNodeService) getService(IWfDefNodeService.class))
                    .findByName(ds.getClientId(), ds.getSource());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSource(x);
    }

    protected void lookup_target_WfDefNode(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {
        WfDefNode x = null;
        try {
            x = ((IWfDefNodeService) getService(IWfDefNodeService.class))
                    .findByName(ds.getClientId(), ds.getTarget());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setTarget(x);
    }

    @Override
    public void entityToModel(WfDefTransition e, WfDefTransitionDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setProcessId(((e.getProcess() != null)) ? e.getProcess().getId()
                : null);
        ds.setProcess(((e.getProcess() != null)) ? e.getProcess().getName()
                : null);
        ds.setSourceId(((e.getSource() != null)) ? e.getSource().getId() : null);
        ds.setSource(((e.getSource() != null)) ? e.getSource().getName() : null);
        ds.setTargetId(((e.getTarget() != null)) ? e.getTarget().getId() : null);
        ds.setTarget(((e.getTarget() != null)) ? e.getTarget().getName() : null);
    }

}

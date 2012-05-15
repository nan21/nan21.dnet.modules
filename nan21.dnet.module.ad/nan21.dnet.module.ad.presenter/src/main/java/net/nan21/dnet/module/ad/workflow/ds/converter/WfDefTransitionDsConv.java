/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

public class WfDefTransitionDsConv extends
        AbstractDsConverter<WfDefTransitionDs, WfDefTransition> implements
        IDsConverter<WfDefTransitionDs, WfDefTransition> {

    @Override
    protected void modelToEntityReferences(WfDefTransitionDs ds,
            WfDefTransition e, boolean isInsert) throws Exception {

        if (ds.getProcessId() != null) {
            if (e.getProcess() == null
                    || !e.getProcess().getId().equals(ds.getProcessId())) {
                e.setProcess((WfDefProcess) this.em.find(WfDefProcess.class,
                        ds.getProcessId()));
            }
        }

        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((WfDefNode) this.em.find(WfDefNode.class,
                        ds.getSourceId()));
            }
        } else {
            this.lookup_source_WfDefNode(ds, e);
        }

        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((WfDefNode) this.em.find(WfDefNode.class,
                        ds.getTargetId()));
            }
        } else {
            this.lookup_target_WfDefNode(ds, e);
        }

    }

    protected void lookup_source_WfDefNode(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {
        if (ds.getSource() != null && !ds.getSource().equals("")) {
            WfDefNode x = null;
            try {
                x = ((IWfDefNodeService) findEntityService(WfDefNode.class))
                        .findByName(ds.getSource());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `WfDefNode` reference:  `source` = "
                                + ds.getSource() + "  ");
            }
            e.setSource(x);

        } else {
            e.setSource(null);
        }
    }

    protected void lookup_target_WfDefNode(WfDefTransitionDs ds,
            WfDefTransition e) throws Exception {
        if (ds.getTarget() != null && !ds.getTarget().equals("")) {
            WfDefNode x = null;
            try {
                x = ((IWfDefNodeService) findEntityService(WfDefNode.class))
                        .findByName(ds.getTarget());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `WfDefNode` reference:  `target` = "
                                + ds.getTarget() + "  ");
            }
            e.setTarget(x);

        } else {
            e.setTarget(null);
        }
    }

}

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

}

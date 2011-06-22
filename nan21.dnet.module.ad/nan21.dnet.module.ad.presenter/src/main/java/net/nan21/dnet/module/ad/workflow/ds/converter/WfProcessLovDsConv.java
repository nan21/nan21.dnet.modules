/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessLovDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;

public class WfProcessLovDsConv extends
        AbstractDsConverter<WfProcessLovDs, WfProcess> implements
        IDsConverter<WfProcessLovDs, WfProcess> {

    protected void modelToEntityAttributes(WfProcessLovDs ds, WfProcess e)
            throws Exception {
        e.setName(ds.getName());
        e.setFullName(ds.getFullName());
    }

    protected void modelToEntityReferences(WfProcessLovDs ds, WfProcess e)
            throws Exception {
    }

    @Override
    public void entityToModel(WfProcess e, WfProcessLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setName(e.getName());
        ds.setFullName(e.getFullName());
    }

}

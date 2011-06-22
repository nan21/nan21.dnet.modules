/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;

public class WfProcessDsConv extends
        AbstractDsConverter<WfProcessDs, WfProcess> implements
        IDsConverter<WfProcessDs, WfProcess> {

    protected void modelToEntityAttributes(WfProcessDs ds, WfProcess e)
            throws Exception {
        e.setCode(ds.getCode());
        e.setFullName(ds.getFullName());
        e.setName(ds.getName());
        e.setCategory(ds.getCategory());
        e.setResourceName(ds.getResourceName());
        e.setDiagramResourceName(ds.getDiagramResourceName());
        e.setVersion(ds.getVersion());
        e.setDeploymentId(ds.getDeploymentId());
    }

    protected void modelToEntityReferences(WfProcessDs ds, WfProcess e)
            throws Exception {
    }

    @Override
    public void entityToModel(WfProcess e, WfProcessDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setCode(e.getCode());
        ds.setFullName(e.getFullName());
        ds.setName(e.getName());
        ds.setCategory(e.getCategory());
        ds.setResourceName(e.getResourceName());
        ds.setDiagramResourceName(e.getDiagramResourceName());
        ds.setVersion(e.getVersion());
        ds.setDeploymentId(e.getDeploymentId());
    }

}

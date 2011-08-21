/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

public class ActDeploymentDsConv extends
        AbstractDsConverter<ActDeploymentDs, ActDeployment> implements
        IDsConverter<ActDeploymentDs, ActDeployment> {

    protected void modelToEntityAttributes(ActDeploymentDs ds, ActDeployment e)
            throws Exception {
        e.setName(ds.getName());
        e.setDeployTime(ds.getDeployTime());
        e.setFullName(ds.getFullName());
    }

    protected void modelToEntityReferences(ActDeploymentDs ds, ActDeployment e)
            throws Exception {
    }

    @Override
    public void entityToModel(ActDeployment e, ActDeploymentDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setName(e.getName());
        ds.setDeployTime(e.getDeployTime());
        ds.setFullName(e.getFullName());
    }

}

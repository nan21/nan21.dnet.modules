/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

public class ActDeploymentLovDsConv extends
        AbstractDsConverter<ActDeploymentLovDs, ActDeployment> implements
        IDsConverter<ActDeploymentLovDs, ActDeployment> {

    protected void modelToEntityAttributes(ActDeploymentLovDs ds,
            ActDeployment e) throws Exception {
        e.setName(ds.getName());
        e.setFullName(ds.getFullName());
    }

    protected void modelToEntityReferences(ActDeploymentLovDs ds,
            ActDeployment e) throws Exception {
    }

    @Override
    public void entityToModel(ActDeployment e, ActDeploymentLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setName(e.getName());
        ds.setFullName(e.getFullName());
    }

}

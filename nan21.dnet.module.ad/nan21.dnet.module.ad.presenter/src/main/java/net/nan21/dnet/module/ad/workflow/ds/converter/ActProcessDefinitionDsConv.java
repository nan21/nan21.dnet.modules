/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

public class ActProcessDefinitionDsConv extends
        AbstractDsConverter<ActProcessDefinitionDs, ActProcessDefinition>
        implements IDsConverter<ActProcessDefinitionDs, ActProcessDefinition> {

    protected void modelToEntityAttributes(ActProcessDefinitionDs ds,
            ActProcessDefinition e) throws Exception {
        e.setKey(ds.getKey());
        e.setFullName(ds.getFullName());
        e.setName(ds.getName());
        e.setCategory(ds.getCategory());
        e.setResourceName(ds.getResourceName());
        e.setDiagramResourceName(ds.getDiagramResourceName());
        e.setVersion(ds.getVersion());
        e.setHasStartForm(ds.getHasStartForm());
    }

    protected void modelToEntityReferences(ActProcessDefinitionDs ds,
            ActProcessDefinition e) throws Exception {
    }

    @Override
    public void entityToModel(ActProcessDefinition e, ActProcessDefinitionDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setKey(e.getKey());
        ds.setFullName(e.getFullName());
        ds.setName(e.getName());
        ds.setCategory(e.getCategory());
        ds.setResourceName(e.getResourceName());
        ds.setDiagramResourceName(e.getDiagramResourceName());
        ds.setVersion(e.getVersion());
        ds.setHasStartForm(e.getHasStartForm());
        ds.setDeploymentId(((e.getDeployment() != null)) ? e.getDeployment()
                .getId() : null);
    }

}

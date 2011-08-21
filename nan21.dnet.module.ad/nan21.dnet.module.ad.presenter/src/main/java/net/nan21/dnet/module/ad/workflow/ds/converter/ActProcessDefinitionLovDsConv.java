/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

public class ActProcessDefinitionLovDsConv extends
        AbstractDsConverter<ActProcessDefinitionLovDs, ActProcessDefinition>
        implements
        IDsConverter<ActProcessDefinitionLovDs, ActProcessDefinition> {

    protected void modelToEntityAttributes(ActProcessDefinitionLovDs ds,
            ActProcessDefinition e) throws Exception {
        e.setName(ds.getName());
        e.setFullName(ds.getFullName());
    }

    protected void modelToEntityReferences(ActProcessDefinitionLovDs ds,
            ActProcessDefinition e) throws Exception {
    }

    @Override
    public void entityToModel(ActProcessDefinition e,
            ActProcessDefinitionLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setName(e.getName());
        ds.setFullName(e.getFullName());
    }

}

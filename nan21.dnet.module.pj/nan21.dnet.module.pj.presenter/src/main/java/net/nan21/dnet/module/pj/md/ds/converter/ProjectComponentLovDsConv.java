/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectComponentLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

public class ProjectComponentLovDsConv extends
        AbstractDsConverter<ProjectComponentLovDs, ProjectComponent> implements
        IDsConverter<ProjectComponentLovDs, ProjectComponent> {

    protected void modelToEntityAttributes(ProjectComponentLovDs ds,
            ProjectComponent e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectComponentLovDs ds,
            ProjectComponent e) throws Exception {
    }

    @Override
    public void entityToModel(ProjectComponent e, ProjectComponentLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

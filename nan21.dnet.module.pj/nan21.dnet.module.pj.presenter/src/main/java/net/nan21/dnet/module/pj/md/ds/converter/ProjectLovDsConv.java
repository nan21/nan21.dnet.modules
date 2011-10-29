/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

public class ProjectLovDsConv extends
        AbstractDsConverter<ProjectLovDs, Project> implements
        IDsConverter<ProjectLovDs, Project> {

    protected void modelToEntityAttributes(ProjectLovDs ds, Project e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectLovDs ds, Project e)
            throws Exception {
    }

    @Override
    public void entityToModel(Project e, ProjectLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

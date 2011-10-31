/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public class ProjectVersionLovDsConv extends
        AbstractDsConverter<ProjectVersionLovDs, ProjectVersion> implements
        IDsConverter<ProjectVersionLovDs, ProjectVersion> {

    protected void modelToEntityAttributes(ProjectVersionLovDs ds,
            ProjectVersion e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectVersionLovDs ds,
            ProjectVersion e) throws Exception {
    }

    @Override
    public void entityToModel(ProjectVersion e, ProjectVersionLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setProjectId(((e.getProject() != null)) ? e.getProject().getId()
                : null);
    }

}

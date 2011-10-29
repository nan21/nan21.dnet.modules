/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ProjectRoleLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

public class ProjectRoleLovDsConv extends
        AbstractDsConverter<ProjectRoleLovDs, ProjectRole> implements
        IDsConverter<ProjectRoleLovDs, ProjectRole> {

    protected void modelToEntityAttributes(ProjectRoleLovDs ds, ProjectRole e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectRoleLovDs ds, ProjectRole e)
            throws Exception {
    }

    @Override
    public void entityToModel(ProjectRole e, ProjectRoleLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

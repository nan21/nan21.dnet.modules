/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ProjectTypeLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

public class ProjectTypeLovDsConv extends
        AbstractDsConverter<ProjectTypeLovDs, ProjectType> implements
        IDsConverter<ProjectTypeLovDs, ProjectType> {

    protected void modelToEntityAttributes(ProjectTypeLovDs ds, ProjectType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectTypeLovDs ds, ProjectType e)
            throws Exception {
    }

    @Override
    public void entityToModel(ProjectType e, ProjectTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}

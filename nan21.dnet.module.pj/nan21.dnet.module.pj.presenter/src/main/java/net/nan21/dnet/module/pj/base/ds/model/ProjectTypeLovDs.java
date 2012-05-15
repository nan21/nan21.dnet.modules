/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProjectType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProjectTypeLovDs.fNAME) })
public class ProjectTypeLovDs extends AbstractTypeLov<ProjectType> {

    public ProjectTypeLovDs() {
        super();
    }

    public ProjectTypeLovDs(ProjectType e) {
        super(e);
    }

}

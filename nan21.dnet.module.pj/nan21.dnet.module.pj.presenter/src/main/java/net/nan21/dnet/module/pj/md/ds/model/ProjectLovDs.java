/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

@Ds(entity = Project.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProjectLovDs.fCODE) })
public class ProjectLovDs extends AbstractTypeWithCodeLov<Project> {

    public ProjectLovDs() {
        super();
    }

    public ProjectLovDs(Project e) {
        super(e);
    }

}

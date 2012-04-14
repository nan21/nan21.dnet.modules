/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProjectComponent.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProjectComponentLovDs.fNAME) })
public class ProjectComponentLovDs extends AbstractTypeLov<ProjectComponent> {

    public static final String fPROJECTID = "projectId";

    @DsField(join = "left", path = "project.id")
    private Long projectId;

    public ProjectComponentLovDs() {
        super();
    }

    public ProjectComponentLovDs(ProjectComponent e) {
        super(e);
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}

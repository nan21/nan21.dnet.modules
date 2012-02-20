/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public class ProjectVersionDsConv extends
        AbstractDsConverter<ProjectVersionDs, ProjectVersion> implements
        IDsConverter<ProjectVersionDs, ProjectVersion> {

    @Override
    protected void modelToEntityReferences(ProjectVersionDs ds,
            ProjectVersion e, boolean isInsert) throws Exception {

        if (ds.getProjectId() != null) {
            if (e.getProject() == null
                    || !e.getProject().getId().equals(ds.getProjectId())) {
                e.setProject((Project) this.em.find(Project.class,
                        ds.getProjectId()));
            }
        } else {
            this.lookup_project_Project(ds, e);
        }

    }

    protected void lookup_project_Project(ProjectVersionDs ds, ProjectVersion e)
            throws Exception {
        if (ds.getProject() != null && !ds.getProject().equals("")) {
            Project x = null;
            try {
                x = ((IProjectService) findEntityService(Project.class))
                        .findByCode(ds.getProject());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Project` reference:  `project` = "
                                + ds.getProject() + "  ");
            }
            e.setProject(x);

        } else {
            e.setProject(null);
        }
    }

}

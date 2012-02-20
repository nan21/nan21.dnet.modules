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
import net.nan21.dnet.module.pj.md.ds.model.ProjectComponentDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

public class ProjectComponentDsConv extends
        AbstractDsConverter<ProjectComponentDs, ProjectComponent> implements
        IDsConverter<ProjectComponentDs, ProjectComponent> {

    @Override
    protected void modelToEntityReferences(ProjectComponentDs ds,
            ProjectComponent e, boolean isInsert) throws Exception {

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

    protected void lookup_project_Project(ProjectComponentDs ds,
            ProjectComponent e) throws Exception {
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

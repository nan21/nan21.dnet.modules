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

    protected void modelToEntityAttributes(ProjectComponentDs ds,
            ProjectComponent e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProjectComponentDs ds,
            ProjectComponent e) throws Exception {

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
        if (ds.getProjectCode() != null && !ds.getProjectCode().equals("")) {
            Project x = null;
            try {
                x = ((IProjectService) getService(IProjectService.class))
                        .findByName(ds.getClientId(), ds.getProjectCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Project` reference:  `projectCode` = "
                                + ds.getProjectCode() + "  ");
            }
            e.setProject(x);
        } else {
            e.setProject(null);
        }
    }

    @Override
    public void entityToModel(ProjectComponent e, ProjectComponentDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setProjectId(((e.getProject() != null)) ? e.getProject().getId()
                : null);
        ds.setProjectCode(((e.getProject() != null)) ? e.getProject().getCode()
                : null);
        ds.setProject(((e.getProject() != null)) ? e.getProject().getName()
                : null);
    }

}

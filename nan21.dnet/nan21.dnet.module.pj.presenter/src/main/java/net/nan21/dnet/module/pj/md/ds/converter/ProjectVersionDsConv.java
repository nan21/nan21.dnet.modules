/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.business.service.IProjectVersionService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public class ProjectVersionDsConv extends
        AbstractDsConverter<ProjectVersionDs, ProjectVersion> implements
        IDsConverter<ProjectVersionDs, ProjectVersion> {

    protected void modelToEntityReferences(ProjectVersionDs ds, ProjectVersion e)
            throws Exception {
        if (ds.getProjectId() != null) {
            if (e.getProject() == null
                    || !e.getProject().getId().equals(ds.getProjectId())) {
                e.setProject((Project) this.em.find(Project.class,
                        ds.getProjectId()));
            }
        } else {
            this.lookup_project_Project(ds, e);
        }
        if (ds.getProjectVersionId() != null) {
            if (e.getProjectVersion() == null
                    || !e.getProjectVersion().getId()
                            .equals(ds.getProjectVersionId())) {
                e.setProjectVersion((ProjectVersion) this.em.find(
                        ProjectVersion.class, ds.getProjectVersionId()));
            }
        } else {
            this.lookup_projectVersion_ProjectVersion(ds, e);
        }
    }

    protected void lookup_project_Project(ProjectVersionDs ds, ProjectVersion e)
            throws Exception {
        if (ds.getProject() != null && !ds.getProject().equals("")) {
            Project x = null;
            try {
                x = ((IProjectService) findEntityService(Project.class))
                        .findByCode(ds.getClientId(), ds.getProject());
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

    protected void lookup_projectVersion_ProjectVersion(ProjectVersionDs ds,
            ProjectVersion e) throws Exception {
        if (ds.getProjectId() != null && !ds.getProjectId().equals("")
                && ds.getProjectVersion() != null
                && !ds.getProjectVersion().equals("")) {
            ProjectVersion x = null;
            try {
                x = ((IProjectVersionService) findEntityService(ProjectVersion.class))
                        .findByName(ds.getClientId(), ds.getProjectId(),
                                ds.getProjectVersion());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectVersion` reference:  `projectId` = "
                                + ds.getProjectId() + " , `projectVersion` = "
                                + ds.getProjectVersion() + "  ");
            }
            e.setProjectVersion(x);

        } else {
            e.setProjectVersion(null);
        }
    }

}

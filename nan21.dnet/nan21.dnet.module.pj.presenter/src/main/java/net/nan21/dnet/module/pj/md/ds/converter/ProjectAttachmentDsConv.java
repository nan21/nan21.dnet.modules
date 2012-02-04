/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectAttachmentDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectAttachment;

public class ProjectAttachmentDsConv extends
        AbstractDsConverter<ProjectAttachmentDs, ProjectAttachment> implements
        IDsConverter<ProjectAttachmentDs, ProjectAttachment> {

    protected void modelToEntityReferences(ProjectAttachmentDs ds,
            ProjectAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
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

    protected void lookup_type_AttachmentType(ProjectAttachmentDs ds,
            ProjectAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttachmentType x = null;
            try {
                x = ((IAttachmentTypeService) findEntityService(AttachmentType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_project_Project(ProjectAttachmentDs ds,
            ProjectAttachment e) throws Exception {
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

}

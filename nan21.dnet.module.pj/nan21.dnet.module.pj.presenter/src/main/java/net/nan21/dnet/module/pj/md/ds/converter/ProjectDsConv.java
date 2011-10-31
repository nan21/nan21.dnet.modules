/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IProjectTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectDs;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

public class ProjectDsConv extends AbstractDsConverter<ProjectDs, Project>
        implements IDsConverter<ProjectDs, Project> {

    protected void modelToEntityAttributes(ProjectDs ds, Project e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProjectDs ds, Project e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ProjectType) this.em.find(ProjectType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ProjectType(ds, e);
        }
        if (ds.getProjectLeadId() != null) {
            if (e.getProjectLead() == null
                    || !e.getProjectLead().getId()
                            .equals(ds.getProjectLeadId())) {
                e.setProjectLead((ProjectMember) this.em.find(
                        ProjectMember.class, ds.getProjectLeadId()));
            }
        }
    }

    protected void lookup_type_ProjectType(ProjectDs ds, Project e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ProjectType x = null;
            try {
                x = ((IProjectTypeService) getService(IProjectTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        } else {
            e.setType(null);
        }
    }

    @Override
    public void entityToModel(Project e, ProjectDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setProjectLeadId(((e.getProjectLead() != null)) ? e.getProjectLead()
                .getId() : null);
        ds.setProjectLead(((e.getProjectLead() != null) && (e.getProjectLead()
                .getMember() != null)) ? e.getProjectLead().getMember()
                .getName() : null);
    }

}

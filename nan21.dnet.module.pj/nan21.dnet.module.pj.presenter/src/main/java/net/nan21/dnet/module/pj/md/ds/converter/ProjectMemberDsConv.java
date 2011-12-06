/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.business.service.IProjectRoleService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

public class ProjectMemberDsConv extends
        AbstractDsConverter<ProjectMemberDs, ProjectMember> implements
        IDsConverter<ProjectMemberDs, ProjectMember> {

    protected void modelToEntityReferences(ProjectMemberDs ds, ProjectMember e)
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
        if (ds.getRoleId() != null) {
            if (e.getProjectRole() == null
                    || !e.getProjectRole().getId().equals(ds.getRoleId())) {
                e.setProjectRole((ProjectRole) this.em.find(ProjectRole.class,
                        ds.getRoleId()));
            }
        } else {
            this.lookup_projectRole_ProjectRole(ds, e);
        }
        if (ds.getMemberId() != null) {
            if (e.getMember() == null
                    || !e.getMember().getId().equals(ds.getMemberId())) {
                e.setMember((Assignable) this.em.find(Assignable.class,
                        ds.getMemberId()));
            }
        } else {
            this.lookup_member_Assignable(ds, e);
        }
    }

    protected void lookup_project_Project(ProjectMemberDs ds, ProjectMember e)
            throws Exception {
        if (ds.getProject() != null && !ds.getProject().equals("")) {
            Project x = null;
            try {
                x = ((IProjectService) getService(IProjectService.class))
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

    protected void lookup_projectRole_ProjectRole(ProjectMemberDs ds,
            ProjectMember e) throws Exception {
        if (ds.getRole() != null && !ds.getRole().equals("")) {
            ProjectRole x = null;
            try {
                x = ((IProjectRoleService) getService(IProjectRoleService.class))
                        .findByName(ds.getClientId(), ds.getRole());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectRole` reference:  `role` = "
                                + ds.getRole() + "  ");
            }
            e.setProjectRole(x);

        } else {
            e.setProjectRole(null);
        }
    }

    protected void lookup_member_Assignable(ProjectMemberDs ds, ProjectMember e)
            throws Exception {
        if (ds.getMember() != null && !ds.getMember().equals("")) {
            Assignable x = null;
            try {
                x = ((IAssignableService) getService(IAssignableService.class))
                        .findByName(ds.getClientId(), ds.getMember());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Assignable` reference:  `member` = "
                                + ds.getMember() + "  ");
            }
            e.setMember(x);

        } else {
            e.setMember(null);
        }
    }

}

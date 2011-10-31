/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

public class ProjectMemberLovDsConv extends
        AbstractDsConverter<ProjectMemberLovDs, ProjectMember> implements
        IDsConverter<ProjectMemberLovDs, ProjectMember> {

    protected void modelToEntityAttributes(ProjectMemberLovDs ds,
            ProjectMember e) throws Exception {
        e.setClientId(ds.getClientId());
    }

    protected void modelToEntityReferences(ProjectMemberLovDs ds,
            ProjectMember e) throws Exception {
    }

    @Override
    public void entityToModel(ProjectMember e, ProjectMemberLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setProjectId(((e.getProject() != null)) ? e.getProject().getId()
                : null);
        ds.setRoleId(((e.getProjectRole() != null)) ? e.getProjectRole()
                .getId() : null);
        ds.setRole(((e.getProjectRole() != null)) ? e.getProjectRole()
                .getName() : null);
        ds.setMemberId(((e.getMember() != null)) ? e.getMember().getId() : null);
        ds.setMember(((e.getMember() != null)) ? e.getMember().getName() : null);
    }

}

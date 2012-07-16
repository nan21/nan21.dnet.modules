/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

@Ds(entity = ProjectMember.class, sort = {
        @SortField(field = ProjectMemberLovDs.fMEMBER),
        @SortField(field = ProjectMemberLovDs.fROLE) })
public class ProjectMemberLovDs extends AbstractAuditableLov<ProjectMember> {

    public static final String fPROJECTID = "projectId";
    public static final String fROLEID = "roleId";
    public static final String fROLE = "role";
    public static final String fMEMBERID = "memberId";
    public static final String fMEMBER = "member";

    @DsField(join = "left", path = "project.id")
    private Long projectId;

    @DsField(join = "left", path = "projectRole.id")
    private Long roleId;

    @DsField(join = "left", path = "projectRole.name")
    private String role;

    @DsField(join = "left", path = "member.id")
    private Long memberId;

    @DsField(join = "left", path = "member.name")
    private String member;

    public ProjectMemberLovDs() {
        super();
    }

    public ProjectMemberLovDs(ProjectMember e) {
        super(e);
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMember() {
        return this.member;
    }

    public void setMember(String member) {
        this.member = member;
    }

}

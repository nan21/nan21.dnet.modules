/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProjectMemberDsFilter extends AbstractAuditableDsFilter {

    private Long projectId;

    private Long projectId_From;
    private Long projectId_To;

    private String project;

    private String projectName;

    private Long roleId;

    private Long roleId_From;
    private Long roleId_To;

    private String role;

    private Long memberId;

    private Long memberId_From;
    private Long memberId_To;

    private String member;

    public Long getProjectId() {
        return this.projectId;
    }

    public Long getProjectId_From() {
        return this.projectId_From;
    }

    public Long getProjectId_To() {
        return this.projectId_To;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setProjectId_From(Long projectId_From) {
        this.projectId_From = projectId_From;
    }

    public void setProjectId_To(Long projectId_To) {
        this.projectId_To = projectId_To;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public Long getRoleId_From() {
        return this.roleId_From;
    }

    public Long getRoleId_To() {
        return this.roleId_To;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId_From(Long roleId_From) {
        this.roleId_From = roleId_From;
    }

    public void setRoleId_To(Long roleId_To) {
        this.roleId_To = roleId_To;
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

    public Long getMemberId_From() {
        return this.memberId_From;
    }

    public Long getMemberId_To() {
        return this.memberId_To;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberId_From(Long memberId_From) {
        this.memberId_From = memberId_From;
    }

    public void setMemberId_To(Long memberId_To) {
        this.memberId_To = memberId_To;
    }

    public String getMember() {
        return this.member;
    }

    public void setMember(String member) {
        this.member = member;
    }

}

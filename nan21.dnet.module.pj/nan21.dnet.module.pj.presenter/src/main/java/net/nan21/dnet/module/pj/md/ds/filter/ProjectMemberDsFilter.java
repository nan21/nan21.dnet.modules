/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProjectMemberDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

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

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

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

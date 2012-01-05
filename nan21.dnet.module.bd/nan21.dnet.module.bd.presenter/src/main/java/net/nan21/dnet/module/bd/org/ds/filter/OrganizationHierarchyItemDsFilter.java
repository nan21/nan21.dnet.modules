/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class OrganizationHierarchyItemDsFilter extends AbstractDsFilter
        implements IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long hierarchyId;

    private Long hierarchyId_From;
    private Long hierarchyId_To;

    private String hierarchy;

    private Long organizationId;

    private Long organizationId_From;
    private Long organizationId_To;

    private String organizationCode;

    private Long parentId;

    private Long parentId_From;
    private Long parentId_To;

    private String parentCode;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Long getHierarchyId() {
        return this.hierarchyId;
    }

    public Long getHierarchyId_From() {
        return this.hierarchyId_From;
    }

    public Long getHierarchyId_To() {
        return this.hierarchyId_To;
    }

    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public void setHierarchyId_From(Long hierarchyId_From) {
        this.hierarchyId_From = hierarchyId_From;
    }

    public void setHierarchyId_To(Long hierarchyId_To) {
        this.hierarchyId_To = hierarchyId_To;
    }

    public String getHierarchy() {
        return this.hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public Long getOrganizationId_From() {
        return this.organizationId_From;
    }

    public Long getOrganizationId_To() {
        return this.organizationId_To;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationId_From(Long organizationId_From) {
        this.organizationId_From = organizationId_From;
    }

    public void setOrganizationId_To(Long organizationId_To) {
        this.organizationId_To = organizationId_To;
    }

    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Long getParentId_From() {
        return this.parentId_From;
    }

    public Long getParentId_To() {
        return this.parentId_To;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setParentId_From(Long parentId_From) {
        this.parentId_From = parentId_From;
    }

    public void setParentId_To(Long parentId_To) {
        this.parentId_To = parentId_To;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

}

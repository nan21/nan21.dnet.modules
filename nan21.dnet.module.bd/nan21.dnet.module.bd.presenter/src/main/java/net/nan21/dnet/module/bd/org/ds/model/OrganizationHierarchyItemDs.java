/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationHierarchyItem.class)
public class OrganizationHierarchyItemDs extends
        AbstractAuditableDs<OrganizationHierarchyItem> {

    public static final String fHIERARCHYID = "hierarchyId";
    public static final String fHIERARCHY = "hierarchy";
    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATIONCODE = "organizationCode";
    public static final String fPARENTID = "parentId";
    public static final String fPARENTCODE = "parentCode";

    @DsField(join = "left", path = "hierarchy.id")
    private Long hierarchyId;

    @DsField(join = "left", path = "hierarchy.name")
    private String hierarchy;

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organizationCode;

    @DsField(join = "left", path = "parent.id")
    private Long parentId;

    @DsField(join = "left", path = "parent.code")
    private String parentCode;

    public OrganizationHierarchyItemDs() {
        super();
    }

    public OrganizationHierarchyItemDs(OrganizationHierarchyItem e) {
        super(e);
    }

    public Long getHierarchyId() {
        return this.hierarchyId;
    }

    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
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

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

}

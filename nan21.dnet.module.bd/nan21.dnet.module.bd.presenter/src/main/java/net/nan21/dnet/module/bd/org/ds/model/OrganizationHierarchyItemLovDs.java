/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationHierarchyItem.class)
public class OrganizationHierarchyItemLovDs extends
        AbstractAuditableLov<OrganizationHierarchyItem> {

    public static final String fHIERARCHYID = "hierarchyId";
    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATIONCODE = "organizationCode";

    @DsField(join = "left", path = "hierarchy.id")
    private Long hierarchyId;

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organizationCode;

    public OrganizationHierarchyItemLovDs() {
        super();
    }

    public OrganizationHierarchyItemLovDs(OrganizationHierarchyItem e) {
        super(e);
    }

    public Long getHierarchyId() {
        return this.hierarchyId;
    }

    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
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

}

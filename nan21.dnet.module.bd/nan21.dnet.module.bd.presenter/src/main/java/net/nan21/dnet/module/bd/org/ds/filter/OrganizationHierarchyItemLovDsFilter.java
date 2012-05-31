/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLovFilter;

public class OrganizationHierarchyItemLovDsFilter extends
        AbstractAuditableLovFilter {

    private Long hierarchyId;

    private Long hierarchyId_From;
    private Long hierarchyId_To;

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

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

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

}

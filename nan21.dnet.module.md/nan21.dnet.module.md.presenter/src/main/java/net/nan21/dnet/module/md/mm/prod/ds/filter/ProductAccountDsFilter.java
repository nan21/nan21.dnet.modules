/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProductAccountDsFilter extends AbstractAuditableDsFilter {

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Long groupId;

    private Long groupId_From;
    private Long groupId_To;

    private String groupCode;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String analiticSegment;

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

    public Long getGroupId() {
        return this.groupId;
    }

    public Long getGroupId_From() {
        return this.groupId_From;
    }

    public Long getGroupId_To() {
        return this.groupId_To;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupId_From(Long groupId_From) {
        this.groupId_From = groupId_From;
    }

    public void setGroupId_To(Long groupId_To) {
        this.groupId_To = groupId_To;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAnaliticSegment() {
        return this.analiticSegment;
    }

    public void setAnaliticSegment(String analiticSegment) {
        this.analiticSegment = analiticSegment;
    }

}

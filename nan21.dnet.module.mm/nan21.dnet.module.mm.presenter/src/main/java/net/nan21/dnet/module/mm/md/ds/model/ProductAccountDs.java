/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAccount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAccount.class)
public class ProductAccountDs extends AbstractAuditableDs<ProductAccount> {

    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATIONCODE = "organizationCode";
    public static final String fGROUPID = "groupId";
    public static final String fGROUPCODE = "groupCode";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organizationCode;

    @DsField(join = "left", path = "group.id")
    private Long groupId;

    @DsField(join = "left", path = "group.code")
    private String groupCode;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    public ProductAccountDs() {
        super();
    }

    public ProductAccountDs(ProductAccount e) {
        super(e);
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

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}

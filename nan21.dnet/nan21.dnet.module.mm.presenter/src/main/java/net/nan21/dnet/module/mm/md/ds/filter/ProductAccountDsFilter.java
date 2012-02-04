/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProductAccountDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

    private Long organizationId;

    private Long organizationId_From;
    private Long organizationId_To;

    private String organizationCode;

    private Long groupId;

    private Long groupId_From;
    private Long groupId_To;

    private String groupCode;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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

}

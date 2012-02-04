/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class CurrencyXRateDsFilter extends AbstractDsFilter implements
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

    private Long sourceId;

    private Long sourceId_From;
    private Long sourceId_To;

    private String sourceCode;

    private Long targetId;

    private Long targetId_From;
    private Long targetId_To;

    private String targetCode;

    private Date validAt;

    private Date validAt_From;
    private Date validAt_To;

    private Float value;

    private Float value_From;
    private Float value_To;

    private Long providerId;

    private Long providerId_From;
    private Long providerId_To;

    private String providerCode;

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

    public Long getSourceId() {
        return this.sourceId;
    }

    public Long getSourceId_From() {
        return this.sourceId_From;
    }

    public Long getSourceId_To() {
        return this.sourceId_To;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceId_From(Long sourceId_From) {
        this.sourceId_From = sourceId_From;
    }

    public void setSourceId_To(Long sourceId_To) {
        this.sourceId_To = sourceId_To;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getTargetId() {
        return this.targetId;
    }

    public Long getTargetId_From() {
        return this.targetId_From;
    }

    public Long getTargetId_To() {
        return this.targetId_To;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public void setTargetId_From(Long targetId_From) {
        this.targetId_From = targetId_From;
    }

    public void setTargetId_To(Long targetId_To) {
        this.targetId_To = targetId_To;
    }

    public String getTargetCode() {
        return this.targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Date getValidAt() {
        return this.validAt;
    }

    public Date getValidAt_From() {
        return this.validAt_From;
    }

    public Date getValidAt_To() {
        return this.validAt_To;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

    public void setValidAt_From(Date validAt_From) {
        this.validAt_From = validAt_From;
    }

    public void setValidAt_To(Date validAt_To) {
        this.validAt_To = validAt_To;
    }

    public Float getValue() {
        return this.value;
    }

    public Float getValue_From() {
        return this.value_From;
    }

    public Float getValue_To() {
        return this.value_To;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public void setValue_From(Float value_From) {
        this.value_From = value_From;
    }

    public void setValue_To(Float value_To) {
        this.value_To = value_To;
    }

    public Long getProviderId() {
        return this.providerId;
    }

    public Long getProviderId_From() {
        return this.providerId_From;
    }

    public Long getProviderId_To() {
        return this.providerId_To;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setProviderId_From(Long providerId_From) {
        this.providerId_From = providerId_From;
    }

    public void setProviderId_To(Long providerId_To) {
        this.providerId_To = providerId_To;
    }

    public String getProviderCode() {
        return this.providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

}

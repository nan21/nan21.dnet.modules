/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class TaxDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

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

    private Float rate;

    private Float rate_From;
    private Float rate_To;

    private Boolean summary;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    private Long parentTaxId;

    private Long parentTaxId_From;
    private Long parentTaxId_To;

    private String parentTax;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Float getRate() {
        return this.rate;
    }

    public Float getRate_From() {
        return this.rate_From;
    }

    public Float getRate_To() {
        return this.rate_To;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setRate_From(Float rate_From) {
        this.rate_From = rate_From;
    }

    public void setRate_To(Float rate_To) {
        this.rate_To = rate_To;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public Long getCategoryId_From() {
        return this.categoryId_From;
    }

    public Long getCategoryId_To() {
        return this.categoryId_To;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }

    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getParentTaxId() {
        return this.parentTaxId;
    }

    public Long getParentTaxId_From() {
        return this.parentTaxId_From;
    }

    public Long getParentTaxId_To() {
        return this.parentTaxId_To;
    }

    public void setParentTaxId(Long parentTaxId) {
        this.parentTaxId = parentTaxId;
    }

    public void setParentTaxId_From(Long parentTaxId_From) {
        this.parentTaxId_From = parentTaxId_From;
    }

    public void setParentTaxId_To(Long parentTaxId_To) {
        this.parentTaxId_To = parentTaxId_To;
    }

    public String getParentTax() {
        return this.parentTax;
    }

    public void setParentTax(String parentTax) {
        this.parentTax = parentTax;
    }

}

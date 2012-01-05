/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class PayScaleRateValueDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

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

    private Long scaleRateId;

    private Long scaleRateId_From;
    private Long scaleRateId_To;

    private Long scalePointId;

    private Long scalePointId_From;
    private Long scalePointId_To;

    private String scalePointCode;

    private Float value;

    private Float value_From;
    private Float value_To;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

    private Date validTo;

    private Date validTo_From;
    private Date validTo_To;

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

    public Long getScaleRateId() {
        return this.scaleRateId;
    }

    public Long getScaleRateId_From() {
        return this.scaleRateId_From;
    }

    public Long getScaleRateId_To() {
        return this.scaleRateId_To;
    }

    public void setScaleRateId(Long scaleRateId) {
        this.scaleRateId = scaleRateId;
    }

    public void setScaleRateId_From(Long scaleRateId_From) {
        this.scaleRateId_From = scaleRateId_From;
    }

    public void setScaleRateId_To(Long scaleRateId_To) {
        this.scaleRateId_To = scaleRateId_To;
    }

    public Long getScalePointId() {
        return this.scalePointId;
    }

    public Long getScalePointId_From() {
        return this.scalePointId_From;
    }

    public Long getScalePointId_To() {
        return this.scalePointId_To;
    }

    public void setScalePointId(Long scalePointId) {
        this.scalePointId = scalePointId;
    }

    public void setScalePointId_From(Long scalePointId_From) {
        this.scalePointId_From = scalePointId_From;
    }

    public void setScalePointId_To(Long scalePointId_To) {
        this.scalePointId_To = scalePointId_To;
    }

    public String getScalePointCode() {
        return this.scalePointCode;
    }

    public void setScalePointCode(String scalePointCode) {
        this.scalePointCode = scalePointCode;
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

    public Date getValidFrom() {
        return this.validFrom;
    }

    public Date getValidFrom_From() {
        return this.validFrom_From;
    }

    public Date getValidFrom_To() {
        return this.validFrom_To;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidFrom_From(Date validFrom_From) {
        this.validFrom_From = validFrom_From;
    }

    public void setValidFrom_To(Date validFrom_To) {
        this.validFrom_To = validFrom_To;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public Date getValidTo_From() {
        return this.validTo_From;
    }

    public Date getValidTo_To() {
        return this.validTo_To;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public void setValidTo_From(Date validTo_From) {
        this.validTo_From = validTo_From;
    }

    public void setValidTo_To(Date validTo_To) {
        this.validTo_To = validTo_To;
    }

}

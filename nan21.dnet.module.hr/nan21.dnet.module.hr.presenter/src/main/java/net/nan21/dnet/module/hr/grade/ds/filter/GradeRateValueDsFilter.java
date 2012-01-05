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

public class GradeRateValueDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long gradeId;

    private Long gradeId_From;
    private Long gradeId_To;

    private String gradeName;

    private Long gradeRateId;

    private Long gradeRateId_From;
    private Long gradeRateId_To;

    private String gradeRateName;

    private Float fixValue;

    private Float fixValue_From;
    private Float fixValue_To;

    private Float minValue;

    private Float minValue_From;
    private Float minValue_To;

    private Float maxValue;

    private Float maxValue_From;
    private Float maxValue_To;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

    private Date validTo;

    private Date validTo_From;
    private Date validTo_To;

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
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

    public Long getGradeId() {
        return this.gradeId;
    }

    public Long getGradeId_From() {
        return this.gradeId_From;
    }

    public Long getGradeId_To() {
        return this.gradeId_To;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public void setGradeId_From(Long gradeId_From) {
        this.gradeId_From = gradeId_From;
    }

    public void setGradeId_To(Long gradeId_To) {
        this.gradeId_To = gradeId_To;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getGradeRateId() {
        return this.gradeRateId;
    }

    public Long getGradeRateId_From() {
        return this.gradeRateId_From;
    }

    public Long getGradeRateId_To() {
        return this.gradeRateId_To;
    }

    public void setGradeRateId(Long gradeRateId) {
        this.gradeRateId = gradeRateId;
    }

    public void setGradeRateId_From(Long gradeRateId_From) {
        this.gradeRateId_From = gradeRateId_From;
    }

    public void setGradeRateId_To(Long gradeRateId_To) {
        this.gradeRateId_To = gradeRateId_To;
    }

    public String getGradeRateName() {
        return this.gradeRateName;
    }

    public void setGradeRateName(String gradeRateName) {
        this.gradeRateName = gradeRateName;
    }

    public Float getFixValue() {
        return this.fixValue;
    }

    public Float getFixValue_From() {
        return this.fixValue_From;
    }

    public Float getFixValue_To() {
        return this.fixValue_To;
    }

    public void setFixValue(Float fixValue) {
        this.fixValue = fixValue;
    }

    public void setFixValue_From(Float fixValue_From) {
        this.fixValue_From = fixValue_From;
    }

    public void setFixValue_To(Float fixValue_To) {
        this.fixValue_To = fixValue_To;
    }

    public Float getMinValue() {
        return this.minValue;
    }

    public Float getMinValue_From() {
        return this.minValue_From;
    }

    public Float getMinValue_To() {
        return this.minValue_To;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public void setMinValue_From(Float minValue_From) {
        this.minValue_From = minValue_From;
    }

    public void setMinValue_To(Float minValue_To) {
        this.minValue_To = minValue_To;
    }

    public Float getMaxValue() {
        return this.maxValue;
    }

    public Float getMaxValue_From() {
        return this.maxValue_From;
    }

    public Float getMaxValue_To() {
        return this.maxValue_To;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    public void setMaxValue_From(Float maxValue_From) {
        this.maxValue_From = maxValue_From;
    }

    public void setMaxValue_To(Float maxValue_To) {
        this.maxValue_To = maxValue_To;
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

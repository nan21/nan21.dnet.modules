/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PayScaleRateValueDsFilter extends AbstractAuditableDsFilter {

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

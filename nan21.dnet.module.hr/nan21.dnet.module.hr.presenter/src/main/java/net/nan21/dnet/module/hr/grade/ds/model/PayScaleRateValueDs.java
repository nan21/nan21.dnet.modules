/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScaleRateValue.class)
public class PayScaleRateValueDs extends AbstractAuditableDs<PayScaleRateValue> {

    public static final String fSCALERATEID = "scaleRateId";
    public static final String fSCALEPOINTID = "scalePointId";
    public static final String fSCALEPOINTCODE = "scalePointCode";
    public static final String fVALUE = "value";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";

    @DsField(join = "left", path = "scaleRate.id")
    private Long scaleRateId;

    @DsField(join = "left", path = "scalePoint.id")
    private Long scalePointId;

    @DsField(join = "left", path = "scalePoint.code")
    private String scalePointCode;

    @DsField()
    private Float value;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    public PayScaleRateValueDs() {
        super();
    }

    public PayScaleRateValueDs(PayScaleRateValue e) {
        super(e);
    }

    public Long getScaleRateId() {
        return this.scaleRateId;
    }

    public void setScaleRateId(Long scaleRateId) {
        this.scaleRateId = scaleRateId;
    }

    public Long getScalePointId() {
        return this.scalePointId;
    }

    public void setScalePointId(Long scalePointId) {
        this.scalePointId = scalePointId;
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

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

}

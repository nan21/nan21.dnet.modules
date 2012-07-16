/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

@Ds(entity = GradeRateValue.class)
public class GradeRateValueDs extends AbstractAuditableDs<GradeRateValue> {

    public static final String fGRADEID = "gradeId";
    public static final String fGRADENAME = "gradeName";
    public static final String fGRADERATEID = "gradeRateId";
    public static final String fGRADERATENAME = "gradeRateName";
    public static final String fFIXVALUE = "fixValue";
    public static final String fMINVALUE = "minValue";
    public static final String fMAXVALUE = "maxValue";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";

    @DsField(join = "left", path = "grade.id")
    private Long gradeId;

    @DsField(join = "left", path = "grade.name")
    private String gradeName;

    @DsField(join = "left", path = "gradeRate.id")
    private Long gradeRateId;

    @DsField(join = "left", path = "gradeRate.name")
    private String gradeRateName;

    @DsField()
    private Float fixValue;

    @DsField()
    private Float minValue;

    @DsField()
    private Float maxValue;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    public GradeRateValueDs() {
        super();
    }

    public GradeRateValueDs(GradeRateValue e) {
        super(e);
    }

    public Long getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
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

    public void setGradeRateId(Long gradeRateId) {
        this.gradeRateId = gradeRateId;
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

    public void setFixValue(Float fixValue) {
        this.fixValue = fixValue;
    }

    public Float getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public Float getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
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

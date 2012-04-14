/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScalePoint.class)
public class PayScalePointDs extends AbstractAuditableDs<PayScalePoint> {

    public static final String fPAYSCALEID = "payScaleId";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fCODE = "code";

    @DsField(join = "left", path = "payScale.id")
    private Long payScaleId;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String code;

    public PayScalePointDs() {
        super();
    }

    public PayScalePointDs(PayScalePoint e) {
        super(e);
    }

    public Long getPayScaleId() {
        return this.payScaleId;
    }

    public void setPayScaleId(Long payScaleId) {
        this.payScaleId = payScaleId;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

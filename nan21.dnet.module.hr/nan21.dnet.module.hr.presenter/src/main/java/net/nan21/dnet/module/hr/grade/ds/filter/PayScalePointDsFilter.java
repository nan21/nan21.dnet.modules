/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PayScalePointDsFilter extends AbstractAuditableDsFilter {

    private Long payScaleId;

    private Long payScaleId_From;
    private Long payScaleId_To;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String code;

    public Long getPayScaleId() {
        return this.payScaleId;
    }

    public Long getPayScaleId_From() {
        return this.payScaleId_From;
    }

    public Long getPayScaleId_To() {
        return this.payScaleId_To;
    }

    public void setPayScaleId(Long payScaleId) {
        this.payScaleId = payScaleId;
    }

    public void setPayScaleId_From(Long payScaleId_From) {
        this.payScaleId_From = payScaleId_From;
    }

    public void setPayScaleId_To(Long payScaleId_To) {
        this.payScaleId_To = payScaleId_To;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

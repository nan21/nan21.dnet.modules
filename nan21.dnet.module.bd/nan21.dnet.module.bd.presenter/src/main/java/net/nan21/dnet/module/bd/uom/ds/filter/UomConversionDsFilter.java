/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class UomConversionDsFilter extends AbstractAuditableDsFilter {

    private Long sourceId;

    private Long sourceId_From;
    private Long sourceId_To;

    private String sourceCode;

    private Long targetId;

    private Long targetId_From;
    private Long targetId_To;

    private String targetCode;

    private Float multiplyWith;

    private Float multiplyWith_From;
    private Float multiplyWith_To;

    private Float divideTo;

    private Float divideTo_From;
    private Float divideTo_To;

    private Boolean active;

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

    public Float getMultiplyWith() {
        return this.multiplyWith;
    }

    public Float getMultiplyWith_From() {
        return this.multiplyWith_From;
    }

    public Float getMultiplyWith_To() {
        return this.multiplyWith_To;
    }

    public void setMultiplyWith(Float multiplyWith) {
        this.multiplyWith = multiplyWith;
    }

    public void setMultiplyWith_From(Float multiplyWith_From) {
        this.multiplyWith_From = multiplyWith_From;
    }

    public void setMultiplyWith_To(Float multiplyWith_To) {
        this.multiplyWith_To = multiplyWith_To;
    }

    public Float getDivideTo() {
        return this.divideTo;
    }

    public Float getDivideTo_From() {
        return this.divideTo_From;
    }

    public Float getDivideTo_To() {
        return this.divideTo_To;
    }

    public void setDivideTo(Float divideTo) {
        this.divideTo = divideTo;
    }

    public void setDivideTo_From(Float divideTo_From) {
        this.divideTo_From = divideTo_From;
    }

    public void setDivideTo_To(Float divideTo_To) {
        this.divideTo_To = divideTo_To;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}

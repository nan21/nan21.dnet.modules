/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class PayScaleRateDsFilter extends AbstractTypeDsFilter {

    private Long payScaleId;

    private Long payScaleId_From;
    private Long payScaleId_To;

    private String payScaleCode;

    private String payScaleName;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currencyCode;

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

    public String getPayScaleCode() {
        return this.payScaleCode;
    }

    public void setPayScaleCode(String payScaleCode) {
        this.payScaleCode = payScaleCode;
    }

    public String getPayScaleName() {
        return this.payScaleName;
    }

    public void setPayScaleName(String payScaleName) {
        this.payScaleName = payScaleName;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

@Ds(entity = PayScaleRate.class, sort = { @SortField(field = PayScaleRateDs.fNAME) })
public class PayScaleRateDs extends AbstractTypeDs<PayScaleRate> {

    public static final String fPAYSCALEID = "payScaleId";
    public static final String fPAYSCALECODE = "payScaleCode";
    public static final String fPAYSCALENAME = "payScaleName";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCYCODE = "currencyCode";

    @DsField(join = "left", path = "payScale.id")
    private Long payScaleId;

    @DsField(join = "left", path = "payScale.code")
    private String payScaleCode;

    @DsField(join = "left", path = "payScale.name")
    private String payScaleName;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currencyCode;

    public PayScaleRateDs() {
        super();
    }

    public PayScaleRateDs(PayScaleRate e) {
        super(e);
    }

    public Long getPayScaleId() {
        return this.payScaleId;
    }

    public void setPayScaleId(Long payScaleId) {
        this.payScaleId = payScaleId;
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

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}

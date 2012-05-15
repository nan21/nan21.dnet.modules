/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CurrencyXRate.class, sort = {
        @SortField(field = CurrencyXRateDs.fVALIDAT, desc = true),
        @SortField(field = CurrencyXRateDs.fSOURCECODE),
        @SortField(field = CurrencyXRateDs.fTARGETCODE) })
public class CurrencyXRateDs extends AbstractAuditableDs<CurrencyXRate> {

    public static final String fSOURCEID = "sourceId";
    public static final String fSOURCECODE = "sourceCode";
    public static final String fTARGETID = "targetId";
    public static final String fTARGETCODE = "targetCode";
    public static final String fVALIDAT = "validAt";
    public static final String fVALUE = "value";
    public static final String fPROVIDERID = "providerId";
    public static final String fPROVIDERCODE = "providerCode";

    @DsField(join = "left", path = "source.id")
    private Long sourceId;

    @DsField(join = "left", path = "source.code")
    private String sourceCode;

    @DsField(join = "left", path = "target.id")
    private Long targetId;

    @DsField(join = "left", path = "target.code")
    private String targetCode;

    @DsField()
    private Date validAt;

    @DsField()
    private Float value;

    @DsField(join = "left", path = "provider.id")
    private Long providerId;

    @DsField(join = "left", path = "provider.code")
    private String providerCode;

    public CurrencyXRateDs() {
        super();
    }

    public CurrencyXRateDs(CurrencyXRate e) {
        super(e);
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
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

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetCode() {
        return this.targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Date getValidAt() {
        return this.validAt;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Long getProviderId() {
        return this.providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderCode() {
        return this.providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

}

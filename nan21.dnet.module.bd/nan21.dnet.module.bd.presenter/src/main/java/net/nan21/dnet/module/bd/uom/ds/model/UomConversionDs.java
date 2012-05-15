/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = UomConversion.class)
public class UomConversionDs extends AbstractAuditableDs<UomConversion> {

    public static final String fSOURCEID = "sourceId";
    public static final String fSOURCECODE = "sourceCode";
    public static final String fTARGETID = "targetId";
    public static final String fTARGETCODE = "targetCode";
    public static final String fMULTIPLYWITH = "multiplyWith";
    public static final String fDIVIDETO = "divideTo";
    public static final String fACTIVE = "active";

    @DsField(join = "left", path = "source.id")
    private Long sourceId;

    @DsField(join = "left", path = "source.code")
    private String sourceCode;

    @DsField(join = "left", path = "target.id")
    private Long targetId;

    @DsField(join = "left", path = "target.code")
    private String targetCode;

    @DsField()
    private Float multiplyWith;

    @DsField()
    private Float divideTo;

    @DsField()
    private Boolean active;

    public UomConversionDs() {
        super();
    }

    public UomConversionDs(UomConversion e) {
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

    public Float getMultiplyWith() {
        return this.multiplyWith;
    }

    public void setMultiplyWith(Float multiplyWith) {
        this.multiplyWith = multiplyWith;
    }

    public Float getDivideTo() {
        return this.divideTo;
    }

    public void setDivideTo(Float divideTo) {
        this.divideTo = divideTo;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}

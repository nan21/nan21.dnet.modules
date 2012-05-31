/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysJobCtxParam.class)
public class SysJobCtxParamDs extends AbstractAuditableDs<SysJobCtxParam> {

    public static final String fJOBCTXID = "jobCtxId";
    public static final String fJOBCTX = "jobCtx";
    public static final String fJOBALIAS = "jobAlias";
    public static final String fJOBPARAMID = "jobParamId";
    public static final String fJOBPARAM = "jobParam";
    public static final String fDATATYPE = "dataType";

    @DsField(join = "left", path = "jobCtx.id")
    private Long jobCtxId;

    @DsField(join = "left", path = "jobCtx.name")
    private String jobCtx;

    @DsField(join = "left", path = "jobCtx.jobAlias")
    private String jobAlias;

    @DsField(join = "left", path = "jobParam.id")
    private Long jobParamId;

    @DsField(join = "left", path = "jobParam.name")
    private String jobParam;

    @DsField(join = "left", path = "jobParam.dataType")
    private String dataType;

    public SysJobCtxParamDs() {
        super();
    }

    public SysJobCtxParamDs(SysJobCtxParam e) {
        super(e);
    }

    public Long getJobCtxId() {
        return this.jobCtxId;
    }

    public void setJobCtxId(Long jobCtxId) {
        this.jobCtxId = jobCtxId;
    }

    public String getJobCtx() {
        return this.jobCtx;
    }

    public void setJobCtx(String jobCtx) {
        this.jobCtx = jobCtx;
    }

    public String getJobAlias() {
        return this.jobAlias;
    }

    public void setJobAlias(String jobAlias) {
        this.jobAlias = jobAlias;
    }

    public Long getJobParamId() {
        return this.jobParamId;
    }

    public void setJobParamId(Long jobParamId) {
        this.jobParamId = jobParamId;
    }

    public String getJobParam() {
        return this.jobParam;
    }

    public void setJobParam(String jobParam) {
        this.jobParam = jobParam;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}

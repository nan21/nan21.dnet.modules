/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SysJobCtxParamDsFilter extends AbstractAuditableDsFilter {

    private Long jobCtxId;

    private Long jobCtxId_From;
    private Long jobCtxId_To;

    private String jobCtx;

    private String jobAlias;

    private Long jobParamId;

    private Long jobParamId_From;
    private Long jobParamId_To;

    private String jobParam;

    private String dataType;

    public Long getJobCtxId() {
        return this.jobCtxId;
    }

    public Long getJobCtxId_From() {
        return this.jobCtxId_From;
    }

    public Long getJobCtxId_To() {
        return this.jobCtxId_To;
    }

    public void setJobCtxId(Long jobCtxId) {
        this.jobCtxId = jobCtxId;
    }

    public void setJobCtxId_From(Long jobCtxId_From) {
        this.jobCtxId_From = jobCtxId_From;
    }

    public void setJobCtxId_To(Long jobCtxId_To) {
        this.jobCtxId_To = jobCtxId_To;
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

    public Long getJobParamId_From() {
        return this.jobParamId_From;
    }

    public Long getJobParamId_To() {
        return this.jobParamId_To;
    }

    public void setJobParamId(Long jobParamId) {
        this.jobParamId = jobParamId;
    }

    public void setJobParamId_From(Long jobParamId_From) {
        this.jobParamId_From = jobParamId_From;
    }

    public void setJobParamId_To(Long jobParamId_To) {
        this.jobParamId_To = jobParamId_To;
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

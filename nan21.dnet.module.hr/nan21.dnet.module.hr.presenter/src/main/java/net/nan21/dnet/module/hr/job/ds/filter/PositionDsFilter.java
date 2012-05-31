/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class PositionDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long jobId;

    private Long jobId_From;
    private Long jobId_To;

    private String jobCode;

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    public Long getJobId() {
        return this.jobId;
    }

    public Long getJobId_From() {
        return this.jobId_From;
    }

    public Long getJobId_To() {
        return this.jobId_To;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobId_From(Long jobId_From) {
        this.jobId_From = jobId_From;
    }

    public void setJobId_To(Long jobId_To) {
        this.jobId_To = jobId_To;
    }

    public String getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

}

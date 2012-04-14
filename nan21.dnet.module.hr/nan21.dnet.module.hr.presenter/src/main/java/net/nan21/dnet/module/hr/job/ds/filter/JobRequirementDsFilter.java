/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class JobRequirementDsFilter extends AbstractAuditableDsFilter {

    private Long jobId;

    private Long jobId_From;
    private Long jobId_To;

    private Long requirementId;

    private Long requirementId_From;
    private Long requirementId_To;

    private String requirement;

    private String notes;

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

    public Long getRequirementId() {
        return this.requirementId;
    }

    public Long getRequirementId_From() {
        return this.requirementId_From;
    }

    public Long getRequirementId_To() {
        return this.requirementId_To;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public void setRequirementId_From(Long requirementId_From) {
        this.requirementId_From = requirementId_From;
    }

    public void setRequirementId_To(Long requirementId_To) {
        this.requirementId_To = requirementId_To;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

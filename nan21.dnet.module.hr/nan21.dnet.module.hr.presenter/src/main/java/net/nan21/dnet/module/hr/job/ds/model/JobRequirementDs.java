/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = JobRequirement.class)
public class JobRequirementDs extends AbstractAuditableDs<JobRequirement> {

    public static final String fJOBID = "jobId";
    public static final String fREQUIREMENTID = "requirementId";
    public static final String fREQUIREMENT = "requirement";
    public static final String fNOTES = "notes";

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "requirement.id")
    private Long requirementId;

    @DsField(join = "left", path = "requirement.name")
    private String requirement;

    @DsField()
    private String notes;

    public JobRequirementDs() {
        super();
    }

    public JobRequirementDs(JobRequirement e) {
        super(e);
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getRequirementId() {
        return this.requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
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

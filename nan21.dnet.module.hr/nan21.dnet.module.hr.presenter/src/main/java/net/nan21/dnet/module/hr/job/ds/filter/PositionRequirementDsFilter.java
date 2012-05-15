/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PositionRequirementDsFilter extends AbstractAuditableDsFilter {

    private Long positionId;

    private Long positionId_From;
    private Long positionId_To;

    private Long requirementId;

    private Long requirementId_From;
    private Long requirementId_To;

    private String requirement;

    private String notes;

    public Long getPositionId() {
        return this.positionId;
    }

    public Long getPositionId_From() {
        return this.positionId_From;
    }

    public Long getPositionId_To() {
        return this.positionId_To;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public void setPositionId_From(Long positionId_From) {
        this.positionId_From = positionId_From;
    }

    public void setPositionId_To(Long positionId_To) {
        this.positionId_To = positionId_To;
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

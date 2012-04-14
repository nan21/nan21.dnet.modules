/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class JobSkillDsFilter extends AbstractAuditableDsFilter {

    private Long jobId;

    private Long jobId_From;
    private Long jobId_To;

    private Long competenceId;

    private Long competenceId_From;
    private Long competenceId_To;

    private String competence;

    private Long ratingScaleId;

    private Long ratingScaleId_From;
    private Long ratingScaleId_To;

    private Long requiredLevelId;

    private Long requiredLevelId_From;
    private Long requiredLevelId_To;

    private String requiredLevel;

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

    public Long getCompetenceId() {
        return this.competenceId;
    }

    public Long getCompetenceId_From() {
        return this.competenceId_From;
    }

    public Long getCompetenceId_To() {
        return this.competenceId_To;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    public void setCompetenceId_From(Long competenceId_From) {
        this.competenceId_From = competenceId_From;
    }

    public void setCompetenceId_To(Long competenceId_To) {
        this.competenceId_To = competenceId_To;
    }

    public String getCompetence() {
        return this.competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public Long getRatingScaleId() {
        return this.ratingScaleId;
    }

    public Long getRatingScaleId_From() {
        return this.ratingScaleId_From;
    }

    public Long getRatingScaleId_To() {
        return this.ratingScaleId_To;
    }

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public void setRatingScaleId_From(Long ratingScaleId_From) {
        this.ratingScaleId_From = ratingScaleId_From;
    }

    public void setRatingScaleId_To(Long ratingScaleId_To) {
        this.ratingScaleId_To = ratingScaleId_To;
    }

    public Long getRequiredLevelId() {
        return this.requiredLevelId;
    }

    public Long getRequiredLevelId_From() {
        return this.requiredLevelId_From;
    }

    public Long getRequiredLevelId_To() {
        return this.requiredLevelId_To;
    }

    public void setRequiredLevelId(Long requiredLevelId) {
        this.requiredLevelId = requiredLevelId;
    }

    public void setRequiredLevelId_From(Long requiredLevelId_From) {
        this.requiredLevelId_From = requiredLevelId_From;
    }

    public void setRequiredLevelId_To(Long requiredLevelId_To) {
        this.requiredLevelId_To = requiredLevelId_To;
    }

    public String getRequiredLevel() {
        return this.requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

}

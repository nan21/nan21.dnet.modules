/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeSkillDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private Long skillId;

    private Long skillId_From;
    private Long skillId_To;

    private String skill;

    private Long ratingScaleId;

    private Long ratingScaleId_From;
    private Long ratingScaleId_To;

    private Long skillLevelId;

    private Long skillLevelId_From;
    private Long skillLevelId_To;

    private String skillLevel;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Long getEmployeeId_From() {
        return this.employeeId_From;
    }

    public Long getEmployeeId_To() {
        return this.employeeId_To;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeId_From(Long employeeId_From) {
        this.employeeId_From = employeeId_From;
    }

    public void setEmployeeId_To(Long employeeId_To) {
        this.employeeId_To = employeeId_To;
    }

    public Long getSkillId() {
        return this.skillId;
    }

    public Long getSkillId_From() {
        return this.skillId_From;
    }

    public Long getSkillId_To() {
        return this.skillId_To;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public void setSkillId_From(Long skillId_From) {
        this.skillId_From = skillId_From;
    }

    public void setSkillId_To(Long skillId_To) {
        this.skillId_To = skillId_To;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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

    public Long getSkillLevelId() {
        return this.skillLevelId;
    }

    public Long getSkillLevelId_From() {
        return this.skillLevelId_From;
    }

    public Long getSkillLevelId_To() {
        return this.skillLevelId_To;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    public void setSkillLevelId_From(Long skillLevelId_From) {
        this.skillLevelId_From = skillLevelId_From;
    }

    public void setSkillLevelId_To(Long skillLevelId_To) {
        this.skillLevelId_To = skillLevelId_To;
    }

    public String getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

}

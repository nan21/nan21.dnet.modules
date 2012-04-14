/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EmployeeSkill.class)
public class EmployeeSkillDs extends AbstractAuditableDs<EmployeeSkill> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fSKILLID = "skillId";
    public static final String fSKILL = "skill";
    public static final String fRATINGSCALEID = "ratingScaleId";
    public static final String fSKILLLEVELID = "skillLevelId";
    public static final String fSKILLLEVEL = "skillLevel";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "skill.id")
    private Long skillId;

    @DsField(join = "left", path = "skill.name")
    private String skill;

    @DsField(join = "left", path = "skill.ratingScale.id")
    private Long ratingScaleId;

    @DsField(join = "left", path = "skillLevel.id")
    private Long skillLevelId;

    @DsField(join = "left", path = "skillLevel.name")
    private String skillLevel;

    public EmployeeSkillDs() {
        super();
    }

    public EmployeeSkillDs(EmployeeSkill e) {
        super(e);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
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

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public Long getSkillLevelId() {
        return this.skillLevelId;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    public String getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

}

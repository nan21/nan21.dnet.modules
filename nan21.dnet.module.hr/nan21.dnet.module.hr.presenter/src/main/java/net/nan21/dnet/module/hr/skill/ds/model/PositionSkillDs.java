/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;

@Ds(entity = PositionSkill.class)
public class PositionSkillDs extends AbstractAuditableDs<PositionSkill> {

    public static final String fPOSITIONID = "positionId";
    public static final String fCOMPETENCEID = "competenceId";
    public static final String fCOMPETENCE = "competence";
    public static final String fRATINGSCALEID = "ratingScaleId";
    public static final String fREQUIREDLEVELID = "requiredLevelId";
    public static final String fREQUIREDLEVEL = "requiredLevel";

    @DsField(join = "left", path = "position.id")
    private Long positionId;

    @DsField(join = "left", path = "skill.id")
    private Long competenceId;

    @DsField(join = "left", path = "skill.name")
    private String competence;

    @DsField(join = "left", path = "skill.ratingScale.id")
    private Long ratingScaleId;

    @DsField(join = "left", path = "requiredLevel.id")
    private Long requiredLevelId;

    @DsField(join = "left", path = "requiredLevel.name")
    private String requiredLevel;

    public PositionSkillDs() {
        super();
    }

    public PositionSkillDs(PositionSkill e) {
        super(e);
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getCompetenceId() {
        return this.competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
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

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public Long getRequiredLevelId() {
        return this.requiredLevelId;
    }

    public void setRequiredLevelId(Long requiredLevelId) {
        this.requiredLevelId = requiredLevelId;
    }

    public String getRequiredLevel() {
        return this.requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

}

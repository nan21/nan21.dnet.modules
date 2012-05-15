/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDs;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;

public class PositionSkillDsConv extends
        AbstractDsConverter<PositionSkillDs, PositionSkill> implements
        IDsConverter<PositionSkillDs, PositionSkill> {

    @Override
    protected void modelToEntityReferences(PositionSkillDs ds, PositionSkill e,
            boolean isInsert) throws Exception {

        if (ds.getPositionId() != null) {
            if (e.getPosition() == null
                    || !e.getPosition().getId().equals(ds.getPositionId())) {
                e.setPosition((Position) this.em.find(Position.class,
                        ds.getPositionId()));
            }
        }

        if (ds.getRequiredLevelId() != null) {
            if (e.getRequiredLevel() == null
                    || !e.getRequiredLevel().getId()
                            .equals(ds.getRequiredLevelId())) {
                e.setRequiredLevel((RatingLevel) this.em.find(
                        RatingLevel.class, ds.getRequiredLevelId()));
            }
        } else {
            this.lookup_requiredLevel_RatingLevel(ds, e);
        }

        if (ds.getCompetenceId() != null) {
            if (e.getSkill() == null
                    || !e.getSkill().getId().equals(ds.getCompetenceId())) {
                e.setSkill((Skill) this.em.find(Skill.class,
                        ds.getCompetenceId()));
            }
        } else {
            this.lookup_skill_Skill(ds, e);
        }

    }

    protected void lookup_requiredLevel_RatingLevel(PositionSkillDs ds,
            PositionSkill e) throws Exception {
        if (ds.getRatingScaleId() != null && !ds.getRatingScaleId().equals("")
                && ds.getRequiredLevel() != null
                && !ds.getRequiredLevel().equals("")) {
            RatingLevel x = null;
            try {
                x = ((IRatingLevelService) findEntityService(RatingLevel.class))
                        .findByName(ds.getRatingScaleId(),
                                ds.getRequiredLevel());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `RatingLevel` reference:  `ratingScaleId` = "
                                + ds.getRatingScaleId()
                                + " , `requiredLevel` = "
                                + ds.getRequiredLevel() + "  ");
            }
            e.setRequiredLevel(x);

        } else {
            e.setRequiredLevel(null);
        }
    }

    protected void lookup_skill_Skill(PositionSkillDs ds, PositionSkill e)
            throws Exception {
        if (ds.getCompetence() != null && !ds.getCompetence().equals("")) {
            Skill x = null;
            try {
                x = ((ISkillService) findEntityService(Skill.class))
                        .findByName(ds.getCompetence());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Skill` reference:  `competence` = "
                                + ds.getCompetence() + "  ");
            }
            e.setSkill(x);

        } else {
            e.setSkill(null);
        }
    }

}

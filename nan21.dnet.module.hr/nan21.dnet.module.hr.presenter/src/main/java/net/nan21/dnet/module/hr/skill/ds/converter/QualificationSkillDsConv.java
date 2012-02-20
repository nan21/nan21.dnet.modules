/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs;
import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;

public class QualificationSkillDsConv extends
        AbstractDsConverter<QualificationSkillDs, QualificationSkill> implements
        IDsConverter<QualificationSkillDs, QualificationSkill> {

    @Override
    protected void modelToEntityReferences(QualificationSkillDs ds,
            QualificationSkill e, boolean isInsert) throws Exception {

        if (ds.getQualificationId() != null) {
            if (e.getQualification() == null
                    || !e.getQualification().getId()
                            .equals(ds.getQualificationId())) {
                e.setQualification((Qualification) this.em.find(
                        Qualification.class, ds.getQualificationId()));
            }
        }

        if (ds.getSkillId() != null) {
            if (e.getSkill() == null
                    || !e.getSkill().getId().equals(ds.getSkillId())) {
                e.setSkill((Skill) this.em.find(Skill.class, ds.getSkillId()));
            }
        } else {
            this.lookup_skill_Skill(ds, e);
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

    }

    protected void lookup_skill_Skill(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {
        if (ds.getSkill() != null && !ds.getSkill().equals("")) {
            Skill x = null;
            try {
                x = ((ISkillService) findEntityService(Skill.class))
                        .findByName(ds.getSkill());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Skill` reference:  `skill` = "
                                + ds.getSkill() + "  ");
            }
            e.setSkill(x);

        } else {
            e.setSkill(null);
        }
    }

    protected void lookup_requiredLevel_RatingLevel(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {
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

}

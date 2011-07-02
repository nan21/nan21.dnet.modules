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

    protected void modelToEntityAttributes(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {

        if (ds.getQualificationId() != null) {
            if (e.getQualification() == null
                    || !e.getQualification().getId()
                            .equals(ds.getQualificationId())) {
                e.setQualification((Qualification) this.em.getReference(
                        Qualification.class, ds.getQualificationId()));
            }
        }
        if (ds.getSkillId() != null) {
            if (e.getSkill() == null
                    || !e.getSkill().getId().equals(ds.getSkillId())) {
                e.setSkill((Skill) this.em.getReference(Skill.class,
                        ds.getSkillId()));
            }
        } else {
            this.lookup_skill_Skill(ds, e);
        }
        if (ds.getRequiredLevelId() != null) {
            if (e.getRequiredLevel() == null
                    || !e.getRequiredLevel().getId()
                            .equals(ds.getRequiredLevelId())) {
                e.setRequiredLevel((RatingLevel) this.em.getReference(
                        RatingLevel.class, ds.getRequiredLevelId()));
            }
        } else {
            this.lookup_requiredLevel_RatingLevel(ds, e);
        }
    }

    protected void lookup_skill_Skill(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {
        Skill x = null;
        try {
            x = ((ISkillService) getService(ISkillService.class)).findByName(
                    ds.getClientId(), ds.getSkill());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSkill(x);
    }

    protected void lookup_requiredLevel_RatingLevel(QualificationSkillDs ds,
            QualificationSkill e) throws Exception {
        RatingLevel x = null;
        try {
            x = ((IRatingLevelService) getService(IRatingLevelService.class))
                    .findByName(ds.getClientId(), ds.getRatingScaleId(),
                            ds.getRequiredLevel());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setRequiredLevel(x);
    }

    @Override
    public void entityToModel(QualificationSkill e, QualificationSkillDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setQualificationId(((e.getQualification() != null)) ? e
                .getQualification().getId() : null);
        ds.setSkillId(((e.getSkill() != null)) ? e.getSkill().getId() : null);
        ds.setSkill(((e.getSkill() != null)) ? e.getSkill().getName() : null);
        ds.setRatingScaleId(((e.getSkill() != null) && (e.getSkill()
                .getRatingScale() != null)) ? e.getSkill().getRatingScale()
                .getId() : null);
        ds.setRequiredLevelId(((e.getRequiredLevel() != null)) ? e
                .getRequiredLevel().getId() : null);
        ds.setRequiredLevel(((e.getRequiredLevel() != null)) ? e
                .getRequiredLevel().getName() : null);
    }

}

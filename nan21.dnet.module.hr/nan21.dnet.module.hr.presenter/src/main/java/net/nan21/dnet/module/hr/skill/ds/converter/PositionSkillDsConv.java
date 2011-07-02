/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(PositionSkillDs ds, PositionSkill e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(PositionSkillDs ds, PositionSkill e)
            throws Exception {

        if (ds.getPositionId() != null) {
            if (e.getPosition() == null
                    || !e.getPosition().getId().equals(ds.getPositionId())) {
                e.setPosition((Position) this.em.getReference(Position.class,
                        ds.getPositionId()));
            }
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
        if (ds.getCompetenceId() != null) {
            if (e.getSkill() == null
                    || !e.getSkill().getId().equals(ds.getCompetenceId())) {
                e.setSkill((Skill) this.em.getReference(Skill.class,
                        ds.getCompetenceId()));
            }
        } else {
            this.lookup_skill_Skill(ds, e);
        }
    }

    protected void lookup_requiredLevel_RatingLevel(PositionSkillDs ds,
            PositionSkill e) throws Exception {
        RatingLevel x = null;
        try {
            x = ((IRatingLevelService) getService(IRatingLevelService.class))
                    .findByName(ds.getClientId(), ds.getRatingScaleId(),
                            ds.getRequiredLevel());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setRequiredLevel(x);
    }

    protected void lookup_skill_Skill(PositionSkillDs ds, PositionSkill e)
            throws Exception {
        Skill x = null;
        try {
            x = ((ISkillService) getService(ISkillService.class)).findByName(
                    ds.getClientId(), ds.getCompetence());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSkill(x);
    }

    @Override
    public void entityToModel(PositionSkill e, PositionSkillDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setPositionId(((e.getPosition() != null)) ? e.getPosition().getId()
                : null);
        ds.setCompetenceId(((e.getSkill() != null)) ? e.getSkill().getId()
                : null);
        ds.setCompetence(((e.getSkill() != null)) ? e.getSkill().getName()
                : null);
        ds.setRatingScaleId(((e.getSkill() != null) && (e.getSkill()
                .getRatingScale() != null)) ? e.getSkill().getRatingScale()
                .getId() : null);
        ds.setRequiredLevelId(((e.getRequiredLevel() != null)) ? e
                .getRequiredLevel().getId() : null);
        ds.setRequiredLevel(((e.getRequiredLevel() != null)) ? e
                .getRequiredLevel().getName() : null);
    }

}

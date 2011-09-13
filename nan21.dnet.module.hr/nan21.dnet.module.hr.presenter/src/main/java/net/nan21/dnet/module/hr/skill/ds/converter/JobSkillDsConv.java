/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.JobSkillDs;
import net.nan21.dnet.module.hr.skill.domain.entity.JobSkill;

public class JobSkillDsConv extends AbstractDsConverter<JobSkillDs, JobSkill>
        implements IDsConverter<JobSkillDs, JobSkill> {

    protected void modelToEntityAttributes(JobSkillDs ds, JobSkill e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(JobSkillDs ds, JobSkill e)
            throws Exception {

        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
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

    protected void lookup_requiredLevel_RatingLevel(JobSkillDs ds, JobSkill e)
            throws Exception {
        if (ds.getRatingScaleId() != null && !ds.getRatingScaleId().equals("")
                && ds.getRequiredLevel() != null
                && !ds.getRequiredLevel().equals("")) {
            RatingLevel x = null;
            try {
                x = ((IRatingLevelService) getService(IRatingLevelService.class))
                        .findByName(ds.getClientId(), ds.getRatingScaleId(),
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

    protected void lookup_skill_Skill(JobSkillDs ds, JobSkill e)
            throws Exception {
        if (ds.getCompetence() != null && !ds.getCompetence().equals("")) {
            Skill x = null;
            try {
                x = ((ISkillService) getService(ISkillService.class))
                        .findByName(ds.getClientId(), ds.getCompetence());
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

    @Override
    public void entityToModel(JobSkill e, JobSkillDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setJobId(((e.getJob() != null)) ? e.getJob().getId() : null);
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

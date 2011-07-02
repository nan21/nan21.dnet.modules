/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs;
import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;

public class EmployeeSkillDsConv extends
        AbstractDsConverter<EmployeeSkillDs, EmployeeSkill> implements
        IDsConverter<EmployeeSkillDs, EmployeeSkill> {

    protected void modelToEntityAttributes(EmployeeSkillDs ds, EmployeeSkill e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(EmployeeSkillDs ds, EmployeeSkill e)
            throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.getReference(Employee.class,
                        ds.getEmployeeId()));
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
        if (ds.getSkillLevelId() != null) {
            if (e.getSkillLevel() == null
                    || !e.getSkillLevel().getId().equals(ds.getSkillLevelId())) {
                e.setSkillLevel((RatingLevel) this.em.getReference(
                        RatingLevel.class, ds.getSkillLevelId()));
            }
        } else {
            this.lookup_skillLevel_RatingLevel(ds, e);
        }
    }

    protected void lookup_skill_Skill(EmployeeSkillDs ds, EmployeeSkill e)
            throws Exception {
        Skill x = null;
        try {
            x = ((ISkillService) getService(ISkillService.class)).findByName(
                    ds.getClientId(), ds.getSkill());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSkill(x);
    }

    protected void lookup_skillLevel_RatingLevel(EmployeeSkillDs ds,
            EmployeeSkill e) throws Exception {
        RatingLevel x = null;
        try {
            x = ((IRatingLevelService) getService(IRatingLevelService.class))
                    .findByName(ds.getClientId(), ds.getRatingScaleId(),
                            ds.getSkillLevel());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSkillLevel(x);
    }

    @Override
    public void entityToModel(EmployeeSkill e, EmployeeSkillDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setSkillId(((e.getSkill() != null)) ? e.getSkill().getId() : null);
        ds.setSkill(((e.getSkill() != null)) ? e.getSkill().getName() : null);
        ds.setRatingScaleId(((e.getSkill() != null) && (e.getSkill()
                .getRatingScale() != null)) ? e.getSkill().getRatingScale()
                .getId() : null);
        ds.setSkillLevelId(((e.getSkillLevel() != null)) ? e.getSkillLevel()
                .getId() : null);
        ds.setSkillLevel(((e.getSkillLevel() != null)) ? e.getSkillLevel()
                .getName() : null);
    }

}

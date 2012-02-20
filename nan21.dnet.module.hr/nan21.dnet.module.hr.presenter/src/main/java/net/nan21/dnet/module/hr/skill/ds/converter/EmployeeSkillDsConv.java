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

    @Override
    protected void modelToEntityReferences(EmployeeSkillDs ds, EmployeeSkill e,
            boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
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

        if (ds.getSkillLevelId() != null) {
            if (e.getSkillLevel() == null
                    || !e.getSkillLevel().getId().equals(ds.getSkillLevelId())) {
                e.setSkillLevel((RatingLevel) this.em.find(RatingLevel.class,
                        ds.getSkillLevelId()));
            }
        } else {
            this.lookup_skillLevel_RatingLevel(ds, e);
        }

    }

    protected void lookup_skill_Skill(EmployeeSkillDs ds, EmployeeSkill e)
            throws Exception {
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

    protected void lookup_skillLevel_RatingLevel(EmployeeSkillDs ds,
            EmployeeSkill e) throws Exception {
        if (ds.getRatingScaleId() != null && !ds.getRatingScaleId().equals("")
                && ds.getSkillLevel() != null && !ds.getSkillLevel().equals("")) {
            RatingLevel x = null;
            try {
                x = ((IRatingLevelService) findEntityService(RatingLevel.class))
                        .findByName(ds.getRatingScaleId(), ds.getSkillLevel());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `RatingLevel` reference:  `ratingScaleId` = "
                                + ds.getRatingScaleId() + " , `skillLevel` = "
                                + ds.getSkillLevel() + "  ");
            }
            e.setSkillLevel(x);

        } else {
            e.setSkillLevel(null);
        }
    }

}

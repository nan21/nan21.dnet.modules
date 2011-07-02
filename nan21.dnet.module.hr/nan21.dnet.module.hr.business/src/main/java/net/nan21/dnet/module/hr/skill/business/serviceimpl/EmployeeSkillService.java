/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.skill.business.service.IEmployeeSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;

public class EmployeeSkillService extends AbstractEntityService<EmployeeSkill>
        implements IEmployeeSkillService {

    public EmployeeSkillService() {
        super();
    }

    public EmployeeSkillService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeSkill> getEntityClass() {
        return EmployeeSkill.class;
    }

    public List<EmployeeSkill> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeSkill> findByEmployeeId(Long employeeId) {
        return (List<EmployeeSkill>) this.em
                .createQuery(
                        "select e from EmployeeSkill where e.employee.id = :pEmployeeId",
                        EmployeeSkill.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeSkill> findBySkill(Skill skill) {
        return this.findBySkillId(skill.getId());
    }

    public List<EmployeeSkill> findBySkillId(Long skillId) {
        return (List<EmployeeSkill>) this.em
                .createQuery(
                        "select e from EmployeeSkill where e.skill.id = :pSkillId",
                        EmployeeSkill.class).setParameter("pSkillId", skillId)
                .getResultList();
    }

    public List<EmployeeSkill> findBySkillLevel(RatingLevel skillLevel) {
        return this.findBySkillLevelId(skillLevel.getId());
    }

    public List<EmployeeSkill> findBySkillLevelId(Long skillLevelId) {
        return (List<EmployeeSkill>) this.em
                .createQuery(
                        "select e from EmployeeSkill where e.skillLevel.id = :pSkillLevelId",
                        EmployeeSkill.class)
                .setParameter("pSkillLevelId", skillLevelId).getResultList();
    }

}

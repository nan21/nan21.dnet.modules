/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;

public interface IEmployeeSkillService extends IEntityService<EmployeeSkill> {

    public List<EmployeeSkill> findByEmployee(Employee employee);

    public List<EmployeeSkill> findByEmployeeId(Long employeeId);

    public List<EmployeeSkill> findBySkill(Skill skill);

    public List<EmployeeSkill> findBySkillId(Long skillId);

    public List<EmployeeSkill> findBySkillLevel(RatingLevel skillLevel);

    public List<EmployeeSkill> findBySkillLevelId(Long skillLevelId);

}

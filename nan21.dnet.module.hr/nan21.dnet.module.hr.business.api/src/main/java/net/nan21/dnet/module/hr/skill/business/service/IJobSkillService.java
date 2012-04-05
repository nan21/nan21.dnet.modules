/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.module.hr.skill.domain.entity.JobSkill;

public interface IJobSkillService extends IEntityService<JobSkill> {

    public List<JobSkill> findByJob(Job job);

    public List<JobSkill> findByJobId(Long jobId);

    public List<JobSkill> findBySkill(Skill skill);

    public List<JobSkill> findBySkillId(Long skillId);

    public List<JobSkill> findByRequiredLevel(RatingLevel requiredLevel);

    public List<JobSkill> findByRequiredLevelId(Long requiredLevelId);

}

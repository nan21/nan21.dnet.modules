/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;

public interface IQualificationSkillService extends
        IEntityService<QualificationSkill> {

    public List<QualificationSkill> findByQualification(
            Qualification qualification);

    public List<QualificationSkill> findByQualificationId(Long qualificationId);

    public List<QualificationSkill> findBySkill(Skill skill);

    public List<QualificationSkill> findBySkillId(Long skillId);

    public List<QualificationSkill> findByRequiredLevel(
            RatingLevel requiredLevel);

    public List<QualificationSkill> findByRequiredLevelId(Long requiredLevelId);

}

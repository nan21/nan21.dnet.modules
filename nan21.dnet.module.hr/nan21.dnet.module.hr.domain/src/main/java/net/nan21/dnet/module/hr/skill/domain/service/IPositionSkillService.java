/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;

public interface IPositionSkillService extends IEntityService<PositionSkill> {

    public List<PositionSkill> findByPosition(Position position);

    public List<PositionSkill> findByPositionId(Long positionId);

    public List<PositionSkill> findBySkill(Skill skill);

    public List<PositionSkill> findBySkillId(Long skillId);

    public List<PositionSkill> findByRequiredLevel(RatingLevel requiredLevel);

    public List<PositionSkill> findByRequiredLevelId(Long requiredLevelId);

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

public interface ISkillService extends IEntityService<Skill> {

    public Skill findByName(Long clientId, String name);

    public List<Skill> findByType(SkillType type);

    public List<Skill> findByTypeId(Long typeId);

    public List<Skill> findByRatingScale(RatingScale ratingScale);

    public List<Skill> findByRatingScaleId(Long ratingScaleId);

}

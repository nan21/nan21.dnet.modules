/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

public interface ISkillTypeService extends IEntityService<SkillType> {

    public SkillType findByName(Long clientId, String name);

    public List<SkillType> findByCategory(SkillCategory category);

    public List<SkillType> findByCategoryId(Long categoryId);

}

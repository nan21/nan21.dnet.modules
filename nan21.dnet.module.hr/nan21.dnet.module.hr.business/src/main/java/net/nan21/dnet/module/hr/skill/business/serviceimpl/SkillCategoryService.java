/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

public class SkillCategoryService extends AbstractEntityService<SkillCategory>
        implements ISkillCategoryService {

    public SkillCategoryService() {
        super();
    }

    public SkillCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SkillCategory> getEntityClass() {
        return SkillCategory.class;
    }

    public SkillCategory findByName(Long clientId, String name) {
        return (SkillCategory) this.em
                .createNamedQuery(SkillCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}

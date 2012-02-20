/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillTypeService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

public class SkillTypeService extends AbstractEntityService<SkillType>
        implements ISkillTypeService {

    public SkillTypeService() {
        super();
    }

    public SkillTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SkillType> getEntityClass() {
        return SkillType.class;
    }

    public SkillType findByName(String name) {
        return (SkillType) this.em.createNamedQuery(SkillType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<SkillType> findByCategory(SkillCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<SkillType> findByCategoryId(Long categoryId) {
        return (List<SkillType>) this.em
                .createQuery(
                        "select e from SkillType e where e.clientId = :pClientId and  e.category.id = :pCategoryId",
                        SkillType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}

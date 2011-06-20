/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.module.hr.training.domain.service.ICourseTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

public class CourseTypeService extends AbstractEntityService<CourseType>
        implements ICourseTypeService {

    public CourseTypeService() {
        super();
    }

    public CourseTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CourseType> getEntityClass() {
        return CourseType.class;
    }

    public CourseType findByName(Long clientId, String name) {
        return (CourseType) this.em
                .createNamedQuery(CourseType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<CourseType> findByCategory(CourseCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<CourseType> findByCategoryId(Long categoryId) {
        return (List<CourseType>) this.em
                .createQuery(
                        "select e from CourseType where e.category.id = :pCategoryId",
                        CourseType.class)
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}

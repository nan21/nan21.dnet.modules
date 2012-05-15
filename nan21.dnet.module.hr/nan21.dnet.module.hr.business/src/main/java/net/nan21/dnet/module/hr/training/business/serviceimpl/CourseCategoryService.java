/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.training.business.service.ICourseCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

public class CourseCategoryService extends
        AbstractEntityService<CourseCategory> implements ICourseCategoryService {

    public CourseCategoryService() {
        super();
    }

    public CourseCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CourseCategory> getEntityClass() {
        return CourseCategory.class;
    }

    public CourseCategory findByName(String name) {
        return (CourseCategory) this.em
                .createNamedQuery(CourseCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}

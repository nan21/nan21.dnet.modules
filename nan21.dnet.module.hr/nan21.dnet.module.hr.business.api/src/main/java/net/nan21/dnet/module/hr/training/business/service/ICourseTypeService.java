/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

public interface ICourseTypeService extends IEntityService<CourseType> {

    public CourseType findByName(String name);

    public List<CourseType> findByCategory(CourseCategory category);

    public List<CourseType> findByCategoryId(Long categoryId);

}

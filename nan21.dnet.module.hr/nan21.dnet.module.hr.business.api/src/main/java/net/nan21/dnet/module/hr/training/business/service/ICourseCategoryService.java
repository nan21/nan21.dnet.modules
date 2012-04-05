/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

public interface ICourseCategoryService extends IEntityService<CourseCategory> {

    public CourseCategory findByName(String name);

}

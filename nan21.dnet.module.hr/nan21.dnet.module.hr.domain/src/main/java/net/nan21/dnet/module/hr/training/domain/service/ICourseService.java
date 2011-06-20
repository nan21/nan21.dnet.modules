/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

import net.nan21.dnet.module.hr.training.domain.entity.Course;

public interface ICourseService extends IEntityService<Course> {

    public Course findByCode(Long clientId, String code);

    public Course findByName(Long clientId, String name);

    public List<Course> findByType(CourseType type);

    public List<Course> findByTypeId(Long typeId);

}

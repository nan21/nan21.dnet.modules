/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import net.nan21.dnet.module.hr.training.domain.entity.PositionCourse;

public interface IPositionCourseService extends IEntityService<PositionCourse> {

    public List<PositionCourse> findByPosition(Position position);

    public List<PositionCourse> findByPositionId(Long positionId);

    public List<PositionCourse> findByCourse(Course course);

    public List<PositionCourse> findByCourseId(Long courseId);

}

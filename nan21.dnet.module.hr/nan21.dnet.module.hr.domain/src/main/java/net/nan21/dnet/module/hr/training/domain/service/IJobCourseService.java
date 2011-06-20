/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;

public interface IJobCourseService extends IEntityService<JobCourse> {

    public List<JobCourse> findByJob(Job job);

    public List<JobCourse> findByJobId(Long jobId);

    public List<JobCourse> findByCourse(Course course);

    public List<JobCourse> findByCourseId(Long courseId);

}

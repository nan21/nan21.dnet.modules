/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.business.service.IJobCourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;

public class JobCourseService extends AbstractEntityService<JobCourse>
        implements IJobCourseService {

    public JobCourseService() {
        super();
    }

    public JobCourseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<JobCourse> getEntityClass() {
        return JobCourse.class;
    }

    public List<JobCourse> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<JobCourse> findByJobId(Long jobId) {
        return (List<JobCourse>) this.em
                .createQuery(
                        "select e from JobCourse e where e.job.id = :pJobId",
                        JobCourse.class).setParameter("pJobId", jobId)
                .getResultList();
    }

    public List<JobCourse> findByCourse(Course course) {
        return this.findByCourseId(course.getId());
    }

    public List<JobCourse> findByCourseId(Long courseId) {
        return (List<JobCourse>) this.em
                .createQuery(
                        "select e from JobCourse e where e.course.id = :pCourseId",
                        JobCourse.class).setParameter("pCourseId", courseId)
                .getResultList();
    }

}

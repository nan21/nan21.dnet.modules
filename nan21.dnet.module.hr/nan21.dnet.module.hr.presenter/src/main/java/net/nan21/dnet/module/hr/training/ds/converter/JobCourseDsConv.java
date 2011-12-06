/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IJobService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.business.service.ICourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.JobCourseDs;
import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;

public class JobCourseDsConv extends
        AbstractDsConverter<JobCourseDs, JobCourse> implements
        IDsConverter<JobCourseDs, JobCourse> {

    protected void modelToEntityReferences(JobCourseDs ds, JobCourse e)
            throws Exception {
        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_Job(ds, e);
        }
        if (ds.getCourseId() != null) {
            if (e.getCourse() == null
                    || !e.getCourse().getId().equals(ds.getCourseId())) {
                e.setCourse((Course) this.em.find(Course.class,
                        ds.getCourseId()));
            }
        } else {
            this.lookup_course_Course(ds, e);
        }
    }

    protected void lookup_job_Job(JobCourseDs ds, JobCourse e) throws Exception {
        if (ds.getJobCode() != null && !ds.getJobCode().equals("")) {
            Job x = null;
            try {
                x = ((IJobService) getService(IJobService.class)).findByCode(
                        ds.getClientId(), ds.getJobCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Job` reference:  `jobCode` = "
                                + ds.getJobCode() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

    protected void lookup_course_Course(JobCourseDs ds, JobCourse e)
            throws Exception {
        if (ds.getCourseCode() != null && !ds.getCourseCode().equals("")) {
            Course x = null;
            try {
                x = ((ICourseService) getService(ICourseService.class))
                        .findByCode(ds.getClientId(), ds.getCourseCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Course` reference:  `courseCode` = "
                                + ds.getCourseCode() + "  ");
            }
            e.setCourse(x);

        } else {
            e.setCourse(null);
        }
    }

}

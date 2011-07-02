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

    protected void modelToEntityAttributes(JobCourseDs ds, JobCourse e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setMandatory(ds.getMandatory());
        e.setValidFor(ds.getValidFor());
    }

    protected void modelToEntityReferences(JobCourseDs ds, JobCourse e)
            throws Exception {

        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.getReference(Job.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_Job(ds, e);
        }
        if (ds.getCourseId() != null) {
            if (e.getCourse() == null
                    || !e.getCourse().getId().equals(ds.getCourseId())) {
                e.setCourse((Course) this.em.getReference(Course.class,
                        ds.getCourseId()));
            }
        } else {
            this.lookup_course_Course(ds, e);
        }
    }

    protected void lookup_job_Job(JobCourseDs ds, JobCourse e) throws Exception {
        Job x = null;
        try {
            x = ((IJobService) getService(IJobService.class)).findByCode(
                    ds.getClientId(), ds.getJobCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setJob(x);
    }

    protected void lookup_course_Course(JobCourseDs ds, JobCourse e)
            throws Exception {
        Course x = null;
        try {
            x = ((ICourseService) getService(ICourseService.class)).findByCode(
                    ds.getClientId(), ds.getCourseCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCourse(x);
    }

    @Override
    public void entityToModel(JobCourse e, JobCourseDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setMandatory(e.getMandatory());
        ds.setValidFor(e.getValidFor());
        ds.setJobId(((e.getJob() != null)) ? e.getJob().getId() : null);
        ds.setJobCode(((e.getJob() != null)) ? e.getJob().getCode() : null);
        ds.setJobName(((e.getJob() != null)) ? e.getJob().getName() : null);
        ds.setCourseId(((e.getCourse() != null)) ? e.getCourse().getId() : null);
        ds.setCourseCode(((e.getCourse() != null)) ? e.getCourse().getCode()
                : null);
        ds.setCourseName(((e.getCourse() != null)) ? e.getCourse().getName()
                : null);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = JobCourse.class)
public class JobCourseDs extends AbstractAuditableDs<JobCourse> {

    public static final String fJOBID = "jobId";
    public static final String fJOBCODE = "jobCode";
    public static final String fJOBNAME = "jobName";
    public static final String fCOURSEID = "courseId";
    public static final String fCOURSECODE = "courseCode";
    public static final String fCOURSENAME = "courseName";
    public static final String fMANDATORY = "mandatory";
    public static final String fVALIDFOR = "validFor";

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.code")
    private String jobCode;

    @DsField(join = "left", path = "job.name")
    private String jobName;

    @DsField(join = "left", path = "course.id")
    private Long courseId;

    @DsField(join = "left", path = "course.code")
    private String courseCode;

    @DsField(join = "left", path = "course.name")
    private String courseName;

    @DsField()
    private Boolean mandatory;

    @DsField()
    private Integer validFor;

    public JobCourseDs() {
        super();
    }

    public JobCourseDs(JobCourse e) {
        super(e);
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getValidFor() {
        return this.validFor;
    }

    public void setValidFor(Integer validFor) {
        this.validFor = validFor;
    }

}

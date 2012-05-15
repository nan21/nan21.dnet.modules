/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class JobCourseDsFilter extends AbstractAuditableDsFilter {

    private Long jobId;

    private Long jobId_From;
    private Long jobId_To;

    private String jobCode;

    private String jobName;

    private Long courseId;

    private Long courseId_From;
    private Long courseId_To;

    private String courseCode;

    private String courseName;

    private Boolean mandatory;

    private Integer validFor;

    private Integer validFor_From;
    private Integer validFor_To;

    public Long getJobId() {
        return this.jobId;
    }

    public Long getJobId_From() {
        return this.jobId_From;
    }

    public Long getJobId_To() {
        return this.jobId_To;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobId_From(Long jobId_From) {
        this.jobId_From = jobId_From;
    }

    public void setJobId_To(Long jobId_To) {
        this.jobId_To = jobId_To;
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

    public Long getCourseId_From() {
        return this.courseId_From;
    }

    public Long getCourseId_To() {
        return this.courseId_To;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseId_From(Long courseId_From) {
        this.courseId_From = courseId_From;
    }

    public void setCourseId_To(Long courseId_To) {
        this.courseId_To = courseId_To;
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

    public Integer getValidFor_From() {
        return this.validFor_From;
    }

    public Integer getValidFor_To() {
        return this.validFor_To;
    }

    public void setValidFor(Integer validFor) {
        this.validFor = validFor;
    }

    public void setValidFor_From(Integer validFor_From) {
        this.validFor_From = validFor_From;
    }

    public void setValidFor_To(Integer validFor_To) {
        this.validFor_To = validFor_To;
    }

}

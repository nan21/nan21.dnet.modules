/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PositionCourseDsFilter extends AbstractAuditableDsFilter {

    private Long positionId;

    private Long positionId_From;
    private Long positionId_To;

    private String positionCode;

    private String positionName;

    private Long courseId;

    private Long courseId_From;
    private Long courseId_To;

    private String courseCode;

    private String courseName;

    private Boolean mandatory;

    private Integer validFor;

    private Integer validFor_From;
    private Integer validFor_To;

    public Long getPositionId() {
        return this.positionId;
    }

    public Long getPositionId_From() {
        return this.positionId_From;
    }

    public Long getPositionId_To() {
        return this.positionId_To;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public void setPositionId_From(Long positionId_From) {
        this.positionId_From = positionId_From;
    }

    public void setPositionId_To(Long positionId_To) {
        this.positionId_To = positionId_To;
    }

    public String getPositionCode() {
        return this.positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return this.positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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

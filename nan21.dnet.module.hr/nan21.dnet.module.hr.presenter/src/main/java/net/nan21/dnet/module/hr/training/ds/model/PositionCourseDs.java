/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.training.domain.entity.PositionCourse;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PositionCourse.class)
public class PositionCourseDs extends AbstractAuditableDs<PositionCourse> {

    public static final String fPOSITIONID = "positionId";
    public static final String fPOSITIONCODE = "positionCode";
    public static final String fPOSITIONNAME = "positionName";
    public static final String fCOURSEID = "courseId";
    public static final String fCOURSECODE = "courseCode";
    public static final String fCOURSENAME = "courseName";
    public static final String fMANDATORY = "mandatory";
    public static final String fVALIDFOR = "validFor";

    @DsField(join = "left", path = "position.id")
    private Long positionId;

    @DsField(join = "left", path = "position.code")
    private String positionCode;

    @DsField(join = "left", path = "position.name")
    private String positionName;

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

    public PositionCourseDs() {
        super();
    }

    public PositionCourseDs(PositionCourse e) {
        super(e);
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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

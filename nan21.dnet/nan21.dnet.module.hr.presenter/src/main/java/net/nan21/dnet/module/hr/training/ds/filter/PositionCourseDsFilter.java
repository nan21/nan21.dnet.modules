/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class PositionCourseDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

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

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class QualificationSkillDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long qualificationId;

    private Long qualificationId_From;
    private Long qualificationId_To;

    private Long skillId;

    private Long skillId_From;
    private Long skillId_To;

    private String skill;

    private Long ratingScaleId;

    private Long ratingScaleId_From;
    private Long ratingScaleId_To;

    private Long requiredLevelId;

    private Long requiredLevelId_From;
    private Long requiredLevelId_To;

    private String requiredLevel;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

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

    public Long getQualificationId() {
        return this.qualificationId;
    }

    public Long getQualificationId_From() {
        return this.qualificationId_From;
    }

    public Long getQualificationId_To() {
        return this.qualificationId_To;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public void setQualificationId_From(Long qualificationId_From) {
        this.qualificationId_From = qualificationId_From;
    }

    public void setQualificationId_To(Long qualificationId_To) {
        this.qualificationId_To = qualificationId_To;
    }

    public Long getSkillId() {
        return this.skillId;
    }

    public Long getSkillId_From() {
        return this.skillId_From;
    }

    public Long getSkillId_To() {
        return this.skillId_To;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public void setSkillId_From(Long skillId_From) {
        this.skillId_From = skillId_From;
    }

    public void setSkillId_To(Long skillId_To) {
        this.skillId_To = skillId_To;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Long getRatingScaleId() {
        return this.ratingScaleId;
    }

    public Long getRatingScaleId_From() {
        return this.ratingScaleId_From;
    }

    public Long getRatingScaleId_To() {
        return this.ratingScaleId_To;
    }

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public void setRatingScaleId_From(Long ratingScaleId_From) {
        this.ratingScaleId_From = ratingScaleId_From;
    }

    public void setRatingScaleId_To(Long ratingScaleId_To) {
        this.ratingScaleId_To = ratingScaleId_To;
    }

    public Long getRequiredLevelId() {
        return this.requiredLevelId;
    }

    public Long getRequiredLevelId_From() {
        return this.requiredLevelId_From;
    }

    public Long getRequiredLevelId_To() {
        return this.requiredLevelId_To;
    }

    public void setRequiredLevelId(Long requiredLevelId) {
        this.requiredLevelId = requiredLevelId;
    }

    public void setRequiredLevelId_From(Long requiredLevelId_From) {
        this.requiredLevelId_From = requiredLevelId_From;
    }

    public void setRequiredLevelId_To(Long requiredLevelId_To) {
        this.requiredLevelId_To = requiredLevelId_To;
    }

    public String getRequiredLevel() {
        return this.requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

}

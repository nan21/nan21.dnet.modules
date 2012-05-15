/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class RatingLevelDsFilter extends AbstractTypeDsFilter {

    private Integer value;

    private Integer value_From;
    private Integer value_To;

    private Long ratingScaleId;

    private Long ratingScaleId_From;
    private Long ratingScaleId_To;

    private String ratingScale;

    public Integer getValue() {
        return this.value;
    }

    public Integer getValue_From() {
        return this.value_From;
    }

    public Integer getValue_To() {
        return this.value_To;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setValue_From(Integer value_From) {
        this.value_From = value_From;
    }

    public void setValue_To(Integer value_To) {
        this.value_To = value_To;
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

    public String getRatingScale() {
        return this.ratingScale;
    }

    public void setRatingScale(String ratingScale) {
        this.ratingScale = ratingScale;
    }

}

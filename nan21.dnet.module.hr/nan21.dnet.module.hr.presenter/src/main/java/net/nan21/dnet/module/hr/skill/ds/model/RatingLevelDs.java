/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = RatingLevel.class, sort = { @SortField(field = RatingLevelDs.fNAME) })
public class RatingLevelDs extends AbstractTypeDs<RatingLevel> {

    public static final String fVALUE = "value";
    public static final String fRATINGSCALEID = "ratingScaleId";
    public static final String fRATINGSCALE = "ratingScale";

    @DsField()
    private Integer value;

    @DsField(join = "left", path = "ratingScale.id")
    private Long ratingScaleId;

    @DsField(join = "left", path = "ratingScale.name")
    private String ratingScale;

    public RatingLevelDs() {
        super();
    }

    public RatingLevelDs(RatingLevel e) {
        super(e);
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getRatingScaleId() {
        return this.ratingScaleId;
    }

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public String getRatingScale() {
        return this.ratingScale;
    }

    public void setRatingScale(String ratingScale) {
        this.ratingScale = ratingScale;
    }

}

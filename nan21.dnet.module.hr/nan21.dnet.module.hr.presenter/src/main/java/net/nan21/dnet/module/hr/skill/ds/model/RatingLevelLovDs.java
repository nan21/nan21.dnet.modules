/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;

@Ds(entity = RatingLevel.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = RatingLevelLovDs.fVALUE) })
public class RatingLevelLovDs extends AbstractTypeLov<RatingLevel> {

    public static final String fRATINGSCALEID = "ratingScaleId";
    public static final String fVALUE = "value";

    @DsField(join = "left", path = "ratingScale.id")
    private Long ratingScaleId;

    @DsField()
    private Integer value;

    public RatingLevelLovDs() {
        super();
    }

    public RatingLevelLovDs(RatingLevel e) {
        super(e);
    }

    public Long getRatingScaleId() {
        return this.ratingScaleId;
    }

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}

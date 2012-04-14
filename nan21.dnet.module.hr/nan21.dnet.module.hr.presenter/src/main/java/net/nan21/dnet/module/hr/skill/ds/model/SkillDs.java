/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.skill.domain.entity.Skill;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Skill.class, sort = { @SortField(field = SkillDs.fNAME) })
public class SkillDs extends AbstractTypeDs<Skill> {

    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fRATINGSCALEID = "ratingScaleId";
    public static final String fRATINGSCALE = "ratingScale";

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "ratingScale.id")
    private Long ratingScaleId;

    @DsField(join = "left", path = "ratingScale.name")
    private String ratingScale;

    public SkillDs() {
        super();
    }

    public SkillDs(Skill e) {
        super(e);
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

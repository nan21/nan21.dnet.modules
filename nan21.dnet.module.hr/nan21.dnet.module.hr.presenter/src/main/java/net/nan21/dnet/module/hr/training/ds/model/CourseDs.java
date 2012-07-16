/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

@Ds(entity = Course.class, sort = { @SortField(field = CourseDs.fNAME) })
public class CourseDs extends AbstractTypeWithCodeDs<Course> {

    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fINTENDEDAUDIENCE = "intendedAudience";
    public static final String fDELIVEREDCOMPETENCES = "deliveredCompetences";
    public static final String fREQUIREMENTS = "requirements";

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField()
    private String intendedAudience;

    @DsField()
    private String deliveredCompetences;

    @DsField()
    private String requirements;

    public CourseDs() {
        super();
    }

    public CourseDs(Course e) {
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

    public String getIntendedAudience() {
        return this.intendedAudience;
    }

    public void setIntendedAudience(String intendedAudience) {
        this.intendedAudience = intendedAudience;
    }

    public String getDeliveredCompetences() {
        return this.deliveredCompetences;
    }

    public void setDeliveredCompetences(String deliveredCompetences) {
        this.deliveredCompetences = deliveredCompetences;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

}

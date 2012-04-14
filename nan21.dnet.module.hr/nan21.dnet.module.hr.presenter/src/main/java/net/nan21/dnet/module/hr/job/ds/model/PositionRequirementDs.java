/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PositionRequirement.class)
public class PositionRequirementDs extends
        AbstractAuditableDs<PositionRequirement> {

    public static final String fPOSITIONID = "positionId";
    public static final String fREQUIREMENTID = "requirementId";
    public static final String fREQUIREMENT = "requirement";
    public static final String fNOTES = "notes";

    @DsField(join = "left", path = "position.id")
    private Long positionId;

    @DsField(join = "left", path = "requirement.id")
    private Long requirementId;

    @DsField(join = "left", path = "requirement.name")
    private String requirement;

    @DsField()
    private String notes;

    public PositionRequirementDs() {
        super();
    }

    public PositionRequirementDs(PositionRequirement e) {
        super(e);
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getRequirementId() {
        return this.requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

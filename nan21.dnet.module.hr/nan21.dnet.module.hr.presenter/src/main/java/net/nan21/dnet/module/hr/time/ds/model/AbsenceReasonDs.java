/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;

@Ds(entity = AbsenceReason.class, sort = { @SortField(field = AbsenceReasonDs.fNAME) })
public class AbsenceReasonDs extends AbstractTypeDs<AbsenceReason> {

    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    public AbsenceReasonDs() {
        super();
    }

    public AbsenceReasonDs(AbsenceReason e) {
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

}

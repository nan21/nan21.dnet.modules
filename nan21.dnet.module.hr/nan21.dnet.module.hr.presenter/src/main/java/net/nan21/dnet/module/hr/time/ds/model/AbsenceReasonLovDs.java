/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AbsenceReason.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AbsenceReasonLovDs.fNAME) })
public class AbsenceReasonLovDs extends AbstractTypeLov<AbsenceReason> {

    public static final String fTYPEID = "typeId";

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    public AbsenceReasonLovDs() {
        super();
    }

    public AbsenceReasonLovDs(AbsenceReason e) {
        super(e);
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

}

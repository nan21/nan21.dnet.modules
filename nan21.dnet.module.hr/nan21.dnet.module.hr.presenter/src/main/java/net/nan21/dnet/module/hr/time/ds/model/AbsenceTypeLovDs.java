/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AbsenceType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AbsenceTypeLovDs.fNAME) })
public class AbsenceTypeLovDs extends AbstractTypeLov<AbsenceType> {

    public AbsenceTypeLovDs() {
        super();
    }

    public AbsenceTypeLovDs(AbsenceType e) {
        super(e);
    }

}

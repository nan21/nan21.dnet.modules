/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = GradeRate.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = GradeRateLovDs.fNAME) })
public class GradeRateLovDs extends AbstractTypeLov<GradeRate> {

    public GradeRateLovDs() {
        super();
    }

    public GradeRateLovDs(GradeRate e) {
        super(e);
    }

}

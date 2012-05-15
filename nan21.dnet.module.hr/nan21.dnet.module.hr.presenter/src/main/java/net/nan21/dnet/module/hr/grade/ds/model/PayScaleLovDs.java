/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScale.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = PayScaleLovDs.fCODE) })
public class PayScaleLovDs extends AbstractTypeWithCodeLov<PayScale> {

    public PayScaleLovDs() {
        super();
    }

    public PayScaleLovDs(PayScale e) {
        super(e);
    }

}

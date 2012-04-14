/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScale.class, sort = { @SortField(field = PayScaleDs.fNAME) })
public class PayScaleDs extends AbstractTypeWithCodeDs<PayScale> {

    public PayScaleDs() {
        super();
    }

    public PayScaleDs(PayScale e) {
        super(e);
    }

}

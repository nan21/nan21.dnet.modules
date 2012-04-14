/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.fin.domain.entity.PaymentMethod;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentMethod.class, sort = { @SortField(field = PaymentMethodDs.fNAME) })
public class PaymentMethodDs extends AbstractTypeDs<PaymentMethod> {

    public PaymentMethodDs() {
        super();
    }

    public PaymentMethodDs(PaymentMethod e) {
        super(e);
    }

}

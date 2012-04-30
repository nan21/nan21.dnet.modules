/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentTerm.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = PaymentTermLovDs.fNAME) })
public class PaymentTermLovDs extends AbstractTypeLov<PaymentTerm> {

    public PaymentTermLovDs() {
        super();
    }

    public PaymentTermLovDs(PaymentTerm e) {
        super(e);
    }

}

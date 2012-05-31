/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentMethod.class, jpqlWhere = " e.active = true and e.docType.category = 'payment-in' ", sort = { @SortField(field = PaymentMethodInLovDs.fNAME) })
public class PaymentMethodInLovDs extends AbstractTypeLov<PaymentMethod> {

    public static final String fTYPE = "type";

    @DsField()
    private String type;

    public PaymentMethodInLovDs() {
        super();
    }

    public PaymentMethodInLovDs(PaymentMethod e) {
        super(e);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

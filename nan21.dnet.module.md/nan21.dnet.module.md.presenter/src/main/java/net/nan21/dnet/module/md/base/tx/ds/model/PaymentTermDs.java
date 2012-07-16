/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;

@Ds(entity = PaymentTerm.class, sort = { @SortField(field = PaymentTermDs.fNAME) })
public class PaymentTermDs extends AbstractTypeDs<PaymentTerm> {

    public static final String fDAYS = "days";

    @DsField()
    private Integer days;

    public PaymentTermDs() {
        super();
    }

    public PaymentTermDs(PaymentTerm e) {
        super(e);
    }

    public Integer getDays() {
        return this.days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Payroll.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = PayrollLovDs.fNAME) })
public class PayrollLovDs extends AbstractTypeLov<Payroll> {

    public PayrollLovDs() {
        super();
    }

    public PayrollLovDs(Payroll e) {
        super(e);
    }

}

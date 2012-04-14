/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Payroll.class, sort = { @SortField(field = PayrollDs.fNAME) })
public class PayrollDs extends AbstractTypeDs<Payroll> {

    public static final String fPERIODTYPE = "periodType";

    @DsField()
    private String periodType;

    public PayrollDs() {
        super();
    }

    public PayrollDs(Payroll e) {
        super(e);
    }

    public String getPeriodType() {
        return this.periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

}

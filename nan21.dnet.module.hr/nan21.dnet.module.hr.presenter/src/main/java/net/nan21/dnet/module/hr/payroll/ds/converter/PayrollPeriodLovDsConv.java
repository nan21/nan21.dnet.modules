/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public class PayrollPeriodLovDsConv extends
        AbstractDsConverter<PayrollPeriodLovDs, PayrollPeriod> implements
        IDsConverter<PayrollPeriodLovDs, PayrollPeriod> {

    protected void modelToEntityAttributes(PayrollPeriodLovDs ds,
            PayrollPeriod e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setStartDate(ds.getStartDate());
        e.setEndDate(ds.getEndDate());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PayrollPeriodLovDs ds,
            PayrollPeriod e) throws Exception {
    }

    @Override
    public void entityToModel(PayrollPeriod e, PayrollPeriodLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setStartDate(e.getStartDate());
        ds.setEndDate(e.getEndDate());
        ds.setActive(e.getActive());
        ds.setPayrollId(((e.getPayroll() != null)) ? e.getPayroll().getId()
                : null);
    }

}

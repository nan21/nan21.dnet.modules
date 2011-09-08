/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public class PayrollPeriodDsConv extends
        AbstractDsConverter<PayrollPeriodDs, PayrollPeriod> implements
        IDsConverter<PayrollPeriodDs, PayrollPeriod> {

    protected void modelToEntityAttributes(PayrollPeriodDs ds, PayrollPeriod e)
            throws Exception {
        e.setName(ds.getName());
        e.setStartDate(ds.getStartDate());
        e.setEndDate(ds.getEndDate());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(PayrollPeriodDs ds, PayrollPeriod e)
            throws Exception {

        if (ds.getPayrollId() != null) {
            if (e.getPayroll() == null
                    || !e.getPayroll().getId().equals(ds.getPayrollId())) {
                e.setPayroll((Payroll) this.em.getReference(Payroll.class,
                        ds.getPayrollId()));
            }
        } else {
            this.lookup_payroll_Payroll(ds, e);
        }
    }

    protected void lookup_payroll_Payroll(PayrollPeriodDs ds, PayrollPeriod e)
            throws Exception {
        if (ds.getPayrollName() != null && !ds.getPayrollName().equals("")) {
            Payroll x = null;
            try {
                x = ((IPayrollService) getService(IPayrollService.class))
                        .findByName(ds.getClientId(), ds.getPayrollName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Payroll` reference:  `payrollName` = "
                                + ds.getPayrollName() + "  ");
            }
            e.setPayroll(x);
        }
    }

    @Override
    public void entityToModel(PayrollPeriod e, PayrollPeriodDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setStartDate(e.getStartDate());
        ds.setEndDate(e.getEndDate());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setPayrollId(((e.getPayroll() != null)) ? e.getPayroll().getId()
                : null);
        ds.setPayrollName(((e.getPayroll() != null)) ? e.getPayroll().getName()
                : null);
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

public class PayrollDsConv extends AbstractDsConverter<PayrollDs, Payroll>
        implements IDsConverter<PayrollDs, Payroll> {

    protected void modelToEntityAttributes(PayrollDs ds, Payroll e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setPeriodType(ds.getPeriodType());
    }

    protected void modelToEntityReferences(PayrollDs ds, Payroll e)
            throws Exception {
    }

    @Override
    public void entityToModel(Payroll e, PayrollDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setPeriodType(e.getPeriodType());
    }

}

/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import net.nan21.dnet.module.hr.payroll.domain.service.IElementService;
import net.nan21.dnet.module.hr.payroll.domain.service.IPayrollPeriodService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;

public class ElementValueDsConv extends
        AbstractDsConverter<ElementValueDs, ElementValue> implements
        IDsConverter<ElementValueDs, ElementValue> {

    protected void modelToEntityAttributes(ElementValueDs ds, ElementValue e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValue(ds.getValue());
    }

    protected void modelToEntityReferences(ElementValueDs ds, ElementValue e)
            throws Exception {

        if (ds.getElementId() != null) {
            if (e.getElement() == null
                    || !e.getElement().getId().equals(ds.getElementId())) {
                e.setElement((Element) this.em.getReference(Element.class,
                        ds.getElementId()));
            }
        } else {
            this.lookup_element_Element(ds, e);
        }
        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.getReference(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getPeriodId() != null) {
            if (e.getPeriod() == null
                    || !e.getPeriod().getId().equals(ds.getPeriodId())) {
                e.setPeriod((PayrollPeriod) this.em.getReference(
                        PayrollPeriod.class, ds.getPeriodId()));
            }
        } else {
            this.lookup_period_PayrollPeriod(ds, e);
        }
    }

    protected void lookup_element_Element(ElementValueDs ds, ElementValue e)
            throws Exception {
        Element x = null;
        try {
            x = ((IElementService) getService(IElementService.class))
                    .findByName(ds.getClientId(), ds.getElement());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setElement(x);
    }

    protected void lookup_period_PayrollPeriod(ElementValueDs ds, ElementValue e)
            throws Exception {
        PayrollPeriod x = null;
        try {
            x = ((IPayrollPeriodService) getService(IPayrollPeriodService.class))
                    .findByName(ds.getClientId(), ds.getPeriod());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setPeriod(x);
    }

    @Override
    public void entityToModel(ElementValue e, ElementValueDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValue(e.getValue());
        ds.setElementId(((e.getElement() != null)) ? e.getElement().getId()
                : null);
        ds.setElement(((e.getElement() != null)) ? e.getElement().getName()
                : null);
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setEmployeeName(((e.getEmployee() != null)) ? e.getEmployee()
                .getName() : null);
        ds.setPeriodId(((e.getPeriod() != null)) ? e.getPeriod().getId() : null);
        ds.setPeriod(((e.getPeriod() != null)) ? e.getPeriod().getName() : null);
    }

}

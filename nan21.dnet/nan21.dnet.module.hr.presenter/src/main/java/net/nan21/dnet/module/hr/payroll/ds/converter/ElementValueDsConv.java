/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.business.service.IElementService;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;

public class ElementValueDsConv extends
        AbstractDsConverter<ElementValueDs, ElementValue> implements
        IDsConverter<ElementValueDs, ElementValue> {

    protected void modelToEntityReferences(ElementValueDs ds, ElementValue e)
            throws Exception {
        if (ds.getElementId() != null) {
            if (e.getElement() == null
                    || !e.getElement().getId().equals(ds.getElementId())) {
                e.setElement((Element) this.em.find(Element.class,
                        ds.getElementId()));
            }
        } else {
            this.lookup_element_Element(ds, e);
        }
        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getPeriodId() != null) {
            if (e.getPeriod() == null
                    || !e.getPeriod().getId().equals(ds.getPeriodId())) {
                e.setPeriod((PayrollPeriod) this.em.find(PayrollPeriod.class,
                        ds.getPeriodId()));
            }
        } else {
            this.lookup_period_PayrollPeriod(ds, e);
        }
    }

    protected void lookup_element_Element(ElementValueDs ds, ElementValue e)
            throws Exception {
        if (ds.getElement() != null && !ds.getElement().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByName(ds.getClientId(), ds.getElement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Element` reference:  `element` = "
                                + ds.getElement() + "  ");
            }
            e.setElement(x);

        } else {
            e.setElement(null);
        }
    }

    protected void lookup_period_PayrollPeriod(ElementValueDs ds, ElementValue e)
            throws Exception {
        if (ds.getPeriod() != null && !ds.getPeriod().equals("")) {
            PayrollPeriod x = null;
            try {
                x = ((IPayrollPeriodService) findEntityService(PayrollPeriod.class))
                        .findByName(ds.getClientId(), ds.getPeriod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PayrollPeriod` reference:  `period` = "
                                + ds.getPeriod() + "  ");
            }
            e.setPeriod(x);

        } else {
            e.setPeriod(null);
        }
    }

}
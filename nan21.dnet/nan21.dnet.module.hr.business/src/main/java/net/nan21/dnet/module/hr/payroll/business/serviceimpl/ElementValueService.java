/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.business.service.IElementValueService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;

public class ElementValueService extends AbstractEntityService<ElementValue>
        implements IElementValueService {

    public ElementValueService() {
        super();
    }

    public ElementValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementValue> getEntityClass() {
        return ElementValue.class;
    }

    public List<ElementValue> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<ElementValue> findByElementId(Long elementId) {
        return (List<ElementValue>) this.em
                .createQuery(
                        "select e from ElementValue e where e.element.id = :pElementId",
                        ElementValue.class)
                .setParameter("pElementId", elementId).getResultList();
    }

    public List<ElementValue> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<ElementValue> findByEmployeeId(Long employeeId) {
        return (List<ElementValue>) this.em
                .createQuery(
                        "select e from ElementValue e where e.employee.id = :pEmployeeId",
                        ElementValue.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<ElementValue> findByPeriod(PayrollPeriod period) {
        return this.findByPeriodId(period.getId());
    }

    public List<ElementValue> findByPeriodId(Long periodId) {
        return (List<ElementValue>) this.em
                .createQuery(
                        "select e from ElementValue e where e.period.id = :pPeriodId",
                        ElementValue.class).setParameter("pPeriodId", periodId)
                .getResultList();
    }

}

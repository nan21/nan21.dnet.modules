/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeService extends AbstractEntityService<Employee> implements
        IEmployeeService {

    public EmployeeService() {
        super();
    }

    public EmployeeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    public Employee findByCode(Long clientId, String code) {
        return (Employee) this.em.createNamedQuery(Employee.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<Employee> findByEmployer(Organization employer) {
        return this.findByEmployerId(employer.getId());
    }

    public List<Employee> findByEmployerId(Long employerId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee where e.employer.id = :pEmployerId",
                        Employee.class).setParameter("pEmployerId", employerId)
                .getResultList();
    }

    public List<Employee> findByCitizenship(Country citizenship) {
        return this.findByCitizenshipId(citizenship.getId());
    }

    public List<Employee> findByCitizenshipId(Long citizenshipId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee where e.citizenship.id = :pCitizenshipId",
                        Employee.class)
                .setParameter("pCitizenshipId", citizenshipId).getResultList();
    }

}

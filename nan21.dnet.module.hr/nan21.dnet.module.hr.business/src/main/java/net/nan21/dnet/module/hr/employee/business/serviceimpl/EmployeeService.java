/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

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

    public Employee findByCode(String code) {
        return (Employee) this.em.createNamedQuery(Employee.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public List<Employee> findByContacts(EmployeeContact contacts) {
        return this.findByContactsId(contacts.getId());
    }

    public List<Employee> findByContactsId(Long contactsId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select distinct e from Employee e , IN (e.contacts) c where e.clientId = :pClientId and c.id = :pContactsId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pContactsId", contactsId).getResultList();
    }

}

/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

public class EmployeeContactService extends
        AbstractEntityService<EmployeeContact> implements
        IEmployeeContactService {

    public EmployeeContactService() {
        super();
    }

    public EmployeeContactService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeContact> getEntityClass() {
        return EmployeeContact.class;
    }

    public List<EmployeeContact> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeContact> findByEmployeeId(Long employeeId) {
        return (List<EmployeeContact>) this.em
                .createQuery(
                        "select e from EmployeeContact where e.employee.id = :pEmployeeId",
                        EmployeeContact.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeContact> findByType(EmployeeContactType type) {
        return this.findByTypeId(type.getId());
    }

    public List<EmployeeContact> findByTypeId(Long typeId) {
        return (List<EmployeeContact>) this.em
                .createQuery(
                        "select e from EmployeeContact where e.type.id = :pTypeId",
                        EmployeeContact.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<EmployeeContact> findByRelationship(
            EmployeeContactRelationship relationship) {
        return this.findByRelationshipId(relationship.getId());
    }

    public List<EmployeeContact> findByRelationshipId(Long relationshipId) {
        return (List<EmployeeContact>) this.em
                .createQuery(
                        "select e from EmployeeContact where e.relationship.id = :pRelationshipId",
                        EmployeeContact.class)
                .setParameter("pRelationshipId", relationshipId)
                .getResultList();
    }

}

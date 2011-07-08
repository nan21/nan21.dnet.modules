/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeEducationService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

public class EmployeeEducationService extends
        AbstractEntityService<EmployeeEducation> implements
        IEmployeeEducationService {

    public EmployeeEducationService() {
        super();
    }

    public EmployeeEducationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeEducation> getEntityClass() {
        return EmployeeEducation.class;
    }

    public List<EmployeeEducation> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeEducation> findByEmployeeId(Long employeeId) {
        return (List<EmployeeEducation>) this.em
                .createQuery(
                        "select e from EmployeeEducation e where e.employee.id = :pEmployeeId",
                        EmployeeEducation.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeEducation> findByType(EducationType type) {
        return this.findByTypeId(type.getId());
    }

    public List<EmployeeEducation> findByTypeId(Long typeId) {
        return (List<EmployeeEducation>) this.em
                .createQuery(
                        "select e from EmployeeEducation e where e.type.id = :pTypeId",
                        EmployeeEducation.class)
                .setParameter("pTypeId", typeId).getResultList();
    }

}

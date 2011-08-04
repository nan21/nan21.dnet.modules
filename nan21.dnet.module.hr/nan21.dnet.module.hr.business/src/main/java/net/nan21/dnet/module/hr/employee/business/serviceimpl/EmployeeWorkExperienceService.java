/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeWorkExperienceService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

public class EmployeeWorkExperienceService extends
        AbstractEntityService<EmployeeWorkExperience> implements
        IEmployeeWorkExperienceService {

    public EmployeeWorkExperienceService() {
        super();
    }

    public EmployeeWorkExperienceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeWorkExperience> getEntityClass() {
        return EmployeeWorkExperience.class;
    }

    public List<EmployeeWorkExperience> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeWorkExperience> findByEmployeeId(Long employeeId) {
        return (List<EmployeeWorkExperience>) this.em
                .createQuery(
                        "select e from EmployeeWorkExperience e where e.employee.id = :pEmployeeId",
                        EmployeeWorkExperience.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

}

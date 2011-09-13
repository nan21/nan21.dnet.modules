/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeAttachmentService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmplAttachmentType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAttachment;

public class EmployeeAttachmentService extends
        AbstractEntityService<EmployeeAttachment> implements
        IEmployeeAttachmentService {

    public EmployeeAttachmentService() {
        super();
    }

    public EmployeeAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeAttachment> getEntityClass() {
        return EmployeeAttachment.class;
    }

    public List<EmployeeAttachment> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeAttachment> findByEmployeeId(Long employeeId) {
        return (List<EmployeeAttachment>) this.em
                .createQuery(
                        "select e from EmployeeAttachment e where e.employee.id = :pEmployeeId",
                        EmployeeAttachment.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeAttachment> findByType(EmplAttachmentType type) {
        return this.findByTypeId(type.getId());
    }

    public List<EmployeeAttachment> findByTypeId(Long typeId) {
        return (List<EmployeeAttachment>) this.em
                .createQuery(
                        "select e from EmployeeAttachment e where e.type.id = :pTypeId",
                        EmployeeAttachment.class)
                .setParameter("pTypeId", typeId).getResultList();
    }

}

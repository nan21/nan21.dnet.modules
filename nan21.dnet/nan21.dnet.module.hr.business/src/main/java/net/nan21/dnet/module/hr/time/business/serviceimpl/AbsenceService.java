/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;

public class AbsenceService extends AbstractEntityService<Absence> implements
        IAbsenceService {

    public AbsenceService() {
        super();
    }

    public AbsenceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Absence> getEntityClass() {
        return Absence.class;
    }

    public List<Absence> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<Absence> findByEmployeeId(Long employeeId) {
        return (List<Absence>) this.em
                .createQuery(
                        "select e from Absence e where e.employee.id = :pEmployeeId",
                        Absence.class).setParameter("pEmployeeId", employeeId)
                .getResultList();
    }

    public List<Absence> findByType(AbsenceType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Absence> findByTypeId(Long typeId) {
        return (List<Absence>) this.em
                .createQuery(
                        "select e from Absence e where e.type.id = :pTypeId",
                        Absence.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<Absence> findByReason(AbsenceReason reason) {
        return this.findByReasonId(reason.getId());
    }

    public List<Absence> findByReasonId(Long reasonId) {
        return (List<Absence>) this.em
                .createQuery(
                        "select e from Absence e where e.reason.id = :pReasonId",
                        Absence.class).setParameter("pReasonId", reasonId)
                .getResultList();
    }

}

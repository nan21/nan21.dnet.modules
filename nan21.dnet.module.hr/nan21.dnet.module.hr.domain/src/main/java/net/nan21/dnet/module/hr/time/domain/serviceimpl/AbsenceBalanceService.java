/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.service.IAbsenceBalanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceBalance;

public class AbsenceBalanceService extends
        AbstractEntityService<AbsenceBalance> implements IAbsenceBalanceService {

    public AbsenceBalanceService() {
        super();
    }

    public AbsenceBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceBalance> getEntityClass() {
        return AbsenceBalance.class;
    }

    public List<AbsenceBalance> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<AbsenceBalance> findByEmployeeId(Long employeeId) {
        return (List<AbsenceBalance>) this.em
                .createQuery(
                        "select e from AbsenceBalance where e.employee.id = :pEmployeeId",
                        AbsenceBalance.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

}

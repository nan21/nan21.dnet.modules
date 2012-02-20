/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceRequestService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;

public class AbsenceRequestService extends
        AbstractEntityService<AbsenceRequest> implements IAbsenceRequestService {

    public AbsenceRequestService() {
        super();
    }

    public AbsenceRequestService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceRequest> getEntityClass() {
        return AbsenceRequest.class;
    }

    public List<AbsenceRequest> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<AbsenceRequest> findByEmployeeId(Long employeeId) {
        return (List<AbsenceRequest>) this.em
                .createQuery(
                        "select e from AbsenceRequest e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
                        AbsenceRequest.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<AbsenceRequest> findByType(AbsenceType type) {
        return this.findByTypeId(type.getId());
    }

    public List<AbsenceRequest> findByTypeId(Long typeId) {
        return (List<AbsenceRequest>) this.em
                .createQuery(
                        "select e from AbsenceRequest e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        AbsenceRequest.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<AbsenceRequest> findByReason(AbsenceReason reason) {
        return this.findByReasonId(reason.getId());
    }

    public List<AbsenceRequest> findByReasonId(Long reasonId) {
        return (List<AbsenceRequest>) this.em
                .createQuery(
                        "select e from AbsenceRequest e where e.clientId = :pClientId and e.reason.id = :pReasonId",
                        AbsenceRequest.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pReasonId", reasonId).getResultList();
    }

    public List<AbsenceRequest> findByItems(AbsenceRequestItem items) {
        return this.findByItemsId(items.getId());
    }

    public List<AbsenceRequest> findByItemsId(Long itemsId) {
        return (List<AbsenceRequest>) this.em
                .createQuery(
                        "select distinct e from AbsenceRequest e , IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
                        AbsenceRequest.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemsId", itemsId).getResultList();
    }

}

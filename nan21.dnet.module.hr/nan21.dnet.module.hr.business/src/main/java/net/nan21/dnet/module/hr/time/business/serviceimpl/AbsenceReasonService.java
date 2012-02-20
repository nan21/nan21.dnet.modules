/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceReasonService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;

public class AbsenceReasonService extends AbstractEntityService<AbsenceReason>
        implements IAbsenceReasonService {

    public AbsenceReasonService() {
        super();
    }

    public AbsenceReasonService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceReason> getEntityClass() {
        return AbsenceReason.class;
    }

    public AbsenceReason findByName(String name) {
        return (AbsenceReason) this.em
                .createNamedQuery(AbsenceReason.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<AbsenceReason> findByType(AbsenceType type) {
        return this.findByTypeId(type.getId());
    }

    public List<AbsenceReason> findByTypeId(Long typeId) {
        return (List<AbsenceReason>) this.em
                .createQuery(
                        "select e from AbsenceReason e where e.clientId = :pClientId and  e.type.id = :pTypeId",
                        AbsenceReason.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

}

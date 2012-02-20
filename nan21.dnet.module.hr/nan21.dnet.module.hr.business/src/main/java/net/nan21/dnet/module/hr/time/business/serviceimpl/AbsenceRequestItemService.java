/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceRequestItemService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;

public class AbsenceRequestItemService extends
        AbstractEntityService<AbsenceRequestItem> implements
        IAbsenceRequestItemService {

    public AbsenceRequestItemService() {
        super();
    }

    public AbsenceRequestItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceRequestItem> getEntityClass() {
        return AbsenceRequestItem.class;
    }

    public List<AbsenceRequestItem> findByAbsenceRequest(
            AbsenceRequest absenceRequest) {
        return this.findByAbsenceRequestId(absenceRequest.getId());
    }

    public List<AbsenceRequestItem> findByAbsenceRequestId(Long absenceRequestId) {
        return (List<AbsenceRequestItem>) this.em
                .createQuery(
                        "select e from AbsenceRequestItem e where e.clientId = :pClientId and e.absenceRequest.id = :pAbsenceRequestId",
                        AbsenceRequestItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAbsenceRequestId", absenceRequestId)
                .getResultList();
    }

}

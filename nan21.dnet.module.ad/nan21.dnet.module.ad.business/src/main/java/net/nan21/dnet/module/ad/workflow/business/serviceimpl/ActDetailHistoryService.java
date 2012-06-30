/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDetailHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDetailHistory;

public class ActDetailHistoryService extends
        AbstractEntityService<ActDetailHistory> implements
        IActDetailHistoryService {

    public ActDetailHistoryService() {
        super();
    }

    public ActDetailHistoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActDetailHistory> getEntityClass() {
        return ActDetailHistory.class;
    }

    public List<ActDetailHistory> findByByteArray(ActByteArray byteArray) {
        return this.findByByteArrayId(byteArray.getId());
    }

    public List<ActDetailHistory> findByByteArrayId(String byteArrayId) {
        return (List<ActDetailHistory>) this.em
                .createQuery(
                        "select e from ActDetailHistory e where  e.byteArray.id = :pByteArrayId",
                        ActDetailHistory.class)
                .setParameter("pByteArrayId", byteArrayId).getResultList();
    }

}

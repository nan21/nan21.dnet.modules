/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDetailHistoryService;

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

}

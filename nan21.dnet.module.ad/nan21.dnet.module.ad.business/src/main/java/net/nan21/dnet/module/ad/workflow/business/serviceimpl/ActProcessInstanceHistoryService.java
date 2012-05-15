/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActProcessInstanceHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;

public class ActProcessInstanceHistoryService extends
        AbstractEntityService<ActProcessInstanceHistory> implements
        IActProcessInstanceHistoryService {

    public ActProcessInstanceHistoryService() {
        super();
    }

    public ActProcessInstanceHistoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActProcessInstanceHistory> getEntityClass() {
        return ActProcessInstanceHistory.class;
    }

    public List<ActProcessInstanceHistory> findByProcessDefinition(
            ActProcessDefinition processDefinition) {
        return this.findByProcessDefinitionId(processDefinition.getId());
    }

    public List<ActProcessInstanceHistory> findByProcessDefinitionId(
            String processDefinitionId) {
        return (List<ActProcessInstanceHistory>) this.em
                .createQuery(
                        "select e from ActProcessInstanceHistory e where  e.processDefinition.id = :pProcessDefinitionId",
                        ActProcessInstanceHistory.class)
                .setParameter("pProcessDefinitionId", processDefinitionId)
                .getResultList();
    }

}

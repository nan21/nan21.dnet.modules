/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActTaskInstanceHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

public class ActTaskInstanceHistoryService extends
        AbstractEntityService<ActTaskInstanceHistory> implements
        IActTaskInstanceHistoryService {

    public ActTaskInstanceHistoryService() {
        super();
    }

    public ActTaskInstanceHistoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActTaskInstanceHistory> getEntityClass() {
        return ActTaskInstanceHistory.class;
    }

    public List<ActTaskInstanceHistory> findByProcessDefinition(
            ActProcessDefinition processDefinition) {
        return this.findByProcessDefinitionId(processDefinition.getId());
    }

    public List<ActTaskInstanceHistory> findByProcessDefinitionId(
            String processDefinitionId) {
        return (List<ActTaskInstanceHistory>) this.em
                .createQuery(
                        "select e from ActTaskInstanceHistory e where e.processDefinition.id = :pProcessDefinitionId",
                        ActTaskInstanceHistory.class)
                .setParameter("pProcessDefinitionId", processDefinitionId)
                .getResultList();
    }

    public List<ActTaskInstanceHistory> findByParent(
            ActTaskInstanceHistory parent) {
        return this.findByParentId(parent.getId());
    }

    public List<ActTaskInstanceHistory> findByParentId(String parentId) {
        return (List<ActTaskInstanceHistory>) this.em
                .createQuery(
                        "select e from ActTaskInstanceHistory e where e.parent.id = :pParentId",
                        ActTaskInstanceHistory.class)
                .setParameter("pParentId", parentId).getResultList();
    }

}

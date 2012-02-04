/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActTaskService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

public class ActTaskService extends AbstractEntityService<ActTask> implements
        IActTaskService {

    public ActTaskService() {
        super();
    }

    public ActTaskService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActTask> getEntityClass() {
        return ActTask.class;
    }

    public List<ActTask> findByProcessDefinition(
            ActProcessDefinition processDefinition) {
        return this.findByProcessDefinitionId(processDefinition.getId());
    }

    public List<ActTask> findByProcessDefinitionId(String processDefinitionId) {
        return (List<ActTask>) this.em
                .createQuery(
                        "select e from ActTask e where e.processDefinition.id = :pProcessDefinitionId",
                        ActTask.class)
                .setParameter("pProcessDefinitionId", processDefinitionId)
                .getResultList();
    }

    public List<ActTask> findByParent(ActTask parent) {
        return this.findByParentId(parent.getId());
    }

    public List<ActTask> findByParentId(String parentId) {
        return (List<ActTask>) this.em
                .createQuery(
                        "select e from ActTask e where e.parent.id = :pParentId",
                        ActTask.class).setParameter("pParentId", parentId)
                .getResultList();
    }

}

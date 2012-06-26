/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActExecutionService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;

public class ActExecutionService extends AbstractEntityService<ActExecution>
        implements IActExecutionService {

    public ActExecutionService() {
        super();
    }

    public ActExecutionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActExecution> getEntityClass() {
        return ActExecution.class;
    }

    public List<ActExecution> findByParent(ActExecution parent) {
        return this.findByParentId(parent.getId());
    }

    public List<ActExecution> findByParentId(String parentId) {
        return (List<ActExecution>) this.em
                .createQuery(
                        "select e from ActExecution e where  e.parent.id = :pParentId",
                        ActExecution.class).setParameter("pParentId", parentId)
                .getResultList();
    }

    public List<ActExecution> findByProcessDefinition(
            ActProcessDefinition processDefinition) {
        return this.findByProcessDefinitionId(processDefinition.getId());
    }

    public List<ActExecution> findByProcessDefinitionId(
            String processDefinitionId) {
        return (List<ActExecution>) this.em
                .createQuery(
                        "select e from ActExecution e where  e.processDefinition.id = :pProcessDefinitionId",
                        ActExecution.class)
                .setParameter("pProcessDefinitionId", processDefinitionId)
                .getResultList();
    }

}

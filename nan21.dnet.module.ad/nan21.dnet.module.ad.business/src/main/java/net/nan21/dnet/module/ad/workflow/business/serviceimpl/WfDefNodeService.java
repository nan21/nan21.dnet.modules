/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public class WfDefNodeService extends AbstractEntityService<WfDefNode>
        implements IWfDefNodeService {

    public WfDefNodeService() {
        super();
    }

    public WfDefNodeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefNode> getEntityClass() {
        return WfDefNode.class;
    }

    public WfDefNode findByName(Long clientId, String name) {
        return (WfDefNode) this.em.createNamedQuery(WfDefNode.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<WfDefNode> findByProcess(WfDefProcess process) {
        return this.findByProcessId(process.getId());
    }

    public List<WfDefNode> findByProcessId(Long processId) {
        return (List<WfDefNode>) this.em
                .createQuery(
                        "select e from WfDefNode where e.process.id = :pProcessId",
                        WfDefNode.class).setParameter("pProcessId", processId)
                .getResultList();
    }

    public List<WfDefNode> findByTaskType(WfDefNodeType taskType) {
        return this.findByTaskTypeId(taskType.getId());
    }

    public List<WfDefNode> findByTaskTypeId(Long taskTypeId) {
        return (List<WfDefNode>) this.em
                .createQuery(
                        "select e from WfDefNode where e.taskType.id = :pTaskTypeId",
                        WfDefNode.class)
                .setParameter("pTaskTypeId", taskTypeId).getResultList();
    }

}

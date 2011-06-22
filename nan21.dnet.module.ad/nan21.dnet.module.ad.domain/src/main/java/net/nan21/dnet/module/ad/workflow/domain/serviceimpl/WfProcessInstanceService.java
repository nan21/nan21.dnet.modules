/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;
import net.nan21.dnet.module.ad.workflow.domain.service.IWfProcessInstanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcessInstance;

public class WfProcessInstanceService extends
        AbstractEntityService<WfProcessInstance> implements
        IWfProcessInstanceService {

    public WfProcessInstanceService() {
        super();
    }

    public WfProcessInstanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfProcessInstance> getEntityClass() {
        return WfProcessInstance.class;
    }

    public List<WfProcessInstance> findByProcess(WfProcess process) {
        return this.findByProcessId(process.getId());
    }

    public List<WfProcessInstance> findByProcessId(String processId) {
        return (List<WfProcessInstance>) this.em
                .createQuery(
                        "select e from WfProcessInstance where e.process.id = :pProcessId",
                        WfProcessInstance.class)
                .setParameter("pProcessId", processId).getResultList();
    }

}

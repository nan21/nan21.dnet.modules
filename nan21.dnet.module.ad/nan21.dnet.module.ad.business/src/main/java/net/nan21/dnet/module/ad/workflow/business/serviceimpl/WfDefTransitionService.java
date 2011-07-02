/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefTransitionService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

public class WfDefTransitionService extends
        AbstractEntityService<WfDefTransition> implements
        IWfDefTransitionService {

    public WfDefTransitionService() {
        super();
    }

    public WfDefTransitionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefTransition> getEntityClass() {
        return WfDefTransition.class;
    }

    public List<WfDefTransition> findByProcess(WfDefProcess process) {
        return this.findByProcessId(process.getId());
    }

    public List<WfDefTransition> findByProcessId(Long processId) {
        return (List<WfDefTransition>) this.em
                .createQuery(
                        "select e from WfDefTransition where e.process.id = :pProcessId",
                        WfDefTransition.class)
                .setParameter("pProcessId", processId).getResultList();
    }

    public List<WfDefTransition> findBySource(WfDefNode source) {
        return this.findBySourceId(source.getId());
    }

    public List<WfDefTransition> findBySourceId(Long sourceId) {
        return (List<WfDefTransition>) this.em
                .createQuery(
                        "select e from WfDefTransition where e.source.id = :pSourceId",
                        WfDefTransition.class)
                .setParameter("pSourceId", sourceId).getResultList();
    }

    public List<WfDefTransition> findByTarget(WfDefNode target) {
        return this.findByTargetId(target.getId());
    }

    public List<WfDefTransition> findByTargetId(Long targetId) {
        return (List<WfDefTransition>) this.em
                .createQuery(
                        "select e from WfDefTransition where e.target.id = :pTargetId",
                        WfDefTransition.class)
                .setParameter("pTargetId", targetId).getResultList();
    }

}

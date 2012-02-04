/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefProcessService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

public class WfDefProcessService extends AbstractEntityService<WfDefProcess>
        implements IWfDefProcessService {

    public WfDefProcessService() {
        super();
    }

    public WfDefProcessService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefProcess> getEntityClass() {
        return WfDefProcess.class;
    }

    public WfDefProcess findByName(Long clientId, String name) {
        return (WfDefProcess) this.em
                .createNamedQuery(WfDefProcess.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<WfDefProcess> findByNodes(WfDefNode nodes) {
        return this.findByNodesId(nodes.getId());
    }

    public List<WfDefProcess> findByNodesId(Long nodesId) {
        return (List<WfDefProcess>) this.em
                .createQuery(
                        "select distinct e from WfDefProcess e , IN (e.nodes) c where c.id = :pNodesId",
                        WfDefProcess.class).setParameter("pNodesId", nodesId)
                .getResultList();
    }

}

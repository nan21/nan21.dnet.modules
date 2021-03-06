/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
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

    public WfDefProcess findByName(String name) {
        return (WfDefProcess) this.em
                .createNamedQuery(WfDefProcess.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<WfDefProcess> findByNodes(WfDefNode nodes) {
        return this.findByNodesId(nodes.getId());
    }

    public List<WfDefProcess> findByNodesId(Long nodesId) {
        return (List<WfDefProcess>) this.em
                .createQuery(
                        "select distinct e from WfDefProcess e , IN (e.nodes) c where e.clientId = :pClientId and c.id = :pNodesId",
                        WfDefProcess.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pNodesId", nodesId).getResultList();
    }

}

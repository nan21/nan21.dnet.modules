/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.domain.service.IWfDefProcessService;

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

}

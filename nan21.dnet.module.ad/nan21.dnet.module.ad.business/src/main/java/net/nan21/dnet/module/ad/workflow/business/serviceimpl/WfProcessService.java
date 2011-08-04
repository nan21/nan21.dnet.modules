/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfProcessService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;

public class WfProcessService extends AbstractEntityService<WfProcess>
        implements IWfProcessService {

    public WfProcessService() {
        super();
    }

    public WfProcessService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfProcess> getEntityClass() {
        return WfProcess.class;
    }

}

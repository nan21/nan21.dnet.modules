/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfTaskInstanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfTaskInstance;

public class WfTaskInstanceService extends
        AbstractEntityService<WfTaskInstance> implements IWfTaskInstanceService {

    public WfTaskInstanceService() {
        super();
    }

    public WfTaskInstanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfTaskInstance> getEntityClass() {
        return WfTaskInstance.class;
    }

}

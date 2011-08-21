/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDeploymentService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

public class ActDeploymentService extends AbstractEntityService<ActDeployment>
        implements IActDeploymentService {

    public ActDeploymentService() {
        super();
    }

    public ActDeploymentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActDeployment> getEntityClass() {
        return ActDeployment.class;
    }

}

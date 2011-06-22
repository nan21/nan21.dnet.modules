/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.domain.service.IWfDeploymentService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDeployment;

public class WfDeploymentService extends AbstractEntityService<WfDeployment>
        implements IWfDeploymentService {

    public WfDeploymentService() {
        super();
    }

    public WfDeploymentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDeployment> getEntityClass() {
        return WfDeployment.class;
    }

}
